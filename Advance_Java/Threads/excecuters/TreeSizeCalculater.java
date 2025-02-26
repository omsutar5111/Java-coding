package Advance_Java.Threads.excecuters;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TreeSizeCalculater implements Callable<Integer> {
    private Node root;
    ExecutorService executorService;
    public TreeSizeCalculater(Node root,ExecutorService executorService){
        this.root=root;
        this.executorService=executorService;
    }
    @Override
    public Integer call() throws Exception {
         if(root ==null){
             return 0;
         }
        TreeSizeCalculater leftSize=new TreeSizeCalculater(root.left,executorService);
         Future<Integer> f1=executorService.submit(leftSize);
        TreeSizeCalculater rightSize=new TreeSizeCalculater(root.left,executorService);
        Future<Integer> f2=executorService.submit(rightSize);
         return  Math.max(f1.get(),f2.get())+1;
    }
}
