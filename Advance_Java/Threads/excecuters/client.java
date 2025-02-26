package Advance_Java.Threads.excecuters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class client {

    public static void main(String[] args) throws Exception {
        random random=new random();
        ExecutorService executorService= Executors.newFixedThreadPool(10);
//        Future<Integer> integerFuture= executorService.submit(random);
//        System.out.println("New task by main thread ");
//        Integer ans=integerFuture.get();
//        System.out.println(ans.toString());

        // Example Tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        TreeSizeCalculater task = new TreeSizeCalculater(root, executorService);
        Future<Integer> result = executorService.submit(task);
        System.out.println(result.get());
        executorService.shutdown();

    }
}
