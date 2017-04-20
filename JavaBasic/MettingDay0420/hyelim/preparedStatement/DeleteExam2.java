package hyelim.preparedStatement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteExam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		PreparedStatement pstmt = null;

		String hakbun;

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member ���̺� �� �����ϱ�......");
			System.out.print("������ �й� �Է� : ");
			hakbun = br.readLine();
			
			String sql = "delete from member where hakbun = ?";
			//����̹� �ε�
			Class.forName(driver);
			//���� ��ü ����
			con = DriverManager.getConnection(url, "scott", "123456");
			//������Ʈ�ս� ����
			pstmt = con.prepareStatement(sql);
			//���� ����
			
			pstmt.setString(1, hakbun);
			pstmt.executeUpdate();	//executeUpdate()�� ����, ����, ������ �� �� ������ ���� ������ ��ȯ��
			
			System.out.println("�����ͺ��̽� ���� ���� ����!");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�����ͺ��̽� ���� ����! = " + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
	}

}
