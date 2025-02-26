package Advance_Java.Threads.excecuters;

import java.util.Random;
import java.util.concurrent.Callable;

public class random implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Random random=new Random();
        System.out.println("Im in thread one"+Thread.currentThread().getName());
        return random.nextInt();
    }
}
