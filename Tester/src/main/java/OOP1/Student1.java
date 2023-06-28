package OOP1;

import java.util.List;

public class Student1 {
  private String name;
  private String character;
  private int age;
  private String skinColor;

  public Student1(String name, String character, int age, String skinColor) {
    this.name = name;
    this.character = character;
    this.age = age;
    this.skinColor = skinColor;
  }

  public String getName() {
    return this.name;
  }

  public void studyEnglish(List<Student1> student1s) {
    String listStudent = "";
    for (Student1 item : student1s) {
      listStudent = listStudent + " " + item.getName();
    }
    System.out.println(listStudent + " are studying English");
  }
}
