package sungJuk.jdbc.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EventActionListener implements ActionListener {
	static JTable table;
	JTextField txHakbun, txIrum, txKor, txEng, txMath, txTot, txAvg, txGrade;
	DrawingPanel_personal drawingPanel;

	// -----------------------------------------DB ����� ���� �غ�
	static Connection con = null;
	static Scanner sc = new Scanner(System.in);
	// model(DB�� �ѷ��� ���̺�)
	// -----------------------------------------DB

	EventActionListener() {

	}

	EventActionListener(JTable table, JTextField txHakbun, JTextField txKor, JTextField txEng, JTextField txMath) {
		this.table = table;
		this.txHakbun = txHakbun;
		this.txKor = txKor;
		this.txEng = txEng;
		this.txMath = txMath;
	}

	EventActionListener(JTable table) {
		this.table = table;
	}

	EventActionListener(JTable table, JTextField txHakbun) {
		this.table = table;
		this.txHakbun = txHakbun;
	}

	public EventActionListener(JTable table, DrawingPanel_personal drawingPanel) {
		this.table = table;
		this.drawingPanel = drawingPanel;
	}

	public EventActionListener(JTable table, JTextField txHakbun, JTextField txIrum, JTextField txKor, JTextField txEng,
			JTextField txMath) {
		super();
		this.table = table;
		this.txHakbun = txHakbun;
		this.txIrum = txIrum;
		this.txKor = txKor;
		this.txEng = txEng;
		this.txMath = txMath;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("����")) {
			insert();
		} else if (e.getActionCommand().equals("���")) {
			select();
		} else if (e.getActionCommand().equals("�˻�")) {
			search();
		} else if (e.getActionCommand().equals("����")) {
			update();
		} else if (e.getActionCommand().equals("����")) {
			delete();
		} else if (e.getActionCommand().equals("�׷���")) {
			draw();
		}
	}

	// ---------------------------------------------------------------------INSERT
	void insert() {
		int i, rowNum;
		String hakbun;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt_select = null;
		ResultSet rs = null;
		Sungjuk obj = new Sungjuk();

		// �Է°� ����ؼ� ����Ŭ������ �ִ� ��ü�鿡 ���� (������İ� ����)
		obj.hakbun = txHakbun.getText().trim();
		obj.irum = txIrum.getText().trim();
		obj.kor = Integer.parseInt(txKor.getText().trim());
		obj.eng = Integer.parseInt(txEng.getText().trim());
		obj.math = Integer.parseInt(txMath.getText().trim());
		obj.process();

		// ������ ���� Ŭ������ �ִ� ��ü�� �����ϴ� ��� -> ��ü�� ����� ������ SQL�� �����ؼ� DB�� ����
		// -> ��°�� �� �ٲ�
		con = connectDB();
		String sql_insert = "insert into sungjuk(hakbun, irum, kor, eng, math, tot, avg, grade) values(?,?,?,?,?,?,?,?)";
		String sql_select = "select *from sungjuk";

		try {
			pstmt = con.prepareStatement(sql_insert);
			pstmt.setString(1, obj.hakbun);
			pstmt.setString(2, obj.irum);
			pstmt.setInt(3, obj.kor);
			pstmt.setInt(4, obj.eng);
			pstmt.setInt(5, obj.math);
			pstmt.setInt(6, obj.tot);
			pstmt.setDouble(7, obj.avg);
			pstmt.setString(8, obj.grade);
			int res = pstmt.executeUpdate();
//			if (res == 1)
//				System.out.println("�Է� ����");
//			else
//				System.out.println("�̹� �Էµ� �й��Դϴ�");

			rowNum = GUI_SeongJeok.model.getRowCount();
			for (i = 0; i < rowNum; i++) {
				hakbun = GUI_SeongJeok.model.getValueAt(i, 0).toString().trim();
				if (obj.hakbun.equals(hakbun)) {
					System.out.println("�ߺ� ����");
					return;
				}
			}

			String arr[] = new String[8];
			arr[0] = obj.hakbun;
			arr[1] = obj.irum;
			arr[2] = Integer.toString(obj.kor);
			arr[3] = Integer.toString(obj.eng);
			arr[4] = Integer.toString(obj.math);
			arr[5] = Integer.toString(obj.tot);
			// arr[6] = obj.avg;
			arr[6] = Double.toString((Math.round(obj.avg * 100) / 100.));
			arr[7] = obj.grade;

			GUI_SeongJeok.model.addRow(arr);

			pstmt_select = con.prepareStatement(sql_select);
			rs = pstmt_select.executeQuery();
			rs.next();
			while (rs.next()) {
				txHakbun.setText(rs.getString("hakbun"));
				txIrum.setText(rs.getString("irum"));
				txKor.setText(rs.getString("kor"));
				txEng.setText(rs.getString("eng"));
				txMath.setText(rs.getString("math"));
			}

		} catch (Exception e) {
			System.out.println("DB���� ����" + e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		// ������ ���� Ŭ������ �ִ� ��ü�� �����ϴ� ��� -> SQL�� �����ؼ� DB�� ����
	}
	// ---------------------------------------------------------------------INSERT

	// ---------------------------------------------------------------------SELECT
	private void select() {
		PreparedStatement pstmt_select = null;
		ResultSet rs = null;
		String sql_select = "select *from sungjuk order by hakbun";
		try{
			Sungjuk obj = new Sungjuk();
			con = connectDB();
			pstmt_select = con.prepareStatement(sql_select);
			rs = pstmt_select.executeQuery();
			rs.next();
			GUI_SeongJeok.model.setNumRows(0);
				while(rs.next()){
					GUI_SeongJeok.model.addRow(new Object[]{
								rs.getString("hakbun"), 
								rs.getString("irum"), 
								rs.getString("kor"), 
								rs.getString("eng"), 
								rs.getString("math"), 
								rs.getString("tot"),
								rs.getString("avg"),
								rs.getString("grade")}
							);
				}
		}catch(Exception e){
			System.out.println("message1 : "+e.getMessage());
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt_select != null) pstmt_select.close();
				if(con != null) con.close();
			}catch(Exception e){
				System.out.println("message2 : "+e.getMessage());
			}
		}
	}
	// ---------------------------------------------------------------------SELECT

	// ----------------------------------------------------------SEARCH
	private void search() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql_search = "select *from sungjuk where hakbun = ?";

		try {
			String hakbun = txHakbun.getText().trim();
			con = connectDB();
			pstmt = con.prepareStatement(sql_search);
			pstmt.setString(1, hakbun);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				GUI_SeongJeok.model.addRow(new Object[] { rs.getString("hakbun"), rs.getString("irum"),
						rs.getString("kor"), rs.getString("eng"), rs.getString("math"), rs.getString("tot"),
						rs.getString("avg"), rs.getString("grade") });
			}
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� ���� ����~!!  why not~?   " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	// ----------------------------------------------------------SEARCH

	// --------------------------------------------------------------------------------UPDATE
	void update() {
		Sungjuk obj = new Sungjuk();
		String hakbun = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql_update = "update sungjuk set kor=?, eng=?, math=?, tot=?, avg=?, grade=? where hakbun=?";
		try {
			obj.hakbun = txHakbun.getText().trim();
			obj.kor = Integer.parseInt(txKor.getText().trim());
			obj.eng = Integer.parseInt(txKor.getText().trim());
			obj.math = Integer.parseInt(txMath.getText().trim());
			obj.process();

			int i, rowNum = GUI_SeongJeok.model.getRowCount();
			for (i = 0; i < rowNum; i++) {
				hakbun = GUI_SeongJeok.model.getValueAt(i, 0).toString().trim();
				if (obj.hakbun.equals(hakbun)) {
					GUI_SeongJeok.model.setValueAt(Integer.toString(obj.kor), i, 2);
					GUI_SeongJeok.model.setValueAt(Integer.toString(obj.eng), i, 3);
					GUI_SeongJeok.model.setValueAt(Integer.toString(obj.math), i, 4);
					GUI_SeongJeok.model.setValueAt(Integer.toString(obj.tot), i, 5);
					GUI_SeongJeok.model.setValueAt(Double.toString((Math.round(obj.avg * 100)) / 100.), i, 6);
					GUI_SeongJeok.model.setValueAt(obj.grade, i, 7);

					con = connectDB();
					pstmt = con.prepareStatement(sql_update);
					pstmt.setInt(1, obj.kor);
					pstmt.setInt(2, obj.eng);
					pstmt.setInt(3, obj.math);
					pstmt.setInt(4, obj.tot);
					pstmt.setDouble(5, obj.avg);
					pstmt.setString(6, obj.grade);
					pstmt.setString(7, obj.hakbun);
					rs = pstmt.executeQuery();

					System.out.println("�й� " + obj.hakbun + "���� ����!");

					txHakbun.setText("");
					txIrum.setText("");
					txKor.setText("");
					txEng.setText("");
					txMath.setText("");
					return;
				}
			}
		} catch (Exception e) {
//			 System.out.println("�����ͺ��̽� ���� ����~!! why not~? " +
//			 e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	// --------------------------------------------------------------------------------UPDATE

	// ---------------------------------------------------------------------DELETE
	void delete() {
		PreparedStatement pstmt = null;

		String sql_delete = "delete from sungjuk where hakbun = ?";
		try {
			int row = table.getSelectedRow();
			if (row == -1)
				return;
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			String hakbun = model.getValueAt(row, 0).toString().trim();
			model.removeRow(row);

			con = connectDB();
			pstmt = con.prepareStatement(sql_delete);
			pstmt.setString(1, hakbun);
			int res = pstmt.executeUpdate();
//			if (res == 1)
//				System.out.println("�й�" + hakbun + "���� ����!");
//			else
//				System.out.println("�������� �ʴ� �й��Դϴ�.");
		} catch (Exception e) {
			System.out.println("DB���� ���� " + e.getMessage());
		}
	}
	// ---------------------------------------------------------------------DELETE

	// ----------------------------------------------------------DRAW
	public void draw() {
		int kor = 0, eng = 0, math = 0, avg = 0;

		int row = table.getSelectedRow();
		if (row == -1)
			return;

		kor = Integer.parseInt((String) GUI_SeongJeok.model.getValueAt(row, 2));
		eng = Integer.parseInt((String) GUI_SeongJeok.model.getValueAt(row, 3));
		math = Integer.parseInt((String) GUI_SeongJeok.model.getValueAt(row, 4));
		avg = (int) Double.parseDouble((String) GUI_SeongJeok.model.getValueAt(row, 6));

		drawingPanel.setScores(kor, eng, math, avg);
		drawingPanel.repaint();
	}
	// ----------------------------------------------------------DRAW

	// ----------------------------------------------------------DB
	static Connection connectDB() {
		Connection con = null;

		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";

			Class.forName(driver);
			con = DriverManager.getConnection(url, "hkclass", "hkclass");
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� ���� ����!");
			e.printStackTrace();
		}
		return con;
	}
	// ----------------------------------------------------------DB

}
