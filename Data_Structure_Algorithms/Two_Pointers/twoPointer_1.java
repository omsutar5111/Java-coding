package Data_Structure_Algorithms.Two_Pointers;

import java.util.ArrayList;
import java.util.List;

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

    public int[][]mergeSorted(int[][] nums1, int[][] nums2){
        int i=0,j=0;
        List<int []>ans=new ArrayList<>();
        while(i< nums1.length&& j< nums2.length){
            if(nums1[i][0]<nums2[j][0]){
                ans.add(new int[]{nums1[i][0],nums1[i][1]});
                i++;
            } else if (nums2[j][0]<nums1[i][0]) {
                ans.add(new int[]{nums2[j][0],nums2[j][1]});
                j++;
            }
            else {
                ans.add(new int[]{nums1[i][0],nums1[i][1]+nums2[j][1]});
                i++;
                j++;
            }
        }
        while(i< nums1.length){
            ans.add(new int[]{nums1[i][0],nums1[i][1]});
            i++;
        }
        while (j< nums2.length){
            ans.add(new int[]{nums2[j][0],nums2[j][1]});
            j++;
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int A[] = { 2, 3, 3, 5, 7, 7, 8, 9, 9, 10, 10 };
        System.out.println(pairSum(A, 11));
    }
}
