package Data_Structure_Algorithms.Strings;

import java.util.HashMap;
import java.util.HashSet;

public class strings {

    public static char[] alphabeticalOrder(char[] str) {
        char[] newStr = new char[26];

        return newStr;

    }

    public static int[] LPS(String str) {
        int[] lps = new int[str.length()];
        int N = lps.length;
        lps[0] = 0;
        for (int i = 1; i < N; i++) {
            int x = lps[i - 1];
            while (str.charAt(i) != str.charAt(x)) {
                if (x == 0) {
                    x = -1;
                    break;
                }
                x = lps[x - 1];
            }
            lps[i] = x + 1;
        }
        return lps;

    }

    public static int checkPattern(String str1, String str2) {
        int count = 0;
        String str3 = str2 + "#" + str1;
        int[] lps = LPS(str3);
        for (int i = 0; i < lps.length; i++) {
            if (lps[i] == str2.length()) {
                count++;
            }
        }
        return count;

    }

    public static int findUniqueSubstring(String str) {
        int ans = 0;
        int n = str.length();
        for (int s = 0; s < n; s++) {
            HashSet<Character> hs = new HashSet<>();
            for (int e = s; e < n; e++) {
                if (hs.contains(str.charAt(e)) == true) {
                    break;
                } else {
                    hs.add(str.charAt(e));
                }
            }
            ans = Math.max(ans, hs.size());
        }
        return ans;
    }

    public static int findUniqueSubstring2(String str) {
        int ans = 0;
        int n = str.length();
        int s = 0, e = 0;
        HashSet<Character> hs = new HashSet<>();
        while (e < n) {
            if (hs.contains(str.charAt(e)) == false) {
                hs.add(str.charAt(e));
                e++;
            } else {
                hs.remove(str.charAt(s));
                s++;
            }
            ans = Math.max(ans, hs.size());
        }
        return ans;
    }

    public static boolean checkAnagrams(String str1, String str2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        fillMap(map1, str1);
        fillMap(map2, str2);

        return areMapSame(map1, map2);
    }

    public static void fillMap(HashMap<Character, Integer> map, String str) {
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i)) == false) {
                map.put(str.charAt(i), 1);
            } else {
                int temp = map.get(str.charAt(i));
                temp++;
                map.put(str.charAt(i), temp);
            }
        }
    }

    public static boolean areMapSame(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        if (map1.size() != map2.size()) {
            return false;
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            int f1 = 0, f2 = 0;
            if (map1.containsKey(ch)) {
                f1 = map1.get(ch);
            }
            if (map2.containsKey(ch)) {
                f2 = map2.get(ch);
            }
            if (f1 != f2) {
                return false;
            }
        }

        return true;
    }

    public static int permutationOfString(String str1, String str2) {
        int ans = 0;
        HashMap<Character, Integer> map1 = new HashMap<>();
        fillMap(map1, str1);
        HashMap<Character, Integer> map2 = new HashMap<>();
        int s = 0, e = str1.length();
        while (s < e) {
            if (map2.containsKey(str2.charAt(s)) == false) {
                map2.put(str2.charAt(s), 1);
            } else {
                int temp = map2.get(str2.charAt(s));
                temp++;
                map2.put(str2.charAt(s), temp);
            }
            s++;
        }
        if (areMapSame(map1, map2)) {
            ans++;
        }
        int start = 1, end = e;
        while (end < str2.length()) {
            char chr = str2.charAt(start - 1);
            int temp = map2.get(chr);
            temp--;
            map2.put(chr, temp);
            if (temp == 0) {
                map2.remove(chr);
            }

            char cha = str2.charAt(end);
            if (map2.containsKey(cha) == false) {
                map2.put(cha, 1);
            } else {
                int t = map2.get(cha);
                t++;
                map2.put(cha, t);
            }

            if (areMapSame(map1, map2)) {
                ans++;
            }
            start++;
            end++;

        }
        return ans;
    }

    public static void main(String[] args) {
        // char str[]={'a','c','s','d','g','a','c','b'};
        // System.out.println((char)(66+32));

        // String str="abcabdabcabeabcabkdabcabc";
        // int lpsArr[]=LPS(str);
        // for(int i=0;i<lpsArr.length;i++){
        // System.out.println(lpsArr[i]);
        // }

        // KMP ALGO PATTERN PROBLEM
        String str1 = "abadcababae";
        String str2 = "aba";
         char s []=str1.toCharArray();

        // System.out.println(checkPattern(str1, str2));
        // }

        // System.out.println(findUniqueSubstring2("abcddefgh"));

        // System.out.println(checkAnagrams("abcde", "cdebf"));
      //  System.out.println(permutationOfString(str2, str1));

    }
}
