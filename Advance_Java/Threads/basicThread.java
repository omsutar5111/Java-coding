package Advance_Java.Threads;

public class basicThread implements Runnable {

    @Override
    public void run() {
        for(int i=1;i<100;i++){
            if(i%2==0){
                System.out.println("thread name"+ Thread.currentThread().getName());
                System.out.println(i);
            }
        }
    }

}
