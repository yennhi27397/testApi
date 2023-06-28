package coding;

public class PracticeMethod {
  static void shownam(String nam) {
    if (nam.equalsIgnoreCase("ti")) {
      System.out.println("Nam con trau");
    } else if (nam.equalsIgnoreCase("suu")) {
      System.out.println("Nam con trau");
    } else if (nam.equalsIgnoreCase("dan")) {
      System.out.println("Nam con ho");
    } else if (nam.equalsIgnoreCase("meo")) {
      System.out.println("Nam con Meo");
    } else if (nam.equalsIgnoreCase("Thin")) {
      System.out.println("Nam con rong");
    } else if (nam.equalsIgnoreCase("tin")) {
      System.out.println("nam con ran");
    } else if (nam.equalsIgnoreCase("Ngo")) {
      System.out.println("Nam con Ngua");
    } else if (nam.equalsIgnoreCase("Mui")) {
      System.out.println("Nam con De");
    } else if (nam.equalsIgnoreCase("Than")) {
      System.out.println("Nam con khi");
    } else if (nam.equalsIgnoreCase("Dau")) {
      System.out.println("nam con ga");
    } else if (nam.equalsIgnoreCase("Tuat")) {
      System.out.println("Nam con cho");
    } else if (nam.equalsIgnoreCase("Hoi")) {
      System.out.println("Nam con heo");
    } else {
      System.out.println("ko la nam con gi ca");
    }
  }


  static void shownum(int so) {
    if (so >= 0) {
      System.out.println("La so duong");
    } else {
      System.out.println("La so am");
    }
  }


  static int getcountnumber(int so) {
    int count = 0;
    for (int i = 0; i <= so; i++) {
      if (i % 2 == 0) {
        count = count + 1;
      }
    }
    return count;
  }


  static int getcountnumber1(int so) {
    int count1 = 0;
    for (int i = 0; i <= so; i++) {
      if (i % 3 == 0 && i % 5 == 0 && i % 9 != 0) {
        count1 = count1 + 1;
      }
    }
    return count1;
  }


  static String getBankName(int so) {
    switch (so) {
      case 1:
        return "Vietcombank";
      case 2:
        return "Techcombank";
      case 3:
        return "VIB";
      case 4:
        return "TP bank";
    }
    return "ko tim thay bank nao ca";
  }


  static void showArray(String[] array) {
    for (String item : array) {
      System.out.println(item);
    }
  }


  static int countNumber(int[] number) {
    int count2 = 0;
    for (int y : number) {
      count2 = count2 + y;
    }
    return count2;
  }


  static int findnumber(int x, int y, int z) {
    return x + y + z;
  }


  static String getWord(String[] word, String daucach) {
    String b = "";
    for (String item : word) {
      b = b + daucach + item;
    }
    return (b);
  }


  static void findWord(String[] word, String chucaicantim) {
    for (String item : word) {
      if (item.contains(chucaicantim)) {
        System.out.println("chu co chu n la " + item);
      }
    }
  }


  public static void main(String[] args) {
    shownam("heo");
    shownum(10009);

    int count = getcountnumber(100);
    System.out.println("So chia het cho 2 la " + count);

    int count1 = getcountnumber1(100);
    System.out.println("so chia het cho 3 va 5 nhung ko chia het cho 9 la " + count1);


    int z = findnumber(2, 3, 4);
    System.out.println("Tong so la " + z);

    String bankName = getBankName(1);
    System.out.println(bankName);

    String[] array = {"techcombank", "vietcombank", "VIB"};
    showArray(array);

    int[] item = {1, 2, 3, 4, 5, 6, 7};
    int i = countNumber(item);
    System.out.println(i);

    String[] c = {"Chuc", "mung", "nam", "moi"};
    String daucach = " ";
    String cautu = getWord(c, daucach);
    System.out.println(cautu);

    findWord(c, "n");

  }
}





