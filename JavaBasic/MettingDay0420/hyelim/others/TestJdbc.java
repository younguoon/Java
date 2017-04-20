package hyelim.others;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJdbc {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// driver 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// connection 객체 생성
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.16:1521:orcl", "scott", "123456");

		// statement 객체 생성
		Statement stmt = con.createStatement();

		// sql
		String sql = "select ename, deptno from emp ";

		// sql 실행 후 ResultSet객체 반환
		// 테이블 형태로 반환 됨.

		ResultSet rset = stmt.executeQuery(sql);

		int deptno = 0;
		String name = null;

		// 첫 번째 레코드에 접근. --> true 값 반환
		// 더 이상 읽을 값이 없으면 false를 반환
		while (rset.next()) {
			name = rset.getString("ename"); // 테이블에 존재하는 필드 명을 넣어줌.
			deptno = rset.getInt("deptno");
			System.out.println(name + "\t" + deptno);
		}
		// 닫기 작업을 해야함.

	}

}
