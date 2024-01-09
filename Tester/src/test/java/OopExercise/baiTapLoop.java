package OopExercise;

import java.util.Calendar;
import java.util.Scanner;

public class baiTapLoop {
  public static void main(String[] args) {


    /*int tong = 0;
    for (int i = 0; i <= 10; i++) {
      tong += i;
    }
    System.out.println("Tong tu 0 den 10 bang: " + tong);*/

//    Nhap so nguyen, in ra ket qua n! => vd: 3!= 1*2*3

    //for
   /* Scanner scanner =new Scanner(System.in);
    System.out.println("Nhap vao so nguyen: ");
    int gt = scanner.nextInt();
    int n =1;

    for (int i =1; i<=gt; i++){
      n = n*i;

        System.out.println(n);
      }*/

    //while
    /*int i =1 ;
    int gt =1;

    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhap vao so nguyen: ");
    int n = scanner.nextInt();
    while (i <= n) {
      gt = gt * i;
      i++;
    }
    System.out.println(n+" giai thua bang "+ gt);*/


//          Nhap a, neu a chan thi tinh tong cac so chan tu 0 den a
//          neu a le thi in ra "toi khong tinh tong so le"

    /*Scanner scanner2 = new Scanner(System.in);
    System.out.println("Nhap a: ");
    int a = scanner2.nextInt();
    int tong = 0;

    if (a % 2 == 0) {
      for (int i = 0; i <= a; i += 2) {
        tong = tong + i;
      }
      System.out.println("Tong cac so chan tu 0 den " + a + " la " + tong);
    } else {
      System.out.println("toi khong tinh tong so le");
    }*/

//          Viet chuong tring tinh tong cac so le tu 1 den n, n nhap tu ban phim
//        Nhap n =7, bo qua ko cong tong voi so 3 => in ra kq

    /*Scanner scanner2 = new Scanner(System.in);
    System.out.println("Nhap n: ");
    int n = scanner2.nextInt();
    int tong = 0;

    if (n % 2 != 0) {
      for (int i = 1; i <= n; i+=2) {
        if (i == 3) {
          continue;
        }
          tong = tong + i;
      }
        System.out.println("Tong cac so le cua " + n + " la " + tong);
    } else {
      System.out.println("Khong tinh tong cac so chan");
    }*/

//    Tim nhung so chia het cho 3 tu 10 den 50

    /*for (int i = 10; i <= 50; i++) {
      if (i % 3 == 0) {
        System.out.print(i+ " ");
      }
    }*/

//    Tinh tong S = 1!+2!+3!+...+10!

   /* int tong = 0;
    int gt = 1;
    for (int i = 1; i <= 10; i++) {
      gt *= i;
      tong +=gt;
    }
    System.out.println(tong);*/

//    tim so hoan hoa tu 0 den 1000 ( biet rang so hoan hao la so: Tong cac uoc thuc cua no bang chinh no)
//    vd: 6 = 1+2+3 (6)

    //Kiem tra xem 1 so co phai la so hoan hao

    /*int n = 10;
    int tong = 0;
    for (int i = 1; i < n; i++) {
      if (n % i == 0)
        tong += i;
    }
    if (n == tong)
      System.out.println(n + " la so hoan hao");
    else
      System.out.println(n + " khong phai la so hoan hao");*/

   /* for (int n = 1; n <= 1000; n++) {
      int tong = 0;
      for (int i = 1; i < n; i++) {
        if (n % i == 0)
          tong += i;
      }
      if (n == tong)
        System.out.println(n + " la so hoan hao");
    }*/
// Nhap a>0, check a co phai la so nguyen to khong, (so nguyen to la so chi co 2 uoc)

    /*int a;
    Scanner scanner3 = new Scanner(System.in);
    while (true) {
      System.out.println("Nhap a > 0: ");
       a = scanner3.nextInt();
      // check dieu kien dam bao nguoi dung nhap so nguyen a>0
      while (a <= 0) {
        System.out.println("Moi nhap lai a, a>0");
        a = scanner3.nextInt();
      }
      System.out.println("Nhap a thanh cong, a = " + a);
      // kiem tra so nguyen to (so nguyen to la so chi co 2 uoc)
      int demUoc = 0;
      for (int i = 1; i <= a; i++) {
        if (a % i == 0)
          demUoc++;
      }
      if (demUoc == 2)
        System.out.println(a + " la so nguyen to");
      else
        System.out.println(a + " ko la so nguyen to");

      System.out.println("ban co muon thoat, bam y de thoat: ");
      String traLoi = new Scanner(System.in).nextLine();
      if (traLoi.equalsIgnoreCase("y"))
        break;
    }*/

   /* Scanner scanner3 = new Scanner(System.in);
    while (true) {
      System.out.println("Nhap b > 0: ");
      int b = scanner3.nextInt();
      while (b <= 0) {
        System.out.println("Moi nhap lai b, b>0");
        b = scanner3.nextInt();
      }
      System.out.println("Ban da nhap dung, b = " + b);

      int uoc = 0;
      for (int i = 1; i <= b; i++) {
        if (b % i == 0)
          uoc++;
      }
      if (uoc == 2)
        System.out.println(b + " la so nguyen to");
      else
        System.out.println(b + " khong phai la so nguyen to");

      System.out.println("Ban co muon thoat chuong trinh khong, neu co nhap Y");
      String kq = new Scanner(System.in).nextLine();
      if (kq.equalsIgnoreCase("y")) ;
      break;
    }*/


    // for trong for

    /*for (int i = 1; i <= 7; i++) {
      for (int j = 1; j <= 7; j++) {
        System.out.print(i + "" + j + "\t");
      }
      System.out.println(" ");

    }*/
//    System.out.println("==========================");

    //vẽ hình chữ nhật

   /* for (int i = 1; i <= 7; i++) {
      for (int j = 1; j <= 7; j++) {
        if (i == 1 || i == 7 || j == 1 || j == 7)
          System.out.print(i + "" + j + "\t");
        else
          System.out.print("" + "\t");
      }
      System.out.println(" ");

    }*/
//    System.out.println("================================");

    //vẽ chữ N

    /*for (int i = 1; i <= 7; i++) {
      for (int j = 1; j <= 7; j++) {
        if (j == 1 || j == 7 || i == j)
          System.out.print(i + "" + j + "\t");
        else
          System.out.print("" + "\t");
      }
      System.out.println(" ");

    }*/

    //vẽ tháp

    /*for (int i = 1; i <= 7; i++) {
      for (int j = 1; j <= 7; j++) {
        if (i >= j)
          System.out.print(i + "" + j + "\t");
        else
          System.out.print("" + "\t");
      }
      System.out.println(" ");
    }*/

// bai tap for trong for
//a
    /*for (int i = 1; i <= 4; i++) {
      for (int j = 1; j <= 4; j++) {
        System.out.print("*" + "\t");
      }
      System.out.println(" ");
    }

    System.out.println("===============================");*/

//b
    /*for (int i = 1; i <= 4; i++) {
      for (int j = 1; j <= 4; j++) {
        if (i == 1 || i == 4 || j == 1 | j == 4)
          System.out.print("*" + "\t");
        else
          System.out.print("\t");
      }
      System.out.println(" ");
    }*/

//c
    /*for (int i = 1; i <= 4; i++) {
      for (int j = 1; j <= 4; j++) {
        if (i >= j)
          System.out.print("*" + "\t");
        else
          System.out.print("\t");
      }
      System.out.println(" ");*/

//d
    /*for (int i = 1; i <= 4; i++) {
      for (int j = 1; j <= 4; j++) {
        if (i == 4 || j == 1 || i == j)
          System.out.print("*" + "\t");
        else
          System.out.print("\t");
      }
      System.out.println(" ");
    }*/

//e
/*
    for (int i = 4; i >= 1; i--) {
      for (int j = 1; j <= i; j++) {
        if (i == 3 && j == 2)
          System.out.print("\t");
        else
          System.out.print("*" + "\t");
      }
      System.out.println(" ");

    }*/


//f
    /*for (int i = 4; i >= 1; i--) {
      for (int j = 1; j <= 4; j++) {
        if (i > j)
          System.out.print("\t");
        else
          System.out.print("*" + "\t");
      }
      System.out.println(" ");

    }*/

//g
    /*for (int i = 4; i >= 1; i--) {
      for (int j = 1; j <= 4; j++) {
        if (i > j || (i == 2 && j == 3))
          System.out.print("\t");
        else
          System.out.print("*" + "\t");
      }
      System.out.println(" ");
    }*/


//     Viết chuong trình nhập từ bàn phím 2 số a, b
//     Nhập 1 ký tự +-*/
//    1. nếu nhập + : Tính a+b và in ra kq
//    2. nếu nhập - : Tính a-b và in ra kq
//    3. nếu nhập * : Tính a*b và in ra kq
//    4. nếu nhập + : Tính a/b và in ra kq (ko chia được cho 0)

    //    Scanner scanner = new Scanner(System.in);
    //    System.out.println("Nhap a");
    //    double a = scanner.nextDouble();
    //    System.out.println("Nhap b");
    //    double b = scanner.nextDouble();
    //    System.out.println("Nhap phep tinh +-*/: ");
    //    String phepTinh = new Scanner(System.in).nextLine();
              /*
              switch (phepTinh){
                case "+":
                  Cong(a,b);
                  break;
                case "-":
                  Tru(a,b);
                  break;
                case "*":
                  Nhan(a,b);
                  break;
                case "/":
                  Chia(a,b);
                  break;
                default:
                  System.out.println("Phep tinh ko hop le");
                  break;
              }*/

    //    System.out.println("moi nhap vao phep tinh (+-*/)");
    //    String phepTinh = new Scanner(System.in).nextLine();
    //    calculator(a,b,phepTinh);


// Viet ct nhap vap ngay, thang, nam sinh
// Cho biet so tuoi va in ra man hinh

    int ngay, thang, nam, tuoi;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhap ngay: ");
    ngay = scanner.nextInt();
    while (ngay < 1 || ngay > 31) {
      System.out.println("Moi nhap lai ngay");
      ngay = scanner.nextInt();
    }
    System.out.println("Nhap thang: ");
    thang = scanner.nextInt();
    while (thang < 1 || thang > 12) {
      System.out.println("Moi nhap lai thang");
      thang = scanner.nextInt();
    }
    System.out.println("Nhap nam: ");
    nam = scanner.nextInt();
    while (nam < 1 || nam > 2023) {
      System.out.println("Moi nhap lai nam");
      nam = scanner.nextInt();
    }

    //khoi tao
    Calendar d = Calendar.getInstance();
    //set ngay thang nam sinh do ng dung nhap vao
    d.set(nam, (thang - 1), ngay);
    // get ngay thang nam sinh
    int namSinh = d.get(Calendar.YEAR);
    int thangSinh = d.get(Calendar.MONTH);
    int ngaySinh = d.get(Calendar.DATE);
    System.out.println(namSinh + "/" + (thangSinh + 1) + "/" + ngaySinh);

    //get năm hiện tại
    Calendar now = Calendar.getInstance();
    int namHienTai = now.get(Calendar.YEAR);
    // lay tuoi
    tuoi = namHienTai - namSinh;
    System.out.println("So tuoi la: " + tuoi);


  }

            /*public static void calculator(double a, double b, String phepTinh) {
              if (phepTinh.equals("+")) {
                System.out.println("Ket qua = " + (a + b));
              } else if (phepTinh.equals("-")) {
                System.out.println("Ket qua = " + (a - b));
              } else if (phepTinh.equals("*")) {
                System.out.println("Ket qua = " + (a * b));
              } else if (phepTinh.equals("/")) {
                if (b != 0)
                  System.out.println("Ket qua = " + (a / b));
                else
                  System.out.println("ko chia duoc cho 0");
              }*/

  //phep cong
          /*  public static void Cong(double a, double b) {
              double tong = a + b;
              System.out.println("Tong la " + tong);
            }*/

  //phep tru
            /*public static void Tru(double a, double b) {
              double tru = a - b;
              System.out.println("Hieu la " + tru);
            }*/

  //phep nhan
            /*public static void Nhan(double a, double b) {
              double nhan = a * b;
              System.out.println("Nhan la " + nhan);
            }*/

  //phep chia
            /*public static void Chia(double a, double b) {
              if (b != 0) {
                double chia = a / b;
                System.out.println("Thuong la " + chia);
              } else {
                System.out.println("khong chia duoc cho 0");
              }
            }*/
}







