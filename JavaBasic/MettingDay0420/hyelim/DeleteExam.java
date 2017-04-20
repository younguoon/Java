package hyelim;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		Statement stmt = null;

		String hakbun;

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member 테이블 값 갱신하기......");
			System.out.print("삭제할 학번 입력 : ");
			hakbun = br.readLine();
			
			String sql = "delete from member where hakbun = '";
			sql += hakbun + "'";
			//드라이버 로드
			Class.forName(driver);
			//연결 객체 생성
			con = DriverManager.getConnection(url, "scott", "123456");
			//스테이트먼스 실행
			stmt = con.createStatement();
			//쿼리 실행
			//stmt.executeUpdate(sql) --> 삭제된 행의 수 반환. 
			int res = stmt.executeUpdate(sql);
			if (res == 1) 
				System.out.println("데이터베이스 내용 삭제 성공!");
			

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("데이터베이스 연결 실패! = " + e.getMessage());
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

}
