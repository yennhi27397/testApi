package OOP1;

import java.util.List;

public class Park1 {
  public static String name = "Cong vien Gia Dinh";

  public static void goToWalk(List<Teacher1> teacher1s, List<Student1> student1s) {
    String listTeacher = "";
    for (Teacher1 item : teacher1s) {
      listTeacher = listTeacher + " " + item.getName();
    }
    String listStudent = "";
    for (Student1 item1 : student1s) {
      listStudent = listStudent + " " + item1.getName();
    }
    System.out.println("Teacher" + listTeacher + " and" + listStudent + " can go to walk at " + Park1.name);
  }
}
