package Data_Structure_Algorithms.DynamicProgramming;

import java.util.Arrays;

public class Dp2 {
      
    public static int maxSubsequenceSum(int[]dp,int A[], int i) {
        if (i == 0) {
            return Math.max(0, A[i]);
        }
        if (i < 0) {
            return 0;
        }
        if(dp[i]!=-1){
           return dp[i];
        }
        int a = A[i] + maxSubsequenceSum(dp,A, i - 2);
        int b = maxSubsequenceSum(dp,A, i - 1);
        dp[i]=Math.max(a,b);
        return dp[i];
    }

    public static int maxSubsequenceSumDp(int A[]) {
        int[]dp=new int[A.length];
        int N = A.length;
        Arrays.fill(dp,-1);
        return maxSubsequenceSum(dp,A,N-1);
    }


    public static int uniquePathsWithObstacles(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        if (A[0][0] == 1 || A[n - 1][m - 1] == 1) {
            return 0;
        }

        if (n == 1 && m == 1) {
            return A[0][0] == 0 ? 1 : 0;
        }


        int dp[][] = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return uniquePathDpRecursion(dp, n - 1, m - 1, A);
    }

    public static int uniquePathDpRecursion(int dp[][],int i,int j, int A[][]){
        if(i<0 || j<0 || A[i][j]==1){
            return 0;
        }
        if(i==0 && j==0){
           return A[i][j]==0?1:0;
        }

        if(dp[i][j]==-1){
            dp[i][j]=uniquePathDpRecursion(dp,i-1,j,A)+uniquePathDpRecursion(dp,i,j-1,A);
        }
        return dp[i][j];

    }

    public static void main(String[] args) {
        int A[] = { 5, 3, 8 };

//        int N = A.length;
//       int result=maxSubsequenceSumDp(A);
//        System.out.println(result);

        int arr[][]={{0,0},{0,0},{0,0},{1,0},{0,0}};
        System.out.println(uniquePathsWithObstacles(arr));
    }
}
