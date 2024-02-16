package OopExercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinMax {
  public static void main(String[] args) {

// Bài 1: Tìm min, max

    List<Integer> array = List.of(1, 4, 7, -9, -3, 10);
    // core: lấy biến tạm, if

    //Min
    int min = array.get(0); // 1
    for (int i = 1; i < array.size(); i++) {
      if (array.get(i) < min) {
        min = array.get(i);
      }
    }
    System.out.println("min = " + min);

    //max
    int max = array.get(0);
    for (int j = 1; j < array.size(); j++) {
      if (array.get(j) > max) {
        max = array.get(j);
      }
    }
    System.out.println("max = " + max);









  }
}
