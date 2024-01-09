package exerciseCoding;

import oop.Parent;
import oop.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExerciseCode {

  // sumComplexNumber 2 so
  public static void sum2Number(int num1, int num2) {
    System.out.println("The sumComplexNumber is " + Integer.sum(num1, num2));
  }

  public static void sumNumbers(int[] number) {
    int num = 0;
    for (int i = 0; i < number.length; i++) {
      num = num + i;
    }
    System.out.println("Sum of array elements is: " + num);
  }

  public static void sum2NumberScanner() {
    int sum, num1, num2;
    Scanner sc = new Scanner(System.in);
    System.out.println("Nhập vào số thứ nhất: ");
    num1 = sc.nextInt();

    System.out.println("Nhập vào số thứ hai: ");
    num2 = sc.nextInt();

    sc.close();
    sum = num1 + num2;
    System.out.println("Tổng của hai số vừa nhập là: " + sum);
  }

  // check so chan hay so le
  public static void check2SoChanLe(int number) {
    if (number % 2 == 0) {
      System.out.println("La so chan");
    } else {
      System.out.println("La so le");
    }
  }

  public static void check2SoChanLeScanner() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("nhập vào số cần kiểm tra i:");
    int i = scanner.nextInt();
    if (i % 2 == 0) {
      System.out.println(i + " là số chẵn!");
    } else {
      System.out.println(i + " là số lẻ");
    }
  }

  // cong 2 so nguyen
  public static void sumComplexNumber(double a, double b) {
    System.out.println("a + b = " + Double.sum(a, b));
  }

  // nhan 2 so nguyen
  public static void nhan2So(int a, int b) {
    int tich = a * b;
    System.out.println("Tich 2 so la " + tich);
  }

  public static void nhan2SoScanner() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("nhập vào số thứ nhất: ");
    double c = scanner.nextDouble();

    System.out.print("Nhập vào số thứ hai:  ");
    double d = scanner.nextDouble();

    double tich = c * d;
    System.out.println("Kết quả: " + tich);
  }

  public static void checkNamNhuan(int year) {
    boolean isLeap = true;
    if (year % 4 == 0 && year % 100 != 0) {
      if (year % 400 == 0) {
        isLeap = true;
      } else {
        isLeap = false;
      }
    } else {
      isLeap = false;
    }
    if (isLeap == true) System.out.println(year + " là năm nhuận.");
    else System.out.println(year + " không phải là năm nhuận.");
  }


  public static void abc(int year) {
    if (year % 4 == 0 && year % 100 != 0) {
      System.out.println(" la nam nhuan");
    } else {
      System.out.println("ko la nam nhuan");
    }
  }


  public static void checkNguyenAmPhuAm(char key) {
    boolean checkKey = false;
    switch (key) {
      case 'a':
      case 'e':
      case 'i':
      case 'o':
      case 'u':
      case 'A':
      case 'E':
      case 'I':
      case 'O':
      case 'U':
        checkKey = true;
    }
    if (checkKey == true) {
      System.out.println(key + " la nguyen am");
    } else {
      if ((key >= 'a' && key <= 'z') || (key >= 'A' && key <= 'Z')) System.out.println(key + " la phu am");
      else System.out.println(key + " khong nam trong bang chu cai");
    }
  }

  // P (1 + R/n) (nt) - P
  public static void laiXuatKep(int p, double r, int n, int t) {
    double amount = p * Math.pow(1 + (r / n), n * t);
    double cinterest = amount - p;
    System.out.println("Tien lai sau " + t + " nam la " + cinterest);
    System.out.println("So tien co duoc sau " + t + " nam la " + amount);


  }

  public static void tinhLaiXuat(int p, double r, int t) {
    double laiXuat = (p * r * t) / 100;
    System.out.println("Lai xuat trong " + t + " nam la " + laiXuat);
  }

  public static void layPhanNguyenPhanDu(int a, int b) {
    int phanNguyen = a / b;
    int phanDu = a % b;
    System.out.println("Phan nguyen la " + phanNguyen);
    System.out.println("Phan du la " + phanDu);
  }

  public static void xoaKhoangTrang(String sentence) {
    sentence = sentence.replaceAll("  ", " ");
    System.out.println("Sentence after delete space is " + sentence);

  }

  public static void vietHoaChuCaiDau(String letter) {
    String firstLetter = letter.substring(0, 1);
    String remainingLetters = letter.substring(1, letter.length());
    firstLetter = firstLetter.toUpperCase();
    letter = firstLetter + remainingLetters;

    System.out.println("Viet hoa chu cai dau la " + letter);

  }

  public static String standardize(String key) {
    char[] chars = key.toLowerCase().toCharArray();
    boolean isFoundFirstLetterForWord = false;
    for (int i = 0; i < chars.length; i++) {
      if (!isFoundFirstLetterForWord && Character.isLetter(chars[i])) {
        chars[i] = Character.toUpperCase(chars[i]);
        isFoundFirstLetterForWord = true;
      } else if (Character.isWhitespace(chars[i]) || chars[i] == '.' || chars[i] == '\'') {
        isFoundFirstLetterForWord = false;
      }
    }
    // sprint HOA
    String clause = String.valueOf(chars);
    // remove spaces.
    String result = removeSpace(clause);
    System.out.println("Viet hoa chu cai dau la " + result);
    return result;
  }

  public static String removeSpace(String key) {
    String removeSpaces = key.replaceAll("\\s+", " ");
    System.out.println(removeSpaces);
    return removeSpaces;
  }

  public static void chuyenChuThuongThanhChuInHoa(String key) {
    System.out.println(key.toUpperCase());
  }

  public static void chuyenChuHoaThanhChuThuong(String key) {
    System.out.println(key.toLowerCase());
  }

  public static void chuyenCharThanhString(char key) {
    //cach 1: toString
    String str1 = Character.toString(key);
    System.out.println("Chuỗi là: " + str1);
    // cach 2: valueOf
    String str2 = String.valueOf(key);
    System.out.println("Chuỗi là: " + str2);

  }
  /*
    function.
    INPUT, OUTPUT
   */

  /*
      1. name function(verb + Noun)
      2. param truyen vao
      3. output cua function.
   */

  // lay danh sach cac con cua cha-me do.
  public static List<Student> getChildByParent(Parent parent) {
    // viet code lay ra dc List<Student>
    return new ArrayList<>();

  }
}







