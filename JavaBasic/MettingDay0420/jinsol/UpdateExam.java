package jinsol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.4.120:1521:orcl";
		
		Connection con = null;
		Statement stmt = null;

		
		String hakbun,addr,phone;
		
		
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member 테이블값 갱신하기....");
			
			System.out.print("갱신할 학번입력:");
			hakbun = br.readLine();
		
			System.out.print("새 주소입력:");
			addr = br.readLine();
			System.out.print("새 전화번호입력:");
			phone = br.readLine();
			
			String sql = "Update member set addr= '"+addr;
			sql+="', phone='"+phone+"'Where hakbun='";
			sql += hakbun + "'";
			
			System.out.println(sql);
			Class.forName(driver);
			con = DriverManager.getConnection(url,"scott","123456");
			stmt = con.createStatement();
			int res = stmt.executeUpdate(sql);
			if (res == 1)
				System.out.println("데이터베이스 연결 성공");
		}
		catch(Exception e){
			System.out.println("데이터베이스 연결 실패!="+e.getMessage());
		}
		finally{
			try{
				if(con != null) con.close();
				if(stmt != null) stmt.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			
		}
		

	}

}
