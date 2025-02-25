package DSA.Advanced_Dsa.DynamicProgramming;

import java.util.Arrays;

public class Dp3 {

    public static int Knapsack_1 (int i,int j,int[]A,int B[],int dp[][]) {
        if (i < 0 || j <= 0) {
            return 0;
        }
        if (dp[i][j] == -1) {
            int a = Knapsack_1(i - 1, j, A, B, dp);
            if (j >= B[i]) {
                a = Math.max(a, Knapsack_1(i - 1, j - B[i], A, B, dp) + A[i]);
                dp[i][j] = a;
            }
        }
        return dp[i][j];
    }

    public static  int knapsack_infinity(int i,int j,int A[],int B[],int dp[][]){
        if(i<0 || j<=0){
            return 0;
        }
        if(dp[i][j]==-1){
            int maxCanTake=knapsack_infinity(i-1,j,A,B,dp);
            if(j>=B[i]){
                maxCanTake=Math.max(maxCanTake,knapsack_infinity(i,j-B[i],A,B,dp)+A[i]);
                dp[i][j]=maxCanTake;
            }
        }
        return dp[i][j];
    }


    public static void main(String[] args) {
        int A[]={60,100,120};
        int B[]={10,20,30};
        int C=50;
        int dp[][]=new int[A.length][C+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(knapsack_infinity(A.length-1,C,A,B,dp));
    }
}
