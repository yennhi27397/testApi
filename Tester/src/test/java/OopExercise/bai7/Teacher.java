package OopExercise.bai7;

public class Teacher {
  public String name;
  public int age;
  public String homeTown;
  protected int codeNumber;

  public Teacher(String name, int age, String homeTown, int codeNumber) {
    this.name = name;
    this.age = age;
    this.homeTown = homeTown;
    this.codeNumber = codeNumber;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getHomeTown() {
    return homeTown;
  }

  public int getCodeNumber() {
    return codeNumber;
  }
}
