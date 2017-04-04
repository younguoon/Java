package chap07.Referance;

public class EnumExample3 {
	public static void main(String[] args) {
		printSeason(Season.SPRING);
		printSeason(Season.SUMMER);
		printSeason(Season.SPRING);
		printSeason(Season.WINTER);
	}
	static void printSeason(Season season){
		System.out.println(season.value());
	}
}
