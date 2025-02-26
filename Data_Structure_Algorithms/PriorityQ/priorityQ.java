package Data_Structure_Algorithms.PriorityQ;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class priorityQ {
    public static void main(String[] args) {
        
       PriorityQueue<Integer>pq=new PriorityQueue<>();
       int k=3;
       int arr[]={10,2,13,14,16,3,19};
        System.out.println(KthSmallest(arr,3));
        pq.add(12);
        pq.add(23);
        pq.add(43);
        pq.add(-9);

//         while(!pq.isEmpty()){
//             System.out.println(pq.peek());
//             pq.remove();
//         }
            
       PriorityQueue<Integer>maxHeap=new PriorityQueue<>(new Comparator<Integer>() {
         @Override
         public int compare(Integer o1,Integer o2){
             return o2-o1;
         }
       });

         
    }

    public static  int KthSmallest(int[]arr,int k){
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2){
                return o2.intValue()-o1.intValue();
            }
        });
         for(int i=0;i<k;i++){
             maxHeap.add(arr[i]);
         }
         for(int i=k;i<arr.length;i++){
             int val=maxHeap.peek();
             if(arr[i]<maxHeap.peek()){
                  maxHeap.remove();
                  maxHeap.add(arr[i]);
             }
         }
         return maxHeap.peek();
    }


    public static ArrayList<Integer> FindRunningMedian(ArrayList<Integer> A) {
     ArrayList<Integer>ans=new ArrayList<>();
     PriorityQueue<Integer>pq=new PriorityQueue<>();
     pq.addAll(A);
     for(int i=0;i<A.size();i++){
         ArrayList<Integer>curr=new ArrayList<>();
         curr.add(A.get(i));
         int median=0;
         for(int j=0;j<curr.size();j++){

         }
     }
     return ans;
    }

}
