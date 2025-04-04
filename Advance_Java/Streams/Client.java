package Advance_Java.Streams;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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



        //Stream Operations
        ArrayList<Integer> list=new ArrayList<>();
        list.add(67);
        list.add(45);
        list.add(98);
        list.add(13);
        list.add(56);
        List<Integer> streamList=list.stream().
                distinct().
                sorted((a,b)->b-a).
                filter((val)->val%7==0).
                limit(1).
                collect(Collectors.toList());
        System.out.println(streamList);
    }
}
