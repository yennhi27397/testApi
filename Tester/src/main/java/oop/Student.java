package oop;

public class Student extends Human {
  private String skinColor;
  private String character;


  public Student(String name, String skinColor, String character, int age) {
    this.name = name;
    this.skinColor = skinColor;
    this.character = character;
    this.age = age;
  }

  public void learn() {
    System.out.println(this.name + " dang hoc tieng anh");
  }

  public String getName() {
    return this.name;
  }
}
