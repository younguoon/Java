package CHap16.NestedClass;

public class NestedClassExample1 {
	public static void main(String[] args) {
		Cart cart = new Cart();
		cart.addItem("蟾屬滇", 3, 1000);
		cart.addItem("馨檜觼", 1, 25000);
		cart.addItem("慾む檣", 1, 7000);
		Cart.Item item = cart.new Item("粒棻嫦",1,500000);
		cart.list.add(item);
		printCart(cart);
	}
	static void printCart(Cart cart){
		int num = cart.getItemNum();
		System.out.println("            鼻ヶ貲    熱榆       欽陛           旎擋");
		System.out.println("天天天天天天天天天天天天天天天天天天天天天天天");
		for(int cnt=0; cnt<num; cnt++){
			Cart.Item item = cart.getItem(cnt);
			System.out.printf("%3d %5s %5d %7d %7d %n", cnt+1, item.name, item.num, item.unitPrice, item.getPrice());
		}
		System.out.println("天天天天天天天天天天天天天天天天天天天天天天天");
		System.out.printf("\t\t識    啗   %10d %n",cart.getTotalPrice());
	}
}
