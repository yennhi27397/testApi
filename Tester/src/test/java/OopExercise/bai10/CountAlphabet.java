package OopExercise.bai10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountAlphabet {

  public static void main(String[] args) {

    /*String chuoi = "Chuc Mung Nam Moi";

    Map<String, Integer> countAppear = new HashMap<>();

    for (char kiTu : chuoi.toCharArray()) {
      String kiTuString = String.valueOf(kiTu).toLowerCase();
      if (countAppear.containsKey(kiTuString)) {
        int count = countAppear.get(kiTuString);
        count++;
        countAppear.put(kiTuString, count);
      } else {
        countAppear.put(kiTuString, 1);
      }
    }
    for (Map.Entry<String, Integer> entry : countAppear.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }*/

    //Min Max

    List<Integer> array = List.of(129, 394, 138, 34, 355, 324);

    int min = array.get(0);

    for (int i = 1; i< array.size();i++) {
      if (array.get(i) < min) {
        min = array.get(i);
      }
    }
    System.out.println("Min la : " + min);

    }
  }








