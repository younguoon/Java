package chap18.Thread.CriticalSection;

public class TransferThread extends Thread {
	SharedArea sharedArea;

	TransferThread(SharedArea area) {
		sharedArea = area;
	}

	public void run() {
		for (int i = 0; i < 12; i++) {
			synchronized (sharedArea) {
				sharedArea.account1.withdraw(1000000);
				System.out.println("�̸��� ���� : 100���� ����, ");
				sharedArea.account2.deposit(1000000);
				System.out.println("������ ���� : 1000�� �Ա�");
			}
		}
	}
}
