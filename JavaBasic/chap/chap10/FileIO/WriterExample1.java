package chap10.FileIO;

import java.io.FileWriter;
import java.io.IOException;

public class WriterExample1 {
	public static void main(String[] args) {
		FileWriter writer = null;
		System.out.println("test");
		try {
			System.out.println("test1");
			writer = new FileWriter("output.txt");
			System.out.println("test2");
			char arr[] = { '뇌', '를', '자', '극', '하', '는', ' ', 'j', 'v', 'a' };
			for (int i = 0; i < arr.length; i++)
				writer.write(arr[i]);
		} catch (IOException ioe) {
			System.out.println("파일로 출력할 수 없습니다.");
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
			}
		}
	}
}
