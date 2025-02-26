package Data_Structure_Algorithms.Patterns;

import java.util.Scanner;

public class pattern_1 {
       public static void main(String[] args) {
        // int i, j, row=5;   
        // //outer loop for rows  
        // for(i=5; i>row; i++)   
        // {   
        // //inner loop for columns  
        // for(j=0; j<=i; j++)   
        // {   
        // //prints stars   
        // System.out.print("* ");   
        // }   
        // //throws the cursor in a new line after printing each line  
        // System.out.println();   
        // }   
    //     Scanner obj = new Scanner(System.in);
    //     float A = obj.nextFloat();
	
		
	  // if(A >98.9){
		//   System.out.println("person has fever");
	  // } else if( A <= 98.2){
		// System.out.println("person has normal temperature");
	  // }
	  // else {
		//   System.out.println("person has low temperature");
	  // }
    Scanner obj =new Scanner(System.in);
         int N = obj.nextInt();
        //stair pattern

      //  for(int i=1;i<=N;i++){
      //   for(int j=1;j<=i;j++){
      //     System.out.print("*");
      //   }
      //   System.out.println();
      //  }

       //space -odd pattern
      // for(int i=1;i<=N;i++){
      //   for(int j=1;j<=i;j++){
      //     if(j%2!=0){
      //       System.out.print(j);
      //     }
      //     else{
      //       System.out.print(" ");
      //     }
      //   }
      //   System.out.println();
      // }

      //hcf program
      // int A=obj.nextInt();
      // int B=obj.nextInt();
      // int C=Math.min(A, B);
      // int hcf=1;
      // for(int i=1;i<=C;i++){
      //   if(A%i==0 && B%i==0){
      //    hcf=i;
      //   }
      // }
      // System.out.println(hcf);

      //Prime Numbers
    //   for (int i = 1; i <= N; i++) {
    //     int count = 0;
    //     for (int j = 1; j <=i; j++) {
    //         if (i % j == 0) {
    //             count++;
    //             if(count>2){
    //                 break;
    //             }
    //         }
    //     }
    //     if (count == 2) {
    //         System.out.println(i);
    //     }
    // }
      
      //Leading spaces inverted pyramid
      // for(int i=0;i<N;i++){
      //   for(int j=1;j<=i;j++){
      //     System.out.print(" ");
      //   }
      //   for(int j=i;j<N;j++){
      //     System.out.print("*");
      //   }
      //   System.out.println();
      // }
          

      //two line star pattern
      // for(int i=1;i<=N;i++){
      //   for(int j=1;j<=N;j++){
      //     if(j==1 || j==N){
      //       System.out.print("*");
      //     }else{
      //       System.out.print(" ");
      //     }
      //   }
      //   System.out.println();
      // }

      // pattern homework 1
      // for(int i=1;i<=N;i++){
      //     System.out.print("*");
      //   for(int j=1;j<=N-i;j++){
      //     System.out.print(" ");
      //   }
      //   System.out.print("*");
      //   System.out.println();
      // }

     //pattern homework2
    //  for(int i=1;i<=N;i++){
    //   for(int j=1;j<=N-i;j++){
    //     System.out.print(" ");
    //   }
    //   for(int j=1;j<=i;j++){
    //     System.out.print("*");
    //   }
    //   System.out.println();
    //  }

      //pattern homework3
    //  for(int i=0;i<N;i++){
    //   for(int j=1;j<=N-i;j++){
    //     System.out.print("*");
    //   }
    //   for(int j=1;j<=i*2;j++){
    //     System.out.print("_");
    //   }
    //   for(int j=1;j<=N-i;j++){
    //     System.out.print("*");
    //   }
    //   System.out.println();
    //  }

         //pattern homework4
//     for(int i=1;i<=N;i++){
//      for(int j=1;j<=i;j++){
//        System.out.print("*");
//      }
//      for(int j=1;j<=N-i;j++){
//        System.out.print("_");
//      }
//      for(int j=1;j<=N-i;j++){
//        System.out.print("_");
//      }
//      for(int j=1;j<=i;j++){
//        System.out.print("*");
//      }
//      System.out.println();
//     }

     //pattern Homework-8
           for(int i=0;i<N;i++){
               for(int j=1;j<=i;j++){
                   System.out.print(" ");
               }
               for(int j=i;j<N;j++){
                   System.out.print("*");
               }
               System.out.println();
           }
      
    








    }
   }
    
