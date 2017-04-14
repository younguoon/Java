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

	// �α��� �г�
	private JPanel loginPanel;
	// �α��� ��ư
	private JButton loginButton;
	// ��ȭ�� ��
	private JLabel label1;
	// ��ȭ�� �Է� �ؽ�Ʈ �ʵ�
	private JTextField idInput;

	// �α׾ƿ� �г� ����
	private JPanel logoutPanel;
	// ��ȭ�� ��� ��
	private JLabel label2;
	// �α׾ƿ� ��ư
	private JButton logoutButton;

	// �Է� �г� ����
	private JPanel msgPanel;
	// �޽��� �Է� �ؽ�Ʈ �ʵ�
	private JTextField msgInput;
	// ���� ��ư
	private JButton exitButton;

	// ���� ������
	private JFrame jframe;
	// ä�� ���� ��� â
	private JTextArea msgOut;

	// ī�� ���̾ƿ� ����
	   private Container tab;
	   private CardLayout clayout;
	   private Thread thread;

	   // ���� �÷���
	   boolean status;

	   public MultiChatClient11(String ip) {
	      this.ip = ip;

	      // �α��� �г� ����
	      loginPanel = new JPanel( );
	      // ���̾ƿ� ����
	      loginPanel.setLayout(new BorderLayout( ));
	      idInput = new JTextField(15);
	      loginButton = new JButton("�α���");
	      // �̺�Ʈ ������ ���
	      loginButton.addActionListener(this);
	      label1 = new JLabel("��ȭ��");
	      // �гο� ���� ����
	      loginPanel.add(label1, BorderLayout.WEST);
	      loginPanel.add(idInput, BorderLayout.CENTER);
	      loginPanel.add(loginButton, BorderLayout.EAST);

	      // �α׾ƿ� �г� ����
	      logoutPanel = new JPanel( );
	      // ���̾ƿ� ����
	      logoutPanel.setLayout(new BorderLayout( ));
	      label2 = new JLabel( );
	      logoutButton = new JButton("�α׾ƿ�");
	      // �̺�Ʈ ������ ���
	      logoutButton.addActionListener(this);
	      // �гο� ���� ����
	      logoutPanel.add(label2, BorderLayout.CENTER);
	      logoutPanel.add(logoutButton, BorderLayout.EAST);

	      // �Է� �г� ����
	      msgPanel = new JPanel( );
	      // ���̾ƿ� ����
	      msgPanel.setLayout(new BorderLayout( ));
	      msgInput = new JTextField(30);
	      // �̺�Ʈ ������ ���
	      msgInput.addActionListener(this);
	      exitButton = new JButton("����");
	      exitButton.addActionListener(this);
	      // �гο� ���� ����
	      msgPanel.add(msgInput, BorderLayout.CENTER);
	      msgPanel.add(exitButton, BorderLayout.EAST);

	      // �α���/�α׾ƿ� �г� ������ ���� ī�� ���̾ƿ� �г�
	      tab = new JPanel( );
	      clayout = new CardLayout( );
	      tab.setLayout(clayout);
	      tab.add(loginPanel, "login");
	      tab.add(logoutPanel, "logout");

	
	
	
	
	// ���� ������ ����
	jframe=new JFrame("::��Ƽê::");msgOut=new JTextArea(" ",10,30);
	// JTextArea�� ������ �������� ���ϰ� ��. ��, ��� �������� ���
	msgOut.setEditable(false);
	// ������ũ�ѹٴ� �׻� ��Ÿ����, ����ũ�ѹٴ� �ʿ��� ���� ��Ÿ���� ��
	JScrollPane jsp = new JScrollPane(msgOut, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);jframe.add(tab,BorderLayout.NORTH);jframe.add(jsp,BorderLayout.CENTER);jframe.add(msgPanel,BorderLayout.SOUTH);
	// �α��� �г��� �켱 ǥ��
	clayout.show(tab,"login");
	// ������ ũ�� �ڵ� ����
	jframe.pack();
	// ������ ũ�� ���� �Ұ� ����
	jframe.setResizable(false);
	// ������ ǥ��
	jframe.setVisible(true);

	}

	public void connectServer( ) {
	      try {
	         // ���� ����
	         socket = new Socket(ip, 8888);
	         System.out.println("[Client]Server ���� ����!!");
	         // �ԡ���� ��Ʈ�� ����
	         inMsg = new BufferedReader
	                (new InputStreamReader(socket.getInputStream( )));
	         outMsg = new PrintWriter(socket.getOutputStream( ), true);

	         // ������ �α��� �޽��� ����
	         outMsg.println(id + "/" + "login");

	         // �޽��� ������ ���� ������ ����
	         thread = new Thread(this);
	         thread.start( );
	      } catch(Exception e) {
	         // e.printStackTrace( );
	        System.out.println("[MultiChatClient]connectServer( )Exp�߻�!");
	      }
	   }

	// �̺�Ʈ ó��
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();

		// ���� ��ư ó��
		if (obj == exitButton) {
			System.exit(0);
		} else if (obj == loginButton) {
			id = idInput.getText();
			label2.setText("��ȭ�� : " + id);
			clayout.show(tab, "logout");
			connectServer();
		} else if (obj == logoutButton) {
			// �α׾ƿ� �޽��� ����
			outMsg.println(id + "/" + "logout");
			// ��ȭ â Ŭ����
			msgOut.setText(" ");
			// �α��� �гη� ��ȯ
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
			// �޽��� ����
			outMsg.println(id + "/" + msgInput.getText());
			// �Է� â Ŭ����
			msgInput.setText(" ");
		}
	}

	public void run() {
		// ���� �޽����� ó���ϴ� ����
		String msg;
		String[] rmsg;

		status = true;
		while (status) {
			try {
				// �޽��� ���Ű� �Ľ�
				msg = inMsg.readLine();
				rmsg = msg.split("/");

				// JTextArea�� ���ŵ� �޽��� �߰�
				msgOut.append(rmsg[0] + ">" + rmsg[1] + "\n");

				// Ŀ���� ���� ��ȭ �޽����� ǥ��
				msgOut.setCaretPosition(msgOut.getDocument().getLength());
			} catch (IOException e) {
				// e.printStackTrace( );
				status = false;
			}
		}
		System.out.println("[MultiChatClient]" + thread.getName() + "�����");
	}

	public static void main(String[] args) {
//		MultiChatClient mcc = new MultiChatClient("127.0.0.1");
//		MultiChatClient mcc = new MultiChatClient("192.168.2.29");
		MultiChatClient mcc = new MultiChatClient("192.168.2.37");
		
	}
}

