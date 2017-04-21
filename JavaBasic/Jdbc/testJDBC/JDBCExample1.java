package testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCExample1 {
	public static void main(String[] args) throws Exception {
		// driver 肺爹
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// Connection 按眉 积己
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
		// Statement 按眉 积己
		Statement stmt = conn.createStatement();
		// sql
		String sql = "select ename, deptno from emp";
		// sql 角青 饶 ResultSet 按眉 馆券
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
