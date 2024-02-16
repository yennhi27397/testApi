package exerciseCoding;

import java.awt.*;

public class RunCode {
  public static void main(String[] args) {
    ExerciseCode.sum2Number(2,3);

    int[] number = {1, 2, 3, 4, 5, 6, 7};
    ExerciseCode.sumNumbers(number);

    //ExerciseCode.sum2NumberScanner();

    // check 2 so chan le
    ExerciseCode.check2SoChanLe(1000);
    //ExerciseCode.check2SoChanLeScanner();

    //Cong 2 so phuc
    ExerciseCode.sumComplexNumber(1.2,4.3);


    ComplexNumber c1 = new ComplexNumber(2.4,2.4);
    ComplexNumber c2 = new ComplexNumber(2.4,4.5);
    ComplexNumber.Sum(c1,c2);

    //nhan 2 so
    ExerciseCode.nhan2So(7,4);
    //ExerciseCode.nhan2SoScanner();

    //check nam nhuan
    ExerciseCode.checkNamNhuan(2020);

    ExerciseCode.abc(2020);

    //check nguyen am phu am
    ExerciseCode.checkNguyenAmPhuAm('f');

    ExerciseCode.laiXuatKep(3000, 0.08,12, 5);

    ExerciseCode.tinhLaiXuat(2000,6, 3);

    ExerciseCode.layPhanNguyenPhanDu(894,53);

    ExerciseCode.xoaKhoangTrang("I  love  you");

    ExerciseCode.vietHoaChuCaiDau("nhi");

    ExerciseCode.standardize("pHam NgoC yEn nHI");

    ExerciseCode.chuyenChuThuongThanhChuInHoa("i can do it");

    ExerciseCode.chuyenChuHoaThanhChuThuong("I CAN DO IT");

    ExerciseCode.chuyenCharThanhString('a');

    ExerciseCode.removeSpace("i   love    you");

    // "Nguyen       Thap        Phi         Doan"
    System.out.println(ExerciseCode.removeSpace("Nguyen       Thap        Phi         Doan"));

  }

}
