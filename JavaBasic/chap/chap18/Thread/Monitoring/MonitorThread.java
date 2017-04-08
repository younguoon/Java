package chap18.Thread.Monitoring;

public class MonitorThread extends Thread{
	Thread thread;
    MonitorThread(Thread thread) {   // ������
        this.thread = thread;
    }
    public void run() {
        while (true) {
            Thread.State state = thread.getState();
            System.out.println("�������� ����: " + state);
            if (state == Thread.State.TERMINATED)
                break;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } 
        }        
    }
}
