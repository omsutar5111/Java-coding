package Data_Structure_Algorithms.Maps_Sets;

import javax.imageio.metadata.IIOMetadataNode;
import java.util.HashMap;
import java.util.Map;

public class hashing_2 {

    public static int PairSum(int[] A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            int key=entry.getKey();
            int value=entry.getValue();
            System.out.println("key+ "+key+"value+ "+value);
        }
        int count = 0;
        // int freq=0;
        int mod = 1000000007;
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                int freq = map.get(A[i]);
                freq++;

                map.put(A[i], freq);
            } else {
                map.put(A[i], 1);
            }
        }

        for (int i = 0; i < A.length; i++) {
            int C = A[i];
            int K = B - A[i];
            if (map.containsKey(K) && C != K) {
                count++;
            }
            if (C == K && map.get(K) > 1) {
                count++;
                map.put(A[i], (map.get(K) - 1));

            }
        }
        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            int key=entry.getKey();
            int value=entry.getValue();
            System.out.println("key+ "+key+"value+ "+value);
        }
        return count;
    }

    public static int frequencyOne(int A[]) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {

            if (map.containsKey(A[i])) {
                int freq = map.get(A[i]);
                freq++;
                map.put(A[i], freq);
            } else {
                map.put(A[i], 1);
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                if (map.get(A[i]) == 1) {
                    count++;
                }
            }
        }

        return count;

    }

    public static int[] frequncyCount(int[] A, int[] Q) {
        int[] freq = new int[Q.length];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {

            if (map.containsKey(A[i])) {
                int count = map.get(A[i]);
                count++;
                map.put(A[i], count);
            } else {
                map.put(A[i], 1);
            }
        }
        for (int i = 0; i < Q.length; i++) {
            int ele = Q[i];
            if (map.containsKey(ele)) {
                freq[i] = map.get(ele);
            }
        }

        return freq;
    }

    public static void main(String[] args) {
        // Problem 1
        // int Q[]={1,6,7};
        int A[] = { 1, 6, 7, 6, 7, 9, 10, -8, 2 };
        System.out.println(PairSum(A, 12));

        // System.out.println(frequencyOne(A));
        // int count[]=frequncyCount(A, Q);
        // for(int i=0;i<count.length;i++){
        // System.out.println(count[i]);
        // }

    }
}
