package Calendar_Hyunwoo;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.*;

class SwingCalender extends JFrame implements ActionListener

{
       String [] days = {"��","��","ȭ","��","��","��","��"};
       int year ,month,day,todays,memoday=0;
       Font f;
       Color bc,fc;
       Calendar today;
       Calendar cal;
       JButton btnBefore,btnAfter;
       JButton[] calBtn = new JButton[49];
       JLabel thing;
       JLabel time;
       JPanel panWest;
       JPanel panSouth;
       JPanel panNorth;
       JTextField txtMonth,txtYear;
       JTextField txtTime;
       BorderLayout bLayout= new BorderLayout();     
       ////////////////////////////////////////
       public SwingCalender(){
             today = Calendar.getInstance(); //����Ʈ�� Ÿ�� �� �� �������� ����� �޷��� �����ɴϴ�.
             cal = new GregorianCalendar();
             year = today.get(Calendar.YEAR);
             month = today.get(Calendar.MONTH)+1;//1���� ���� 0 
             panNorth = new JPanel();
			 panNorth.add(btnBefore = new JButton("Before"));            
             panNorth.add(txtYear = new JTextField(year+"��"));
             panNorth.add(txtMonth = new JTextField( month+"��",3));
             txtYear.setEnabled(false);
			 txtMonth.setEnabled(false);
             panNorth.add(btnAfter = new JButton("After"));
             f=new Font("Sherif",Font.BOLD,18);
             txtYear.setFont(f);
             txtMonth.setFont(f);       
             add(panNorth,"North");
             //�̳��� �޷¿� ���� �ش��ϴ� �κ�
             panWest = new JPanel(new GridLayout(7,7));//���ڳ�,���������� ��ġ������
             f=new Font("Sherif",Font.BOLD,12);
             gridInit();
             calSet();
             hideInit();
             add(panWest,"Center");
             
             btnBefore.addActionListener(this);
             btnAfter.addActionListener(this);       
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             setTitle("Swing");
             setBounds(200,200,345,250);
             setVisible(true);   
       }//end constuctor
       public void calSet(){
             cal.set(Calendar.YEAR,year);
             cal.set(Calendar.MONTH,(month-1));
             cal.set(Calendar.DATE,1);
             int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
             /*
              * get �� set �� ���� �ʵ�ġ��, ������ ��Ÿ���ϴ�.
              * �� �ʵ��� ����,SUNDAY,MONDAY,TUESDAY,WEDNESDAY
              * ,THURSDAY,FRIDAY, �� SATURDAY �� �˴ϴ�. 
              * get()�޼ҵ��� ���� ������ ���ڷ� ��ȯ
              */
             int j=0;
             int hopping=0;
             calBtn[0].setForeground(new Color(255,0,0));//�Ͽ��� "��"
             calBtn[6].setForeground(new Color(0,0,255));//����� "��"
             for(int i=cal.getFirstDayOfWeek();i<dayOfWeek;i++){  j++;  }
             /*
              * �Ͽ��Ϻ��� �״��� ù���� ���ϱ��� ��ĭ���� �����ϱ� ���� 
              */
             hopping=j;
             for(int kk=0;kk<hopping;kk++){
                    calBtn[kk+7].setText("");
             }
             for(int i=cal.getMinimum(Calendar.DAY_OF_MONTH);
                           i<=cal.getMaximum(Calendar.DAY_OF_MONTH);i++){
                 cal.set(Calendar.DATE,i);
                    if(cal.get(Calendar.MONTH) !=month-1){
                           break;
                    }
              
                    todays=i;
		            if(memoday==1){
                           calBtn[i+6+hopping].setForeground(new Color(0,255,0));                         
                    }
                    else{
                           calBtn[i+6+hopping].setForeground(new Color(0,0,0));
                           if((i+hopping-1)%7==0){//�Ͽ���
                                 calBtn[i+6+hopping].setForeground(new Color(255,0,0));
                           }
                           if((i+hopping)%7==0){//�����
                                 calBtn[i+6+hopping].setForeground(new Color(0,0,255));
                           }
                    }
                    /*
                     * ������ ���� �������� ����ؾ� �ϴ� ������ ���� ��ư�� ������ ���ϰ�
                     * �ε����� 0���� �����̴� -1�� ���� ������ ������ ���ְ�
                     * ��ư�� ������ �������ش�. 
                     */
                    calBtn[i+6+hopping].setText((i)+"");
             }//for
       }//end Calset()
       public void actionPerformed(ActionEvent ae){         
            if(ae.getSource() == btnBefore){
                    this.panWest.removeAll();
                    calInput(-1);
                    gridInit();
                    panelInit();               
                    calSet();
                    hideInit();
                    this.txtYear.setText(year+"��");
                    this.txtMonth.setText(month+"��");                   
             }                   
             else if(ae.getSource() == btnAfter){
                    this.panWest.removeAll();
                    calInput(1);
                    gridInit();
                    panelInit();
                    calSet();
                    hideInit();
                    this.txtYear.setText(year+"��");
                    this.txtMonth.setText(month+"��");                                       
             }
           else if(Integer.parseInt(ae.getActionCommand()) >= 1 && 
                    Integer.parseInt(ae.getActionCommand()) <=31){
                    day = Integer.parseInt(ae.getActionCommand());
                    //��ư�� ��� �� 1,2,3.... ���ڸ� ���������� ��ȯ�Ͽ� Ŭ���� ��¥�� �ٲ��ش�.
                    System.out.println(+year+"-"+month+"-"+day);
                    calSet();
             }      
      }//end actionperformed()
       public void hideInit(){
            for(int i = 0 ; i < calBtn.length;i++){
                    if((calBtn[i].getText()).equals(""))
                           calBtn[i].setEnabled(false);
                    //���� ������ ���� ������ ��ư�� ��Ȱ��ȭ ��Ų��. 
             }//end for
       }//end hideInit()

       public void gridInit(){
         //jPanel3�� ��ư ���̱�
         for(int i = 0 ; i < days.length;i++)
		   {
              panWest.add(calBtn[i] = new JButton(days[i]));
			  calBtn[i].setContentAreaFilled(false);
			  calBtn[i].setBorderPainted(false);
		   }	
			  for(int i = days.length ; i < 49;i++){                
                    panWest.add(calBtn[i] = new JButton(""));                   
                    calBtn[i].addActionListener(this);
             }              
       }//end gridInit()
	   public void panelInit(){
         GridLayout gridLayout1 = new GridLayout(7,7);
         panWest.setLayout(gridLayout1);   
       }//end panelInit()
       public void calInput(int gap){
             month+=(gap);
             if (month<=0){
                           month = 12;
                           year  =year- 1;
             }else if (month>=13){
                           month = 1;
                           year =year+ 1;
             }
       }//end calInput()
}//end class

public class FrameMain

{
       public static void main(String[] args){
             SwingCalender jdbc = new SwingCalender();  

       }

}