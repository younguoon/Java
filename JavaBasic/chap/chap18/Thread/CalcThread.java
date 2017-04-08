package chap18.Thread;

public class CalcThread extends Thread{
	SharedArea sharedArea;
	public void run(){
		double total = 0.0;
		for (int i = 0; i < 100000; i+=2) 
			if(i/2%2==0)
				total +=1.0/i;
			else
				total -=1.0/i;
		sharedArea.result=total*4;
		sharedArea.isReady = true;
	}
}
