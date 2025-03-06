package Advance_Java.concurrancyAndMultithreading.excecuters;

public class NumberPrinter implements  Runnable{
    int num;
    public NumberPrinter(int num){
        this.num=num;
    }

    public static void print(int num){
        System.out.println("num: "+num+" from Thread:"+Thread.currentThread().getName() );
    }

    @Override
    public void run() {
        print(num);
    }
}
