package seongJeokGUI;

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
import javax.swing.table.TableColumn;


public class GUI_SeongJeok {
	public static void main(String[] args) {
		JFrame frame = new JFrame("성적 프로그램");
		frame.setPreferredSize(new Dimension(500,250));
		frame.setLocation(400, 200);
		Container contentPane = frame.getContentPane();
		
		String colNames[] = {"학번", "이름", "국어", "영어", "수학", "총점", "평균", "등급"};
        DefaultTableModel model = new DefaultTableModel(colNames, 0);
        JTable table = new JTable(model);         
        
        int widths[] = {70,70,50,50,50,50,50,50};
        for (int i = 0; i < widths.length; i++) {
			TableColumn column = table.getColumnModel().getColumn(i);
			column.setPreferredWidth(widths[i]);
		}
        
        contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
        
        JTextField hakbun = new JTextField(5);
        JTextField irum = new JTextField(5);
        JTextField kor = new JTextField(3);
        JTextField eng = new JTextField(3);
        JTextField math = new JTextField(3);

        JButton button1 = new JButton("추가");
        JButton button2 = new JButton("삭제");
        JButton button3 = new JButton("수정");

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("학번"));
        panel1.add(hakbun);
        panel1.add(new JLabel("이름"));
        panel1.add(irum);
        panel1.add(new JLabel("국어"));
        panel1.add(kor);
        panel1.add(new JLabel("영어"));
        panel1.add(eng);
        panel1.add(new JLabel("수학"));
        panel1.add(math);

        JPanel panel2 = new JPanel();
        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);

        JPanel panel3 = new JPanel(new BorderLayout());
        panel3.add(panel1, BorderLayout.CENTER);
        panel3.add(panel2, BorderLayout.SOUTH);

        contentPane.add(panel3, BorderLayout.SOUTH);
        button1.addActionListener(new EventActionListener(table, hakbun, irum, kor, eng, math));
        button2.addActionListener(new EventActionListener(table));
        button3.addActionListener(new EventActionListener(table, hakbun, irum, kor, eng, math));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);	}
}
