package chap06;

public class CreditLineAccount extends Account{
	int creditLine;

	public CreditLineAccount(String accountNo, String ownerName, int balance, int creditLine) {
		super(accountNo, ownerName, balance);
		this.creditLine = creditLine;
	}
	int withdraw(int amount) throws Exception{
		if((balance+creditLine)<amount)
			throw new Exception("���� �Ұ�");
		balance -=amount;
		return amount;
	}
	
}
