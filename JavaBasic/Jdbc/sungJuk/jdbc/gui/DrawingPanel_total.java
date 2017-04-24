package sungJuk.jdbc.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawingPanel_total extends JPanel{
	int avgKor, avgEng, avgMath, avgAvg;
	
	public void paint(Graphics g){
//		System.out.println("U CLICKED drawingPanel_total");
		g.clearRect(0, 0, getWidth(), getHeight());
		g.drawLine(50, 250, 450, 250);
		for (int i = 0; i < 11; i++) {
			g.drawString(i*10 + "", 25, 255-20*i);
			g.drawLine(50, 250-20*i, 450, 250-20*i);
		}
		g.drawLine(50, 40, 50, 250);
		g.drawString("국어", 100, 270);
		g.drawString("영어", 200, 270);
		g.drawString("수학", 300, 270);
		g.drawString("평균", 400, 270);
		g.setColor(Color.DARK_GRAY);
		if(avgKor>0)
			g.fillRect(110, (int)(250-avgKor*2), 10, (int)(avgKor*2));
		if(avgEng>0)
			g.fillRect(210, (int)(250-avgEng*2), 10, (int)(avgEng*2));
		if(avgMath>0)
			g.fillRect(310, (int)(250-avgMath*2), 10, (int)(avgMath*2));
		if(avgAvg>0)
			g.setColor(Color.MAGENTA);
			g.fillRect(410, (int)(250-avgAvg*2), 10, (int)(avgAvg*2));
	}	
	void setScores(int avgKor, int avgEng, int avgMath, int avgAvg){
		this.avgKor=avgKor;
		this.avgEng=avgEng;
		this.avgMath=avgMath;
		this.avgAvg=avgAvg;
	}
}



