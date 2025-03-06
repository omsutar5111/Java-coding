package Advance_Java.concurrancyAndMultithreading.excecuters;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FibonnaciNumber implements Callable<Integer> {
    int num;
    public FibonnaciNumber(int num){
        this.num=num;
    }
    @Override
    public Integer call() throws Exception {
        System.out.println("Returning "+num+" th Fibonacci number from Thread : "+Thread.currentThread().getName());
        if(num<=1)return num;
        ExecutorService executorService= Executors.newFixedThreadPool(4);
        Future<Integer>fib1=executorService.submit(new FibonnaciNumber(num-1));
        Future<Integer>fib2=executorService.submit(new FibonnaciNumber(num-2));
        return fib1.get()+fib2.get();

    }
}
