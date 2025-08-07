package src;

public class thread {
    public static final Object lock=new Object();
    static  int cnt=1;
    static int max=100;
    static boolean isOddTurn = true; // 控制交替顺序的标志
    public static void main(String []args){

        Runnable printer=()->{
            boolean oddTurn=Thread.currentThread().getName().contains("奇数");
            while(true){
              synchronized (lock){
            //                  lock.notify();
                  while(isOddTurn&&!oddTurn||!isOddTurn&&oddTurn) {//是奇数的turn，但线程是偶数或者不是奇数turn但线程是奇数则需要等待
                      try {
                          lock.wait();
                      } catch (InterruptedException e) {
                          Thread.currentThread().interrupt();
                          return;
            //                      throw new RuntimeException(e);
                      }
                  }
                  if(cnt>max) break;
                  System.out.println(Thread.currentThread().getName()+"："+cnt++);
                  isOddTurn=!isOddTurn;
                  lock.notify();//唤醒另外一个线程
              }
          }
        };

        Thread t1=new Thread(printer,"奇数打印");
        Thread t2=new Thread(printer,"偶数打印");
        t2.start();
        t1.start();



    }
}
