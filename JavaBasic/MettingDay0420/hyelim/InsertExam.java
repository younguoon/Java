package hyelim;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class InsertExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		Statement stmt = null;
		
		String sql = "insert into member(hakbun, name, addr, phone) values";
		String hakbun, name, addr, phone;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member 테이블 값 추가하기......");
			System.out.print("학번 입력 : ");
			hakbun = br.readLine();
			System.out.print("이름 입력 : ");
			name = br.readLine();
			System.out.print("주소 입력 : " );
			addr = br.readLine();
			System.out.print("전화번호 입력 : " );
			phone = br.readLine();
			
			sql += "('"+hakbun+"', '"+name+"', '"+addr+"' , '"+phone+"')";
			System.out.println(sql);
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
			stmt = con.createStatement();
			int res = stmt.executeUpdate(sql);
			if(res == 1)
				System.out.println("데이터베이스 연결 성공!");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("데이터베이스 연결 실패! = " + e.getMessage());
		} finally {
			try {
				if(con != null) con.close();
				if(stmt != null) stmt.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
	}

}
