package leetcode;

public class easy {
    // problem 2574 prefix sum
    public static int[] leftRightDifference(int[] nums) {
        int left[] = leftSum(nums);
        int right[] = rightSum(nums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(left[i] - right[i]);
        }
        return nums;
    }

    public static int[] leftSum(int[] arr) {
        int leftsum[] = new int[arr.length];
        leftsum[0] = 0;
        for (int i = 1; i < leftsum.length; i++) {
            leftsum[i] = leftsum[i - 1] + arr[i - 1];
        }
        return leftsum;
    }

    public static int[] rightSum(int[] arr) {
        int rightSum[] = new int[arr.length];
        rightSum[arr.length - 1] = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + arr[i + 1];
        }
        return rightSum;
    }

    // problem 1991 find middle index in array
    public static int findMiddleIndex(int[] nums) {
        int ans = -1;
        int pref[] = prefixSum(nums);
        int suff[] = suffixSum(nums);
        for (int i = 0; i < nums.length; i++) {
            if (pref[i] == suff[i]) {
                ans = i;
                return ans;
            }
        }
        return ans;
    }

    // find consecutives ones
    public static int consecutivesOnes(String A) {
        int prefixOnes[] = new int[A.length()];
        int ones = 0;
        int zeroes = 0;
        int count = 0;
        int maxCount = 0;
        int n = A.length();
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '1') {
                ones++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '0') {
                zeroes++;
            }
        }
        if (zeroes == n) {
            return 0;
        }
        if (A.charAt(0) == '1') {
            prefixOnes[0] = 1;
        } else {
            prefixOnes[0] = 0;
        }
        for (int i = 1; i < n; i++) {
            if (A.charAt(i) == '1' && A.charAt(i - 1) == '1') {
                prefixOnes[i] = 1 + prefixOnes[i - 1];
            } else if (A.charAt(i) == '1') {
                prefixOnes[i] = 1;
            } else {
                prefixOnes[i] = 0;
            }

        }

        int suffixOne[] = new int[n];
        if (A.charAt(n - 1) == '1') {
            suffixOne[n - 1] = 1;
        } else {
            suffixOne[n - 1] = 0;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (A.charAt(i) == '1' && A.charAt(i + 1) == '1') {
                suffixOne[i] = 1 + suffixOne[i + 1];
            } else if (A.charAt(i) == '1') {
                suffixOne[i] = 1;
            } else {
                suffixOne[i] = 0;
            }
        }
        int maxOnes = 0;
        for (int i = 0; i < n; i++) {
            maxOnes = Math.max(maxOnes, (Math.max(prefixOnes[i], suffixOne[i])));
        }
        for (int i = 1; i < n - 1; i++) {
            if (A.charAt(i) == '0') {
                int sum = suffixOne[i + 1] + prefixOnes[i - 1];
                if (sum < ones) {
                    sum = sum + 1;
                }
                maxOnes = Math.max(maxOnes, sum);
            }
        }
        return maxOnes;
    }

    public static int[] prefixSum(int[] A) {
        int[] prefixSum = new int[A.length];
        int N = prefixSum.length;
        prefixSum[0] = A[0];
        for (int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }
        return prefixSum;
    }

    public static int[] suffixSum(int[] A) {
        int[] suffixSum = new int[A.length];
        int N = suffixSum.length;
        suffixSum[N - 1] = A[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + A[i];
        }
        return suffixSum;
    }

    // find majority element majority =element who is appeared more than n/2 in
    // array
    public static int majorityElement(int[] nums) {
        int count = 0;
        int majority = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count > (nums.length / 2)) {
                return majority;
            }
            if (count == 0) {
                majority = nums[i];
            }
            if (majority == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return majority;

    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int target = tickets[k]; // Track the number of tickets the target person needs

        for(int i=0;i<tickets.length;i++){
            if(i<=k){
                time+=Math.min(target,tickets[i]);
            }
            else{
                time+=Math.min(target-1,tickets[i]);
            }
        }

        return time;
    }

    //1652. Defuse the Bomb
    public  static int[] decrypt(int[] code, int k) {
        int ans[]=new int[code.length];
        if(k==0){
            return ans;
        }
        for(int i=0;i<code.length;i++){
            int sum=0;

            if(k>0){
                for(int j=1;j<=k;j++){
                    int index=(j+i)%code.length;
                    sum+=code[index];
                }
                ans[i]=sum;
            }
            else{
                for(int j=1;j<=-k;j++){
                    int index=(i-j+code.length)%code.length;
                    sum+=code[index];
                }
                ans[i]=sum;
            }
        }
        return ans;
    }


    //1768. Merge Strings Alternately
    public static  String mergeAlternately(String word1, String word2) {
        StringBuilder sb=new StringBuilder();
        int p1=0,p2=0;
        createString(p1,p2,word1,word2,sb);
        return sb.toString();

    }

    public static void createString(int p1,int p2,String word1,String word2,StringBuilder sb){
        if(p1>=word1.length() && p2>=word2.length()){
            return;
        }
        if(p1<word1.length()){
            sb.append(word1.charAt(p1));
            p1++;
        }
        if(p2<word2.length()){
            sb.append(word2.charAt(p2));
            p2++;
        }
        createString(p1,p2,word1,word2,sb);
    }
    public static void main(String[] args) {
        int nums[] = { 1 };
        // int ans[] = leftRightDifference(nums);
        // for (int i = 0; i < ans.length; i++) {
        // System.out.println(ans[i]);
        // }

        // System.out.println(findMiddleIndex(nums));
         System.out.println(consecutivesOnes("000010"));
        System.out.println(majorityElement(nums));
    }
}
