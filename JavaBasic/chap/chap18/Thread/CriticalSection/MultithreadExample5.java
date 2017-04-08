package chap18.Thread.CriticalSection;


public class MultithreadExample5 {
	public static void main(String[] args) {
        SharedArea area = new SharedArea();
        area.account1 = new Account("111-111-1111", "ÀÌ¸ù·æ", 20000000);
        area.account2 = new Account("222-222-2222", "¼ºÃáÇâ", 10000000);
        TransferThread thread1 = new TransferThread(area);
        PrintThread thread2 = new PrintThread(area);
        thread1.start();
        thread2.start();
	}
}


