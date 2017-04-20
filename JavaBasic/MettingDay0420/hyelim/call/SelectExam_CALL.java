package hyelim.call;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import oracle.jdbc.internal.OracleTypes;
/*
 CREATE OR REPLACE PROCEDURE call_select (
    v_member_cursor out sys_refcursor
)
IS
BEGIN
    OPEN V_MEMBER_CURSOR
    FOR
    SELECT * FROM MEMBER
    ORDER BY hakbun;
END;
/

 */
public class SelectExam_CALL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
			//call : ���ν��� ȣ�� ��ɾ�. ? : �Ķ����
			cstmt = con.prepareCall("{call call_select(?)}");
			//����Ŭ�� �����ϴ� Ŀ��Ÿ������ �ޱ�
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			cstmt.executeQuery();
			
			rs = (ResultSet)cstmt.getObject(1);
			
			System.out.println("hakbun\tname\taddr\tphone");
			System.out.println("-------------------------------------");
			
			while(rs.next()) {
				System.out.print(rs.getString("hakbun") + "\t");
				System.out.print(rs.getString("name") + "\t");
				System.out.print(rs.getString("addr") + "\t");
				System.out.print(rs.getString("phone") + "\n");
			}
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� ���� ����");
			e.printStackTrace();
		} finally {
			try {
				if( con != null)
					con.close();
				if(cstmt != null)
					cstmt.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}	
}
