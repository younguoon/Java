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
			System.out.println("Member ���̺� �� �����ϱ�......");
			System.out.print("������ �й� �Է� : ");
			hakbun = br.readLine();
			
			String sql = "delete from member where hakbun = '";
			sql += hakbun + "'";
			//����̹� �ε�
			Class.forName(driver);
			//���� ��ü ����
			con = DriverManager.getConnection(url, "scott", "123456");
			//������Ʈ�ս� ����
			stmt = con.createStatement();
			//���� ����
			//stmt.executeUpdate(sql) --> ������ ���� �� ��ȯ. 
			int res = stmt.executeUpdate(sql);
			if (res == 1) 
				System.out.println("�����ͺ��̽� ���� ���� ����!");
			

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�����ͺ��̽� ���� ����! = " + e.getMessage());
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
