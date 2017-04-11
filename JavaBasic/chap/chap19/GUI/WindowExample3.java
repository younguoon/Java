package chap19.GUI;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class WindowExample3 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Zoo Program");
		frame.setLocation(500, 400);
		Container contentPane = frame.getContentPane();
		GridLayout layout = new GridLayout(3,2);
		contentPane.setLayout(layout);
		contentPane.add(new JButton("¾ó·è¸»"));
		contentPane.add(new JButton("»çÀÚ"));
		contentPane.add(new JButton("ÄÚ³¢¸®"));
		contentPane.add(new JButton("ÄÚ»Ô¼Ò"));
		contentPane.add(new JButton("Æë±Ï"));
		contentPane.add(new JButton("ÇÏÀÌ¿¡³ª"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
