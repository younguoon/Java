package hyelim.call;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import oracle.jdbc.internal.OracleTypes;

/*
create or replace procedure call_delte(p_hakbun MEMBER.HAKBUN%TYPE)
IS
BEGIN
    delete from member where hakbun = p_hakbun;
END;
/
 */
public class DeleteExam_CALL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		CallableStatement cstmt = null;

		String hakbun;

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member 테이블 값 갱신하기......");
			System.out.print("삭제할 학번 입력 : ");
			hakbun = br.readLine();
	
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
			
			cstmt = con.prepareCall("{call call_delete(?)}");
			cstmt.setString(1, hakbun);
			cstmt.executeUpdate();
			
			System.out.println("데이터베이스 연결 성공!");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("데이터베이스 연결 실패! = " + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
				if (cstmt != null)
					cstmt.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}

	}

}
