package Java_Interview_Questions;

import java.util.*;

public class Deloitte {
  public static void result(int [][]values,int rows,int cols){
     for(int col=0;col<cols;col++){
         int maxVal=Integer.MIN_VALUE;
         for(int row=0;row<rows;row++){
             if(values[row][col]!=-1){
                 maxVal=Math.max(values[row][col],maxVal);
             }
         }
         for(int row=0;row<rows;row++){
             if(values[row][col]==-1){
                 values[row][col]=maxVal;
             }
         }
     }
     for(int i=0;i<rows;i++){
         for(int j=0;j<cols;j++){
             System.out.print(values[i][j]+ " ");
         }
         System.out.println();
     }
  }
  public static  String mostOccuringFirst(String input){
      if (input == null || input.isEmpty()) {
          return "";
      }

      String[] words = input.split("\\s+"); // Splitting by spaces
      LinkedHashMap<String, Integer> wordCount = new LinkedHashMap<>();

      // Count occurrences while maintaining order
      for (String word : words) {
          wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
      }

      // Finding the first most occurred word
      String mostOccurredWord = "";
      int maxCount = 0;

      for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
          if (entry.getValue() > maxCount) {
              mostOccurredWord = entry.getKey();
              maxCount = entry.getValue();
          }
      }

      return mostOccurredWord;
  }
    public static void main(String[] args) {
        String input = "apple banana apple orange banana apple orange";
        System.out.println("Most occurred first word: " + mostOccuringFirst(input));
        int[][] values = {
                {3, -1, 5},
                {1, 9, -1},
                {4, 2, 6}
        };

        result(values,3,3);
    }
}
