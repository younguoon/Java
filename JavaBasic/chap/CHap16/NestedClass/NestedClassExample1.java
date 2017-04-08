package CHap16.NestedClass;

public class NestedClassExample1 {
	public static void main(String[] args) {
		Cart cart = new Cart();
		cart.addItem("���ݷ�", 3, 1000);
		cart.addItem("����ũ", 1, 25000);
		cart.addItem("������", 1, 7000);
		Cart.Item item = cart.new Item("�ɴٹ�",1,500000);
		cart.list.add(item);
		printCart(cart);
	}
	static void printCart(Cart cart){
		int num = cart.getItemNum();
		System.out.println("            ��ǰ��    ����       �ܰ�           �ݾ�");
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		for(int cnt=0; cnt<num; cnt++){
			Cart.Item item = cart.getItem(cnt);
			System.out.printf("%3d %5s %5d %7d %7d %n", cnt+1, item.name, item.num, item.unitPrice, item.getPrice());
		}
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		System.out.printf("\t\t��    ��   %10d %n",cart.getTotalPrice());
	}
}
