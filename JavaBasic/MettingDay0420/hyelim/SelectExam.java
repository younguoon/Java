package hyelim;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member";
		
		try {
			//jdbc ����̹� �ε�
			Class.forName(driver);
			//db�� ����								�����	   ���
			con = DriverManager.getConnection(url, "scott", "123456");
			//statement ��ü ���
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			System.out.println("hakbun\tname\taddr\tphone");
			System.out.println("-------------------------------------");
			while(rs.next()) {
				System.out.print(rs.getString("hakbun") + "\t");
				System.out.print(rs.getString("name") + "\t");
				System.out.print(rs.getString("addr") + "\t");
				System.out.print(rs.getString("phone") + "\n");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�����ͺ��̽� ���� ����");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
	}
}
