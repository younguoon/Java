package chap06.Interface;

public class SeparateVolume implements Lendable{
	String requestNo;
	String bookTitle;
	String writer;
	String borrower;
	String checkOutDate;
	byte state;
	SeparateVolume(String requestNo, String bookTitle, String writer){
		this.requestNo = requestNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}
	@Override
	public void checkOut(String borrower, String date) {   
        if (state != 0)
            return;
        this.borrower = borrower;
        this.checkOutDate = date;
        this.state = 1;
        System.out.println("*" + bookTitle + " CD�� ����Ǿ����ϴ�.");
        System.out.println("������:" + borrower);
        System.out.println("������:" + date + "\n");    
    }
    public void checkIn() { 
        this.borrower = null;
        this.checkOutDate = null;
        this.state = 0;
        System.out.println("*" + bookTitle + " CD�� �ݳ��Ǿ����ϴ�.\n");
    }

	
}
