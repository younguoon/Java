package chap05.Method;

class MethodExample3 {
    public static void main(String args[]) {
        int arr[] = new int[0];             // ���̰� 0�� �迭�� ����
        Numbers obj = new Numbers(arr);
        int average = obj.getAverage();     
        System.out.println("��� = " + average);
    }
}