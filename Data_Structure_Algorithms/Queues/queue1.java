package Data_Structure_Algorithms.Queues;

import java.util.*;

public class queue1 {

    public static void reverseFirstK(Queue<Integer> q, int k) {
        int n = q.size();
        Stack<Integer> stk = new Stack<>();
        for (int i = 1; i <= k; i++) {
            stk.push(q.remove());
        }
        while (stk.size() > 0) {
            q.add(stk.pop());
        }
        for (int i = 1; i <= n - k; i++) {
            q.add(q.remove());
        }

        System.out.println(q);
    }

    public static ArrayList<Integer> generateList(int N) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);

        int count = 3;
        while (list.size() < N) {
            int obj = q.remove();
            list.add(obj);
            if (count < N) {
                int v1 = obj * 10 + 1;
                int v2 = obj * 10 + 2;
                int v3 = obj * 10 + 3;
                count = count + 3;
                q.add(v1);
                q.add(v2);
                q.add(v3);

            }
        }
        return list;
    }

    //Unique Letter
    public static String repeatedConsecutive(String ans){
        Queue<Character> q1 = new ArrayDeque<Character>();
       HashMap<Character,Integer>map=new HashMap<>();
        String A=ans;
        StringBuilder result = new StringBuilder();
        for(int i=0;i<A.length();i++){
            char ch=A.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
            q1.offer(ch);
            while(!q1.isEmpty()&&map.get(ch)>1){
                q1.poll();
            }
            if (q1.isEmpty()){
                result.append('#') ;
            }
            else result.append(q1.peek());
        }

        return  result.toString();



    }

    //Parking Ice Cream Truck
    public static ArrayList<Integer> iceCreamTruck(ArrayList<Integer>A,int B){
        ArrayList<Integer>list=new ArrayList<>();
        PriorityQueue<Integer> q=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                    return o2.intValue()-o1.intValue();
            }
        });
        for(int i =0;i<B;i++){
            q.add(A.get(i));
        }
        list.add(q.peek());
        for(int i=1;i<A.size()-B+1;i++){
          q.remove(A.get(i-1));
            if(!q.isEmpty()&&A.get(i+B-1)>q.peek()){
                q.add(A.get(i+B-1));
                list.add(q.peek());
            }
            else {
                list.add(q.peek());
                q.add(A.get(i+B-1));
            }
        }

        return list;

    }

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(20);
        q.add(34);
        q.add(31);
        q.add(12);
        q.add(19);
        q.add(10);
        int[] A = {1, 2, 3, 4, 2, 7, 1, 3, 6};
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : A) {
            list.add(num);
        }
        System.out.println(iceCreamTruck(list,6));
//        System.out.println("bbb"+q.contains(2));
//        System.out.println(q);
        // q.remove();
        // reverseFirstK(q, 3);
//        ArrayList<Integer> Al = generateList(10);
//        System.out.println(Al);

    }
}