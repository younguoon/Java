package hyelim.call;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/*
create or replace procedure call_insert(
    hakbun  MEMBER.HAKBUN%TYPE,
    name    MEMBER.NAME%TYPE,
    addr    MEMBER.ADDR%TYPE,
    phone   MEMBER.phone%TYPE
)
IS
BEGIN
    	
END;
/
*/
public class InsertExam_CALL {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		CallableStatement cstmt = null;
		String hakbun, name, addr, phone;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member ���̺� �� �߰��ϱ�......");
			System.out.print("�й� �Է� : ");
			hakbun = br.readLine();
			System.out.print("�̸� �Է� : ");
			name = br.readLine();
			System.out.print("�ּ� �Է� : " );
			addr = br.readLine();
			System.out.print("��ȭ��ȣ �Է� : " );
			phone = br.readLine();
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
			cstmt = con.prepareCall("{call call_insert(?, ?, ?, ?)}");
			cstmt.setString(1, hakbun);
			cstmt.setString(2, name);
			cstmt.setString(3, addr);
			cstmt.setString(4, phone);
			cstmt.executeUpdate();
			
			System.out.println("�����ͺ��̽� �Է� ����!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�����ͺ��̽� ���� ����! = " + e.getMessage());
		} finally {
			try {
				if(con != null) con.close();
				if(cstmt != null) cstmt.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
	}

}