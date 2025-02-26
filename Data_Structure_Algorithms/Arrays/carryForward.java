package Data_Structure_Algorithms.Arrays;

import java.util.ArrayList;

public class carryForward {

    // problem on checkin AG sunsequnce pair
    public static int[] prefix(String A) {
        int pref[] = new int[A.length()];
        if (A.charAt(0) == 'A') {
            pref[0] = 1;
        } else {
            pref[0] = 0;
        }
        for (int i = 1; i < A.length(); i++) {
            char ch = A.charAt(i);

            if (ch == 'A') {
                pref[i] = pref[i - 1] + 1;
            } else {
                pref[i] = pref[i - 1];
            }
            ;
        }
        return pref;
    }

    public static int solve(String A) {
        int ans = 0;
        int mod = 1000 * 1000 * 1000 + 7;
        int countA[] = prefix(A);
        for (int i = 1; i < A.length(); i++) {
            char ch = A.charAt(i);

            if (ch == 'G') {
                ans = ans + countA[i];
                ans = ans % mod;
            }
        }
        // System.out.println(ans);
        return ans;

    }

    // carry forward finding leaders (. An element is a leader if it is strictly
    // greater than all the elements to its right side.
    public int[] leaders(int[] A) {
        int max = A[A.length - 1];
        ArrayList<Integer> resultAL = new ArrayList<Integer>();
        resultAL.add(max);
        for (int i = A.length - 2; i > 0; i--) {
            if (A[i] > max) {
                max = A[i];
                resultAL.add(A[i]);
            }
        }
        int[] result = new int[resultAL.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultAL.get(i);
        }
        return result;
    }

    // calculate maxSum subarray
    public static int maxSum(int[] A) {
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = 0;
            for (int j = i; j < A.length; j++) {
                sum = sum + A[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // print subaaray from start index to end index
    public static void printSubaaray(int A[], int start, int end) {
        for (int i = start; i <= end; i++) {
            for (int j = i; j <= end; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(A[k] + " ");
                }
                System.out.println();
            }

        }
    }

    // print sum of all subarrays
    public static void printSumsubarray(int A[]) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = 0;
            for (int j = i; j < A.length; j++) {
                sum = sum + A[j];
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }

    // Total sum of subarrays
    public static int allSumsub(int A[]) {
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans = ans + (A[i] * ((i + 1) * (A.length - i)));
        }
        return ans;
    }


    public static int minMaxSubarray(int arr[],int min,int max){
        int ans=0;
        ArrayList <Integer> list=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if((arr[i]==min || arr[i]==max)){
                if(arr[i]==min){
                    while(arr[i]!=max){
                        list.add(arr[i]);
                    }
                }
                else{
                    while(arr[i]!=min){
                        list.add(arr[i]);
                    }
                }
            }

        }
        ans=list.size();
        return ans;
    }

    //Find max sum window equl to  or less than integer B
    public  static int maxsumWindwo(int []A,int B){
        int ans=Integer.MIN_VALUE;
        int pref[]=new int[A.length];
        pref[0]=A[0];
        for(int i=1;i<A.length;i++){
            pref[i]=pref[i-1]+A[i];
        }
        int start=0;
        for(int i=0;i<A.length;i++){
            while(pref[i]-pref[start]>B && start<i){
                start++;
            }
            if(pref[i]-pref[start]<=B){
                ans=Math.max(ans,pref[i]-pref[start]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // int ans[] = prefix("ANAGRAM");
        // for (int i = 0; i < ans.length; i++) {
        // System.out.println(ans[i]);
        // }
        // int fans = solve("ANAGRAM");
        // System.out.println(fans);

        int A[] = { 1, 2,3,4 };
        // int ans = maxSum(A);
        // System.out.println(ans);

         printSubaaray(A, 0, 3);
        // printSumsubarray(A);
//        System.out.println(allSumsub(A));
        int arr[]={16,17,4,3,5,2};
//        System.out.println(maxsumWindwo(arr,12));
//        System.out.println(minMaxSubarray(arr,2,3));
    }
}
