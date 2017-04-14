package chap20.Network.MultiChat;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientExample5 {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java ClientExample4 <user-name>");
			return;
		}
		try {
//			Socket socket = new Socket("127.0.0.1", 9001);
//			Socket socket = new Socket("192.168.4.120", 9002);
			Socket socket = new Socket("192.168.2.37", 9002);
			

			Thread thread1 = new SenderThread(socket, args[0]);
			Thread thread2 = new ReceiverThread(socket);
			thread1.start();
			thread2.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
