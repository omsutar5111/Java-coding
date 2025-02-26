package Advance_Java.Streams;

public class Client {

    public static void main(String[] args) {
        Runnable runnable=()->{
            System.out.println("from runnable interface calling run method");
        };

        Thread t1=new Thread(runnable);
        t1.start();

        Thread t2=new Thread(()->{
            System.out.println("calling directly from contractor");
        });
    }
}
