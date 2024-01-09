package OopExercise;

public class charjava {

  public static void main(String[] args) {
//    char ch = 'a';
//    char ch1 = 65;
//    char ch2;
//    System.out.println(ch);
//    System.out.println(ch1);
//
//    Scanner scanner = new Scanner(System.in);
//    System.out.println("Moi nhap vao ky tu: ");
//    String kiTu= scanner.nextLine();
//    ch2 = kiTu.charAt(3);
//    System.out.println(ch2);


//    StringBuilder chuoi = new StringBuilder();
//    chuoi.append("Xin chao, ");
//    chuoi.append("Tôi la Nhi");
//    chuoi.insert(3, "hello!");
//    chuoi.delete(3,9);
//    System.out.println(chuoi.length());


//contains: Kiểm tra chuỗi con
    /*String str = "mp3";
    String str1 = "Tôi nghe nhạc mp4";
    boolean check = str1.contains(str);
    if (check)
      System.out.println("có chứa trong chuỗi");
    else
      System.out.println("Không chứa trong chuỗi");*/


//substring: trích lọc chuỗi con từ chuỗi ban đầu
    /*String chuoi = "I love you";
    String chuoiCon = chuoi.substring(2,6);
    System.out.println(chuoi);
    System.out.println(chuoiCon);*/

//replace: Thay thế chuỗi

    String chuoi = "  hsdauhuda    ";
    String kq = chuoi.trim();
    System.out.println(chuoi);
    System.out.println(kq);

    //xóa khoảng trắng đầu
    //cách 1:
    String kq1 = chuoi.replaceFirst("^\\s+", "");
    System.out.println(kq1);

    //cách 2:
    /*while (chuoi.startsWith(" ")){
      chuoi = chuoi.substring(1);
    }
    System.out.println(chuoi);*/

    //xóa khoảng trắng cuối
    //cách 1
    String kq2 = chuoi.replaceAll("\\s+$", "");
    System.out.println(kq2);


    //spit tách chuỗi
    String s1 = "Hello, world";
    String[] mang = s1.split(", ");
    //duyet mang
    for (int i = 0; i < mang.length; i++) {
      System.out.println(mang[i]);
    }

    //tocharArray: tách chữ thành từng ký tự cho vào mảng
    String s2 = "acbc";
    char[] kiTu = s2.toCharArray();
    for (int j = 0; j < s2.length(); j++) {
      System.out.println(kiTu[j]);
    }

    String s3= "iloveyou123";
    StringBuilder sb = new StringBuilder(s3);
    sb.reverse();
    System.out.println(sb);
  }

}

