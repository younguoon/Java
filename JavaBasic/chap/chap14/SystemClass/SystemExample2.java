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
			System.out.println("입력된 문자열 : " + str);
		} catch (IOException e) {
			System.out.println("키보드 입력 에러");
		}

	}
}
