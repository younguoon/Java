package sungJuk.jdbc.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DrawActionListener_personal implements ActionListener{
	JTextField text1, text2, text3, txKor, txEng, txMath;
	
	public DrawActionListener_personal(JTextField txKor, JTextField txEng, JTextField txMath, DrawingPanel_personal drawingPanel_personal) {
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
		}catch(NumberFormatException nfe){
			JOptionPane.showInputDialog(JOptionPane.ERROR_MESSAGE);
		}
	}
}


