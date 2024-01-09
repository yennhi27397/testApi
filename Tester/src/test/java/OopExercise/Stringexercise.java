package OopExercise;

import java.util.ArrayList;
import java.util.Scanner;

public class Stringexercise {
  public static void main(String[] args) {

    /*Nhap vao 1 chuoi tu ban phim
    Dem xem co bn ky tu thuong
    bao nhie in hoa
    bao nhieu so
    bao nhieu space
     */
    /*Scanner scanner = new Scanner(System.in);
    System.out.println("Nhap chuoi: ");
    String chuoi = scanner.nextLine();

    //gan bien den
      int demInThuong = 0;
      int demInHoa =0;
      int demSo =0;
      int demSpace =0;

      for (int i = 0; i<chuoi.length();i++){
        char kiTu = chuoi.charAt(i);
        if (Character.isLowerCase(kiTu)){
          demInThuong++;
        } else if (Character.isUpperCase(kiTu)) {
          demInHoa++;
        }else if (Character.isDigit(kiTu)) {
          demSo++;
        }else if (Character.isWhitespace(kiTu)) {
          demSpace++;
        }
      }
    System.out.println("So ki tu in thuong la: "+ demInThuong);
    System.out.println("So ki tu in hoa la: "+ demInHoa);
    System.out.println("So ki tu in so la: "+ demSo);
    System.out.println("So ki tu khoang trang la: "+ demSpace);*/


    /* String str1 = "English = 78 Science = 83 Math = 68 History = 65
    1. Tinh sum cac so trong chuoi tren
    2. Tinh trung binh cong */

    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhap chuoi: ");
    String chuoi = scanner.nextLine();

    int sum = 0;
    for (int i = 0; i < chuoi.length(); i++) {
      char kiTu = chuoi.charAt(i);
      if (Character.isDigit(kiTu)) {
        sum +=kiTu;
      }
    }
    System.out.println(sum);


   /* String[] pt = new String[]{"Chi Pheo", "Thi No", "Ong Giao"};
    for (int i = 0; i < pt.length; i++) {
      System.out.println(pt[i]);

    }
    pt[1] = "abama";
    for (int i = 0; i < pt.length; i++) {
      System.out.println(pt[i]);
    }

    int[] so = new int[]{1, 4, 2, 4, 6, 5, 7};
    for (int i = 0; i < so.length; i++) {
      System.out.print(so[i]);
      so[i] += 7;
    }
    System.out.println("----------------");

    for (int i = 0; i < so.length; i++) {
      System.out.println(so[i]);

    }*/




  }
}



