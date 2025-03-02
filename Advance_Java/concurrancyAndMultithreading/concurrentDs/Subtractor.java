package Advance_Java.concurrancyAndMultithreading.concurrentDs;

import java.util.concurrent.atomic.AtomicInteger;

public class Subtractor implements Runnable{

    AtomicInteger ai;


    public Subtractor(AtomicInteger ai) {
        this.ai=ai;
    }

    @Override
    public void run() {
        for (int i=0; i<100000; i++){
           ai.decrementAndGet();
        }
    }
}
