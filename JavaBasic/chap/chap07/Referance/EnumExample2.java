package chap07.Referance;

public class EnumExample2 {
	public static void main(String[] args) {
		printDay("MONDAY");
		printDay("WEDNSDAY");
		printDay("FRIDAY");
	}
	static void printDay(String name){
		Day day = Day.valueOf(name);
		System.out.println(day);
	}
}
