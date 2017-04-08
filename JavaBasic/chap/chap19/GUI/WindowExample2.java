package chap19.GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WindowExample2 {
	public static void main(String[] args) {
        JFrame frame = new JFrame("Hello Program");
        frame.setPreferredSize(new Dimension(200, 70));
        frame.setLocation(500, 400);
        Container contentPane = frame.getContentPane();
        JTextField text = new JTextField();
        JButton button = new JButton("»Æ¿Œ");
        JLabel label = new JLabel("Hello");
        contentPane.add(text, BorderLayout.CENTER);
        contentPane.add(button, BorderLayout.EAST);
        contentPane.add(label, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
