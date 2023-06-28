package oop;

import java.util.List;

public class Teacher extends Human {
  private int salary;
  private String toothbrush;


  public Teacher(String name, int age, String gender, int salary) { // contructor
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.salary = salary;
  }

  public void teachEnglish(List<Student> students) {
    String listName = "";
    for (Student item : students) {
      listName = listName + " " + item.getName();
    }
    System.out.println(this.name + " teach English for" + listName);
    System.out.println("i done work and feel tired");
    gotoBed();
  }

  public String getName() {
    return this.name;
  }

  public void love(Teacher teacher) {
    System.out.println(this.name + " love " + teacher.getName() + " so much");
  }

  public void earnMoney() {
    System.out.println(this.name + " get salary in " + "$" + salary);
  }

  private void gotoBed() {
    System.out.println(this.name + " di ngu");
  }

  protected void eat() {
    System.out.println(this.name + " eat broken rice");
  }

  protected void sleep() {
    System.out.println(this.name + " sleep in a house");
  }
}
