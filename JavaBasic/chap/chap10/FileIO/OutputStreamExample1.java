package chap10.FileIO;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamExample1 {
	public static void main(String[] args) {
		FileOutputStream out = null;
		try{
			out = new FileOutputStream("output.dat");
			byte arr[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,12,13,14};
			for (int i = 0; i < arr.length; i++)
				out.write(arr[i]);
		}catch(IOException ioe){
			System.out.println("파일로 출력할 수 없습니다.");
		}finally {
			try{
				out.close();
			}catch(Exception e){
			}
		}
		
	}
}
