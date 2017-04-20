package hyelim.call;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

/*
create or replace procedure call_update(
    p_hakbun    MEMBER.HAKBUN%TYPE,
    p_addr      MEMBER.ADDR%TYPE,
    p_phone     MEMBER.PHONE%TYPE
)
IS
BEGIN
    update member set addr = p_addr, phone = p_phone
    where hakbun = p_hakbun;
END;
/
*/

public class UpdateExam_CALL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		CallableStatement cstmt = null;
		String hakbun, addr, phone;

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member 테이블 값 갱신하기......");
			System.out.print("갱신할 학번 입력 : ");
			hakbun = br.readLine();
			System.out.print("새 주소 입력 : ");
			addr = br.readLine();
			System.out.print("새 전화번호 입력 : ");
			phone = br.readLine();
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
			
			cstmt = con.prepareCall("{call call_update(?, ?, ?)}");
			cstmt.setString(1, hakbun);
			cstmt.setString(2, addr);
			cstmt.setString(3, phone);
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
