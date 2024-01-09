package OopExercise;

import java.util.*;

public class ArraylistExercise {
  public static void main(String[] args) {
    //set: thay doi thong tin
    ArrayList<Integer> mang = new ArrayList<>(List.of(1, 22, 35, 4, 5, 697, 2));
    mang.set(4, 24);
    System.out.println(mang);

    //
    ArrayList<Integer> mang1 = new ArrayList<>(List.of(1, 22, 35, 4, 5, 697, 2));
    System.out.println(mang1.get(6));

    //remove (xoa 1 phan tu dc chi dinh)
    ArrayList<Integer> mang2 = new ArrayList<>(List.of(1, 22, 35, 4, 5, 697, 2));
    mang2.remove(5);
    System.out.println(mang2);


    //contains(): Kiem tra Colection co chua element do hay ko?
    ArrayList<Integer> mang3 = new ArrayList<>(List.of(1, 22, 35, 4, 5, 697, 2));
    boolean i = mang3.contains(4);
    System.out.println(i);

    //Collections.sort(list): sx tang dan
    ArrayList<Integer> mang4 = new ArrayList<>(List.of(1, 22, 35, 4, 5, 697, 2));
    Collections.sort(mang4);
    System.out.println(mang4);

    //indexOf(): tim vi tri dau tien cua element trong list
    //neu ko ton tai tra ve -1
    ArrayList<Integer> mang5 = new ArrayList<>(List.of(1, 22, 35, 4, 5, 697, 2));
    System.out.println(mang5.indexOf(10));


    HashMap<String, Integer> dic = new HashMap<>();
    dic.put("user1", 12354456);
    dic.put("user2", 1234356);
    dic.put("user3", 12345634);
    dic.put("user4", 12345456);
    dic.put("user5", 1239456);
    dic.put("user6", 1238456);
    dic.put("user7", 1234856);
    dic.put("user8", 1234456);
    dic.put("user9", 1234456);
    dic.put("user10", 1232456);

    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhap username: ");
    String userName = scanner.nextLine();
    System.out.println("Nhap password: ");
    int passWord = new Scanner(System.in).nextInt();

    if (!dic.containsKey(userName)) {
      System.out.println("khong co username");
    } else if (!dic.get(userName).equals(passWord)) {
      System.out.println("Mat khau khong hop le");
    } else {
      System.out.println("Ban da dang nhap thanh cong");
    }
  }

}

