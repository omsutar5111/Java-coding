package Data_Structure_Algorithms.sorting;

import java.util.Arrays;

public class sorting {

  public static int[] insertionSort(int arr[]) {
    int N = arr.length;
    for (int i = 1; i < N; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        } else {
          break;
        }
      }
    }
    return arr;
  }

  public static int[] merge(int A[], int B[]) {
    int N = A.length;
    int M = B.length;
    int C[] = new int[(N + M)];
    int p1 = 0, p2 = 0, p3 = 0;
    while (p1 < N && p2 < M) {
      if (A[p1] < B[p2]) {
        C[p3] = A[p1];
        p1++;
        p3++;
      } else {
        C[p3] = B[p2];
        p2++;
        p3++;
      }
    }
    while (p1 < N) {
      C[p3] = A[p1];
      p1++;
      p3++;
    }
    while (p2 < M) {
      C[p3] = B[p2];
      p2++;
      p3++;
    }
    return C;
  }

  public static int[] merge2(int A[], int s, int m, int e) {
    int p1=s,p2=m+1,p3=0;
        int[] temp=new int[e-s+1];
        while(p1<=m && p2<=e){
            if(A[p1]<=A[p2]){
                temp[p3]=A[p1];
                p1++;
                p3++;
            }else{
                temp[p3]=A[p2];
                p2++;
                p3++;
            }
        }
        //copy remaining elements from p1
        while(p1<=m){
            temp[p3]=A[p1];
            p1++;
            p3++;
        }
        //copy remaining elements from p2
        while(p2<=e){
            temp[p3]=A[p2];
            p2++;
            p3++;
        }
        //merge the array
        for(int i=s;i<=e;i++){
            A[i]=temp[i-s];
        }
        return A;
  }

  public static void mergeSort(int A[], int s, int e) {
    if (s == e) {
      return;
    }
    int mid = (s + e) / 2;
    mergeSort(A, s, mid);
    mergeSort(A, mid + 1, e);
    merge2(A, s, mid, e);
  }

  public static int[] swap(int[] arr, int i, int j) {
    int[] B = new int[arr.length];
    int temp = arr[i];
    arr[i] = B[j];
    B[j] = temp;
    return B;
  }

  public static int[] sortArray(int arr[]) {
    Arrays.sort(arr);
    return arr;
  }

  public static int[] reverseSorting(int arr[]) {
    Arrays.sort(arr);
    int N = arr.length;
    int arr2[] = new int[N];
    for (int i = 0; i < N; i++) {
      arr2[N - 1 - i] = arr[i];
    }
    return arr2;

  }

  public static int problem1(int arr[]) {
    int sum = 0;
    int arr2[] = reverseSorting(arr);
    int N = arr2.length;
    for (int i = 0; i < N; i++) {
      sum = sum + (i + 1) * arr2[i];
    }
    return sum;

  }

  public static int problem2(int arr[]) {
    int count = 0;
    Arrays.sort(arr);
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == i) {
        count++;
      }
    }
    return count;

  }

  public static int problem3(int arr[]) {
    int count = 0;
    Arrays.sort(arr);
    if (arr[0] == 0) {
      count++;
    }
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == i && arr[i] != arr[i - 1]) {
        count++;
      }
    }
    return count;

  }

  public static String largestNumber(int[] A) {
    int B[] = reverseSorting(A);
    String str = "";
    for (int i = 0; i < B.length; i++) {
      str = str + String.valueOf(i);
    }
    return str;
  }

  public static int[] bubbleSort(int arr[]) {
    // int[] B=new int[arr.length];
    int N = arr.length;
    for (int i = 0; i < N - 1; i++) {
      for (int j = 0; j < N - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }

    return arr;
  }

  public static void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]+" ");
    }
  }

  public static void main(String[] args) {
    int arr[] = { -1, 1, 3, 5, 7, 8, 2, 6, 4, 4, 8, 6, 7 };
    int A[] = { 1, 4, 6, 7, 9 };
    int B[] = { 5, 8, 10 };
    // Integer arr2[]={1,2,3,4,5,6};
    // Arrays.sort(arr2,new Comparator<Integer>() {

    // @Override
    // public int compare(Integer o1, Integer o2) {
    // // TODO Auto-generated method stub
    // return o2-o1;
    // }

    // });
    // for(int i=0;i<arr2.length;i++){
    // System.out.println(arr2[i]);
    // }

    // int []insertionSort=insertionSort(arr);
    // for(int i=0;i<insertionSort.length;i++){
    // System.out.println(insertionSort[i]);
    // }

    // int merge[]=merge(A, B);
    // for(int i=0;i<merge.length;i++){
    // System.out.println(merge[i]);
    // }

    // int merge2[] = merge2(arr, 0, 1, 12);
    // for (int i = 0; i < merge2.length; i++) {
    // System.out.print(merge2[i]+" ");
    // }

    //  printArray(arr);
    //  mergeSort(arr, 0, arr.length - 1);
    //  System.out.println("sorted array");
    //  printArray(arr);

    // Integer arr2[]={1,7,8,3,5,2,6,4,9};
    // Arrays.sort(arr);
    // Arrays.sort(arr2,Collections.reverseOrder());
    // int arr3[]=reverseSorting(arr);
    // for(int i=0;i<arr3.length;i++){
    // System.out.println(arr3[i]);
    // }

    // Homework problem
    // System.out.println(largestNumber(arr));

    // int[] B=bubbleSort(arr);
    // for(int i=0;i<arr.length;i++){
    // System.out.println(arr[i]);
    // }

    // String animal="omkar";
    // animal.charAt(0);
    // char[]arr7=animal.toCharArray();
    // int i=34;

    // animal.length();

    // Problem 1 find min cost=sum of array by removing one element till array
    // become zero
    // int cost=problem1(arr);

    // problem 2 Nobel numbers:Nobel numbers are which is exactly same as no of less
    // elements than that number
    // System.out.println(problem2(arr));

    // problem 3 Nobel number count when array contain duplicate values
    // System.out.println(problem3(arr));

  }
}
