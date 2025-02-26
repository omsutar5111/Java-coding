package Data_Structure_Algorithms.Arrays;

import java.util.Scanner;

public class TwodArray {

    public static void displayMat(int mat[][]) {
        int r = mat.length;
        int c = mat[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int A) {
        int ans[][] = new int[A][A];
        int start = 1;
        int i = 0;
        int j = 0;
        // int row=A.length;
        // int col=A[0].length;
        int iteration = ans.length - 1;
        while (iteration >= 0) {
            if (iteration == 0) {
                ans[i][j] = start;
                break;
            }
            for (int K = 0; K < iteration; K++) {
                ans[i][j] = start;
                start++;
                j++;
            }
            for (int k = 0; k < iteration; k++) {
                ans[i][j] = start;
                start++;
                i++;
            }
            for (int k = 0; k < iteration; k++) {
                ans[i][j] = start;
                start++;
                j--;
            }
            for (int k = 0; k < iteration; k++) {
                ans[i][j] = start;
                start++;
                i--;
            }
            i++;
            j++;
            iteration = iteration - 2;
        }
        return ans;

    }

    public static int[][] ElementZero(int[][] A) {
        int N = A.length;
        int M = A[0].length;

        for (int i = 0; i < N; i++) {
            int temp = 1;
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 0) {
                    temp = 0;
                }
            }
            if (temp == 0) {
                for (int k = 0; k < M; k++) {
                    if (A[i][k] != 0) {
                        A[i][k] = -1;
                    }
                }
            }

        }

        for (int i = 0; i < M; i++) {
            int temp = 1;
            for (int j = 0; j < N; j++) {
                if (A[j][i] == 0) {
                    temp = 0;
                }
            }
            if (temp == 0) {
                for (int k = 0; k < N; k++) {
                    if (A[k][i] != 0) {
                        A[k][i] = -1;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == -1) {
                    A[i][j] = 0;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int row = obj.nextInt();
        int col = obj.nextInt();
        int mat[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = obj.nextInt();
            }
        }

        int[][] ans = ElementZero(mat);
        displayMat(ans);

    }
}
