package Java_Interview_Questions;
import java.util.*;
public class IBM {
    public static int minInsertionsToBalance(String s) {
        int open = 0, insertions = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++; // Increase open parenthesis count
            } else { // ch == ')'
                if (open > 0) {
                    open--; // Match with an existing '('
                } else {
                    insertions++; // Need to insert '(' before this ')'
                }
            }
        }

        // Remaining unmatched '(' need a closing ')'
        return insertions + open;
    }
    public static int minOperation(List<Integer>current,List<Integer>desired){
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < desired.size(); i++) {
            indexMap.put(desired.get(i), i);
        }

        // Step 2: Convert 'current' into an index sequence based on 'desired'
        List<Integer> position = new ArrayList<>();
        for (int num : current) {
            if (indexMap.containsKey(num)) {
                position.add(indexMap.get(num));
            }
        }

        // Step 3: Find LIS length
        int lisLength = findLIS(position);

        // Step 4: Compute and return the answer
        return current.size() - lisLength;
    }
    private static int findLIS(List<Integer> list) {
        if (list.isEmpty()) return 0;

        // Using a list for tracking LIS (Binary Search approach)
        List<Integer> lis = new ArrayList<>();
        for (int num : list) {
            int pos = Collections.binarySearch(lis, num);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            if (pos < lis.size()) {
                lis.set(pos, num);
            } else {
                lis.add(num);
            }
        }
        return lis.size();
    }
    public static int minOperations(List<Integer> current, List<Integer> desired) {
        int n = current.size();

        // Try all possible suffix lengths of desired list
        for (int l = n; l >= 0; l--) {
            // Get the suffix of desired list of length l
            List<Integer> suffix = desired.subList(n - l, n);

            // Check if this suffix exists as a consecutive substring in current
            for (int i = 0; i <= n - l; i++) {
                List<Integer> sublist = current.subList(i, i + l);
                if (sublist.equals(suffix)) {
                    // Found a match, minimum operations is n - l
                    return n - l;
                }
            }
        }

        return n;
    }
    public static void main(String[] args) {
        List<Integer> current = Arrays.asList(1,5,2,3,4);
        List<Integer> desired = Arrays.asList(2,3,4,5,1);
        System.out.println(minOperation(current, desired));
     //   System.out.println(minOperations(current,desired));


    }
}

/*
  1 5 2 3 4     2 3 4 5 1

 */
