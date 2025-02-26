package Advance_Java.Threads.synchronize;

public class Subtractor implements Runnable{

    private Count count;
   final private Object lock;

    public Subtractor(Count count, Object lock) {
        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i=0; i<100000; i++){
            synchronized (lock)
            {
                 count.num--;

            }
        }
    }
}
