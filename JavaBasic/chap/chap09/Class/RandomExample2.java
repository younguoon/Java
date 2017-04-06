package chap09.Class;

import java.util.Random;

public class RandomExample2 {
	public static void main(String args[]) {
        Random random = new Random(349239L);
        System.out.println(random.nextInt(100));
        System.out.println(random.nextInt(100));
        System.out.println(random.nextInt(100));
    }

}
