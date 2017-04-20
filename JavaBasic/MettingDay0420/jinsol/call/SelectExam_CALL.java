package jinsol.call;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectExam_CALL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.4.120:1521:orcl";
		
		Connection con = null; 
		CallableStatement cstmt = null;
		ResultSet rs=null;
		
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url,"scott","123456");
			cstmt = con.prepareCall("(call call_select(?))");
			cstmt.executeQuery();
			
			rs=(ResultSet)cstmt.getObject(1);
			
			System.out.println("hakbun\tname\taddr\tphone");
			System.out.println("--------------------------");
			while(rs.next()){
				System.out.println(rs.getString("hakbun")+"\t");
				System.out.println(rs.getString("name")+"\t");
				System.out.println(rs.getString("addr")+"\t");
				System.out.println(rs.getString("phone")+"\n");
		}
		

	}
		catch(Exception e){
			System.out.println("데이터베이스 연결 실패!");
			e.printStackTrace();
		}
		
		finally{
			try{
				if(rs!=null) rs.close();
				if(cstmt!=null) cstmt.close();
				if(con!=null) con.close();
				
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
}



