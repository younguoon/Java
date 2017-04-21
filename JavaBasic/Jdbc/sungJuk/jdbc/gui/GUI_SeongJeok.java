package sungJuk.jdbc.gui;

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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;

public class GUI_SeongJeok {
	static String colNames[] = { "ÇÐ¹ø", "ÀÌ¸§", "±¹¾î", "¿µ¾î", "¼öÇÐ", "ÃÑÁ¡", "Æò±Õ", "µî±Þ" };
	static DefaultTableModel model = new DefaultTableModel(colNames, 0);

	public static void main(String[] args) {
		JFrame frame = new JFrame("\uC131\uC801\uAD00\uB9AC \uD504\uB85C\uADF8\uB7A8");
		frame.setBackground(new Color(255, 255, 255));
		frame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(GUI_SeongJeok.class.getResource("/com/sun/java/swing/plaf/motif/icons/Inform.gif")));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 19));
		frame.setPreferredSize(new Dimension(500, 840));
		frame.setLocation(400, 200);
		Container contentPane = frame.getContentPane();

		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		JTable table = new JTable(model);
		table.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setForeground(new Color(0, 0, 0));
		table.setBackground(new Color(255, 255, 255));
		table.setPreferredScrollableViewportSize(new Dimension(400, 300));

		int widths[] = { 70, 70, 50, 50, 50, 50, 50, 50 };
		for (int i = 0; i < widths.length; i++) {
			TableColumn column = table.getColumnModel().getColumn(i);
			column.setPreferredWidth(widths[i]);
		}

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(scrollPane, BorderLayout.NORTH);

		JTextField hakbun = new JTextField(5);
		hakbun.setBackground(new Color(255, 250, 240));
		hakbun.setForeground(new Color(0, 0, 128));
		hakbun.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		hakbun.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField irum = new JTextField(5);
		irum.setBackground(new Color(255, 250, 240));
		irum.setForeground(new Color(0, 0, 128));
		irum.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		irum.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField kor = new JTextField(3);
		kor.setBackground(new Color(255, 250, 240));
		kor.setForeground(new Color(0, 0, 128));
		kor.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		kor.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField eng = new JTextField(3);
		eng.setBackground(new Color(255, 250, 240));
		eng.setForeground(new Color(0, 0, 128));
		eng.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		eng.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField math = new JTextField(3);
		math.setBackground(new Color(255, 250, 240));
		math.setForeground(new Color(0, 0, 128));
		math.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		math.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_input = new JPanel();
		panel_input.setBackground(new Color(255, 255, 255));
		panel_input.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_input.setLayout(new GridLayout(0, 10, 0, 0));
		JLabel label_hakbun = new JLabel("ÇÐ¹ø");
		label_hakbun.setForeground(new Color(0, 0, 128));
		label_hakbun.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		label_hakbun.setHorizontalAlignment(SwingConstants.CENTER);
		panel_input.add(label_hakbun);
		panel_input.add(hakbun);
		JLabel label_irum = new JLabel("ÀÌ¸§");
		label_irum.setForeground(new Color(0, 0, 128));
		label_irum.setBackground(new Color(255, 255, 255));
		label_irum.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		label_irum.setHorizontalAlignment(SwingConstants.CENTER);
		panel_input.add(label_irum);
		panel_input.add(irum);
		JLabel label_kor = new JLabel("±¹¾î");
		label_kor.setForeground(new Color(0, 0, 128));
		label_kor.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		label_kor.setHorizontalAlignment(SwingConstants.CENTER);
		panel_input.add(label_kor);
		panel_input.add(kor);
		JLabel label_eng = new JLabel("¿µ¾î");
		label_eng.setForeground(new Color(0, 0, 128));
		label_eng.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		label_eng.setHorizontalAlignment(SwingConstants.CENTER);
		panel_input.add(label_eng);
		panel_input.add(eng);
		JLabel label_math = new JLabel("¼öÇÐ");
		label_math.setForeground(new Color(0, 0, 128));
		label_math.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		label_math.setHorizontalAlignment(SwingConstants.CENTER);
		panel_input.add(label_math);
		panel_input.add(math);

		JPanel panel_button = new JPanel();
		panel_button.setBackground(new Color(255, 255, 255));
		panel_button.setBorder(new LineBorder(new Color(0, 0, 0)));
		JPanel panel3 = new JPanel(new BorderLayout());
		panel_button.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		// ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¹öÆ° ¸®½ºÆ®
		JButton button_insert = new JButton("ÀúÀå");
		button_insert.setForeground(Color.BLUE);
		button_insert.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 14));
		panel_button.add(button_insert);
		button_insert.addActionListener(new EventActionListener(table, hakbun, irum, kor, eng, math));
		JButton button_select = new JButton("Ãâ·Â");
		button_select.setForeground(new Color(0, 128, 0));
		button_select.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 14));
		panel_button.add(button_select);
		button_select.addActionListener(new EventActionListener(table));
		
		JButton button_search = new JButton("°Ë»ö");
		button_search.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 14));
		panel_button.add(button_search);
		button_search.addActionListener(new EventActionListener(table, hakbun));
		JButton button_update = new JButton("¼öÁ¤");
		button_update.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 14));
		panel_button.add(button_update);
		button_update.addActionListener(new EventActionListener(table, hakbun, kor, eng, math));
		JButton button_delete = new JButton("»èÁ¦");
		button_delete.setForeground(Color.RED);
		button_delete.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 14));
		panel_button.add(button_delete);
		button_delete.addActionListener(new EventActionListener(table));
		JButton button_ploting = new JButton("±×·¡ÇÁ");
		button_ploting.setForeground(new Color(255, 0, 255));
		button_ploting.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 14));
		panel_button.add(button_ploting);
		// ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¹öÆ° ¸®½ºÆ®

		panel3.add(panel_input, BorderLayout.NORTH);
		panel3.add(panel_button, BorderLayout.CENTER);
		contentPane.add(panel3, BorderLayout.SOUTH);

		JPanel panel_Additioinal = new JPanel();
		panel_Additioinal.setBackground(new Color(255, 255, 255));
		panel_Additioinal.setForeground(new Color(255, 250, 250));
		panel_Additioinal.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel3.add(panel_Additioinal, BorderLayout.SOUTH);
		panel_Additioinal.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel label_save = new JLabel("¡ØÀúÀå : ÇÐ¹ø, ÀÌ¸§, °ú¸ñÁ¡¼ö ÀÔ·Â");
		label_save.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		panel_Additioinal.add(label_save);

		JLabel label_select = new JLabel("¡ØÃâ·Â : ±×³É ¹öÆ° Å¬¸¯");
		label_select.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		panel_Additioinal.add(label_select);

		JLabel label_search = new JLabel("¡Ø°Ë»ö : ÇÐ¹ø ÀÔ·Â");
		label_search.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		panel_Additioinal.add(label_search);

		JLabel label_update = new JLabel("¡Ø¼öÁ¤ : ¼öÁ¤ÇÒ ÇÐ¹ø, Á¡¼öÀÔ·Â");
		label_update.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		panel_Additioinal.add(label_update);

		JLabel label_delete = new JLabel("¡Ø»èÁ¦ : Å×ÀÌºí¿¡¼­ »èÁ¦ÇÒ Çà Å¬¸¯");
		label_delete.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		panel_Additioinal.add(label_delete);

		JLabel label_graph = new JLabel("¡Ø±×·¡ÇÁ : Å×ÀÌºí¿¡¼­ PlotÇÒ Çà Å¬¸¯");
		label_graph.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		panel_Additioinal.add(label_graph);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		// -------------------------------------------------------------------------Â÷Æ®
		// °³ÀÎ¼ºÀû Â÷Æ®
		DrawingPanel_personal drawingPanel_Personal = new DrawingPanel_personal();
		tabbedPane.addTab("°³ÀÎ¼ºÀû Â÷Æ®", new ImageIcon(GUI_SeongJeok.class.getResource("/javax/swing/plaf/basic/icons/image-failed.png")), drawingPanel_Personal, null);
		tabbedPane.setForegroundAt(0, new Color(0, 0, 128));
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 224));
		FlowLayout fl_drawingPanel_Personal = (FlowLayout) drawingPanel_Personal.getLayout();
		fl_drawingPanel_Personal.setAlignOnBaseline(true);
		drawingPanel_Personal.setBorder(new LineBorder(new Color(0, 0, 0)));
		drawingPanel_Personal.setForeground(new Color(0, 0, 128));
		drawingPanel_Personal.setBackground(new Color(255, 228, 225));
		button_ploting.addActionListener(new EventActionListener(table, drawingPanel_Personal));
		
		//ÀüÃ¼¼ºÀû Â÷Æ®
		DrawingPanel_personal drawingPanel_Total = new DrawingPanel_personal();
		tabbedPane.addTab("ÀüÃ¼¼ºÀû Â÷Æ®", new ImageIcon(GUI_SeongJeok.class.getResource("/javax/swing/plaf/basic/icons/image-delayed.png")), drawingPanel_Total, null);
		tabbedPane.setBackgroundAt(1, new Color(255, 255, 224));
		tabbedPane.setForegroundAt(1, new Color(75, 0, 130));
		FlowLayout fl_drawingPanel_Total = (FlowLayout) drawingPanel_Total.getLayout();
		fl_drawingPanel_Total.setAlignOnBaseline(true);
		drawingPanel_Total.setBorder(new LineBorder(new Color(0, 0, 0)));
		drawingPanel_Total.setForeground(new Color(47, 79, 79));
		drawingPanel_Total.setBackground(new Color(255, 228, 225));
		button_select.addActionListener(new EventActionListener(table, drawingPanel_Total));
		// -------------------------------------------------------------------------Â÷Æ®

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
