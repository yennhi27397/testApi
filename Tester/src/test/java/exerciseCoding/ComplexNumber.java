package exerciseCoding;

public class ComplexNumber {
  double real, img;

  public ComplexNumber(double real, double img) {
    this.real = real;
    this.img = img;
  }

  public static ComplexNumber Sum(ComplexNumber c1, ComplexNumber c2) {
    ComplexNumber temp = new ComplexNumber(0, 0);

    temp.real = c1.real + c2.real;//cộng các phần thực
    temp.img = c1.img + c2.img;//cộng các phần ảo

    System.out.printf("Kết quả là: "+ temp.real+" + "+ temp.img +"i");
    //trả về số phức đầu ra
    return temp;

  }


}

