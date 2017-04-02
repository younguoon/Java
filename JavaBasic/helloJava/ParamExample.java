
public class ParamExample {
	public static void main(String[] args) {
		for (String str : args)
            System.out.println(str);
        System.out.println("args.length=" + args.length);
    }
}
