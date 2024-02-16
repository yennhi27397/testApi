package OopExercise;

import java.util.HashMap;
import java.util.Map;

public class CountAppear {
  public static void main(String[] args) {
    //Bài 2: Đếm số lần xuất hiện của String

    String chuoi = "I Love You";
    Map<String,Integer> countAppearance = new HashMap<>();
    for (char kiTu: chuoi.toCharArray()){
      String kiTuString = String.valueOf(kiTu);
      if (countAppearance.containsKey(kiTuString)) {
        int count = countAppearance.get(kiTuString);
        count++;
        countAppearance.put(kiTuString, count);
      } else {
        countAppearance.put(kiTuString,1);
      }
    }
    for (Map.Entry<String,Integer> entry:  countAppearance.entrySet()) {
      String key = entry.getKey();
      Integer value = entry.getValue();
      System.out.println(key + ": " + value);
    }

    String chuoi1 = "Van Su Nhu Y";
    Map<String, Integer> countAppearance1 = new HashMap<>();
    for (char kiTu : chuoi1.toCharArray()) {
      String kiTuString = String.valueOf(kiTu).toLowerCase();
      if (countAppearance1.containsKey(kiTuString)) {
        int count = countAppearance1.get(kiTuString);
        count++;
        countAppearance1.put(kiTuString, count);
      } else {
        countAppearance1.put(kiTuString, 1);
      }
    }
    for (Map.Entry<String,Integer> entry : countAppearance1.entrySet()){
      System.out.println(entry.getKey()+": "+ entry.getValue());
    }

  }
}
