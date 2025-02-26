package Data_Structure_Algorithms.DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Dp1 {
    static int[] dp1;

    public static int fibonacci(int N){
        int a; int b;
        if(N==1 || N==0){
            return N;
        }
      a=fibonacci(N-1);
      b=fibonacci(N-2);
        return a+b;
    }
    public static  int dp(int N){
         dp1=new int[N+1];
        Arrays.fill(dp1,-1);
        return fibonacci2(N);
     // return stairsWays2(N);
//     return minSquares2(N);
    }

    public static int fibonacci2(int N){
             int a; int b;
        if(N==1 || N==0){
            dp1[N]=N;
            return N;
        }
        if(dp1[N]!=-1){
            return dp1[N];
        }
        a=fibonacci2(N-1);
        b=fibonacci2(N-2);
        dp1[N]=a+b;
        return a+b;
    }

    public static int stairsWays(int N){
        if(N==1 || N==2){
            return N;
        }
        int a=stairsWays(N-1);
        int b=stairsWays(N-2);
        return a+b;
    }
    public static int stairsWays2(int N){
        int a,b;
         if(N==1 || N==2){
            //dp1[N]=N;
            return N;
        }
        if(dp1[N-1]==-1){
           a=stairsWays2(N-1);
        }else{
           a= dp1[N-1];
        }
          if(dp1[N-2]==-1){
           b=stairsWays2(N-2);
        }else{
           b= dp1[N-2];
        }
         
       dp1[N]=a+b;
        return a+b;
    }

    public static int minSquares(int N){
        if(N==0 || N==1){
            return N;
        }
        int count=Integer.MAX_VALUE;
       for(int i=1;i*i<=N;i++){
           int ans=minSquares(N-(i*i));
           count=Math.min(ans, count);
       }
        return count+1;
    }

     public static int minSquares2(int N){
        if(N==0 || N==1){
            return N;
        }
        if(dp1[N]!=-1){
            return dp1[N];
        }
        int count=Integer.MAX_VALUE;
       for(int i=1;i*i<=N;i++){
           int ans=minSquares2(N-(i*i));
           count=Math.min(ans, count);
       }
       dp1[N]=count+1;
        return count+1;
    }
    public static void main(String[] args) {
       System.out.println(fibonacci(7));
//        System.out.println(fibonacci2(7));
        System.out.println(dp(7));
    //    System.out.println(stairsWays(4));
    //    System.out.println(dp(4));
//       System.out.println(minSquares(9));
//      System.out.println(dp(8));
    }
}
