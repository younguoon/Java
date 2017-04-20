package jinsol.others;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import jinsol.Sungjuk;

public class Sungjuk_DB {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		while (true) {
			int menu;

			System.out.println("\n*** 메뉴 ***");
			System.out.println("1. 성적 입력");
			System.out.println("2. 성적 출력");
			System.out.println("3. 성적 조회");
			System.out.println("4. 성적 수정");
			System.out.println("5. 성적 삭제");
			System.out.println("6. 종     료\n");

			System.out.print("메뉴 선택(1~6) => ");
			menu = scan.nextInt();

			switch (menu) {
			case 1:
				input_sungjuk();
				break;
			case 2:
				output_sungjuk();
				break;
			case 3:
				// search_sungjuk(sungjuk);
				break;
			case 4:
				// update_sungjuk(sungjuk);
				break;
			case 5:
				// delete_sungjuk(sungjuk);
				break;
			case 6:
				System.out.println("\n프로그램 종료...");
				break;
			default:
				System.out.println("\n메뉴를 다시 선택하세요!!!");
				break;
			}

			if (menu == 6) {
				break;
			}
		}
	}

	static void input_sungjuk() {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.4.120:1521:orcl";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "Insert Into sungjuk (hakbun,irum,kor,eng,math) Values(?,?,?,?,?)";
		String hakbun, irum, kor, eng, math;

		try {
			Sungjuk obj = new Sungjuk();
			System.out.println();
			obj.input();
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, obj.hakbun);
			pstmt.setString(2, obj.irum);
			pstmt.setLong(3, obj.kor);
			pstmt.setLong(4, obj.eng);
			pstmt.setLong(5, obj.math);
			pstmt.executeUpdate();
			System.out.println("\n성적 입력 성공!!!");
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패!=" + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}

	static void output_sungjuk() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.4.120:1521:orcl";

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "Select * from sungjuk";

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("hakbun\tirum\tkor\teng\tmath");
			System.out.println("---------------------------------------");

			while (rs.next()) {
				System.out.println(rs.getString("hakbun") + "\t" + rs.getString("irum") + "\t" + rs.getString("kor")
						+ "\t" + rs.getString("eng") + "\t" + rs.getString("math") + "\n");
				/*
				 * System.out.println(rs.getString("irum")+"\t");
				 * System.out.println(rs.getString("kor")+"\t");
				 * System.out.println(rs.getString("eng")+"\t");
				 * System.out.println(rs.getString("math")+"\n");
				 */
			}
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패!");
			e.printStackTrace();
		}

		finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	static void search_sungjuk(ArrayList<Sungjuk> sungjuk) {
	}

	static void update_sungjuk(ArrayList<Sungjuk> sungjuk) {
	}

	static void delete_sungjuk(ArrayList<Sungjuk> sungjuk) {

	}

}
