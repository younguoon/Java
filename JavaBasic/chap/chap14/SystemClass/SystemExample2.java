package chap14.SystemClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemExample2 {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str;
		try {
			str = reader.readLine();
			System.out.println("�Էµ� ���ڿ� : " + str);
		} catch (IOException e) {
			System.out.println("Ű���� �Է� ����");
		}

	}
}
