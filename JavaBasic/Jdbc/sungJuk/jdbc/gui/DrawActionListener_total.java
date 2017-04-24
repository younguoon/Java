package sungJuk.jdbc.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DrawActionListener_total implements ActionListener {
	int avgKor, avgEng, avgMath, avgAvg;
	
	public DrawActionListener_total(int avgKor, int avgEng, int avgMath, int avgAvg, DrawingPanel_total drawingpanel_total) {
		this.avgKor = avgKor;
		this.avgEng = avgEng;
		this.avgMath = avgMath;
		this.avgAvg = avgAvg;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		String sql_total = "select ceil(avg(kor)) avgKor, ceil(avg(eng)) avgEng, ceil(avg(math)) avgMath, ceil(avg(avg)) avgAvg from sungjuk";
		try {
			System.out.println("HERE IS total listener ~! Connected DB ");
			con = connectDB();
			pstmt = con.prepareStatement(sql_total);
			rs = pstmt.executeQuery();
			avgKor = rs.getInt("avgKor");
			avgEng = rs.getInt("avgEng");
			avgMath = rs.getInt("avgMath");
			avgAvg = rs.getInt("avgAvg");
			System.out.println(avgKor);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
				System.out.println("message2 : " + ex.getMessage());
			}
		}
	}

	static Connection connectDB() {
		Connection con = null;

		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";

			Class.forName(driver);
			con = DriverManager.getConnection(url, "hkclass", "hkclass");
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패!");
			e.printStackTrace();
		}
		return con;
	}
}
