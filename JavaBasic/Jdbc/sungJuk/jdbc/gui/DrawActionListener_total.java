package sungJuk.jdbc.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DrawActionListener_total implements ActionListener {
	Double avgKor, avgEng, avgMath, avgAvg;
	
	public DrawActionListener_total(Double avgKor, Double avgEng, Double avgMath, Double avgAvg) {
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
		String sql_total = "select avg(kor), avg(eng), avg(math), avg(avg) from sungjuk;";
		try {
			con = connectDB();
			pstmt = con.prepareStatement(sql_total);
			rs = pstmt.executeQuery();
			avgKor = rs.getDouble("avg(kor)");
			avgEng = rs.getDouble("avg(eng)");
			avgMath = rs.getDouble("avg(math)");
			avgAvg = rs.getDouble("avg(avg)");
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
