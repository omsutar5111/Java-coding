package Data_Structure_Algorithms.Recursion;

public class recursion_1 {


    public static int fact(int N) {
        if (N == 1) {
            return 1;
        }
        int temp = fact(N - 1);
        return N * temp;
    }

    public static int fib(int N) {
        if (N == 0 || N == 1) {
            return N;
        } else if (N == 2) {
            return 1;
        }
        int temp1 = fib(N - 1);
        int temp2 = fib(N - 2);
        return temp1 + temp2;

    }

    public static void LinearSeries(int A) {
        if (A == 1) {
            System.out.print(1 + " ");
            return;
        }
        LinearSeries(A - 1);
        System.out.print(A + " ");

    }

    public static void DecendingOrder(int A) {
        if (A == 0) {
            return;
        }
        System.out.println(A + " ");
        DecendingOrder(A - 1);

    }

    public static int isPalindrome(String str, int S, int E) {
        if (S == E || S > E) {
            return 1;
        }
        if (str.charAt(S) == str.charAt(E)) {
            return isPalindrome(str, S + 1, E - 1);
        } else {
            return 0;
        }

    }

    public static void PalindromeMain(String str) {
        System.out.println(isPalindrome(str, 0, str.length() - 1));

    }

    public static void printNumbers(int N) {
        if (N == 0) {
            return;
        }
        printNumbers(N - 1);
        System.out.println(N);
    }
 
    static int ans=1;;
    public static int powerMod(int A,int B){
       if(B==0){
        return ans;
       }
       ans=ans*A;
       powerMod(A, B-1);
       return ans;
    }
    public static void main(String[] args) {
        // System.out.println(fact(2));
        // System.out.println(fib(3));
        // LinearSeries(4);
        // DecendingOrder(4);
        // PalindromeMain("asdsa");
        // String str="sachin";
        // System.out.println(str.substring(0,str.length()-1));
        // System.out.println(str.charAt(0));
        //printNumbers(5);
        System.out.println(powerMod(2, 4));
    }
}
