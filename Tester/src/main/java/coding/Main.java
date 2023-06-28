package coding;

public class Main {
  public static void main(String[] args) {
    String name = "Doan";
    name = "Nhi"; // re-assign value
    System.out.println("Chao Anh/Chi " + name); // append String

    int myNum = 9;
    System.out.println("Cho anh " + name + " " + myNum + " ngan dong");

    myNum = 10 / 2;
    System.out.println(myNum);

    myNum = 10 * 2;
    System.out.println(myNum);

    myNum = 10 - 2;
    System.out.println(myNum);

    myNum = 10 + 2;
    System.out.println(myNum);

    myNum = 7 / 2;
    System.out.println(myNum);

    myNum = 7 % 2; // chia lay du. 7 chia 2 du 1.
    System.out.println(myNum);

    float myFloat = 5.75f;
    System.out.println(myFloat);

    myFloat = 5.75f / 2; // 2.875?
    System.out.println(myFloat);

    myFloat = 5.75f * 2; // 11.5?
    System.out.println(myFloat);

    myFloat = 5.75f + 2; // 7.75?
    System.out.println(myFloat);

    myFloat = 5.75f - 2; // 3.75?
    System.out.println(myFloat);

    myFloat = 5.75f % 2; //1.75?
    System.out.println(myFloat);

    char myGrade = 'b';
    System.out.println(myGrade);

    boolean isJavaFun = true;
    boolean isFishTasty = false;
    System.out.println(isJavaFun);     // Outputs true
    System.out.println(isFishTasty);   // Outputs false

    int time = 20;
    if (time < 18) {
      System.out.println("Good day.");
    } else {
      System.out.println("Good evening.");
    }
// Outputs "Good evening."

    boolean noloveanhDoan = false;
    if (noloveanhDoan == false) {
      System.out.println("Nhi love anh Doan");
    } else {
      System.out.println("Anh Doan love Nhi");
    }


    String Ten = "NHI";
    if (Ten.equalsIgnoreCase("Nhi")) {
      System.out.println("anh Doan yeu Nhi");
    } else {
      System.out.println("anh Doan ko yeu ai ca");
    }


    int Money1 = 20000;
    if (Money1 >= 10000 && Money1 <= 20000) {
      System.out.println("cho anh Doan");
    } else {
      System.out.println("Sung va cong quy");
    }


    int Money2 = 9000;
    boolean noloveanhDoan2 = false;
    if (Money2 >= 10000 || noloveanhDoan2 == true) {
      System.out.println("cho anh Doan");
    } else {
      System.out.println("Sung va cong quy");
    }


    int time1 = 22;
    if (time1 < 10) {
      System.out.println("Good morning.");
    } else if (time1 < 18) {
      System.out.println("Good day.");
    } else {
      System.out.println("Good evening.");
    }
// Outputs "Good evening."


    int money = 9999;
    if (money >= 10000 && money <= 20000) {
      System.out.println("Cho anh Doan");
    } else if (money > 20000 && money < 30000) {
      System.out.println("Cho ba Nhi");
    } else if (money < 10000) {
      System.out.println("Cho heo an");
    } else {
      System.out.println("Cho Me Nhi");
    }

    int day = 12;
    switch (day) {
      case 1:
        System.out.println("Monday");
        break;
      case 2:
        System.out.println("Tuesday");
        break;
      case 3:
        System.out.println("Wednesday");
        break;
      case 4:
        System.out.println("Thursday");
        break;
      case 5:
        System.out.println("Friday");
        break;
      case 6:
        System.out.println("Saturday");
        break;
      case 7:
        System.out.println("Sunday");
        break;
      default:
        System.out.println("Looking forward to the Weekend");
    }
// Outputs "Thursday" (day 4)

    int payment = 1;
    switch (payment) {
      case 1:
        System.out.println("zalo pay");
      case 2:
        System.out.println("momo");
      case 3:
        System.out.println("vnpay");
      default:
        System.out.println("another payment");
    }

    String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
    System.out.println(cars[2]);
// Now outputs Opel instead of Volvo


    for (int i = 2; i <= 6; i += 2) {
      System.out.println("i: " + (i + 1));
    }
    System.out.println("Stop");


    String nam = "cho";
    if (nam.equalsIgnoreCase("Ti")) {
      System.out.println("Nam con Chuot");
    } else if (nam.equalsIgnoreCase("Suu")) {
      System.out.println("Nam con trau");
    } else if (nam.equalsIgnoreCase("Dan")) {
      System.out.println("Nam con Ho");
    } else if (nam.equalsIgnoreCase("Meo")) {
      System.out.println("Nam con Meo");
    } else if (nam.equalsIgnoreCase("thin")) {
      System.out.println("Nam con Rong");
    } else if (nam.equalsIgnoreCase("ti")) {
      System.out.println("Nam con Ran");
    } else if (nam.equalsIgnoreCase("ngo")) {
      System.out.println("Nam con Ngua");
    } else if (nam.equalsIgnoreCase("Mui")) {
      System.out.println("Nam con De");
    } else if (nam.equalsIgnoreCase("Than")) {
      System.out.println("Nam con Khi");
    } else if (nam.equalsIgnoreCase("Dau")) {
      System.out.println("Nam con Ga");
    } else if (nam.equalsIgnoreCase("Tuat")) {
      System.out.println("Nam con Cho");
    } else if (nam.equalsIgnoreCase("Hoi")) {
      System.out.println("Nam con heo");
    } else System.out.println("ko la nam con gi het");


    int num = -2;
    if (num >= 0) {
      System.out.println("La so duong");
    } else {
      System.out.println("La so am");
    }

    int count = 0;
    for (int i = 0; i <= 10; i++) {
      if (i % 2 == 0) {
        count = count + 1; //
      }
    }
    System.out.println("tong so chi het cho 2 = " + count);
  }
}




