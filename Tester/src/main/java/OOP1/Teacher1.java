package OOP1;

import java.util.List;

public class Teacher1 {
  private String name;
  private String character;
  private int age;
  private String skinColor;

  public Teacher1(String name, String character, int age, String skinColor) {
    this.name = name;
    this.character = character;
    this.age = age;
    this.skinColor = skinColor;
  }

  public String getName() {
    return this.name;
  }

  public void teachEnglish(List<Student1> student1s) {
    String listStudent = "";
    for (Student1 item : student1s) {
      listStudent = listStudent + " " + item.getName();
    }
    System.out.println(this.name + " is a teacher of " + listStudent);
  }

  public void earnSalary(Teacher1 teacher1, int salary) {
    System.out.println(this.name + " and " + teacher1.getName() + " earn $" + salary + " every month");
  }

}
