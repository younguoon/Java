package testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCExample1 {
	public static void main(String[] args) throws Exception {
		// driver �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// Connection ��ü ����
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
		// Statement ��ü ����
		Statement stmt = conn.createStatement();
		// sql
		String sql = "select ename, deptno from emp";
		// sql ���� �� ResultSet ��ü ��ȯ
		ResultSet rest = stmt.executeQuery(sql);
		int deptno = 0;
		String name = null;

		while (rest.next()) {
			name = rest.getString("ename");
			deptno = rest.getInt("deptno");
			System.out.println("name : " + name + ",  deptno : " + deptno);
		}
	}
}
