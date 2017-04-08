package chap18.Thread.CriticalSection;

public class PrintThread extends Thread {
	SharedArea sharedArea;

	PrintThread(SharedArea area) {
		sharedArea = area;
	}

	public void run() {
		for (int i = 0; i < 3; i++) {
			synchronized (sharedArea) {
				int sum = sharedArea.account1.balance + sharedArea.account2.balance;
				System.out.println("°èÁÂ ÀÜ¾× ÇÕ°è : " + sum);
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
