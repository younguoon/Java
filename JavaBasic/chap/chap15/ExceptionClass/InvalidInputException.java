package chap15.ExceptionClass;

public class InvalidInputException extends Exception{
	InvalidInputException(){
		super("잘못된 입력입니다.");
	}
}
