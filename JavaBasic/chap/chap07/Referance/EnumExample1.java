package chap07.Referance;

public class EnumExample1 {
	public static void main(String[] args) {
		Day days[] = Day.values();
		for (Day day : days)
			System.out.println(day);
	}
}
