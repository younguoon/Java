package chap19.GUI;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class WindowExample5 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Zoo Program");
		frame.setLocation(500, 400);
		Container contentPane = frame.getContentPane();
		BoxLayout layout = new BoxLayout(contentPane, BoxLayout.X_AXIS);
		
		contentPane.setLayout(layout);
		contentPane.add(new JButton("�ڹ�"));
		contentPane.add(new JButton("����������"));
		contentPane.add(new JButton("īǪġ��"));
		contentPane.add(new JButton("��縶��ƾ"));
		contentPane.add(new JButton("�ݷ����"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
