package chap20.Network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SenderThread extends Thread{
	Socket socket;
    SenderThread(Socket socket) {   
        this.socket = socket;
    }
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
            PrintWriter writer = 
                new PrintWriter(socket.getOutputStream());
            while (true) {
                String str = reader.readLine();
                if (str.equals("bye"))
                    break;
                writer.println(str);
                writer.flush();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }   
        finally {
            try {
                socket.close();
            }
            catch (Exception ignored) {
            }
        }
    }
}
