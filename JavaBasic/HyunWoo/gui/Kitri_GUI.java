package gui;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class Kitri_GUI extends JFrame {
	JTable table;
	ButtonGroup buttonGroup = new ButtonGroup();
	String time, meal;
	String morning, lunch, dinner;
	String apple, banana, strawberry;
	String arr[] = new String[2];
	
	public static void main(String[] args) {
		Kitri_GUI frame = new Kitri_GUI();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 600);
	}

	public Kitri_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel_top = new JPanel();
		panel_top.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_top.setBackground(Color.WHITE);
		getContentPane().add(panel_top, BorderLayout.NORTH);
		panel_top.setLayout(new GridLayout(0, 3, 0, 0));

		JRadioButton btn_morning = new JRadioButton("��ħ");
		buttonGroup.add(btn_morning);
		btn_morning.setForeground(Color.BLUE);
		btn_morning.setFont(new Font("�޸�����ü", Font.BOLD, 22));
		btn_morning.setBackground(Color.WHITE);
		btn_morning.setHorizontalAlignment(SwingConstants.CENTER);
		panel_top.add(btn_morning);

		JRadioButton btn_lunch = new JRadioButton("����");
		buttonGroup.add(btn_lunch);
		btn_lunch.setForeground(Color.BLUE);
		btn_lunch.setFont(new Font("�޸�����ü", Font.BOLD, 22));
		btn_lunch.setBackground(Color.WHITE);
		btn_lunch.setHorizontalAlignment(SwingConstants.CENTER);
		panel_top.add(btn_lunch);

		JRadioButton btn_dinner = new JRadioButton("����");
		buttonGroup.add(btn_dinner);
		btn_dinner.setForeground(Color.BLUE);
		btn_dinner.setFont(new Font("�޸�����ü", Font.BOLD, 22));
		btn_dinner.setBackground(Color.WHITE);
		btn_dinner.setHorizontalAlignment(SwingConstants.CENTER);
		panel_top.add(btn_dinner);

		JCheckBox btn_apple = new JCheckBox("���");
		btn_apple.setForeground(new Color(255, 0, 255));
		btn_apple.setFont(new Font("�޸�����ü", Font.BOLD, 22));
		btn_apple.setBackground(Color.WHITE);
		btn_apple.setHorizontalAlignment(SwingConstants.CENTER);
		panel_top.add(btn_apple);

		JCheckBox btn_banana = new JCheckBox("�ٳ���");
		btn_banana.setForeground(new Color(255, 0, 255));
		btn_banana.setFont(new Font("�޸�����ü", Font.BOLD, 22));
		btn_banana.setBackground(Color.WHITE);
		btn_banana.setHorizontalAlignment(SwingConstants.CENTER);
		panel_top.add(btn_banana);

		JCheckBox btn_strawberry = new JCheckBox("����");
		btn_strawberry.setForeground(new Color(255, 0, 255));
		btn_strawberry.setFont(new Font("�޸�����ü", Font.BOLD, 22));
		btn_strawberry.setBackground(Color.WHITE);
		btn_strawberry.setHorizontalAlignment(SwingConstants.CENTER);
		panel_top.add(btn_strawberry);
		panel_top.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { btn_morning, btn_lunch, btn_dinner, btn_apple, btn_banana, btn_strawberry }));

		JPanel panel_buttom = new JPanel();
		panel_buttom.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_buttom.setBackground(Color.WHITE);
		getContentPane().add(panel_buttom, BorderLayout.SOUTH);

		Choice choice = new Choice();
		choice.setFont(new Font("�޸�����ü", Font.BOLD, 17));
		choice.setForeground(Color.BLACK);
		choice.setBackground(Color.WHITE);
		choice.add("��ü");
		choice.add("��ħ");
		choice.add("����");
		choice.add("����");
		panel_buttom.add(choice);
		
		JButton btn_select = new JButton("���");
		btn_select.setFont(new Font("�޸�����ü", Font.BOLD, 19));
		btn_select.setForeground(new Color(255, 0, 255));
		panel_buttom.add(btn_select);
		
		JButton btn_save = new JButton("����");
		btn_save.setForeground(Color.BLUE);
		btn_save.setFont(new Font("�޸�����ü", Font.BOLD, 19));
		panel_buttom.add(btn_save);
		
		JButton btn_exit = new JButton("����");
		btn_exit.setForeground(Color.RED);
		btn_exit.setFont(new Font("�޸�����ü", Font.BOLD, 19));
		panel_buttom.add(btn_exit);

		JScrollPane scrollPane_table = new JScrollPane();
		scrollPane_table.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollPane_table, BorderLayout.CENTER);
		
		String columnNames[] = {"�ð�", "�Ĵ�"};
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		table = new JTable(model);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("�޸�����ü", Font.BOLD, 25));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getColumnModel().getColumn(0).setMaxWidth(150);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setRowHeight(35);
		scrollPane_table.setViewportView(table);
		

		btn_select.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				int i;
//				for(i=0; i<arr.length;i++){
//					table.remove(i);
//				}
//				if(time == null || meal == null){
//					return;
//				}else{
//				if(choice.getSelectedItem()=="��ħ"){
//					for(i=0; i<arr.length+1;i++){
//						if(arr[0].toString()=="��ħ"){
//							arr[0] = time;
//							arr[1] = meal;
//							model.addRow(arr);
//						}
//					}
//				}
//			}
			}
		});
		
		btn_save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				time = null;
				meal = null;
				if(btn_morning.isSelected())
					time = "��ħ";
				if(btn_lunch.isSelected())
					time = "����";
				if(btn_dinner.isSelected())
					time = "����";
				
				if(btn_apple.isSelected())
					meal += "���  ";
				if(btn_banana.isSelected())
					meal += "�ٳ���  ";
				if(btn_strawberry.isSelected())
					meal += "����  ";
				
				if(time==null){
					return;
				}else{
				arr[0] = time;
				arr[1] = meal;
				model.addRow(arr);
				}
			}
		});
		
		btn_exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}	

}
