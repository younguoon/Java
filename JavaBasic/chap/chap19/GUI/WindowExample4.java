package chap19.GUI;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class WindowExample4 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Zoo Program");
		frame.setLocation(500, 400);
		Container contentPane = frame.getContentPane();
		FlowLayout layout = new FlowLayout();
		contentPane.setLayout(layout);
		contentPane.add(new JButton("���"));
		contentPane.add(new JButton("���ξ���"));
		contentPane.add(new JButton("������"));
		contentPane.add(new JButton("����"));
		contentPane.add(new JButton("����"));
		contentPane.add(new JButton("������"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
