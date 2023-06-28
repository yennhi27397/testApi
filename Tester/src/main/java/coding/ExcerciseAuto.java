package coding;

import java.util.ArrayList;
import java.util.List;

public class ExcerciseAuto {

  static void showName(String nam) {
    if (nam.equalsIgnoreCase("ti")) {
      System.out.println("Nam con chuot");
    } else if (nam.equalsIgnoreCase("Suu")) {
      System.out.println("nam con Trau");
    } else if (nam.equalsIgnoreCase("Dan")) {
      System.out.println("Nam con Ho");
    } else if (nam.equalsIgnoreCase("Meo")) {
      System.out.println("Nam con Meo");
    } else if (nam.equalsIgnoreCase("Thin")) {
      System.out.println("Nam con rong");
    } else if (nam.equalsIgnoreCase("tin")) {
      System.out.println("Nam con Ran");
    } else if (nam.equalsIgnoreCase("Ngo")) {
      System.out.println("Nam con ngua");
    } else if (nam.equalsIgnoreCase("Mui")) {
      System.out.println("Nam con de");
    } else if (nam.equalsIgnoreCase("Than")) {
      System.out.println("Nam con Khi");
    } else if (nam.equalsIgnoreCase("Dau")) {
      System.out.println("Nam con ga");
    } else if (nam.equalsIgnoreCase("Tuat")) {
      System.out.println("Nam con cho");
    } else if (nam.equalsIgnoreCase("Hoi")) {
      System.out.println("Nam con heo");
    } else {
      System.out.println("ko la nam con gi ca");
    }

  }

  static void soAmduong(int y) {
    if (y >= 0) {
      System.out.println("la so duong");
    } else {
      System.out.println("la so am");
    }

  }

  static int getCountNumber(int number) {
    int count = 0;
    for (int item = 0; item <= number; item++) {
      if (item % 2 == 0) {
        count = count + 1;
      }
    }
    return count;
  }


  public static void main(String[] args) {
    showName("ti");
    soAmduong(10);
    int count = getCountNumber(1000);
    System.out.println("so chia het cho 2 la " + count);


    int count1 = 0;
    for (int i = 0; i <= 1000; i++) {
      if (i % 3 == 0 && i % 5 == 0 && i % 9 != 0) {
        count1 = count1 + 1;
      }
    }
    System.out.println("so chia het cho 3 va 5 nhung ko chia het cho 9 la " + count1);


    int y = 2;
    switch (y) {
      case 1:
        System.out.println("Vietcombank");
        break;
      case 2:
        System.out.println("techcombank");
        break;
      case 3:
        System.out.println("VIB");
        break;
      case 4:
        System.out.println("TP bank");
        break;
    }


    List<String> bank = new ArrayList<>();
    bank.add("techcombank");
    bank.add("Vietcombank");
    bank.add("VIB");
    bank.add("TPbank");
    System.out.println(bank.get(0) + 97);
    for (String item : bank) {
      System.out.println(item);
    }


    String[] x = {"Vietcombank", "Techcombank", "VIB", "TPbank"};
    System.out.println(x[1]);


    int count2 = 0;
    int[] v = {1, 2, 3, 4, 5, 6, 7, 8};
    for (int item : v) {
      count2 = count2 + item;
    }
    System.out.println("Tong so la " + count2);


    int count3 = 0;
    int[] a = {1, 2, 4, 5, 6, 10};
    for (int item : a) {
      count3 = count3 + item;
    }
    System.out.println("Tong so la " + count3);


    String b = "";
    String[] c = {"Chuc", "mung", "nam", "moi"};
    for (String item : c) {
      b = b + " " + item;
    }
    System.out.println(b);


    String[] chuoi = {"Chuc", "mung", "nam", "moi"};
    for (String item : chuoi) {
      if (item.contains("n")) {
        System.out.println("chu co chu n la " + item);
      }
    }


    String u = "";
    String[] chuoi1 = {"Anh", "yeu", "khoe", "chua", "da", "?"};
    for (String item : chuoi1) {
      u = u + " " + item;
    }
    System.out.println(u);


    String z = "con Lu heo";
    System.out.println(z.toUpperCase());


    String p = "con Lu heo";
    System.out.println(p.substring(4, 6));
  }

}


// System.out.println(String.join(" ", word1));












