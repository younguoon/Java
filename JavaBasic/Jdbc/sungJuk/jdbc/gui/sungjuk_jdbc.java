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
				search_sungjuk();
				break;
			case 4:
				update_sungjuk();
				break;
			case 5:
				delete_sungjuk();
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

	private static void delete_sungjuk() {
		PreparedStatement pstmt = null;
		String sql = "delete from sungjuk where hakbun=?";
		try{
			Scanner sc = new Scanner(System.in);
			System.out.println("삭제할 학번 입력 => ");
			String hakbun = sc.next();
			
			con = connectDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  hakbun);
			int res = pstmt.executeUpdate();
			if(res==1)
				System.out.println(hakbun + "학번 삭제 완료!!");
			else
				System.out.println("존재하지 않는 학번입니다.");
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
			
			System.out.println("수정할 학번 입력 => ");
			obj.hakbun = sc.next();
			System.out.print("\n국어 입력 => ");
			obj.kor = sc.nextInt();
			System.out.print("영어 입력 => ");
			obj.eng = sc.nextInt();
			System.out.print("수학 입력 => ");
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
				System.out.println(obj.hakbun+"학번 수정 완료 !!");
			}else{
				System.out.println("존재하지 않는 학번입니다.");
			}
		}catch(Exception e){
			System.out.println("데이터베이스 연결 실패!"+e.getMessage());
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
			System.out.println("조회할 학번 입력 : ");
			String hakbun = sc.next();
			
			con = connectDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  hakbun);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				System.out.println();
				System.out.print("학번 : " + rs.getString("hakbun") + "\n");
				System.out.print("이름 : " + rs.getString("irum") + "\n");
				System.out.print("국어 : " + rs.getInt("kor") + "\n");
				System.out.print("영어 : " + rs.getInt("eng") + "\n");
				System.out.print("수학 : " + rs.getInt("math") + "\n");
				System.out.print("총첨 : " + rs.getInt("tot") + "\n");
				System.out.print("평균 : " + rs.getDouble("avg") + "\n");
				System.out.print("등급 : " + rs.getString("grade") + "\n");
			}else{
				System.out.println("출력할 데이터가 없습니다.");
			}
		}catch(Exception e){
			System.out.println("데이터베이스 연결 실패 !!" + e.getMessage());
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
				System.out.println("출력할 데이터가 없습니다.");
			else
				pstmt2 = con.prepareStatement(sql2);
				rs2 = pstmt2.executeQuery();
				System.out.println();
				System.out.println("\n                *** 성적표 ***");
				System.out.println("==============================================");
				System.out.println(" 학번    이름     국어    영어    수학    총점    평균    등급");
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
			System.out.println("데이터베이스 연결 실패 : " + e.getMessage());
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
			System.out.println("입력 성공");
		else
			System.out.println("이미 입력된 학번입니다");
		}catch(Exception e){
			System.out.println("DB연결 실패"+e.getMessage());
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
			System.out.println("데이터베이스 연결 실패!");
			e.printStackTrace();
		}
		return con;
	}

}


