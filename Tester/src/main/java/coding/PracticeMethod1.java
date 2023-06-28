package coding;

public class PracticeMethod1 {
  static void findNam(String nam) {
    if (nam.equalsIgnoreCase("Ti")) {
      System.out.println("nam con chuot");
    } else if (nam.equalsIgnoreCase("Suu")) {
      System.out.println("nam con trau");
    } else if (nam.equalsIgnoreCase("dan")) {
      System.out.println("Nam con ho");
    } else {
      System.out.println("ko la nam con gi ca");
    }
  }

  static void findSo(int so) {
    if (so >= 0) {
      System.out.println("La so duong");
    } else {
      System.out.println("la so am");
    }
  }

  static int countNumber(int so) {
    int count = 0;
    for (int i = 0; i <= so; i++) {
      if (i % 2 == 0) {
        count = count + 1;
      }
    }
    return count;
  }

  static int countNumber1(int so) {
    int count = 0;
    for (int i = 0; i <= so; i++) {
      if (i % 3 == 0 && i % 5 == 0 && i % 9 != 0) {
        count = count + 1;
      }
    }
    return count;
  }

  static String findBank(int so) {
    switch (so) {
      case 1:
        return "Vietcombank";
      case 2:
        return "Techcombank";
      case 3:
        return "VIB";
    }
    return "ko la bank nao ca";
  }


  static void listBank(String[] bank) {
    for (String item : bank) {
      System.out.println(item);
    }
  }

  static void listNumber(int[] number) {
    for (int item : number) {
      System.out.println(item);
    }
  }

  static int sumNumber(int[] so) {
    int count = 0;
    for (int item : so) {
      count = count + item;
    }
    return count;
  }

  static String noiCau(String[] word, String daucach) {
    String i = "";
    for (String item : word) {
      i = i + daucach + item;
    }
    return i;
  }

  static void findWord(String[] word, String kitu) {
    for (String item : word) {
      if (item.contains(kitu)) {
        System.out.println("Chu co chua ky tu Y la " + item);
      }
    }
  }


  public static void main(String[] args) {
    findNam("meo");
    findSo(1);

    int so = countNumber(100);
    System.out.println("So chia het cho 2 la " + so);

    int count = countNumber1(100);
    System.out.println("So chia het cho 3 va 5 nhung ko chia het cho 9 la " + count);

    String bank = findBank(1);
    System.out.println(bank);

    String[] item = {"Vietcombank", "Techcombank", "VIB"};
    listBank(item);

    int[] c = {1, 2, 3};
    listNumber(c);

    int[] d = {1, 2, 3};
    int e = sumNumber(d);
    System.out.println("Tong so la " + e);

    String[] word = {"Love", "You", "Mom"};
    String daucach = " ";
    String f = noiCau(word, daucach);
    System.out.println(f);

    findWord(word, "L");

  }
}


