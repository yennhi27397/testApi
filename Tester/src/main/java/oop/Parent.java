package oop;

public class Parent extends Human {
  private int salary;

  public Parent(String name, int age, String gender, int salary) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.salary = salary;
  }

  public void paySchoolFee(Student student, int money) {
    System.out.println(this.name + " pay school fee for " + student.getName() + " with fee are $" + money);
  }

}

