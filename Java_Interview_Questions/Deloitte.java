package Java_Interview_Questions;

import java.util.*;

public class Deloitte {
  public static void result(int [][]values,int rows,int cols){

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
    }
}
