package chap20.Network.MyChat;

/*�ܼ� ��Ƽä�� Ŭ���̾�Ʈ ���α׷�*/
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
 
 
public class MultiClient {
   
   
    static boolean chatmode = false;
    static int chatState = 0;
    //0 : �α׿� �ȵȻ���, 1 : �α׿µȻ���, 2: ������Ϸ� (��ȭ����),
    //3 : ������ 1:1��ȭ��û�� ���� ,
    //5 : req_fileSend (������ �������ڿ��� ���������� ������û�� ����)
    public static void main(String[] args) throws UnknownHostException, IOException {
       
       
        try{
            String ServerIP = "localhost";
            Socket socket = new Socket(ServerIP, 9999); //���� ��ü ����        
            System.out.println("[##] ������ ������ �Ǿ����ϴ�......");
            //����ڷκ��� ���� ���ڿ��� ������ �������ִ� ������ �ϴ� ������.
           
           
            /////////////////////////////////////////////////////////////
           
            Thread sender = new Sender(socket);  
            Thread receiver = new Receiver(socket);        
       
            sender.start(); //������ �õ�
            receiver.start(); //������ �õ�
           
        }catch(Exception e){
            System.out.println("����[MultiClient class]:"+e);
        }
       
    }//main()-------
}//End class MultiClient
 
 
 
 
 
/////////////////////////////////////////////////////////////////////
 
//�����κ��� �޽����� �д� Ŭ����
class Receiver extends Thread{
   
    Socket socket;
    DataInputStream in;
   
    //Socket�� �Ű������� �޴� ������.
    public Receiver(Socket socket){
        this.socket = socket;
       
        try{
            in = new DataInputStream(this.socket.getInputStream());
        }catch(Exception e){
            System.out.println("����:"+e);
        }
    }//������ --------------------
   
   
    /**�޽��� �ļ�*/    
   public String[] getMsgParse(String msg){
        //System.out.println("msgParse()=>msg?"+ msg);
       
        String[] tmpArr = msg.split("[|]");
       
        return tmpArr;
    }
   
   
   
    @Override
    public void run(){ //run()�޼ҵ� ������
       
        while(in!=null){ //�Է½�Ʈ���� null�� �ƴϸ�..�ݺ�
            try{        
           
               
                String msg = in.readUTF(); //�Է½�Ʈ���� ���� �о�� ���ڿ��� msg�� �Ҵ�.
               
                String[] msgArr = getMsgParse(msg.substring(msg.indexOf("|")+1));
               
                //�޼��� ó�� ----------------------------------------------
                if(msg.startsWith("logon#yes")){ //�α׿� �õ� (��ȭ��)
                    MultiClient.chatState = 1; //ä�� ���¸� �α׿� �� ���·� ����.
                    //logon#yes|�׷츮��Ʈ              
                    System.out.println(msgArr[0]);
                    System.out.println("�������� �Է��� �ּ���:");
                   
                }else  if(msg.startsWith("logon#no")){ //�α׿� ���� (��ȭ��)
                   
                    MultiClient.chatState = 0;                 
                    System.out.println("[##] �ߺ��� �̸��� �����մϴ�\n���̸��� �ٽ� �Է��� �ּ���:");
                    //1. �̸��� �ߺ��ɰ��(������ü or �׷�) logon#no ��Ŷ�� �����κ��� ���޵�.
                    //2. �̸��� �ߺ��ɰ�� �������� ��ü������ name(1), name(2) �̷������� �ߺ����� �ʰ� �����ϴ� ���.
                                       
                }else if(msg.startsWith("enterRoom#yes")){ //�׷�����  
                   
                    //enterRoom#yes|����
                    System.out.println("[##] ä�ù� ("+msgArr[0]+") �� �����Ͽ����ϴ�.");
                    MultiClient.chatState = 2; //ê ���� ���� ( ä�ù����� �Ϸ�� ��ȭ���ɻ���)
                     
                }else if(msg.startsWith("enterRoom#no")){
                    //enterRoom#no|����
                     System.out.println("[##] �Է��Ͻ� ["+msgArr[0]+ "]�� ���������ʴ� �����Դϴ�.");
                     System.out.println("�������� �ٽ� �Է��� �ּ���:");
               
                }else if(msg.startsWith("show")){ //�������������ϰ����ϴ� �޽���
               
                    //show|�޽�������    
                    System.out.println(msgArr[0]);
                   
                }else if(msg.startsWith("say")){ //��ȭ����
                    //say|���̵�|��ȭ����                   
                    System.out.println("["+msgArr[0]+"] "+msgArr[1] ); 
                   
                }else if(msg.startsWith("whisper")){ //�ӼӸ�
                    //whisper|���̵�|��ȭ����  
                    System.out.println("[��]["+msgArr[0]+"] "+msgArr[1] );
                   
                }else if(msg.startsWith("req_PvPchat")){ //�ش� ����ڿ��� 1:1��ȭ ��û
                    //req_PvPchat|��³���  
                    MultiClient.chatState = 3; //ê ���� ���� (������ 1:1��ȭ��û�� �������)
                    //MultiClient.chatmode=true; //Sender���� 1:1��û�� ���Դٴ°��� �˷��ֱ� ����
                    System.out.println(msgArr[0]); //�޼����� ����
                    System.out.print("������:");  
                   
                }else if(msg.startsWith("req_fileSend")){ //������ ���� ����ڿ��� �������� ���� ��û
                    //req_fileSend|��³���  
                    //req_fileSend|[##] name �Բ��� ���� ������ �õ��մϴ�. �����Ͻðڽ��ϱ�?(Y/N)
                    MultiClient.chatState = 5; //���� ���� (������ �������ڿ��� ���������� ������û�� ����)
                    System.out.println(msgArr[0]); //�޼����� ����
                    System.out.print("������:");  
                    sleep(100);
                   
                }else if(msg.startsWith("fileSender")){ //������ ���������� ���ϼ��� �غ�
                                   
                    //fileSender|filepath;                 
                    System.out.println("fileSender:"+InetAddress.getLocalHost().getHostAddress());
                    System.out.println("fileSender:"+msgArr[0]);
                    //String ip=InetAddress.getLocalHost().getHostAddress();
                   
                    try {
                        new FileSender(msgArr[0]).start(); //������ ����.
                    } catch (Exception e) {
                        System.out.println("FileSender ������ ����:");
                        e.printStackTrace();
                    }
                   
                }else if(msg.startsWith("fileReceiver")){ //���Ϲޱ�
                    //fileReceiver|ip|fileName;
                   
                    System.out.println("fileReceiver:"+InetAddress.getLocalHost().getHostAddress());
                    System.out.println("fileReceiver:"+msgArr[0]+"/"+msgArr[1]);
                   
                    String ip = msgArr[0];  //������ �����Ǹ� ���� ����
                    String fileName = msgArr[1]; //�������� ������ �����̸�.
                           
                    try {
                        new FileReceiver(ip,fileName).start(); //������ ����.
                    } catch (Exception e) {
                        System.out.println("FileSender ������ ����:");
                        e.printStackTrace();
                    }
                   
                   
                }  else if(msg.startsWith("req_exit")){ //����  
                   
                   
                   
                }
           
            }catch(SocketException e){             
                 System.out.println("����:"+e);
                 System.out.println("##�������� ������ ������ ���������ϴ�.");
                return;
                 
            } catch(Exception e){              
                System.out.println("Receiver:run() ����:"+e);
             
            }
        }//while----
    }//run()------
}//class Receiver -------
 
 
/////////////////////////////////////////////////////////////////////
 
//������ �޽����� �����ϴ� Ŭ����
class Sender extends Thread {
    Socket socket;
    DataOutputStream out;
    String name;
   
    //������ ( �Ű������� ���ϰ� ����� �̸� �޽��ϴ�. )
    public Sender(Socket socket){ //���ϰ� ����� �̸��� �޴´�.
        this.socket = socket;      
        try{
            out = new DataOutputStream(this.socket.getOutputStream());
           
           
        }catch(Exception e){
            System.out.println("����:"+e);
        }
    }
   
    @Override
    public void run(){ //run()�޼ҵ� ������
       
        Scanner s = new Scanner(System.in);
        //Ű����κ��� �Է��� �ޱ����� ��ĳ�� ��ü ����
   
        System.out.println("���̸��� �Է��� �ּ���:");
        /*try {
            while(true){
                System.out.println("���̸��� �Է��� �ּ���:");
                 name = s.nextLine();
                 if(name!=null&&!name.trim().equals("")){                
                     out.writeUTF("req_logon|"+name);
                     break; //�ݺ��� ����
                 }else{
                     System.out.println("[##] �̸����� ������ �Է��Ҽ������ϴ�.");
                 }
            }
        } catch (IOException e1) {
            System.out.println("���ܹ߻�:run():�̸��Է� : "+e1.getMessage());
            e1.printStackTrace();
        }
        */
       
        while(out!=null){ //��½�Ʈ���� null�� �ƴϸ�..�ݺ�
            try { //while�� �ȿ� try-catch���� ����� ������ while�� ���ο��� ���ܰ� �߻��ϴ���
                  //��� �ݺ��Ҽ��ְ� �ϱ����ؼ��̴�.                  
               
                String msg = s.nextLine();
               
               if(msg==null||msg.trim().equals("")){
                   
                   msg=" ";
                   //continue; //�ֿܼ��� �������� �ѱ�°��� ���� ȿ������.
                   //System.out.println("����");
                }
               
                if(MultiClient.chatState == 0){            
                    //���� ��ȭ�� ���� ó���� ���.
                   
                     if(!msg.trim().equals("")){                 
                         name=msg;
                         out.writeUTF("req_logon|"+msg);
                       
                     }else{
                         System.out.println("[##] �̸����� ������ �Է��Ҽ������ϴ�.\r\n" +
                                "���̸��� �ٽ� �Է��� �ּ���:");
                     }             
                   
                }else if(MultiClient.chatState == 1) {//�α׿µ� �����̸� �׷���� �Է¹ޱ����� ����
                    //req_enterRoom|��ȭ��|������
                   
                     if(!msg.trim().equals("")){                 
                         out.writeUTF("req_enterRoom|"+name+"|"+msg);                      
                     }else{
                         System.out.println("[##] ������ �Է��Ҽ������ϴ�.\r\n" +
                                "�������� �ٽ� �Է��� �ּ���:");
                     }          
                   
                   
                }else if(msg.trim().startsWith("/")){
                    //��ɾ� ��� �߰�. ( /������ , /�ӼӸ� ������̵� �����Ҹ޽���... �� )
                    //Ŭ���̾�Ʈ�ܿ��� üũ
 
       
                /*  if(msg.equals("/������")
                       ||msg.startsWith("/�ӼӸ�")
                       ||msg.startsWith("/��������")
                       ||msg.startsWith("/����")
                       ||msg.startsWith("/��ȭ��û")
                       ||msg.startsWith("/��ȭ����")){  
                       
                        out.writeUTF("req_cmdMsg|"+name+"|"+msg);
                        //req_cmdMsg|��ȭ��|/������
                    }else if(msg.equalsIgnoreCase("/exit")){
                          System.out.println("[##] Ŭ���̾�Ʈ�� �����մϴ�.");
                          System.exit(0);
                        break;
                    }else{
                        System.out.println("[##] �߸��� ��ɾ��Դϴ�.");
                       
                    }  */  
                   
                    //Ȯ�强�� ���� �� �ڵ带 ����.
                   
                    if(msg.equalsIgnoreCase("/exit")){
                      System.out.println("[##] Ŭ���̾�Ʈ�� �����մϴ�.");
                      System.exit(0);
                      break;
                    }else{
                        out.writeUTF("req_cmdMsg|"+name+"|"+msg);
                        //req_cmdMsg|��ȭ��|/������
                    }
                   
                }/*else if(msg.startsWith("/�ӼӸ�")){
                   
                    out.writeUTF("req_whisper|"+name+"|"+msg);    
                   
                }*/else if(MultiClient.chatState==3){ //3 : ������ 1:1��ȭ��û�� ���� ,
                    //PvPchat|result)
                    msg = msg.trim(); //�޽��� ��������
                   
                    if(msg.equalsIgnoreCase("y")){
                        out.writeUTF("PvPchat|yes");                           
                    }else if(msg.equalsIgnoreCase("n")){
                        out.writeUTF("PvPchat|no");                                
                    }else{                       
                        System.out.println("�Է��� ���� �ùٸ��� �ʽ��ϴ�.");  
                        out.writeUTF("PvPchat|no");  
                    }
                    MultiClient.chatState=2; //1:1��ȭ ��û�� ����Ϸ� ����
               
                }else if(MultiClient.chatState == 5) { //5 : ������ ���������� �õ��Ͽ� ������� ������û�� ��ٸ�.
                    //fileSend|result)
                    if(msg.trim().equalsIgnoreCase("y")){
                        out.writeUTF("fileSend|yes");                          
                    }else if(msg.trim().equalsIgnoreCase("n")){
                        out.writeUTF("fileSend|no");                               
                    }else{
                        System.out.println("�Է��� ���� �ùٸ��� �ʽ��ϴ�.");
                        out.writeUTF("fileSend|no");          
                    }
                   
                    MultiClient.chatState=2; //�������ۼ�����û������ ����Ϸ� ����
                   
                }else{
                    //req_say|���̵�|��ȭ����
                    out.writeUTF("req_say|"+name+"|"+msg);                 
                }  
               
            }catch(SocketException e){             
                 System.out.println("Sender:run()����:"+e);
                 System.out.println("##�������� ������ ������ ���������ϴ�.");
                return;              
           } catch (IOException e) {
                System.out.println("����:"+e);
           }
        }//while------
     
    }//run()------
}//class Sender-------
 
/////////////////////////////////////////////////////////////////////
