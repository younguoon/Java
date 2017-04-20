package jinsol.preparedSatement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DeleteExam02 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

				String driver = "oracle.jdbc.driver.OracleDriver";
				String url = "jdbc:oracle:thin:@192.168.4.120:1521:orcl";
				
				Connection con = null; 
				Statement stmt = null;
				PreparedStatement pstmt = null;

				
				String hakbun;
				
				
				try{
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					System.out.println("Member ���̺� �����ϱ�....");
					
					System.out.print("������ �й��Է�:");
					hakbun = br.readLine();
				
					String sql = "Delete from member where hakbun =?";
					
					System.out.println(sql);
					Class.forName(driver);
					con = DriverManager.getConnection(url,"scott","123456");
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, hakbun);
					
					int res = pstmt.executeUpdate();//executeUpdate�� ��ȯ���� ������->��ȯ������ ������ Ȯ���� �� ����
					if (res == 1) //executeUpdate�� ����,����,������ ������  ROWCOUNT ��ȯ�Ѵ� 1�̸� �Ѱ�����
						System.out.println("�����ͺ��̽� ���� ����");
					else
						System.out.println("������ �����Ͱ� �����ϴ�");
				}
				catch(Exception e){
					System.out.println("�����ͺ��̽� ���� ����!="+e.getMessage());
				}
				finally{
					try{
						if(con != null) con.close();
						if(stmt != null) stmt.close();
						if(pstmt != null) pstmt.close();
						
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
					
				}
				

	}
}
