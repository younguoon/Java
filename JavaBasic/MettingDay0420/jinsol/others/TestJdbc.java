package jinsol.others;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJdbc {

	public static void main(String[] args)throws Exception{
		// TODO Auto-generated method stub
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@192.168.4.120:1521:orcl","scott","123456");
		Statement stmt = con.createStatement();
		
		String sql = "Select ename,deptno From emp";
		
		ResultSet rset = stmt.executeQuery(sql);
		int deptno=0;
		String name = null;
		
		
		while(rset.next()){
			name=rset.getString("ename");
			deptno=rset.getInt("deptno");
			System.out.println(name+"  "+deptno);
		}
		
	}

}
