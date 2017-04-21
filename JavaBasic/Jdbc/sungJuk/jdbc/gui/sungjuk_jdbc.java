package sungJuk.jdbc.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class sungjuk_jdbc {
	static Connection con = null;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

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
				input_sungjuk();
				break;
			case 2:
				output_sungjuk();
				break;
			case 3:
				search_sungjuk();
				break;
			case 4:
				update_sungjuk();
				break;
			case 5:
				delete_sungjuk();
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

	private static void delete_sungjuk() {
		PreparedStatement pstmt = null;
		String sql = "delete from sungjuk where hakbun=?";
		try{
			Scanner sc = new Scanner(System.in);
			System.out.println("������ �й� �Է� => ");
			String hakbun = sc.next();
			
			con = connectDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  hakbun);
			int res = pstmt.executeUpdate();
			if(res==1)
				System.out.println(hakbun + "�й� ���� �Ϸ�!!");
			else
				System.out.println("�������� �ʴ� �й��Դϴ�.");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	private static void update_sungjuk() {
		Sungjuk obj = new Sungjuk();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "update sungjuk set kor=?, eng=?, math=?, tot=?, avg=?, grade=? where hakbun=?";
		
		try{
			Scanner sc = new Scanner(System.in);
			
			System.out.println("������ �й� �Է� => ");
			obj.hakbun = sc.next();
			System.out.print("\n���� �Է� => ");
			obj.kor = sc.nextInt();
			System.out.print("���� �Է� => ");
			obj.eng = sc.nextInt();
			System.out.print("���� �Է� => ");
			obj.math = sc.nextInt();
			obj.process();
			
			con = connectDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, obj.kor);
			pstmt.setInt(2, obj.eng);
			pstmt.setInt(3, obj.math);
			pstmt.setInt(4, obj.tot);
			pstmt.setDouble(5, obj.avg);
			pstmt.setString(6, obj.grade);
			int res = pstmt.executeUpdate();
			if(res==1){
				System.out.println(obj.hakbun+"�й� ���� �Ϸ� !!");
			}else{
				System.out.println("�������� �ʴ� �й��Դϴ�.");
			}
		}catch(Exception e){
			System.out.println("�����ͺ��̽� ���� ����!"+e.getMessage());
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}

	private static void search_sungjuk() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select *from sungjuk where hakbun = ?";
		
		try{
			Scanner sc = new Scanner(System.in);
			System.out.println("��ȸ�� �й� �Է� : ");
			String hakbun = sc.next();
			
			con = connectDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  hakbun);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				System.out.println();
				System.out.print("�й� : " + rs.getString("hakbun") + "\n");
				System.out.print("�̸� : " + rs.getString("irum") + "\n");
				System.out.print("���� : " + rs.getInt("kor") + "\n");
				System.out.print("���� : " + rs.getInt("eng") + "\n");
				System.out.print("���� : " + rs.getInt("math") + "\n");
				System.out.print("��÷ : " + rs.getInt("tot") + "\n");
				System.out.print("��� : " + rs.getDouble("avg") + "\n");
				System.out.print("��� : " + rs.getString("grade") + "\n");
			}else{
				System.out.println("����� �����Ͱ� �����ϴ�.");
			}
		}catch(Exception e){
			System.out.println("�����ͺ��̽� ���� ���� !!" + e.getMessage());
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}

	private static void output_sungjuk() {
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		String sql1 = "select count(*) from sungjuk";
		String sql2 = "select * from sungjuk order by hakbun";
		try {
			Sungjuk obj = new Sungjuk();
			con = connectDB();
			pstmt1 = con.prepareStatement(sql1);
			rs1 = pstmt1.executeQuery();
			rs1.next();
			if(rs1.getInt(1)==0)
				System.out.println("����� �����Ͱ� �����ϴ�.");
			else
				pstmt2 = con.prepareStatement(sql2);
				rs2 = pstmt2.executeQuery();
				System.out.println();
				System.out.println("\n                *** ����ǥ ***");
				System.out.println("==============================================");
				System.out.println(" �й�    �̸�     ����    ����    ����    ����    ���    ���");
				System.out.println("==============================================");
				while(rs2.next()){
					obj.hakbun = rs2.getString("hakbun");
					obj.irum = rs2.getString("irum");
					obj.kor = rs2.getInt("kor");
					obj.eng = rs2.getInt("eng");
					obj.math = rs2.getInt("math");
					obj.tot = rs2.getInt("tot");
					obj.avg = rs2.getDouble("avg");
					obj.grade = rs2.getString("grade");
					obj.output();
				}
				System.out.println("==============================================");
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� ���� ���� : " + e.getMessage());
		}finally{
			try{
				if(rs1 != null) rs1.close();
				if(rs2 != null) rs2.close();
				if(pstmt1 != null) pstmt1.close();
				if(pstmt2 != null) pstmt2.close();
				if(con != null) con.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}

	private static void input_sungjuk() {
		Sungjuk obj = new Sungjuk();
		
		System.out.println();
		obj.input();
		obj.process();
		
		con = connectDB();
		PreparedStatement pstmt = null;
		String sql = "insert into sungjuk(hakbun, irum, kor, eng, math, tot, avg, grade) values(?,?,?,?,?,?,?,?)";
		
		try{
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, obj.hakbun);
		pstmt.setString(2, obj.irum);
		pstmt.setInt(3, obj.kor);
		pstmt.setInt(4, obj.eng);
		pstmt.setInt(5, obj.math);
		pstmt.setInt(6, obj.tot);
		pstmt.setDouble(7, obj.avg);
		pstmt.setString(8, obj.grade);
		int res = pstmt.executeUpdate();
		if(res ==1 )
			System.out.println("�Է� ����");
		else
			System.out.println("�̹� �Էµ� �й��Դϴ�");
		}catch(Exception e){
			System.out.println("DB���� ����"+e.getMessage());
		}
		finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con!=null) con.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
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
			System.out.println("�����ͺ��̽� ���� ����!");
			e.printStackTrace();
		}
		return con;
	}

}


