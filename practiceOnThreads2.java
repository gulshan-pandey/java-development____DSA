// WAP that creates 2 threads,each thread should print "hello from Thread X".whree X is the number of the thread(1 0r 2),ten times,then terminate

class ques1 extends Thread{
    private int x;

    ques1(int x){
        this.x = x;
    }
    public void run(){
        for(int i=0;i<=10;i++){
            System.out.printf("(%d) HELLO from Thread - %d \n",i,x);
        }
    }
}

public class practiceOnThreads2 extends Thread{
   
   

    public static void main(String[] args) {
        
      ques1 p1 = new ques1(1);
      ques1 p2 = new ques1(2);

      p1.start();
      p2.start();
    }
}