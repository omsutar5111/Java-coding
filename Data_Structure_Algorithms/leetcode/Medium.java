package Data_Structure_Algorithms.leetcode;

import java.util.*;

public class Medium {
    
    //33. Search in Rotated Array
   public static int searchBinary(int A[],int target){
       int left=0;
       int right=A.length-1;
       while(left<=right){
           int mid=right-(right-left)/2;
           if(A[mid]==target){
               return mid;
           }
           if(A[left]<=A[mid]){
               if(A[left]<=target && A[mid]>=target){
                   right=mid-1;
               }
               else{
                   left=left+1;
               }
           }
          else{
              if(A[mid]<=target && target<=A[right]){
                  left=mid+1;
              }
              right=mid-1;
           }

       }

       return -1;
   }

   //153 FIND minimum in rotated array
    public static int findMin(int arr[]){
       int min=Integer.MAX_VALUE;
       int left=0;
       int right=arr.length;
       while(left<=right){
           int mid=right-(right-left)/2;
           if(arr[left]<=arr[mid]){
                left=mid+1;
           }
           else{
               right=mid;
           }
       }

       return arr[min];
    }

    // problem 670 :max one swap to get maximum number

    public  static int minSwapMaxVal(int num){
        char[]digits=Integer.toString(num).toCharArray();
        int maxIndex=digits.length-1;
        int x=-1,y=-1;
        for(int i=digits.length-1;i>0;i--){
            if(digits[i]>digits[maxIndex]){
                maxIndex=i;
            } else if (digits[i]<digits[maxIndex]) {
                x=i;
                y=maxIndex;
            }
        }
        if(x!=-1){
            char temp=digits[x];
            digits[x]=digits[y];
            digits[y]=temp;
        }
        return Integer.parseInt(new String(digits));
    }

    //2825. Make String a Subsequence Using Cyclic Increments
    //approach two pointers.
    public static boolean canMakeSubsequence(String str1, String str2) {
        int p1=0,p2=0;
        while(p2<str2.length() && p1<str1.length()){
            if(str1.charAt(p1)==str2.charAt(p2)){
                p1++;
                p2++;
                continue;
            }
            char ch=str1.charAt(p1);
            if(ch=='z'){
                ch='a';
            }
            else {
                ch++;
            }

            char ch2=str2.charAt(p2);
            if(ch==ch2){
                p2++;
            }
            p1++;
        }
        if(p2==str2.length()){
            return true;
        }
        return false;
    }
      //2109. Adding Spaces to a String
    public  static String addSpaces(String s, int[] spaces) {
        StringBuilder sb=new StringBuilder();
        int startIndex=0;
        for(int i=0;i<spaces.length;i++){
            int endIndex=spaces[i];
            sb.append(s.substring(startIndex,endIndex));
            sb.append(" ");
            startIndex=endIndex;

        }
        sb.append(s.substring(startIndex,s.length()));

        return sb.toString();
    }


    public static int minEatingSpeed(int[] piles, int h) {
        int maxPile=0;
        int ans=Integer.MAX_VALUE;
        for(int pile:piles){
            maxPile=Math.max(pile,maxPile);
        }
        int L=1,R=maxPile;
        while(L<=R){
            int mid=L+(R-L)/2;
            if(canEat(mid,piles,h)){
                ans=Math.min(mid,ans);
                R=mid-1;
            }
            else{
                L=mid+1;
            }
        }
        return ans;

    }
 //problem 2162 partition array according to given pivot

    public static  int []pivotArray(int nums[],int pivot){
       int n=nums.length;
       int ans[]=new int[n];
       int left=0,right=n-1,equal=0;
       for(int num:nums){
           if(num<pivot){
               left++;
           } else if (num==pivot) {
               equal++;
           }
       }
       int startIndex=0;
       int mid=left;
       int largerThanPivot=left+equal;
       for(int num:nums){
           if(num<pivot){
               ans[startIndex]=num;
               startIndex++;
           } else if (num==pivot) {
               ans[mid]=num;
               mid++;
           }
           else{
               ans[largerThanPivot]=num;
               largerThanPivot++;
           }
       }
       return ans;
    }
    public static boolean canEat(int capacity,int []piles,int h){
//        int totalTime=0;
//        for(int pile:piles){
//            int time=0;
//            if(pile>capacity){
//
//                if(pile%capacity==0){
//                    time=pile/capacity;
//                }
//                else{
//                    time=(pile/capacity)+1;
//                }
//            }
//            else{
//                time=1;
//            }
//            totalTime+=time;
//        }
//        if(h<totalTime){
//            return false;
//        }
//        return true;
        int totalTime = 0;
        for (int pile : piles) {
            // Ceiling division for time calculation
            totalTime += (pile + capacity - 1) / capacity;
            if (totalTime > h) {
                return false; // If total time exceeds allowed hours, return false
            }
        }
        return totalTime <= h;
    }

    public static int waysToSplitArray(int[] nums) {
        int n=nums.length;
        int ans=0;
        int pref[]=new int[n];
        int suf[]=new int[n];
        suf[n-1]=nums[n-1];
        pref[0]=nums[0];
        for(int i=1;i<n;i++){
            pref[i]=pref[i-1]+nums[i];
        }
        for(int i=n-2;i>=0;i--){
            suf[i]=suf[i+1]+nums[i];
        }
        for(int i=0;i<n-1;i++){
            if(pref[i]>=suf[i+1]){
                ans++;
            }
        }
        return ans;

    }

    //6.ZIGZAG pattern string
    public static String payPayString(String s,int numRows){
      if(numRows==1){
          return s;
      }
      int cycle=2*numRows-2;
      StringBuilder []rows=new StringBuilder[numRows];
      for(int i=0;i<numRows;i++){
          rows[i]=new StringBuilder();
      }
      for(int i=0;i<s.length();i++){
          char ch=s.charAt(i);
          int pos=i%cycle;
          if(pos<numRows){
              rows[pos].append(ch);
          }
          else{
              rows[cycle-pos].append(ch);
          }
      }
      StringBuilder result=new StringBuilder();
      for(StringBuilder row:rows){
          result.append(row);
      }
     return result.toString();
    }

    // 1780. Check if Number is a Sum of Powers of Three

    public boolean cheecPowerofThree(int num){
       // tsak is to find if its possible to sum of  unique power to three is equal to number
        while(num>0){
            if(num%3==2){
                return false;
            }
            num/=3;
        }
        return true;
    }

    public static List<List<String>>collectAnagrams(String[]str){
        HashMap<String,List<String>>map=new HashMap<>();
        for(String word:str){
            char ch[]=word.toCharArray();
            Arrays.sort(ch);
            String key=new String(ch);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(word);

        }
        return  new ArrayList<>(map.values());
    }
  //2523. Closest Prime Numbers in Range
    public  static int[]getClosestPrimes(int left,int right){
       ArrayList<Integer>ans=new ArrayList<>();
       boolean getPrimes[]=new boolean[right+1];
       Arrays.fill(getPrimes,true);
       for(int i=2;i*i<=right;i++){
           if(getPrimes[i]){
               for(int j=i*i;j<=right;j+=i){
                   getPrimes[j]=false;
               }
           }
       }
       for(int i=Math.max(2,left);i<=right;i++){
           if(getPrimes[i]){
               ans.add(i);
           }
       }
        if (ans.size() < 2) {
            return new int[]{-1, -1};
        }
        int min= ans.get(0),max=ans.get(1),minDifference=max-min;
        for(int i=1;i<ans.size()-1;i++){
            int diff=ans.get(i+1)- ans.get(i);
            if(diff<minDifference){
                min=ans.get(i);
                max=ans.get(i+1);
            }
        }
        return  new  int[]{min,max};
    }
    //3169
    public static  int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int occupiedDays=0;
        int currentMeetingEndDay=0;
        for(int []meeting:meetings){
           if(meeting[0]>currentMeetingEndDay){
               occupiedDays+=meeting[1]-meeting[0]+1;
               currentMeetingEndDay=meeting[1];
           }
           else{
               if(meeting[1]>currentMeetingEndDay){
                   occupiedDays+=meeting[1]-currentMeetingEndDay;
                   currentMeetingEndDay=meeting[1];
               }
           }
        }
        return days-occupiedDays;

    }

    public static void main(String[] args) {
       int []Arr={4,5,6,7,0,1,2};
       int spaces[]={5,9};
       int piles[]={805306368,805306368,805306368};
       int h=1000000000;
//        System.out.println(minEatingSpeed(piles,h));
//        String[]strs ={"eat","tea","tan","ate","nat","bat"};
        int nums[]={6,-1,9};
//        System.out.println(waysToSplitArray(nums));
//        System.out.println(collectAnagrams(strs));

//        System.out.println(searchBinary(Arr,0));
//        System.out.println(canMakeSubsequence("f","f"));
////        System.out.println(addSpaces( "EnjoyYourCoffee",spaces));
//       int getClosestPrime[]=getClosestPrimes(18 ,25);
//       for (int num:getClosestPrime){
//           System.out.println(num);
//       }

        int [][]meetings={{5,7},{1,3},{9,10}};
        System.out.println(countDays(10,meetings));
    }
}
