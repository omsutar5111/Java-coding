package DSA.Advanced_Dsa;

import java.util.HashMap;
import java.util.*;
public class test {

  
public static int pow(int A,int B,int C){
    int ans=1;
    for(int i=0;i<B;i++){
        ans=(ans%100000007)*(A%10000007);
    }
    return (ans%100000007)%C;
}

   
    public static void main(String[] args) {
        
    int A=2;
    int B=4;
    int C=3;
    System.out.println(pow(A, B, C));

  
    }
}
