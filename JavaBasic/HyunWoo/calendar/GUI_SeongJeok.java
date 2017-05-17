//package calendar;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Container;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.Toolkit;
//import java.util.Properties;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTabbedPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.JTextPane;
//import javax.swing.ListSelectionModel;
//import javax.swing.SwingConstants;
//import javax.swing.border.EmptyBorder;
//import javax.swing.border.LineBorder;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableColumn;
//
//import org.jdatepicker.impl.JDatePanelImpl;
//import org.jdatepicker.impl.JDatePickerImpl;
//import org.jdatepicker.impl.UtilDateModel;
//
//public class GUI_SeongJeok {
//	
//	public static void main(String[] args) {
//		JFrame frame = new JFrame("撩瞳婦葬 Щ煎斜極");
//		frame.setBackground(new Color(255, 255, 255));
//		frame.setIconImage(Toolkit.getDefaultToolkit()
//				.getImage(GUI_SeongJeok.class.getResource("/com/sun/java/swing/plaf/motif/icons/Inform.gif")));
//		frame.getContentPane().setBackground(new Color(255, 255, 255));
//		frame.setFont(new Font("蜈擎 堅蛐", Font.BOLD, 19));
//		frame.setPreferredSize(new Dimension(500, 850));
//		frame.setLocation(400, 200);
//		Container contentPane = frame.getContentPane();
//
////		JTable table = new JTable(model);
////		table.setFont(new Font("蜈擎 堅蛐", Font.PLAIN, 16));
////		table.setSurrendersFocusOnKeystroke(true);
////		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
////		table.setBorder(new LineBorder(new Color(0, 0, 0)));
////		table.setForeground(new Color(0, 0, 0));
////		table.setBackground(new Color(255, 255, 255));
////		table.setPreferredScrollableViewportSize(new Dimension(400, 250));
//
//		int widths[] = { 70, 70, 50, 50, 50, 50, 50, 50 };
//		for (int i = 0; i < widths.length; i++) {
//			TableColumn column = table.getColumnModel().getColumn(i);
//			column.setPreferredWidth(widths[i]);
//		}
//
//		JScrollPane scrollPane = new JScrollPane(table);
//		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
//		contentPane.add(scrollPane, BorderLayout.NORTH);
//
//		JPanel panel_input = new JPanel();
//		panel_input.setBackground(new Color(255, 255, 255));
//		panel_input.setBorder(new LineBorder(new Color(0, 0, 0)));
//		panel_input.setLayout(new GridLayout(0, 10, 0, 0));
//
//		JPanel panel_button = new JPanel();
//		panel_button.setBackground(new Color(255, 255, 255));
//		panel_button.setBorder(new LineBorder(new Color(0, 0, 0)));
//		JPanel panel3 = new JPanel(new BorderLayout());
//		panel_button.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//
//		// 天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天幗が 葬蝶お
//		
//		
//		UtilDateModel model = new UtilDateModel();
//		Properties p = new Properties();
//		p.put("text.today", "Today");
//		p.put("text.month", "Month");
//		p.put("text.year", "Year");
//		
//		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
//		panel_datePicker.setLayout(new BorderLayout(0, 0));
//		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
//		datePicker.setBorder(new LineBorder(new Color(0, 0, 0)));
//		panel_datePicker.add(datePicker, BorderLayout.NORTH);
//		// -------------------------------------------------------------------------
//
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.pack();
//		frame.setVisible(true);
//
//	}
//}
