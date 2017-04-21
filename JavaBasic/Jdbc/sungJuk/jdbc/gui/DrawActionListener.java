package sungJuk.jdbc.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DrawActionListener implements ActionListener{

	JTextField text1, text2, text3, txKor, txEng, txMath;
//	DrawingPanel drawingPanel;
	
	public DrawActionListener(JTextField txKor, JTextField txEng, JTextField txMath, DrawingPanel drawingPanel2) {
		this.txKor=txKor;
		this.txEng=txEng;
		this.txMath=txMath;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			int korean = Integer.parseInt(txKor.getText().trim());
			int english = Integer.parseInt(txEng.getText().trim());
			int math = Integer.parseInt(txMath.getText().trim());
//			drawingPanel.setScores(korean, english, math);
//			drawingPanel.repaint();
		}catch(NumberFormatException nfe){
//			JOptionPane.showMessageDialog(drawingPanel, "잘못된 숫자 포맷입니다.", "에러 메시지", JOptionPane.ERROR_MESSAGE);
		}
	}
}
