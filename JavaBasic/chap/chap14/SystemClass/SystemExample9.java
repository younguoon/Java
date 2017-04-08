package chap14.SystemClass;

public class SystemExample9 {
	public static void main(String[] args) {
		char arr1[] = {'가','나','다','라','마','바','사','아','자','차','카','타','파','하'};
		char arr2[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n'};
		System.arraycopy(arr1, 10, arr2, 2,3);
		for(char ch : arr2)
			System.out.println(ch);
	}
}
