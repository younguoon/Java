package jinsol.preparedSatement;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class InsertExam02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.4.120:1521:orcl";
		
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;

		String sql = "Insert Into member (hakbun,name,addr,phone) Values(?,?,?,?)";
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
			
			
			System.out.println(sql);
			Class.forName(driver);
			con = DriverManager.getConnection(url,"scott","123456");
			
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,hakbun);
			pstmt.setString(2,name);
			pstmt.setString(3,addr);
			pstmt.setString(4,phone);
			pstmt.executeUpdate(sql);
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
