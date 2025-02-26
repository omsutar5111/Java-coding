package Data_Structure_Algorithms.Two_Pointers;

public class twoPointer_1 {
    public static int pairSum(int[] A, int B) {
        int mod = 1000 * 1000 * 1000 + 7;
        int count = 0;
        int p1 = 0, p2 = A.length - 1;
        while (p1 < p2) {
            int sum = A[p1] + A[p2];
            if (sum == B) {
                count = (count + 1) % mod;
                p1++;
            } else if (sum > B) {
                p2--;
            } else {
                p1++;
            }
        }
        return count % mod;
    }

    public static void main(String[] args) {
        int A[] = { 2, 3, 3, 5, 7, 7, 8, 9, 9, 10, 10 };
        System.out.println(pairSum(A, 11));
    }
}
