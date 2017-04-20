package hyelim;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class InsertExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		Statement stmt = null;
		
		String sql = "insert into member(hakbun, name, addr, phone) values";
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
			
			sql += "('"+hakbun+"', '"+name+"', '"+addr+"' , '"+phone+"')";
			System.out.println(sql);
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
			stmt = con.createStatement();
			int res = stmt.executeUpdate(sql);
			if(res == 1)
				System.out.println("�����ͺ��̽� ���� ����!");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�����ͺ��̽� ���� ����! = " + e.getMessage());
		} finally {
			try {
				if(con != null) con.close();
				if(stmt != null) stmt.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
	}

}
