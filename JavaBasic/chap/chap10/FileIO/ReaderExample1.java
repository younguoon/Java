package chap10.FileIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderExample1 {
	public static void main(String[] args) {
		try{
			FileReader reader = new FileReader("poem.txt");
			while(true){
				int data = reader.read();
				if(data == -1)
					break;
				char ch = (char) data;
				System.out.println(ch);
			}
			reader.close();
		}
		catch(FileNotFoundException fnfe){
			System.out.println("������ �������� �ʽ��ϴ�.");
		}
		catch(IOException ioe){
			System.out.println("������ ���� �� �����ϴ�.");
		}
	}
}
