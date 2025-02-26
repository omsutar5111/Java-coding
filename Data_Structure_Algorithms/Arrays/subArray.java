package Data_Structure_Algorithms.Arrays;

public class subArray {


    public static void PrintAllSubaarays(int A[]) {
        for(int i=0;i<A.length;i++){
            for(int j=i;j<A.length;j++){
               for(int k=i;k<=j;k++){
                System.out.print(A[k]+" ");
               } 
               System.out.println("");
            }
            System.out.println("");
        }
    }

  public static void sumOfallSubarrays(int []A) {

int pf[]=new int[A.length];
pf[0]=A[0];
for(int i=1;i<A.length;i++){
    pf[i]=pf[i-1]+A[i];
}
for(int s=0;s<pf.length;s++){
    for(int e=s;e<pf.length;e++){
        if(s==0){
            System.out.println(pf[e]);
        }
        else{
            System.out.println(pf[e]-pf[s-1]);
        }
    }
    System.out.println("");
}  
  }

  public static void PrintAllSubaaraysSum2(int A[]) {
    int N=A.length;
   // int count=0;
    for(int s=0;s<N;s++){
        int sum=0;
    
        for(int e=s;e<N;e++){
           sum+=A[e];
          System.out.println(sum);
          //  if(sum<0){
          //   count++;
          //  }
        }
       
    System.out.println(" ");
    } 
  //  System.out.println(count);
  }

  public static void PrintAllSubaaraysSumOptimized(int A[]) {
    int N= A.length;
    int sum=0;
    for(int i=0;i<N;i++){
        sum+=(A[i]*(i+1)*(N-i));
    }
    System.out.println(sum);
  }

     
    public static void main(String[] args) {
        int A[]={1,-2,4,-5,1};
        //PrintAllSubaarays(A);
       //sumOfallSubarrays(A);
      // PrintAllSubaaraysSum2(A);
     // PrintAllSubaaraysSumOptimized(A);
     
     
    }
}
