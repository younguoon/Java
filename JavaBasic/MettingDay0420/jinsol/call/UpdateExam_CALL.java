package jinsol.call;

/*create or replace procedure call_update(p_hakbun MEMBER.HAKBUN%TYPE,
p_addr MEMBER.ADDR%TYPE, p_phone MEMBER.PHONE%TYPE)
is
begin
update member set addr = p_addr,phone =p_phone where hakbun = p_hakbun;
end;/
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class UpdateExam_CALL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.4.120:1521:orcl";
		
		Connection con = null;
		Statement stmt = null;
		CallableStatement cstmt = null;

		
		String hakbun,addr,phone;
		
		
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member ���̺� �����ϱ�....");
			
			System.out.print("������ �й��Է�:");
			hakbun = br.readLine();
			System.out.print("�� �ּ��Է�:");
			addr = br.readLine();
			System.out.print("�� ��ȭ��ȣ�Է�:");
			phone = br.readLine();
			
			String sql = "Update member set addr = ?, phone = ? Where hakbun = ?";
			
			System.out.println(sql);
			Class.forName(driver);
			con = DriverManager.getConnection(url,"scott","123456");

			cstmt = con.prepareCall(sql);
			
			cstmt.setString(1, addr);
			cstmt.setString(2, phone);
			cstmt.setString(3, hakbun);
			cstmt.executeUpdate();
			System.out.println("�����ͺ��̽� ���� ����");
		}
		catch(Exception e){
			System.out.println("�����ͺ��̽� ���� ����!="+e.getMessage());
		}
		finally{
			try{
				if(con != null) con.close();
				if(cstmt != null) cstmt.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			
		}}
		
}
