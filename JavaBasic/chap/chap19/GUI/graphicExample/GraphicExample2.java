package chap19.GUI.graphicExample;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GraphicExample2 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("���� �׷��� ���α׷�");
		frame.setLocation(500, 200);
		frame.setPreferredSize(new Dimension(400,350));
		Container contentPane = frame.getContentPane();
		DrawingPanel drawingPanel = new DrawingPanel();
		contentPane.add(drawingPanel, BorderLayout.CENTER);
		JPanel controlPanel = new JPanel();
		JTextField text1 = new JTextField(3);
		JTextField text2 = new JTextField(3);
		JTextField text3 = new JTextField(3);
		
		JButton button = new JButton("�׷��� �׸���");
		controlPanel.add(new JLabel("����"));
		controlPanel.add(text1);
		controlPanel.add(new JLabel("����"));
		controlPanel.add(text2);
		controlPanel.add(new JLabel("����"));
		controlPanel.add(text3);
		controlPanel.add(button);
		contentPane.add(controlPanel, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(new DrawActionListener(text1, text2, text3, drawingPanel));
		frame.pack();
		frame.setVisible(true);
		
	}
}
