package chap05.Method;

class MethodExample1 {
    public static void main(String args[]) {
        Account obj1 = new Account("111-222-33333333", "�迵��", 200000);
        Account obj2 = new Account("555-666-77777777", "������", 1000000);
        obj1.deposit(1000000);
//        obj2.withdraw(200000);
        printAccount(obj1);
        printAccount(obj2);
   }
   static void printAccount(Account obj) {
        System.out.println("���¹�ȣ:" + obj.accountNo);  
        System.out.println("������ �̸�:" + obj.ownerName);   
        System.out.println("�ܾ�:" + obj.balance);  
        System.out.println();                         // �� �ٲ� ���� ���
    }
}
