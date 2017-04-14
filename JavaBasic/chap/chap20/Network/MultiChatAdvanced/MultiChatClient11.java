package chap20.Network.MultiChatAdvanced;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiChatClient11 implements ActionListener, Runnable {
	private String ip;
	private String id;
	private Socket socket;
	private BufferedReader inMsg = null;
	private PrintWriter outMsg = null;

	// 로그인 패널
	private JPanel loginPanel;
	// 로그인 버튼
	private JButton loginButton;
	// 대화명 라벨
	private JLabel label1;
	// 대화명 입력 텍스트 필드
	private JTextField idInput;

	// 로그아웃 패널 구성
	private JPanel logoutPanel;
	// 대화명 출력 라벨
	private JLabel label2;
	// 로그아웃 버튼
	private JButton logoutButton;

	// 입력 패널 구성
	private JPanel msgPanel;
	// 메시지 입력 텍스트 필드
	private JTextField msgInput;
	// 종료 버튼
	private JButton exitButton;

	// 메인 윈도우
	private JFrame jframe;
	// 채팅 내용 출력 창
	private JTextArea msgOut;

	// 카드 레이아웃 관련
	   private Container tab;
	   private CardLayout clayout;
	   private Thread thread;

	   // 상태 플래그
	   boolean status;

	   public MultiChatClient11(String ip) {
	      this.ip = ip;

	      // 로그인 패널 구성
	      loginPanel = new JPanel( );
	      // 레이아웃 설정
	      loginPanel.setLayout(new BorderLayout( ));
	      idInput = new JTextField(15);
	      loginButton = new JButton("로그인");
	      // 이벤트 리스너 등록
	      loginButton.addActionListener(this);
	      label1 = new JLabel("대화명");
	      // 패널에 위젯 구성
	      loginPanel.add(label1, BorderLayout.WEST);
	      loginPanel.add(idInput, BorderLayout.CENTER);
	      loginPanel.add(loginButton, BorderLayout.EAST);

	      // 로그아웃 패널 구성
	      logoutPanel = new JPanel( );
	      // 레이아웃 설정
	      logoutPanel.setLayout(new BorderLayout( ));
	      label2 = new JLabel( );
	      logoutButton = new JButton("로그아웃");
	      // 이벤트 리스너 등록
	      logoutButton.addActionListener(this);
	      // 패널에 위젯 구성
	      logoutPanel.add(label2, BorderLayout.CENTER);
	      logoutPanel.add(logoutButton, BorderLayout.EAST);

	      // 입력 패널 구성
	      msgPanel = new JPanel( );
	      // 레이아웃 설정
	      msgPanel.setLayout(new BorderLayout( ));
	      msgInput = new JTextField(30);
	      // 이벤트 리스너 등록
	      msgInput.addActionListener(this);
	      exitButton = new JButton("종료");
	      exitButton.addActionListener(this);
	      // 패널에 위젯 구성
	      msgPanel.add(msgInput, BorderLayout.CENTER);
	      msgPanel.add(exitButton, BorderLayout.EAST);

	      // 로그인/로그아웃 패널 선택을 위한 카드 레이아웃 패널
	      tab = new JPanel( );
	      clayout = new CardLayout( );
	      tab.setLayout(clayout);
	      tab.add(loginPanel, "login");
	      tab.add(logoutPanel, "logout");

	
	
	
	
	// 메인 프레임 구성
	jframe=new JFrame("::멀티챗::");msgOut=new JTextArea(" ",10,30);
	// JTextArea의 내용을 수정하지 못하게 함. 즉, 출력 전용으로 사용
	msgOut.setEditable(false);
	// 수직스크롤바는 항상 나타내고, 수평스크롤바는 필요할 때만 나타나게 함
	JScrollPane jsp = new JScrollPane(msgOut, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);jframe.add(tab,BorderLayout.NORTH);jframe.add(jsp,BorderLayout.CENTER);jframe.add(msgPanel,BorderLayout.SOUTH);
	// 로그인 패널을 우선 표시
	clayout.show(tab,"login");
	// 프레임 크기 자동 설정
	jframe.pack();
	// 프레임 크기 조정 불가 설정
	jframe.setResizable(false);
	// 프레임 표시
	jframe.setVisible(true);

	}

	public void connectServer( ) {
	      try {
	         // 소켓 생성
	         socket = new Socket(ip, 8888);
	         System.out.println("[Client]Server 연결 성공!!");
	         // 입·출력 스트림 생성
	         inMsg = new BufferedReader
	                (new InputStreamReader(socket.getInputStream( )));
	         outMsg = new PrintWriter(socket.getOutputStream( ), true);

	         // 서버에 로그인 메시지 전달
	         outMsg.println(id + "/" + "login");

	         // 메시지 수신을 위한 스레드 생성
	         thread = new Thread(this);
	         thread.start( );
	      } catch(Exception e) {
	         // e.printStackTrace( );
	        System.out.println("[MultiChatClient]connectServer( )Exp발생!");
	      }
	   }

	// 이벤트 처리
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();

		// 종료 버튼 처리
		if (obj == exitButton) {
			System.exit(0);
		} else if (obj == loginButton) {
			id = idInput.getText();
			label2.setText("대화명 : " + id);
			clayout.show(tab, "logout");
			connectServer();
		} else if (obj == logoutButton) {
			// 로그아웃 메시지 전송
			outMsg.println(id + "/" + "logout");
			// 대화 창 클리어
			msgOut.setText(" ");
			// 로그인 패널로 전환
			clayout.show(tab, "login");
			outMsg.close();
			try {
				inMsg.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			status = false;
		} else if (obj == msgInput) {
			// 메시지 전송
			outMsg.println(id + "/" + msgInput.getText());
			// 입력 창 클리어
			msgInput.setText(" ");
		}
	}

	public void run() {
		// 수신 메시지를 처리하는 변수
		String msg;
		String[] rmsg;

		status = true;
		while (status) {
			try {
				// 메시지 수신과 파싱
				msg = inMsg.readLine();
				rmsg = msg.split("/");

				// JTextArea에 수신된 메시지 추가
				msgOut.append(rmsg[0] + ">" + rmsg[1] + "\n");

				// 커서를 현재 대화 메시지에 표시
				msgOut.setCaretPosition(msgOut.getDocument().getLength());
			} catch (IOException e) {
				// e.printStackTrace( );
				status = false;
			}
		}
		System.out.println("[MultiChatClient]" + thread.getName() + "종료됨");
	}

	public static void main(String[] args) {
//		MultiChatClient mcc = new MultiChatClient("127.0.0.1");
//		MultiChatClient mcc = new MultiChatClient("192.168.2.29");
		MultiChatClient mcc = new MultiChatClient("192.168.2.37");
		
	}
}

