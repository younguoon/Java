package chap15.ExceptionClass;

public class ExceptionExample11 {
	public static void main(String[] args) {
		try{
		int result = subtract(5,100);
		System.out.println(result);
	}catch(InvalidInputException e){
		System.out.println(e.getMessage());
	}
	}
	static int subtract(int a, int b) throws InvalidInputException{
		if(a<b)
			throw new InvalidInputException();
		return a-b;
		}
}
