package chap18.Thread.Monitoring;

public class MultithreadExample9 {
    public static void main(String args[]) {
        CalcThread thread1 = new CalcThread();
        PrintThread thread2 = new PrintThread();
        MonitorThread thread3 = new MonitorThread(thread1);
        SharedArea obj = new SharedArea();
        thread1.sharedArea = obj;
        thread2.sharedArea = obj;
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
