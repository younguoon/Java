package seongJeokGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EventActionListener implements ActionListener{
	JTable table;
	JTextField txHakbun, txIrum, txKor, txEng, txMath, txTot, txAvg, txGrade;
	
	EventActionListener(){
	}
	
	EventActionListener(JTable table){
		this.table = table;
	}
	
	public EventActionListener(JTable table, JTextField txHakbun, JTextField txIrum, JTextField txKor, JTextField txEng, JTextField txMath) {
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
		if(e.getActionCommand().equals("추가")){
			insert();
		}else if(e.getActionCommand().equals("삭제")){
			delete();
		}else{
			update();
		}
	}

	void insert(){
		SeongJeok obj = new SeongJeok();
		int i, rowNum, flag=0;
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		obj.hakbun = txHakbun.getText().trim();
		rowNum = model.getRowCount();
		
		for (i = 0; i < rowNum; i++) {
			String table_hakbun = model.getValueAt(i, 0).toString().trim();
			if(table_hakbun.equals(obj.hakbun)){
				flag=1;
				break;
			}
		}
		
		if(flag==0){
			obj.irum = txIrum.getText().trim();
			obj.kor = Integer.parseInt(txKor.getText().trim());
			obj.eng = Integer.parseInt(txEng.getText().trim());
			obj.math = Integer.parseInt(txMath.getText().trim());
			obj.process();
			
			Object arr[] = new Object[8];
			arr[0] = obj.hakbun;
			arr[1] = obj.irum;
			arr[2] = obj.kor;
			arr[3] = obj.eng;
			arr[4] = obj.math;
			arr[5] = obj.tot;
			arr[6] = obj.avg;
			arr[7] = obj.grade;
			
			model.addRow(arr);
			System.out.println("학번"+obj.hakbun+"추가 성공!");
		}else
			System.out.println("학번 "+obj.hakbun+"중복오류로 추가 실패!");
		
		txHakbun.setText("");
		txIrum.setText("");
		txKor.setText("");
		txEng.setText("");
		txMath.setText("");
	}

	void delete() {
		int row = table.getSelectedRow();
		if(row==-1)
			return;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String hakbun = model.getValueAt(row, 0).toString().trim();
		model.removeRow(row);
		System.out.println("학번"+hakbun+"삭제 성공!");
	}

	void update() {
		int i, rowNum, flag=0;
		String table_hakbun = null;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		SeongJeok obj = new SeongJeok();
		
		obj.hakbun = txHakbun.getText().trim();
		obj.kor = Integer.parseInt(txKor.getText().trim());
		obj.eng = Integer.parseInt(txEng.getText().trim());
		obj.math = Integer.parseInt(txMath.getText().trim());
		obj.process();
		
		rowNum = model.getRowCount();
		for (i = 0; i < rowNum; i++) {
			table_hakbun = model.getValueAt(i, 0).toString().trim();
			if(table_hakbun.equals(obj.hakbun)){
				model.setValueAt(obj.kor, i, 2);
				model.setValueAt(obj.eng, i, 3);
				model.setValueAt(obj.math, i, 4);
				model.setValueAt(obj.tot, i, 5);
				model.setValueAt(obj.avg, i, 6);
				model.setValueAt(obj.grade, i, 7);
				flag=1;
				break;
			}
		}
		if(flag==0)
			System.out.println("학번 "+obj.hakbun+"수정 실패!");
		else
			System.out.println("학번 "+obj.hakbun+"수정 성공!");
		
		txHakbun.setText("");
		txIrum.setText("");
		txKor.setText("");
		txEng.setText("");
		txMath.setText("");
		
	}
}




