package Data_Structure_Algorithms.sorting;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class sorting_types {

    static int count=0;
    public static int inversionCount(int A[]) { 
        int pair =0;
        for(int i=0;i<A.length;i++){
            for(int j=i+1;j<A.length;j++){
                if(A[i]>A[j]){
                    pair++;
                }
            }
        }
        return pair;
        
    }
    public static int[] merge2(int A[], int s, int m, int e) {
        int p1=s,p2=m+1,p3=0;
            int[] temp=new int[e-s+1];
            while(p1<=m && p2<=e){
                if(A[p1]<=A[p2]){
                    temp[p3]=A[p1];
                    p1++;
                    p3++;
                }else{
                    temp[p3]=A[p2];
                    p2++;
                    p3++;
                    count=count+m-p1+1;
                }
            }
            //copy remaining elements from p1
            while(p1<=m){
                temp[p3]=A[p1];
                p1++;
                p3++;
            }
            //copy remaining elements from p2
            while(p2<=e){
                temp[p3]=A[p2];
                p2++;
                p3++;
            }
            //merge the array
            for(int i=s;i<=e;i++){
                A[i]=temp[i-s];
            }
            return A;
      }
    
      public static int factors(int A){
        int count=1;
        for(int i=2;i<=A;i++){
            if(A%i==0){
                count++;
            }
        }
        return count;
      }
  
      public static void mergeSort(int A[], int s, int e) {
        if (s == e) {
          return;
        }
        int mid = (s + e) / 2;
        mergeSort(A, s, mid);
        mergeSort(A, mid + 1, e);
        merge2(A, s, mid, e);
      }

      public static int reArrange(int A[],int s,int e){
        // int random=(int)((Math.random()*(e-s))+e  );
        //  int tem=A[random];
        //         A[random]=A[s];
        //         A[s]=tem;
        int p1=s+1;
        int p2=e;
        while(p1<=p2){
            if(A[s]>=A[p1]){
                p1++;
            }
            else if(A[s]<A[p2]){
                p2--;
            }
            else{
                int temp=A[p1];
                A[p1]=A[p2];
                A[p2]=temp;
                p1++;p2--;
            }
        }
        int temp1=A[s];
        A[s]=A[p2];
        A[p2]=temp1;
        return p2;
      }

      public static void quickSort(int A[],int s,int e){
          if(s>=e){
            return;
          }
          int p=reArrange(A, s, e);
          quickSort(A, s, p-1);
          quickSort(A, p+1, e);

      }

     public static ArrayList<Integer> sortFactor(ArrayList<Integer>A){
     Collections.sort(A,new Comparator<Integer>() {
     @Override
    public int compare(Integer o1, Integer o2) {
    // TODO Auto-generated method stub
   int count1=factors(o1);
   int count2=factors(o2);
    if(count1==count2){
        if(o1<o2){
            return -1;
        }
        else if(o2<o1){
            return 1;
        }
        else return 0;
    }
    else if(count1<count2){
        return -1;
    }
    return 1; 
    }
            
        });
        return A;
     }

     public static void selectionSort(int A[]){
        int n= A.length;
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted part of the array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (A[j] < A[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = A[minIndex];
            A[minIndex] = A[i];
            A[i] = temp;
        }
     }
   
     public static void bubbleSort(int A[]) {
          int n=A.length;
          for(int i=0;i<n;i++){
            for (int j=1;j<n-i;j++){
                if(A[j-1]>A[j]){
                    int temp=A[j];
                    A[j]=A[j-1];
                    A[j-1]=temp;
                }
            }
          }
     }
   
     public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
          System.out.print(arr[i]+" ");
        }
        System.out.println();
      }

      //B Closest Points to Origin

    public static ArrayList<ArrayList<Integer>> nearestRestaurants(ArrayList<ArrayList<Integer>> A, int B) {

         A.sort( new Comparator<ArrayList<Integer>>(){
             @Override
             public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                 int sum1=0,sum2=0;
                 for(int i:o1){
                     sum1+= i*i;
                 }
                 for(int j:o2){
                     sum2+= j*j;
                 }
                 return Integer.compare(sum1,sum2);
             }
         });
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<B;i++){
            ans.add(A.get(i));
        }
        return ans;
    }
    
     public static void main(String[] args) {
        int A[]={2,5,7,3,4,8,1};
       // System.out.println(inversionCount(A));
       // mergeSort(A, 0, A.length-1);
     //   System.out.println(count);

      printArray(A);
      //quickSort(A, 0, A.length-1);  //TC==NLOGN
      selectionSort(A);  //Tc=N2
//      bubbleSort(A);     //TC=N2
     // mergeSort(A, 0, A.length-1); //TC=NLOGN
      System.out.println("array after Data_Structure_Algorithms.sorting");
      printArray(A);


    }
}
