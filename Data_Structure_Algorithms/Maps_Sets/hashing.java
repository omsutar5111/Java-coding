package Data_Structure_Algorithms.Maps_Sets;// import java.lang.reflect.Array;
// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.HashSet;
import java.util.*;
public class hashing {

    public static int[] suffixCount(int []A) {
        Arrays.sort(A);
        int suffixCount[]=new int[A.length];
        suffixCount[0]=A[0];
        int count=1;
        for(int i=1;i<A.length;i++){
            if(A[i]==A[i-1]){
                suffixCount[i]=count;
            }
            if(A[i]-1==A[i-1]){
              count++;
              suffixCount[i]=count;
            }
            else{
                count=1;
                suffixCount[i]=1;
            }
        }
        return suffixCount;
    }

public static int  prob1(int[]A) {
  int B[]=suffixCount(A);
  int length=0;
     for(int i=0;i<A.length;i++){
       length=Math.max(length, B[i]);
     }
    return length;
}

public static int prob1UsingHahmap(int A []) {
    int ans=1;
    HashSet <Integer>set =new HashSet();
    for(int i=0;i<A.length;i++){
        set.add(A[i]);
    }
    
    for(int i=0;i<set.size();i++){
       int X=A[i];
    }

    return ans;
}
    public static void main(String[] args) {
        int[]A={-1,8,5,5,5,3,10,2,4,9};
    
       System.out.println(prob1(A));
     
    }
}
