package seongJeokGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EventActionListener implements ActionListener {
	JTable table;
	JTextField txHakbun, txIrum, txKor, txEng, txMath, txTot, txAvg, txGrade;
	DrawingPanel drawingPanel;

	EventActionListener() {
	}

	EventActionListener(JTable table) {
		this.table = table;
	}

	public EventActionListener(JTable table, DrawingPanel drawingPanel) {
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
		if (e.getActionCommand().equals("추가")) {
			insert();
		} else if (e.getActionCommand().equals("삭제")) {
			delete();
		} else if (e.getActionCommand().equals("수정")) {
			update();
		} else if (e.getActionCommand().equals("그래프 그리기")){
			draw();
		}
	}

	private void draw() {
		int kor = 0, eng = 0, math = 0, avg = 0;

		int row = table.getSelectedRow();
		if (row == -1)
			return;

		DefaultTableModel model = (DefaultTableModel) table.getModel();

		kor = Integer.parseInt((String) model.getValueAt(row, 2));
		eng = Integer.parseInt((String) model.getValueAt(row, 3));
		math = Integer.parseInt((String) model.getValueAt(row, 4));
		avg = (int)Double.parseDouble((String) model.getValueAt(row, 6));

		drawingPanel.setScores(kor, eng, math, avg);
		drawingPanel.repaint();
	}

	void insert() {
		int i, rowNum;
		String hakbun;
		SeongJeok obj = new SeongJeok();

		obj.hakbun = txHakbun.getText().trim();
		obj.irum = txIrum.getText().trim();
		obj.kor = Integer.parseInt(txKor.getText().trim());
		obj.eng = Integer.parseInt(txEng.getText().trim());
		obj.math = Integer.parseInt(txMath.getText().trim());
		obj.process();
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		rowNum = model.getRowCount();
		for (i = 0; i < rowNum; i++) {
			hakbun = model.getValueAt(i, 0).toString().trim();
			if (obj.hakbun.equals(hakbun)) {
				System.out.println("중복 오류");
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

		model.addRow(arr);
		System.out.println("학번" + obj.hakbun + "추가 성공!");

		txHakbun.setText("");
		txIrum.setText("");
		txKor.setText("");
		txEng.setText("");
		txMath.setText("");
	}

	void delete() {
		int row = table.getSelectedRow();
		if (row == -1)
			return;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String hakbun = model.getValueAt(row, 0).toString().trim();
		model.removeRow(row);
		System.out.println("학번" + hakbun + "삭제 성공!");
	}

	void update() {
		int i, rowNum;
		String hakbun = null;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		SeongJeok obj = new SeongJeok();

		obj.hakbun = txHakbun.getText().trim();
		obj.kor = Integer.parseInt(txKor.getText().trim());
		obj.eng = Integer.parseInt(txEng.getText().trim());
		obj.math = Integer.parseInt(txMath.getText().trim());
		obj.process();

		rowNum = model.getRowCount();
		for (i = 0; i < rowNum; i++) {
			hakbun = model.getValueAt(i, 0).toString().trim();
			if (obj.hakbun.equals(hakbun)) {
				model.setValueAt(Integer.toString(obj.kor), i, 2);
				model.setValueAt(Integer.toString(obj.eng), i, 3);
				model.setValueAt(Integer.toString(obj.math), i, 4);
				model.setValueAt(Integer.toString(obj.tot), i, 5);
				model.setValueAt(Double.toString((Math.round(obj.avg * 100)) / 100.), i, 6);
				model.setValueAt(obj.grade, i, 7);
				System.out.println("학번 " + obj.hakbun + "수정 성공!");
				txHakbun.setText("");
				txIrum.setText("");
				txKor.setText("");
				txEng.setText("");
				txMath.setText("");
				return;
			}
		}
		System.out.println("학번 " + obj.hakbun + "수정 실패!");

	}
}





