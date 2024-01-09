package OopExercise;

public class exercise {
  public static void main(String[] args) {
/*
    int a = 6;
    a += 3;
    System.out.println(a);

    a -= 5;
    System.out.println(a);

    a *= 2;
    System.out.println(a);

    a %= 5;
    System.out.println(a);

    int b = 2;
    a -= (b + 7);
    System.out.println(a);
    System.out.println("====================================");

    int i1 = 2;
    int i2 = 5;
    int i3 = -3;
    double d1 = 2.0;
    double d2 = 2.0;
    double d3 = -0.5;
    System.out.println("i1 + (i2*i3)= " + (i1 + (i2 * i3)));
    System.out.println("i1 * (i2+i3)= " + (i1 * (i2 + i3)));
    System.out.println("i1 / (i2+i3)= " + (i1 / (i2 + i3)));
    System.out.println("i1 / i2+i3= " + (i1 / i2 + i3));
    System.out.println("3+4+5/3= " + ((double)3 + 4 + 5 / 3));
    System.out.println("(3+4+5)/3= " + ((double)(3 + 4 + 5) / 3));
    System.out.println("d1 + (d2*d3) = " + (d1+(d2*d3)));
    System.out.println("d1 + d2*d3 = " +( d1+d2*d3));
    System.out.println("d1 / d2-d3 = " + (d1/d2-d3));
    System.out.println("d1 / (d2-d3) = " + (d1/(d2-d3)));
    System.out.println("d1 + d2+d3/3 =" + ((double)d1+d2+d3/3));
*/


    /*Scanner scanner = new Scanner(System.in);
    System.out.println("Nhap ban kinh r: ");
    double r = scanner.nextDouble();
    double cv = 2 * Math.PI * r;
    double dt = Math.PI * Math.pow(r, 2);

    System.out.println("Chi vi hinh tron la: " + cv);
    System.out.println("Dien tich hinh tron la: " + dt);
    System.out.println("============================");

    Scanner scanner1 = new Scanner(System.in);
    System.out.println("Nhap chieu dai: ");
    double chieuDai = scanner1.nextDouble();

    System.out.println("Nhap chieu rong: ");
    double chieuRong = scanner1.nextDouble();

    double chuVi = (chieuDai + chieuRong) * 2;
    System.out.println("Chu vu HCN la " + chuVi);

    double dienTich = chieuRong * chieuDai;
    System.out.println("Dien tich HCN la: "+ dienTich);*/

    /*Scanner scanner2 = new Scanner(System.in);
    System.out.println("Nhap vao tong 2 diem: ");
    double tong = scanner2.nextDouble();

    System.out.println("Nhap vao hieu 2 diem: ");
    double hieu = scanner2.nextDouble();

    double x = (tong+hieu)/2;
    double y = (tong-hieu)/2;
    System.out.println("Gia tri x la: "+ x);
    System.out.println("Gia tri y la: "+ y);*/


    /*Scanner scanner3 = new Scanner(System.in);
    System.out.println("Nhap chieu cao: ");
    double chieuCao = scanner3.nextDouble();
    System.out.println("Nhap can nang: ");
    double canNang = scanner3.nextDouble();

    double BMI = canNang / Math.pow(chieuCao, 2);
    if (BMI < 15) {
      System.out.println("Than hinh gay");
    } else if (BMI >= 15 && BMI < 16) {
      System.out.println("Than hinh gay");
    } else if (BMI >= 16 && BMI < 18.5) {
      System.out.println("Than hinh hoi gay");
    } else if (BMI >= 18.5 && BMI < 25) {
      System.out.println("Than hinh binh thuong");
    } else if (BMI >= 25 && BMI < 30) {
      System.out.println("Than hinh hoi beo");
    } else if (BMI >= 30 && BMI < 35) {
      System.out.println("Than hinh beo");
    } else {
      System.out.println("Than hinh qua beo");
    }*/


    /*Scanner scanner4 = new Scanner(System.in);
    System.out.println("Nhap nam: ");
    int nam = scanner4.nextInt();

    if (nam % 4 == 0 && nam % 100 != 0) {
      System.out.println(nam + " la nam nhuan.");
    } else if (nam % 400 == 0) {
      System.out.println(nam + " la nam nhuan.");
    } else {
      System.out.println(nam + " khong la nam nhuan");
    }*/


    /*Scanner scanner5 = new Scanner(System.in);
    System.out.println("Nhap thang: ");
    int thang = scanner5.nextInt();

    if (thang == 1 || thang == 3 || thang == 5 || thang == 7 || thang == 8 || thang == 10 || thang == 12) {
      System.out.println("thang " + thang + " co 31 ngay");
    } else if (thang == 4 || thang == 6 || thang == 9 || thang == 11) {
      System.out.println("thang " + thang + " co 30 ngay");
    } else if (thang == 2) {
      System.out.println("Nhap nam: ");
      int nam = scanner5.nextInt();
      if (nam % 4 == 0 && nam % 100 != 0) {
        System.out.println("Thang " + thang + " nam " + nam + " co 29 ngay.");
      } else if (nam % 400 == 0) {
        System.out.println("Thang " + thang + " nam " + nam + " co 29 ngay.");
      } else {
        System.out.println("Thang " + thang + " nam " + nam + " co 28 ngay.");
      }
    } else {
      System.out.println("Thang khong hop le");
    }*/


    /*Scanner scanner6 = new Scanner(System.in);
    System.out.println("Nhap thang: ");
    int thang = scanner6.nextInt();
    if ((thang == 1) || (thang == 2) || (thang == 3)) {
      System.out.println("Thang " + thang + " thuoc quy 1.");
    } else if ((thang == 4) || (thang == 5) || (thang == 6)) {
      System.out.println("Thang " + thang + " thuoc quy 2.");
    } else if ((thang == 7) || (thang == 8) || (thang == 9)) {
      System.out.println("Thang " + thang + " thuoc quy 3.");
    }else if ((thang == 10) || (thang == 11) || (thang == 12)) {
      System.out.println("Thang " + thang + " thuoc quy 4.");
  } else {
      System.out.println("Thang khong hop le.");
    }*/


    /*Scanner scanner7 = new Scanner(System.in);
    System.out.println("Nhap vao diem trung binh: ");
    double diem = scanner7.nextDouble();
    String kq = (diem >= 8 && diem <= 10) ? "loai gioi"
        : ((diem < 8 && diem >= 6.5) ? "loai kha"
               : (diem < 6.5 && diem >= 5) ? "loai TB"
                      : (diem < 5) ? "loai yeu" : "diem khong hop le");

    System.out.println("Diem " + diem + " thuoc " + kq);*/


    /*Scanner scanner8 = new Scanner(System.in);
    System.out.println("Nhap thang: ");
    int thang = scanner8.nextInt();
    switch (thang) {
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12:
        System.out.println("thang " + thang + " co 31 ngay.");
        break;
      case 4:
      case 6:
      case 9:
      case 11:
        System.out.println("thang " + thang + " co 30 ngay.");
        break;
      case 2:
        System.out.println("thang " + thang + " co 28 hoac 29 ngay.");
        break;
      default:
        System.out.println("thang " + thang + " khong hop le.");
    }*/


    /*Scanner scanner9 = new Scanner(System.in);
    System.out.println("Moi ban so de chon: ");
    int so = scanner9.nextInt();
    switch (so){
      case 1:
        System.out.println("Tim theo ten");
        break;
      case 2:
        System.out.println("Tim theo tac gia");
        break;
      case 3:
        System.out.println("Tim theo nha xuat ban");
        break;
      case 4:
        System.out.println("Tim theo tieu de");
        break;
      default:
        System.out.println("Phim bam khong hop le");
    }*/




  }
}
