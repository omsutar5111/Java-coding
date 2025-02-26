package Data_Structure_Algorithms.Advanced_Dsa;

public class PrefixSum_SubArray {

    public static int[] prefixSum(int[] A) {
        int[] prefixSum = new int[A.length];
        int N = prefixSum.length;
        prefixSum[0] = A[0];
        for (int i = 1; i < N; i++) {
            prefixSum[i] = A[i] + A[i - 1];
        }
        return prefixSum;
    }

    public static void prefixSumWithMultipleQueries(int[] A, int[][] Q) {
        int N = Q.length;
        int[] pref = prefixSum(A);
        for (int i = 0; i < N; i++) {
            int L = Q[i][0];
            int R = Q[i][1];
            if (L == 0) {
                System.out.println(pref[R]);
            } else {
                System.out.println(pref[R] - pref[L - 1]);
            }
        }
    }

    public static int[] Problrm1BruteForce(int A[], int[][] Q) {
        int N = Q.length;
        for (int i = 0; i < N; i++) {
            int index = Q[i][0];
            int value = Q[i][1];
            for (int j = index; j < A.length; j++) {
                A[j] = A[j] + value;
            }
        }
        return A;
    }

    public static int[] problem1Optimized(int A[], int[][] Q) {
        for (int i = 0; i < Q.length; i++) {
            int index = Q[i][0];
            int value = Q[i][1];
            A[index] = value;
        }
        for (int i = 1; i < A.length; i++) {
            A[i] = A[i] + A[i - 1];
        }
        return A;
    }

    public static int[] problem1ForNonzeroArray(int A[], int[][] Q) {
        int arr[] = new int[A.length];
        for (int i = 0; i < Q.length; i++) {
            int index = Q[i][0];
            int value = Q[i][1];
            arr[index] = value;
        }
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] + arr[i];
        }
        return A;
    }

    public static int[] GoogleProblem(int[] A, int[][] Q) {
        for (int i = 0; i < Q.length; i++) {
            int s = Q[i][0];
            int e = Q[i][1];
            int value = Q[i][2];
            A[s] += value;
            if (e + 1 < A.length) {
                A[e + 1] -= value;
            }
        }
        for (int i = 1; i < A.length; i++) {
            A[i] = A[i] + A[i - 1];
        }
        return A;
    }

    public static int[] googleForNonZero(int A[], int B[][]) {
        int arr[] = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            int s = B[i][0] - 1;
            int e = B[i][1] - 1;
            int value = B[i][2];
            arr[s] += value;
            if (e + 1 < arr.length) {
                arr[e + 1] -= value;
            }
        }
        for (int j = 1; j < arr.length; j++) {
            arr[j] = arr[j - 1] + arr[j];
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] + arr[i];
        }
        return A;
    }

    public static int[] suffixMax(int[] A) {
        int sfx[] = new int[A.length];
        int N = sfx.length;
        sfx[N - 1] = A[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            sfx[i] = Math.max(A[i], sfx[i + 1]);
        }
        return sfx;
    }

    public static int[] PrefixMax(int[] A) {
        int Pfx[] = new int[A.length];
        Pfx[0] = A[0];
        for (int i = 1; i < Pfx.length; i++) {
            Pfx[i] = Math.max(A[i], Pfx[i - 1]);
        }
        return Pfx;

    }

    public static int RainWater(int[] A) {
        int ans = 0;
        int[] pf = PrefixMax(A);
        int sf[] = suffixMax(A);
        for (int i = 1; i < A.length - 2; i++) {
            int water = Math.min(pf[i - 1], sf[i + 1]) - A[i];
            if (water > 0) {
                ans += water;
            }
        }
        return ans;

    }

    public static int Kadane(int A[]) {
        int pref[] = prefixSum(A);
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            ans = Math.max(ans, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // int [][]Q={{2,4},{3,-1},{0,2},{4,1}};
        // int []A={0,0,0,0,0,0};
        // int B[]=problem1Optimized(A, Q);
        // for(int i=0;i<B.length;i++){
        // System.out.println(B[i]);
        // }

        // int[][]Q={{2,4},{1,2}};
        // int []A={1,2,3,4,5};
        // int C[]=problem1ForNonzeroArray(A, Q);
        // for(int i=0;i<C.length;i++){
        // System.out.println(C[i]);
        // }

        // int A[]= {0,0,0,0,0,0,0,0,0,0};
        // // System.out.println(A.length);
        // int Q[][]={{3,6,1},{2,7,3},{5,8,-3},{1,9,2}};
        // int D[]=GoogleProblem(A, Q);
        // for(int i=0;i<D.length;i++){
        // System.out.println(D[i]);
        // }

        // int []A={1,2,6,8,9,0,5};
        // int sfx[]=PrefixMax(A);
        // for(int i=0;i<sfx.length;i++){
        // System.out.println(sfx[i]);
        // }

        // int A[]={2,1,3,2,1,2,4,3,2,1,3,1};
        // System.out.println(RainWater(A));

        int[] A = { -2,1,-3,4,-1,2,1,-5,4};
       System.out.println(Kadane(A));

//        int k=1,p=3;
//        k=p+k;
//        p=k-p;
//        k=k-p;
//        System.out.println("k="+k +"p="+p);
    }
}
