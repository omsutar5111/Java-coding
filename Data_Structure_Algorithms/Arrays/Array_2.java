package Data_Structure_Algorithms.Arrays;

public class Array_2 {

    public static int majority(int A[]) {
        int majority = A[0];
        int freq = 1;
        for (int i = 1; i < A.length; i++) {
            if (freq == 0) {
                majority = A[i];
                freq = 1;
            } else if (A[i] == majority) {
                freq++;
            } else {
                freq--;
            }
        }
        return majority;
    }

    public static int[] RotateArray(int arr[]) {
        int n = arr.length;
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] =  arr[i-1];
            arr[i-1] =temp;
        }

        return arr;
    }


    public static int CountFactors(int A){
        int ans=0;
        for(int i=1;i*i<=A;i++){
            if(A%i==0){
                if(A/i==i){
                    ans++;
                }
                else{
                    ans=ans+2;
                }
            }

        }
        return ans;
    }

    public static Boolean isPrime(int A){
        int factor=CountFactors(A);
        if(factor>2){
            return true;
        }
        return false;
    }

    public static int[]ArrayRotate(int A[],int B){
        B=B%A.length;
        for(int i=0;i<B;i++){
            RotateArray(A);
        }
        return A;
    }

    public static boolean MonotonicArray(int arr[]){
        if(arr.length<=2){
            return true;
        }
        boolean decresing=true;
        boolean increasing=true;

        for(int i=1;i<arr.length;i++){
            if(!(arr[i]>=arr[i-1])){
                increasing=false;
            }
            if (!(arr[i]<=arr[i-1])){
                decresing=false;
            }
        }
      return increasing | decresing;
    }


    public static int minMaxSubarray(int min,int max,int arr[]){
       int minIndex=-1;
       int maxIndex=-1;
       int ans=Integer.MAX_VALUE;
       for(int i=0;i<arr.length;i++){
           if(arr[i]==min && minIndex==-1){
               minIndex=i;
           }
           if(arr[i]==max && maxIndex==-1){
               maxIndex=i;
           }
           if(minIndex!=-1 && maxIndex!=-1){
               ans=Math.min( ans,Math.abs(minIndex-maxIndex)+1);
           }
       }
       if(minIndex==-1 && maxIndex==-1){
           return 0;
       }
       return ans;
    }

    public static int maxProfit(int stocks[]){
        int profit=0;
        for(int i=1;i<stocks.length;i++){

        }
        return profit;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int arr2[]={16,17,4,3,5,2};
   //    int ans[] = RotateArray(arr);
//       int ans[]=ArrayRotate(arr,3);
//        for (int i = 0; i < ans.length; i++) {
//            System.out.print(ans[i]+ "");
//        }
        System.out.println(minMaxSubarray(2,3,arr2));
//        System.out.println(isPrime(2));

    }

}
