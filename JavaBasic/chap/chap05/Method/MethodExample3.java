package chap05.Method;

class MethodExample3 {
    public static void main(String args[]) {
        int arr[] = new int[0];             // 길이가 0인 배열을 생성
        Numbers obj = new Numbers(arr);
        int average = obj.getAverage();     
        System.out.println("평균 = " + average);
    }
}