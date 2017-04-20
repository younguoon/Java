package hyelim.others;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJdbc {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// driver �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// connection ��ü ����
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.16:1521:orcl", "scott", "123456");

		// statement ��ü ����
		Statement stmt = con.createStatement();

		// sql
		String sql = "select ename, deptno from emp ";

		// sql ���� �� ResultSet��ü ��ȯ
		// ���̺� ���·� ��ȯ ��.

		ResultSet rset = stmt.executeQuery(sql);

		int deptno = 0;
		String name = null;

		// ù ��° ���ڵ忡 ����. --> true �� ��ȯ
		// �� �̻� ���� ���� ������ false�� ��ȯ
		while (rset.next()) {
			name = rset.getString("ename"); // ���̺� �����ϴ� �ʵ� ���� �־���.
			deptno = rset.getInt("deptno");
			System.out.println(name + "\t" + deptno);
		}
		// �ݱ� �۾��� �ؾ���.

	}

}
