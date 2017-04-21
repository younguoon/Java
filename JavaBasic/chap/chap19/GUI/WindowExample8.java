package chap19.GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class WindowExample8 {
	private static final JLabel lblNewLabel = new JLabel("New label");
	public static void main(String[] args) {
		JFrame frame = new JFrame("������ ��� ���α׷�");
		frame.setPreferredSize(new Dimension(400,200));
		frame.setLocation(500, 400);
		Container contentPane = frame.getContentPane();
		String colNames[] = {"�̸�", "����", "����"};
        DefaultTableModel model = new DefaultTableModel(colNames, 0);
        JTable table = new JTable(model);         
        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        JPanel panel = new JPanel();
        JTextField text1 = new JTextField(6);
        JTextField text2 = new JTextField(3);
        JTextField text3 = new JTextField(2);
        JButton button1 = new JButton("�߰�");
        JButton button2 = new JButton("����");
        panel.add(new JLabel("�̸�"));
        panel.add(text1);
        panel.add(new JLabel("����"));
        panel.add(text2);
        JLabel label = new JLabel("����");
        panel.add(label);
        panel.add(text3);
        panel.add(button1);
        panel.add(button2);
        contentPane.add(panel, BorderLayout.SOUTH);
        button1.addActionListener(
                new AddActionListener(table, text1, text2, text3));
        button2.addActionListener(new RemoveActionListener(table));
        scrollPane.setColumnHeaderView(lblNewLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

	}
}
