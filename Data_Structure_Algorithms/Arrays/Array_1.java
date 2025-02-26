package Data_Structure_Algorithms.Arrays;

import java.util.Scanner;


public class Array_1 {

   public static int[] reversedArray(int[]newArr) {
    int N=newArr.length;
    int i=0;
    int j=N-1;
    while(i<j){
        int temp=newArr[i];
        newArr[i]=newArr[j];
        newArr[j]=temp;
        i++;
        j--;
    }
    return newArr;
    
   }
   public static int[] reverseArray(int []newArr) {
    int N=newArr.length;
   for(int i=0,j=N-1;i<j;i++){
    int temp=newArr[i];
    newArr[i]=newArr[j];
    newArr[j]=temp;
    j--;
   }
    return newArr;
  }

    public static int [] prefixSum(int arr[]) {
        int []pf=new int[arr.length];
        for(int i=0;i<pf.length;i++){
         int sum=0;
         for(int j=0;j<=i;j++){
            sum +=arr[j];
         }
         pf[i]=sum;
        }
        return pf;
    }
    public static int [] prefixSumOptimal(int arr[]) {
        int []pf=new int[arr.length];
        pf[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            pf[i]=pf[i-1]+arr[i];
        }
        return pf;
    }

    public static void multipleQueries(int[]newArr,int[][]queries) {
        int Q= queries.length;
        int N=newArr.length;
        for(int i=0;i<Q;i++){
            int L=queries[i][0];
            int R=queries[i][1];
            int sum =0;
            for(int j=L;j<=R;j++){
                sum+=newArr[j];
            }
            System.out.println(sum);

        }
    }
    public static void optimalQueriesSum(int[]newArr,int [][]queries) {
        int []pf=prefixSumOptimal(newArr);
        int N= newArr.length;
        int Q= queries.length;
        for(int i=0;i<Q;i++){
            int L=queries[i][0];
            int R=queries[i][1];
            if(L==0){
                System.out.println(pf[R]);
            }else{
                System.out.println(pf[R]-pf[L-1]);
            }
        }
       
    }

    public static int EquilibiriumIndex(int[]newArr) {
        int count =0;
        int N=newArr.length;
        int[]pf=prefixSum(newArr);
        if(pf[N-1]-pf[0]==0){
           count++;
        }
        for(int i=1;i<N;i++){
           int sumLeft=pf[i-1];
           int sumRight=pf[N-1]-pf[i];
    
           if(sumLeft==sumRight){
            count++;
           }

           }
           return count;
        }
       
        public static int[] CountOdd(int []newArr,int[][]queries) {
            int Q=queries.length;
            int []Odd=new int[Q];
           for(int i=0;i<Q;i++){
            int L=queries[i][0];
            int R=queries[i][1];
            int count =0;
            for(int j=L;j<=R;j++){
                if(newArr [j] %2 !=0){
                    count++;
                }
            }
            Odd[i]=count;
           }

            return Odd;
        }
        public static int[] CountOddOptimal(int[]newArr) {
            int Q=newArr.length;
            int []pf=new int[Q];
            if(newArr[0]%2 !=0){
                pf[0]=1;
               }else{
                pf[0]=0;
               }
            for(int i=1;i<Q;i++){
             if(newArr[i]%2 !=0){
                pf[i]=pf[i-1]+1;
             }
              else{
                pf[i]=pf[i-1];
              }  

            }
            return pf;
        }
        public static int[] CountOddwithQueries(int []newArr,int[][]queries) {
            int Q=queries.length;
            int []pfOdd=CountOddOptimal(newArr);
            int []countOdd=new int[Q];
            for(int i=0;i<Q;i++){
                int L=queries[i][0];
                int R= queries[i][1];
            if(L==0){
                countOdd[i]=pfOdd[R];
            }else{
                countOdd[i]=pfOdd[R]-pfOdd[L-1];
            }
            }
            return countOdd;
        }


        public static int countAGpair(char[]charArray) {
            int count=0;
            for(int i=0;i<charArray.length-1;i++){
                for(int j=i+1;j<charArray.length;j++){
                    if(charArray[i]=='a' && charArray[j]=='g'){
                        count++;
                    }
                }
            }
            return count;
        }
        public static int[] suffixG(char[]charArray) {
            int N=charArray.length;
            int []gCount=new int[N];
            if(charArray[N-1]=='g'){
                gCount[N-1]=1;
            }else{
                gCount[N-1]=0;
            }
            for(int i=N-2;i>=0;i--){
                if(charArray[i]=='g'){
                    gCount[i]=gCount[i+1]+1;
                }
                else{
                    gCount[i]=gCount[i+1];
                }
            }
            return gCount;
        }
        public static int OptimalAGpair(char[]charArray) {
            int count=0;
            int N=charArray.length;
         int[] gCount=suffixG(charArray);
         for(int i=0;i<=N-2;i++){
            if(charArray[i] =='a'){
               count= count+gCount[i+1];
            }
         }
            return count;
            
        }
        public static int Optimal3rdApproach(char[]charArray) {
            int count=0;
            int sfCount=0;
            int N= charArray.length;
            for(int i=N-1;i>=0;i--){
                if(charArray[i]=='g'){
                    sfCount=sfCount+1;
                }
                if(charArray[i]=='a'){
                    count=count+sfCount;
                }
            }
            return count;
        }
    
       public static int LeaderCount(int[]newArr) {
        int count =1;
        int N= newArr.length;
        for(int i=0;i<N-1;i++){
            int max=Integer.MIN_VALUE;
           for(int j=i+1;j<N;j++){
              max=Math.max(newArr[j], max);

           }
           if(max<newArr[i]){
            count++;
        }
        }
        return count;
       }
        public static int[] SuffixMax(int[]newArr) {
            int N= newArr.length;
            int []sfxMax=new int[N];
            sfxMax[N-1]=newArr[N-1];
            for(int i=N-2;i>=0;i--){
                sfxMax[i]=Math.max(sfxMax[i+1], newArr[i]);
            }
            return sfxMax;
        }
        public static int countLeaders(int []newArr) {
            int count=1;
            int N=newArr.length;
            int []sfxMax=SuffixMax(newArr);
            sfxMax[N-1]=newArr[N-1];
            for(int i= N-2;i>=0;i--){
                if(sfxMax[i]>sfxMax[i+1]){
                    count++;
                }
            }
            return count;
        }
        public static int OptimalCountLeaders(int[]newArr) {
            int count=1;
            int N =newArr.length;
            int sfxmax= newArr[N-1];
            for(int i=N-2;i>=0;i--){
                if(newArr[i]>sfxmax){
                  count++;
                  newArr[i]=sfxmax;
                }
                
            }

            return count;
        }
 
        public int solve(String A) {
            int count=0;
            int N =A.length();
            for(int i=0;i<N;i++){
                for(int j=i+1;j<N;j++){
                    if(A.charAt(i)=='A' && A.charAt(j)=='G'){
                       count++;
                    }
                }
            }
            return count;
        }    
      
        public static int Max(int[]A){
            int N=A.length;
              int max=Integer.MIN_VALUE;;
              for(int i=0;i<N;i++){
                  if(A[i]>max){
                      max=A[i];
                  }
              }
              return max;
            }
         public  static int SecondMax(int[] A) {
                int N=A.length;
                 int max=Max(A);
                 int secMax=Integer.MIN_VALUE;;
                 for(int i=0;i<N;i++){
                     if(max>A[i] && secMax!=max && secMax<A[i] ){
                   
                        secMax=A[i];
                     }
                    }
                    return secMax;
                 }
                 

                 
           public static int SubArrayProb1(int A[],int min,int max) {
          
            int minIndex=-1;
            int maxIndex=-1;
            int length=Integer.MAX_VALUE;
            for(int i=0;i<A.length;i++){
                if(A[i]==min){
                    minIndex=i;
                }
                if(A[i]==max){
                    maxIndex=i;
                }
               if(minIndex>-1 && maxIndex>-1){
                length= Math.min(length,(Math.abs((maxIndex-minIndex)+1)));
               }
               
            }
            return length;
           }       
             
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        
        int []newArr={15,1,7,2,5,4,2,3};
        //second most element in array.
        // int []A={12,6,8,17,18,17,18,4,18};
        // System.out.println(Max(A));
        // System.out.println(SecondMax(A));
       

        //Reversed Array withooy same array
       // int []reversedArray=reversedArray(newArr);
    //    int []reverseArr=reverseArray(newArr);
    //  for(int i=0;i<reverseArr.length;i++){
    //     System.out.println(reverseArr[i]);
    // }

        //Problem1
    //     int N =obj.nextInt();
    //     int []arr=new int [N];
    //     for(int i=0;i<N;i++){
    //         arr[i]=obj.nextInt();
    //     }

    //  int pf[]=(prefixSumOptimal(arr));
    //  for(int i=0;i<pf.length;i++){
    //     System.out.println(pf[i]);
    //  }

    //Problem 2
      // multipleQueries(newArr, queries);
      // optimalQueriesSum(newArr, queries);

      //Problem 3
     // System.out.println(EquilibiriumIndex(newArr));

     //Problem4
    // int []Odd=(CountOdd(newArr, queries));
    // for(int i=0;i<Odd.length;i++){
    //     System.out.println(Odd[i]);
    // }

    // int []OddOptimal=(CountOddOptimal(newArr));
    // for(int i=0;i<OddOptimal.length;i++){
    //     System.out.println(OddOptimal[i]);
    // }

    // int []OddOptimalWithQueries=(CountOddwithQueries(newArr,queries));
    // for(int i=0;i<OddOptimalWithQueries.length;i++){
    //     System.out.println(OddOptimalWithQueries[i]);
    // }

    //problem 1 carry forward
    char []charArray= {'a','s','g','a','g','h','e','f','g'};
    // System.out.println(countAGpair(charArray));
    // System.out.println(OptimalAGpair(charArray));
    // System.out.println(Optimal3rdApproach(charArray));

    //problem 2 carry forward
    //   int [ ]suffixMax=SuffixMax(newArr);
    //   for(int i=0;i<suffixMax.length;i++){
    //     System.out.println(suffixMax[i]);
    //   }
    // System.out.println(countLeaders(newArr));
    //  System.out.println(OptimalCountLeaders(newArr));
   // System.out.println(LeaderCount(newArr));

    //problem 3
//      System.out.println(SubArrayProb1(newArr));

    }
    
}
