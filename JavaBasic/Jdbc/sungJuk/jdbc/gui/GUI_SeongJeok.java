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


public class GUI_SeongJeok {
	static String colNames[] = {"ÇÐ¹ø", "ÀÌ¸§", "±¹¾î", "¿µ¾î", "¼öÇÐ", "ÃÑÁ¡", "Æò±Õ", "µî±Þ"};
    static DefaultTableModel model = new DefaultTableModel(colNames, 0);
    
	public static void main(String[] args) {
		JFrame frame = new JFrame("\uC131\uC801\uAD00\uB9AC \uD504\uB85C\uADF8\uB7A8");
		frame.setBackground(new Color(255, 255, 255));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI_SeongJeok.class.getResource("/com/sun/java/swing/plaf/motif/icons/Inform.gif")));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 19));
		frame.setPreferredSize(new Dimension(500, 820));
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
		
        int widths[] = {70,70,50,50,50,50,50,50};
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

        
//----------------------------------------------------------µ¥ÀÌÅÍ ÀÔ·Â
        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(255, 255, 255));
        panel1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel1.setLayout(new GridLayout(0, 10, 0, 0));
        JLabel label = new JLabel("ÇÐ¹ø");
        label.setForeground(new Color(0, 0, 128));
        label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel1.add(label);
        panel1.add(hakbun);
        JLabel label_1 = new JLabel("ÀÌ¸§");
        label_1.setForeground(new Color(0, 0, 128));
        label_1.setBackground(new Color(255, 255, 255));
        label_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
        label_1.setHorizontalAlignment(SwingConstants.CENTER);
        panel1.add(label_1);
        panel1.add(irum);
        JLabel label_2 = new JLabel("±¹¾î");
        label_2.setForeground(new Color(0, 0, 128));
        label_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
        label_2.setHorizontalAlignment(SwingConstants.CENTER);
        panel1.add(label_2);
        panel1.add(kor);
        JLabel label_3 = new JLabel("¿µ¾î");
        label_3.setForeground(new Color(0, 0, 128));
        label_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
        label_3.setHorizontalAlignment(SwingConstants.CENTER);
        panel1.add(label_3);
        panel1.add(eng);
        JLabel label_4 = new JLabel("¼öÇÐ");
        label_4.setForeground(new Color(0, 0, 128));
        label_4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
        label_4.setHorizontalAlignment(SwingConstants.CENTER);
        panel1.add(label_4);
        panel1.add(math);

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(255, 255, 255));
        panel2.setBorder(new LineBorder(new Color(0, 0, 0)));
        JPanel panel3 = new JPanel(new BorderLayout());
                panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        //----------------------------------------------------------µ¥ÀÌÅÍ ÀÔ·Â
                
                
        //----------------------------------------------------------µ¥ÀÌÅÍ ÀúÀå
                JButton button_insert = new JButton("ÀúÀå");
                button_insert.setForeground(Color.BLUE);
                button_insert.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 14));
                        panel2.add(button_insert);
                        //----------------------------------------------------------µ¥ÀÌÅÍ ÀúÀå
                        
                              
                        //----------------------------------------------------------µ¥ÀÌÅÍ Â÷Æ®·Î º¯È¯
                                button_insert.addActionListener(new EventActionListener(table, hakbun, irum, kor, eng, math));
        JButton button_select = new JButton("Ãâ·Â");
        button_select.setForeground(new Color(0, 128, 0));
        button_select.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 14));
        panel2.add(button_select);
        button_select.addActionListener(new EventActionListener(table));
        JButton button_search = new JButton("°Ë»ö");
        button_search.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 14));
        panel2.add(button_search);
        button_search.addActionListener(new EventActionListener(table, hakbun));
        JButton button_update = new JButton("¼öÁ¤");
        button_update.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 14));
        panel2.add(button_update);
        button_update.addActionListener(new EventActionListener(table, hakbun, kor, eng, math));
        JButton button_delete = new JButton("»èÁ¦");
        button_delete.setForeground(Color.RED);
        button_delete.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 14));
        panel2.add(button_delete);
        button_delete.addActionListener(new EventActionListener(table));
        JButton button_ploting = new JButton("\uADF8\uB798\uD504");
        button_ploting.setForeground(new Color(255, 0, 255));
        button_ploting.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 14));
        panel2.add(button_ploting);

        panel3.add(panel1, BorderLayout.NORTH);
        panel3.add(panel2, BorderLayout.CENTER);
        contentPane.add(panel3, BorderLayout.SOUTH);
        
        JPanel panel_Additioinal = new JPanel();
        panel_Additioinal.setBackground(new Color(255, 255, 255));
        panel_Additioinal.setForeground(new Color(255, 250, 250));
        panel_Additioinal.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel3.add(panel_Additioinal, BorderLayout.SOUTH);
        panel_Additioinal.setLayout(new GridLayout(0, 2, 0, 0));
        
        JLabel lblNewLabel = new JLabel("\u203B\uC800\uC7A5 : \uD559\uBC88, \uC774\uB984, \uACFC\uBAA9\uC810\uC218 \uC785\uB825");
        lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
        panel_Additioinal.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("\u203B\uCD9C\uB825 : \uADF8\uB0E5 \uBC84\uD2BC \uD074\uB9AD");
        lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
        panel_Additioinal.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("\u203B\uAC80\uC0C9 : \uD559\uBC88 \uC785\uB825");
        lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
        panel_Additioinal.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("\u203B\uC218\uC815 : \uC218\uC815\uD560 \uD559\uBC88, \uC810\uC218\uC785\uB825");
        lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
        panel_Additioinal.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("\u203B\uC0AD\uC81C : \uD14C\uC774\uBE14\uC5D0\uC11C \uC0AD\uC81C\uD560 \uD589 \uD074\uB9AD");
        lblNewLabel_4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
        panel_Additioinal.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("\u203B\uADF8\uB798\uD504 : \uD14C\uC774\uBE14\uC5D0\uC11C Plot\uD560 \uD589 \uD074\uB9AD");
        lblNewLabel_5.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
        panel_Additioinal.add(lblNewLabel_5);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0)));
        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
        DrawingPanel drawingPanel_Personal = new DrawingPanel();
        tabbedPane.addTab("\uAC1C\uC778 \uC131\uC801\uCC28\uD2B8", null, drawingPanel_Personal, null);
        tabbedPane.setForegroundAt(0, new Color(0, 128, 128));
        tabbedPane.setBackgroundAt(0, new Color(152, 251, 152));
        FlowLayout fl_drawingPanel_Personal = (FlowLayout) drawingPanel_Personal.getLayout();
        fl_drawingPanel_Personal.setAlignOnBaseline(true);
        drawingPanel_Personal.setBorder(new LineBorder(new Color(0, 0, 0)));
        drawingPanel_Personal.setForeground(new Color(25, 25, 112));
        drawingPanel_Personal.setBackground(new Color(0, 255, 255));
        button_ploting.addActionListener(new EventActionListener(table, drawingPanel_Personal));
        
        DrawingPanel drawingPanel_Total = new DrawingPanel();
        drawingPanel_Total.setForeground(new Color(25, 25, 112));
        drawingPanel_Total.setBorder(new LineBorder(new Color(0, 0, 0)));
        drawingPanel_Total.setBackground(new Color(0, 255, 255));
        tabbedPane.addTab("\uC804\uCCB4 \uC131\uC801\uCC28\uD2B8", null, drawingPanel_Total, null);
        tabbedPane.setBackgroundAt(1, new Color(152, 251, 152));
        tabbedPane.setForegroundAt(1, new Color(0, 128, 128));
//----------------------------------------------------------µ¥ÀÌÅÍ Â÷Æ®·Î º¯È¯
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);	}
}



