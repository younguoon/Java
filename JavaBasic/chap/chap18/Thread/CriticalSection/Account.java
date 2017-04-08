package chap18.Thread.CriticalSection;

public class Account {
	String accountNo;    // ���¹�ȣ
    String ownerName;    // ������ �̸�
    int balance;         // �ܾ�
    Account(String accountNo, String ownerName, int balance) {   
        this.accountNo = accountNo; 
        this.ownerName = ownerName;  
        this.balance = balance;       
    }
    void  deposit(int amount)  {       
        balance += amount;
    }
    int withdraw(int amount) {
        if (balance < amount)
            return 0;
        balance -= amount;
        return amount;
    }

}
