package jinsol.call;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/*create or replace procedure call_insert(hakbun MEMBER.HAKBUN%TYPE,
name MEMBER.NAME%TYPE, addr MEMBER.ADDR%TYPE, phone MEMBER.PHONE%TYPE)
is
begin
insert into member values (hakbun,name,addr,phone);
end;
*/


public class InsertExam_CALL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.4.120:1521:orcl";
		
		Connection con = null; 
		CallableStatement cstmt = null;
		ResultSet rs=null;
		
		String hakbun,name,addr,phone;
		
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member 테이블값 추가하기....");
			
			System.out.print("학번입력:");
			hakbun = br.readLine();
			System.out.print("이름입력:");
			name = br.readLine();
			System.out.print("주소입력:");
			addr = br.readLine();
			System.out.print("전화번호입력:");
			phone = br.readLine();
			
			
			
			Class.forName(driver);
			con = DriverManager.getConnection(url,"scott","123456");
			
			
			cstmt = con.prepareCall("{call call_insert(?,?,?,?)}");
			cstmt.setString(1,hakbun);
			cstmt.setString(2,name);
			cstmt.setString(3,addr);
			cstmt.setString(4,phone);
			cstmt.executeUpdate();
			System.out.println("데이터베이스 연결 성공");
			
		}
		catch(Exception e){
			System.out.println("데이터베이스 연결 실패!="+e.getMessage());
		}
		finally{
			try{
				if(con != null) con.close();
				if(cstmt != null) cstmt.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			
		}
	}

}
