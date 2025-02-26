package Data_Structure_Algorithms.Backtracking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class bt {
static ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
    public static  void printAllNumber(int arr[],int i,int N){
        //T.C=(2^N*N)  S.C=N;
                if(i==N){
                    for(int j=0;j<arr.length;j++){
                        System.out.print(arr[j]+" ");
                    }
                    System.out.println();
                    return;
                }
                arr[i]=1;
                printAllNumber(arr,i+1,N);
                arr[i]=2;
                printAllNumber(arr,i+1,N);
    }
    public static int countSubsetSum(int arr[], int n, int i, int sum, int k) {

        //TC:O(2^n)  SC:O(N)
        if (i == n) {
            if (sum == k) {
                return 1;
            } else {

                return 0;
            }
        }
        sum = sum + arr[i];//choice one to add
        int c1 = countSubsetSum(arr, n, i + 1, sum, k);
        sum = sum - arr[i];//choice two remove it.
        int c2 = countSubsetSum(arr, n, i + 1, sum, k);
        return c1 + c2;
    }

   public static ArrayList<ArrayList<Integer>> getAllsubset(ArrayList<Integer>A){
       Collections.sort(A);
       ArrayList<Integer>cur=new ArrayList<>();

       ans.add(cur);
       allSubset(A,0,cur);
        return ans;
    }

    public static void allSubset(ArrayList<Integer>A,int i,ArrayList<Integer>cur){
        if(i==A.size()){
             return;
        }
        cur.add(A.get(i));
        ans.add(new ArrayList<>(cur));
        allSubset(A,i+1,cur);
        cur.remove(cur.size()-1);
        allSubset(A,i+1,cur);
    }



    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printAllpermutations(int arr[], int n, int i) {
        if (i == n) {
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + "");
            }
            System.out.println();
            return;
        }

        for (int j = i; j < n; j++) {
            swap(arr, i, j);
            printAllpermutations(arr, n, i + 1);
            swap(arr, i, j);

        }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 2, 7 };
        int arr2[]=new int[3];
//         System.out.println(countSubsetSum(arr, arr.length, 0, 0, 7));

//        printAllpermutations(arr, arr.length, 0);

        printAllNumber(arr,0,arr2.length);

        //problem to get all subset
//        ArrayList<Integer>list=new ArrayList<>();
//        ArrayList<Integer>Arr=new ArrayList<>();
//        Arr.add(2);
//        Arr.add(3);
//        Arr.add(5);
//        Arr.add(7);
//      ArrayList<ArrayList<Integer>>ans= getAllsubset(Arr);
//      for(int i=0;i<ans.size();i++){
//          list=ans.get(i);
//          for(int j=0;j<list.size();j++){
//              System.out.print(list.get(j)+" ");
//          }
//          System.out.println();
//      }


    }
}
