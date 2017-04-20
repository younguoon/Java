package hyelim.preparedStatement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteExam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		PreparedStatement pstmt = null;

		String hakbun;

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member 테이블 값 갱신하기......");
			System.out.print("삭제할 학번 입력 : ");
			hakbun = br.readLine();
			
			String sql = "delete from member where hakbun = ?";
			//드라이버 로드
			Class.forName(driver);
			//연결 객체 생성
			con = DriverManager.getConnection(url, "scott", "123456");
			//스테이트먼스 실행
			pstmt = con.prepareStatement(sql);
			//쿼리 실행
			
			pstmt.setString(1, hakbun);
			pstmt.executeUpdate();	//executeUpdate()는 수정, 삽입, 삭제를 한 후 성공한 행의 갯수를 반환함
			
			System.out.println("데이터베이스 내용 삭제 성공!");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("데이터베이스 연결 실패! = " + e.getMessage());
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
