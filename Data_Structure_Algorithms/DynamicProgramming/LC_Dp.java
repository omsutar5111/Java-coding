package Data_Structure_Algorithms.DynamicProgramming;

import java.util.*;

public class LC_Dp {
    //2140. Solving Questions With Brainpower
    public long mostPoints(int[][] questions) {
        long dp[]=new long[questions.length];
        Arrays.fill(dp,-1);
        return  getPointsRecursively(questions,0,dp);
    }
    public long getPointsRecursively(int [][]questions,int index,long []dp){
        if(index>=questions.length){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int nextIndex=index+questions[index][1]+1;
        long currentPoints=questions[index][0]+(nextIndex<=questions.length?getPointsRecursively(questions,nextIndex,dp):0);
        long skipCurrent=getPointsRecursively(questions,index+1,dp);
        dp[index]=Math.max(currentPoints,skipCurrent);
        return dp[index];
    }
}
