package Data_Structure_Algorithms.Bit_Manipulation;

public class bits_1 {
   
    public static int basePower (int A,int B) {
      int ans =0;
      int remainder=0;
      int powerAnswer=0;
      int power=0;
      while(A>0){
       remainder=A%10;
      powerAnswer=remainder*(int)(Math.pow(B,power ));
      power++;
      ans+=powerAnswer;
      A=A/10;
      }
      return ans;
    }

    public static int DecimalToBase(int A,int B) {
      int p=0;
      int ans=0;
      while(A>0)
      {
        int remainder=A%B;
          ans=ans+remainder*(int)Math.pow(10,p);
          p++;
          A=A/B;
      }
      return ans;    
      
    }


    public static boolean oddEven(int A) {
      if((A|1)>A){
        //(A&1)==0
        return true; 
      }
      return false;
    }
    public static int findUnique(int A[]) {
        int ans=0; 
        for(int i=0;i<A.length;i++){
            ans=ans^A[i];
        }
        return ans;
        
    }

    public static Boolean checkSetorUnset(int N,int K) {
      int ans = N &(1<<K);
      if(ans==0){
        return false;
      }
      return true;
      
    }

    public static int ToggleKbit(int N,int K) {
      int ans= N^(1<<K);
      return ans;
      
    }
    public static int UnsetBit(int N,int K) {
      if(checkSetorUnset(N, K)){
        N=N^(1<<K);
      }
      return N;
    }

    public static int countsetBits(int N) {
      int count=0;
      for(int i=0;i<32;i++){
        if(checkSetorUnset(N, i)){
        count++;
      }
      }
      return count;
    }

    public static int countsetBits2(int N) {
      int count=0;
     while(N > 0){
      int ans=N&1;
      if( ans==1){
        count++;
      }
      N=N>>1;
     }
      return count;
    }
    public static void main(String[] args) {
        //System.out.println(oddEven(23));
        int[] A={1,2,3,4,3,2,1};
      //  System.out.println(findUnique(A));

    // System.out.println(basePower(22, 3));
    // System.out.println(DecimalToBase(4, 3));
    // System.out.println(checkSetorUnset(20, 3));
    // System.out.println(ToggleKbit(45, 1  ));
    // System.out.println(UnsetBit(45, 4));
     // System.out.println(countsetBits(11));
     //System.out.println(countsetBits2(11));
    }


}
