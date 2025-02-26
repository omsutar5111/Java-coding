package Data_Structure_Algorithms.ScalerContest;

public class contest_1 {

  public static int[] maxPositiveSubarray(int[] A) {
    int start = 0;
    int end = 0;
    int n = A.length;
    int i = 0;
    int Maxsize = 0;
    int left = -1;
    int right = -1;
    int currSize = 0;
    while (i < n) {
      if (A[i] >= 0) {
        start = i;
        end = i;
        while (end < n && A[end] >= 0) {
          end++;
        }
        currSize = end - start;
        if (currSize > Maxsize) {
          Maxsize = currSize;
          left = start;
          right = end - 1;
        }
        i = end + 1;
      } else {
        i++;
      }
    }
    int arr[] = new int[Maxsize];
    for (int j = 0; j < Maxsize; j++) {
      arr[j] = A[left];
      left++;
    }
    return arr;
  }

  public static void swapFunc(int arr[], int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  public static int colorCode(int[] B) {
    int ans = 0;
    for (int i = 0; i < B.length; i++) {
      if (B[i] == i + 1) {
        ans++;
      }
    }
    for (int i = 0; i < B.length; i++) {

      if (B[i] != i + 1) {
        ans++;
        while (B[i] != i + 1) {
          // int correct = B[i] - 1;
          swapFunc(B, i, B[i] - 1);
        }

      }

    }
    return ans;
  }

  public static int findMinOperations(int A[], int B) {
    int count = 0;
    boolean flag = false;
    for (int i = 0; i < A.length; i++) {
      if (A[i] == B) {
        flag = true;
      }
    }
    if (flag == false) {
      return -1;
    }
    for (int i = 0; i < A.length; i++) {
      if (A[i] > B) {
        count++;
      }
    }
    return count;
  }

  // public static int maxProductofThree(int A[]) {
  // int product=1;
  // for(int i=0;i<A.length;i++){
  // int
  // }
  // return product;
  // }
  public static int minSwaps(int[] A, int C) {
    int count = 0;
    for (int i = 0; i < A.length; i++) {
      if (A[i] < C) {
        count++;
      }
    }
    int swap = 0;
    for (int i = 0; i < count; i++) {
      if (A[i] < C) {
        swap++;
      }
    }
    int ans = count - swap;
    int s = 1;
    int e = count;
    while (e < A.length) {
      if (A[s - 1] < C) {
        swap = swap - 1;
      }
      if (A[e] <= C) {
        swap = swap + 1;
      }
      ans = Math.min(ans, swap);
      s++;
      e++;
    }
    return ans;

  }

  public static void main(String[] args) {
    // problem 1

    // int[] A={1,6,2,3,7};
    // System.out.println(findMinOperations(A, 3));

    // problem 2

    // ArrayList<Integer>list=new ArrayList<>();
    // list.add(34);

    // int A[]={5,6,-1,7,8,9};
    // int B[]=maxPositiveSubarray(A);
    // for(int i=0;i<B.length;i++){
    // System.out.println(B[i]);
    // }

    int A[] = { 1, 6, 8, 9, 4, 3, 2, 9 };
    System.out.println(minSwaps(A, 5));
    int color[] = { 1, 2, 3, 4, 5 };
    // System.out.println(colorCode(color));
  }
}
