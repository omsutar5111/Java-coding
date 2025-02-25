package DSA.Advanced_Dsa.GreedyAlgorithm;

import java.util.*;

public class greedy {

    static  class Pair{
        int start;
        int end;
        int value;
        int weight;
        double ratio;
        public Pair(int start,int end){
            this.start=start;
            this.end=end;
        }
        public  Pair(int value,int weight,double ratio){
            this.value=value;
            this.weight=weight;
            this.ratio=ratio;
        }
    }
    public static  class PairComparator implements Comparator<Pair>{

        @Override
        public int compare(Pair o1, Pair o2) {
            return Integer.compare(o1.end, o2.end);
        }
    }

    public static class PairRatioComparator implements Comparator<Pair>{
        @Override
        public int  compare(Pair o1, Pair o2) {
           if(o1.ratio>o2.ratio){
               return  -1;
           }
           else if(o2.ratio>o1.ratio){
               return 1;
           }
           else return 0;
        }
    }

    public  static int maximumTaskFromActivity(int A[],int B[]) {
        Pair []pairs=new Pair[A.length];
        for(int i=0;i<A.length;i++){
            pairs[i]=new Pair(A[i],B[i]);
        }
        Arrays.sort(pairs,new PairComparator());
        int ans=1;
        int minStartTime=pairs[0].end;
        for(int i=1;i<A.length;i++){
            if(pairs[i].start>=minStartTime){
                ans++;
                minStartTime=pairs[i].end;
            }
        }
        return ans;
    }


    static class deadline{

    }

    public static int maxPaymentJob(int paymentDeadline[][]){
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();

        return 0;
    }

    public static int fractionalKnapsack(int values[],int weights[],int capacity){
        ArrayList<Pair>list=new ArrayList<>();
        for(int i=0;i<weights.length;i++){
            int val=values[i];
            int weight=weights[i];
            Double ratio=val/(weight/1.0);
            list.add(new Pair(val,weight,ratio));
        }
        double ans=0;
        Collections.sort(list,new PairRatioComparator());
        for(int i=0;i<list.size();i++){
            Pair p=list.get(i);
            if(p.weight<=capacity){
                ans=ans+p.value;
                capacity=capacity-p.weight;
            }
            else {
                ans=ans+(capacity*p.ratio);
                break;
            }
        }
        return  (int) ((ans*1000)/10);

    }
    public static void main(String[] args) {
       int values[]={60, 100, 120};
       int weights[]={10, 20, 30};
       int c=50;
        System.out.println(fractionalKnapsack(values,weights,c));
    }
    
}
