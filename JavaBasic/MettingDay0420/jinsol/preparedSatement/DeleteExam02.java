package jinsol.preparedSatement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DeleteExam02 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

				String driver = "oracle.jdbc.driver.OracleDriver";
				String url = "jdbc:oracle:thin:@192.168.4.120:1521:orcl";
				
				Connection con = null; 
				Statement stmt = null;
				PreparedStatement pstmt = null;

				
				String hakbun;
				
				
				try{
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					System.out.println("Member 테이블값 삭제하기....");
					
					System.out.print("삭제할 학번입력:");
					hakbun = br.readLine();
				
					String sql = "Delete from member where hakbun =?";
					
					System.out.println(sql);
					Class.forName(driver);
					con = DriverManager.getConnection(url,"scott","123456");
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, hakbun);
					
					int res = pstmt.executeUpdate();//executeUpdate는 반환값을 가진다->반환값으로 오류를 확인할 수 있음
					if (res == 1) //executeUpdate는 업뎃,삽입,삭제한 쿼리의  ROWCOUNT 반환한다 1이면 한개삭제
						System.out.println("데이터베이스 삭제 성공");
					else
						System.out.println("삭제할 데이터가 없습니다");
				}
				catch(Exception e){
					System.out.println("데이터베이스 연결 실패!="+e.getMessage());
				}
				finally{
					try{
						if(con != null) con.close();
						if(stmt != null) stmt.close();
						if(pstmt != null) pstmt.close();
						
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
					
				}
				

	}
}
