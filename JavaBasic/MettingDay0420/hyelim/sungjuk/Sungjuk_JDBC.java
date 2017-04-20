package hyelim.sungjuk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Sungjuk_JDBC {

	public static void main(String[] args) {
		// ArrayList<Sungjuk> sungjuk = new ArrayList<Sungjuk>();
		Scanner scan = new Scanner(System.in);

		// database connect
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		while (true) {
			int menu;

			System.out.println("\n*** �޴� ***");
			System.out.println("1. ���� �Է�");
			System.out.println("2. ���� ���");
			System.out.println("3. ���� ��ȸ");
			System.out.println("4. ���� ����");
			System.out.println("5. ���� ����");
			System.out.println("6. ��     ��\n");

			System.out.print("�޴� ����(1~6) => ");
			menu = scan.nextInt();

			switch (menu) {
			case 1:
				input_sungjuk(driver, url, con, pstmt);
				break;
			case 2:
				output_sungjuk(driver, url, con, stmt);
				break;
			case 3:
				search_sungjuk(driver, url, con, stmt);
				break;
			case 4:
				update_sungjuk(driver, url, con, pstmt);
				break;
			case 5:
				delete_sungjuk(driver, url, con, pstmt);
				break;
			case 6:
				System.out.println("\n���α׷� ����...");
				break;
			default:
				System.out.println("\n�޴��� �ٽ� �����ϼ���!!!");
				break;
			}

			if (menu == 6) {
				break;
			}
		}
	}

	static void input_sungjuk(String driver, String url, Connection con, PreparedStatement pstmt) {
		String hakbun, irum, kor, eng, math;
		Sungjuk obj = new Sungjuk();
		try {
			obj.input();
			obj.process();

			String sql = "insert into sungjuk values(?, ?, ?, ?, ?, ?, ?, ?)";

			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, obj.hakbun);
			pstmt.setString(2, obj.irum);
			pstmt.setInt(3, obj.kor);
			pstmt.setInt(4, obj.eng);
			pstmt.setInt(5, obj.math);
			pstmt.setInt(6, obj.tot);
			pstmt.setDouble(7, obj.avg);
			pstmt.setString(8, obj.grade);

			pstmt.executeUpdate();
			System.out.println("\n���� �Է� ����!!!");
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� ���� ����! = " + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
	}

	static void output_sungjuk(String driver, String url, Connection con, Statement stmt) {
		try {

			String sql = "select * from sungjuk";

			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");

			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);

			System.out.println();
			System.out.println("\n                *** ����ǥ ***");
			System.out.println("==============================================");
			System.out.println(" �й�    �̸�     ����    ����    ����    ����    ���    ���");
			System.out.println("==============================================");
			while (rs.next()) {
				System.out.print(rs.getString("hakbun") + "\t");
				System.out.print(rs.getString("irum") + "\t");
				System.out.print(rs.getString("kor") + "\t");
				System.out.print(rs.getString("eng") + "\t");
				System.out.print(rs.getString("math") + "\t");
				System.out.print(rs.getString("tot") + "\t");
				System.out.print(rs.getString("avg") + "\t");
				System.out.print(rs.getString("grade") + "\n");
			}
			System.out.println("==============================================");
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� ���� ����! = " + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
	}

	static void search_sungjuk(String driver, String url, Connection con, Statement stmt) {
		Scanner scan = new Scanner(System.in);

		System.out.print("\n��ȸ�� �й� �Է�  => ");
		String hakbun = scan.next();

		try {
			String sql = "select * from sungjuk where hakbun = '" + hakbun + "'";

			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			rs.next();
			System.out.print("�й� : " + rs.getString("hakbun") + "\n");
			System.out.print("�̸� : " + rs.getString("irum") + "\n");
			System.out.print("���� : " + rs.getInt("kor") + "\n");
			System.out.print("���� : " + rs.getInt("eng") + "\n");
			System.out.print("���� : " + rs.getInt("math") + "\n");
			System.out.print("��÷ : " + rs.getInt("tot") + "\n");
			System.out.print("��� : " + rs.getDouble("avg") + "\n");
			System.out.print("��� : " + rs.getString("grade") + "\n");

		} catch (Exception e) {
			System.out.println("�����ͺ��̽� ���� ����! = " + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}

	}

	static void update_sungjuk(String driver, String url, Connection con, PreparedStatement pstmt) {
		Scanner scan = new Scanner(System.in);
		System.out.print("\n������ �й� �Է� => ");
		String hakbun = scan.next();
		Sungjuk obj = new Sungjuk();
		int kor, eng, math;
		try {
			String sql = "update sungjuk " + "set kor = ?, eng = ?, math = ?, " + "tot = ?, avg = ?, grade = ?"
					+ "where hakbun = ?";
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
			pstmt = con.prepareStatement(sql);

			System.out.print("\n���� �Է� => ");
			kor = scan.nextInt();
			System.out.print("���� �Է� => ");
			eng = scan.nextInt();
			System.out.print("���� �Է� => ");
			math = scan.nextInt();

			obj.hakbun = hakbun;
			obj.kor = kor;
			obj.kor = eng;
			obj.kor = math;
			obj.process();

			pstmt.setInt(1, obj.kor);
			pstmt.setInt(2, obj.eng);
			pstmt.setInt(3, obj.math);
			pstmt.setInt(4, obj.tot);
			pstmt.setDouble(5, obj.avg);
			pstmt.setString(6, obj.grade);
			pstmt.executeUpdate();

			System.out.println("\n" + hakbun + " �й� ���� �Ϸ�!!!");
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� ���� ����! = " + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}

	}

	static void delete_sungjuk(String driver, String url, Connection con, PreparedStatement pstmt) {
		Scanner scan = new Scanner(System.in);
		System.out.print("\n������ �й� �Է� => ");
		String hakbun = scan.next();

		try {
			String sql = "delete from sungjuk where hakbun = ?";

			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, hakbun);
			pstmt.executeUpdate(); // executeUpdate()�� ����, ����, ������ �� �� ������ ����
									// ������ ��ȯ��
			System.out.println("\n" + hakbun + " �й� ���� �Ϸ�!!!");
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� ���� ����! = " + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}

	}
}
