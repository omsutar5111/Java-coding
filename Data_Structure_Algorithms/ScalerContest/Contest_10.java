package Data_Structure_Algorithms.ScalerContest;

import java.util.ArrayList;
import java.util.HashMap;

public class Contest_10 {
  //INTERSECTION OF TWO ARRAYS

      public static int[] intersect(int[] A, int[] B) {
          HashMap<Integer,Integer> map=new HashMap<>();
          ArrayList<Integer> list=new ArrayList<>();
          for(int i=0;i<A.length;i++){
              if(map.containsKey(A[i])){
                  int freq=map.get(A[i])+1;
                  map.put(A[i],freq);
              }
              else{
                  map.put((A[i]),1);
              }
          }
          for(int i=0;i<B.length;i++){
              if(map.containsKey(B[i])){
                  list.add(B[i]);
                  int freq=map.get(B[i])-1;
                  if(freq>0){
                      map.put(B[i],freq);
                  }
                  else{
                      map.remove(B[i]);
                  }
              }
          }

          int ans[]=new int[list.size()];
          for(int i=0;i<ans.length;i++){
              ans[i]=list.get(i);
          }
          return ans;
      }

 // find the smallest element in rotated array

    public static int findSmallestInRotatetd(int A[]){
          int l=0,r=A.length-1;
          while (l<r){
              int mid=l+(r-l)/2;
              if(A[mid]>A[r]){
                  l=mid+1;
              }
              else{
                  r=mid;
              }
          }
          return A[l];
    }

    //check string acroymn

    public  static int solve(String[] A, String B) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<A.length;i++){
            sb.append(A[i].charAt(0));
        }
        // sb.toString();
        if(sb.toString().equals(B)){
            return 1;
        }
        return 0;
    }





    public static void main(String[] args) {

    }
}
