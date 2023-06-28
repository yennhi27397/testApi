package oop;

public class Human {
  protected String name;
  protected String gender;
  protected int age;


  protected void eat() {
    System.out.println(this.name + " eat raw food");
  }

  protected void sleep() {
    System.out.println(this.name + " sleep in cave");
  }
}
