package chap20.Network.MultiChatAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class MultiChatServer {
	private ServerSocket ss = null;
	private Socket s = null;

	ArrayList<ChatThread> chatlist = new ArrayList<ChatThread>();

	public void start() {
		try {
			ss = new ServerSocket(8888);
			System.out.println("server start");
			while (true) {
				s = ss.accept();
				ChatThread chat = new ChatThread();
				chatlist.add(chat);
				chat.start();
			}
		} catch (Exception e) {
			System.out.println("MultiChatServer : start()Exp 발생 !!");
		}
	}

	public static void main(String[] args) {
		MultiChatServer server = new MultiChatServer();
		server.start();
	}

	void msgSendAll(String msg) {
		for (ChatThread ct : chatlist) {
			ct.outMsg.println(msg);
		}
	}

	class ChatThread extends Thread {
		String msg;
		String[] rmsg;

		private BufferedReader inMsg = null;
		private PrintWriter outMsg = null;

		public void run() {
			boolean status = true;
			System.out.println("**ChatThread start**");
			try {
				inMsg = new BufferedReader(new InputStreamReader(s.getInputStream()));
				outMsg = new PrintWriter(s.getOutputStream(), true);
				while (status) {
					msg = inMsg.readLine();
					rmsg = msg.split("/");
					if (rmsg[1].equals("losgout")) {
						chatlist.remove(this);
						msgSendAll("server/" + rmsg[0] + "님이 종료했습니다.");
						status = false;
					} else if (rmsg[1].equals("login")) {
						msgSendAll("server/)" + rmsg[0] + "님이 로그인했습니다.");
					} else {
						msgSendAll(msg);
					}
				}
				this.interrupt();
				System.out.println("##" + this.getName() + "stop!!");
			} catch (IOException e) {
				chatlist.remove(this);
				System.out.println("chatThread: run()IOException 발생!!");
			}
		}
	}
}
