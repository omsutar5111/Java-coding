package Advance_Java.Threads.concurrentDs;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger ai=new AtomicInteger();
        Adder a=new Adder(ai);
        Subtractor s=new Subtractor(ai);
        Thread t1=new Thread(a);
        Thread t2=new Thread(s);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(ai.get());
    }
}
