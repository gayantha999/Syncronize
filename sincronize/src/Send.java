import static java.lang.Thread.sleep;

public class Send {
    //String msg;
  //  Send send;

    public void send(String msg){
        System.out.println("Sending \t" + msg);
        try {
            Thread.sleep(1000);
        }
        catch(Exception e){
            System.out.println("Thread interuptred");
        }
        System.out.println("\n" +msg + "Sent");
    }
}

class thrededSend extends  Thread{
    private String msg;
    Send sender;
thrededSend(String m, Send obj){
    msg=m;
    sender=obj;
}
public void run(){
    synchronized (sender){
        sender.send(msg);
    }
}
}

class main{
    public static void main (String args[]){
        Send snd=new Send();
        thrededSend th1=new thrededSend("HI ",snd);
        thrededSend th2=new thrededSend("Bye ", snd);
    th1.start();
    th2.start();
    try {
        th1.join();
        th2.join();
    }
    catch (Exception e){
        System.out.println("Interrupted");
    }
    }


}

