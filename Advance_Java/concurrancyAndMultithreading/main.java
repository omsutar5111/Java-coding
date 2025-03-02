package Advance_Java.concurrancyAndMultithreading;

public class main {
    public static void main(String[] args)throws  Exception {
        basicThread bs = new basicThread();
        Thread t1 = new Thread(bs);
        Thread t2=new Thread(bs);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
