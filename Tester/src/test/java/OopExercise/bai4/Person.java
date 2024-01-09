package OopExercise.bai4;

public class Person {
  public String name;
  public int age;
  public String career;
  protected int identification;

  public Person(String name, int age, String career, int identification) {
    this.name = name;
    this.age = age;
    this.career = career;
    this.identification = identification;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getCareer() {
    return career;
  }

  public int getIdentification() {
    return identification;
  }
}


