package DSA.Advanced_Dsa;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BinarySearch {

    public static int Problem2(int A[], int K) {
        // find floor of integer K >=Ans
        int ans = 0;
        if (A.length == 1) {
            return 1;
        }
        int l = A[0];
        int r = A.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] == K) {
                return mid;
            } else if (A[mid] < K) {
                ans = Math.max(ans, mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;

    }

    public static int Problem1(int A[], int K) {
        int ans = 0;
        int l = A[0];
        int r = A.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] == K) {
                return mid;
            } else if (A[mid] > K) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
            ans = mid;
        }
        return ans;
    }

    public static int problem3(int A[], int K) {
        // first occurance of K
        int ans = -1;
        int l = A[0];
        int r = A.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] == K) {
                ans = mid;
                r = mid - 1;
            } else if (A[mid] > K) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;

    }

    public static int FindUnique(int A[]) {
        int start = 0;
        int end = A.length - 1;
        int N = A.length;
        if (A.length == 1) {
            return A[0];
        }
        if (A[0] != A[1]) {
            return A[0];
        }
        if (A[N - 1] != A[N - 2]) {
            return A[N - 1];
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] != A[mid - 1] && A[mid] != A[mid + 1]) {
                return A[mid];
            }
            if (A[mid] == A[mid - 1]) {
                mid = mid - 1;
            }
            if (mid % 2 == 0) {
                start = mid + 2;
            } else {
                end = mid - 1;
            }
        }
        return -1;

    }

    public static int squrtOfNumber(int N) {
        int start = 1;
        int end = N;
        int ans = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            long square = mid * mid;
            if (square == N) {
                return mid;
            }
            if (square < N) {
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }
        }
        return ans;

    }

    public static int HomworkCeilingNumber(int A, int B[], int C) {
        int l = 0;
        int r = A - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (B[mid] == C) {
                return C;
            } else if (B[mid] > C) {
                r = mid - 1;
                ans = B[mid];
            } else {
                l = mid + 1;
            }
        }
        return ans;

    }

    public static int LocalMinima(int A[]) {
        int ans = -1;
        if (A[0] < A[1]) {
            return 0;
        } else if (A[A.length - 1] < A[A.length - 2]) {
            return A.length - 1;
        }
        int l = 1;
        int r = A.length - 2;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] < A[mid - 1] && A[mid] < A[mid + 1]) {
                return mid;
            } else if (A[mid] < A[mid + 1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    public static int[] searchRange(int[] A, int B) {
        // find first and last occurance of given integer
        int arr[] = { -1, -1 };
        int si = arr[0];
        int ei = arr[1];
        if (A.length == 1) {
            si = 0;
            ei = si;
        }
        int l = 0;
        int r = A.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] == B) {
                si = mid;
                r = mid - 1;
            } else if (A[mid] < B) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (si != -1) {
            ei = si;
            l = si + 1;
            r = A.length - 1;

            while (l <= r) {
                int mid = (l + r) / 2;
                if (A[mid] == B) {
                    ei = mid;
                    l = mid + 1;
                } else if (A[mid] < B) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        arr[0] = si;
        arr[1] = ei;
        return arr;
    }

    public static int BitonicArray(int[] A, int B) {
        int l = 1;
        int r = A.length - 2;
        int bitonic = -1;
        int bitonicIndex = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                bitonic = A[mid];
                bitonicIndex = mid;
                r = mid - 1;
            } else if (A[mid] < A[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        l = 0;
        r = bitonicIndex;
        int index = -1;
        if (B > bitonic) {
            return -1;
        }
        while (l <= r) {
            int m = (l + r) / 2;
            if (A[m] == B) {
                return m;
            } else if (A[m] < B) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        l = bitonicIndex + 1;
        r = A.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (A[m] == B) {
                return m;
            } else if (A[m] > B) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return index;

    }

    public static int Pivot(final int[] A, int B) {
        int l = 0, r = A.length - 1;
        int pivot = 0;
        int pivotIndex = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] < A[0]) {
                pivot = A[mid];
                pivotIndex = mid;
                r = mid - 1;
            } else if (A[mid] >= A[0]) {
                l = mid + 1;
            }
        }
        if (pivotIndex == -1) {
            return 0;
        }
        l = 0;
        r = pivotIndex - 1;
        int index = -1;
        if (B > A[pivotIndex - 1]) {
            return -1;
        }
        while (l <= r) {
            int m = (l + r) / 2;
            if (A[m] == B) {
                return m;
            } else if (A[m] < B) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        l = pivotIndex;
        r = A.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (A[m] == B) {
                return m;
            } else if (A[m] > B) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return index;
    }

    public static int painterPartian(int A, int B, int[] C) {
        int l = 0, r = 0;
        long ans = 0;
        for (int i = 0; i < C.length; i++) {
            r = r + (C[i] % 10000003);
        }
        for (int j = 0; j < C.length; j++) {
            l = Math.max(l, (C[j] % 10000003));
        }

        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(mid, B, C, A)) {
                ans = mid % 10000003;
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return (int) ((ans * B) % 10000003);

    }

    public static boolean check(int mid, int B, int C[], int A) {
        int sum = 0;
        int painters = 1;
        B = B % 10000003;
        for (int i = 0; i < C.length; i++) {
            sum = (sum + (C[i] % 10000003));
            if (sum > mid) {
                painters++;
                sum = (C[i] % 10000003);
                if (painters > A) {
                    return false;
                }
            }

        }
        return true;
    }

    public static int minOfAdjecent(int stall[]) {
    int ans=stall[1]-stall[0];
    for(int i=1;i<stall.length-2;i++){
        ans=Math.min(ans,(stall[i+1]-stall[i]));
    }
    return ans;
    
    }

    public static boolean checkCow(int mid,int stall[],int cow) {
        int lastPlaced=stall[0];
        int count=1;
        for(int i=1;i<stall.length;i++){
            if(stall[i]-lastPlaced>=mid){
                 count++;
                 lastPlaced=stall[i];
            }
            if(count==cow){
                return true;
            }
        }
        return false;
        
    }
    public static int AggrasiveCows(int stall[],int cow) {
        int ans=0;
        int l=minOfAdjecent(stall);
        int r=stall[stall.length-1]-stall[0];
        while(l<=r){
            int mid=(l+r)/2;
            if(checkCow(mid,stall,cow)){
                ans=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return ans;

        
    }


    public static void main(String[] args) {
        int A[] = { 12,16,11,14,19,25,30,39,43};
        Arrays.sort(A);
       
        for(int i=0;i<A.length;i++){
            System.out.println(A[i]);
        }

          int N = 4;
        // System.out.println(Problem1(A, 4));
        // System.out.println(Problem2(A, 10));
        // System.out.println(problem3(A, 4));
        // System.out.println(FindUnique(A));
        // System.out.println(squrtOfNumber(N));
        // System.out.println(LocalMinima(A));
        // System.out.println(Pivot(A, 7));
  
       // System.out.println(painterPartian(1, 1000000, A));
      // System.out.println(AggrasiveCows(A, N));

    }
}