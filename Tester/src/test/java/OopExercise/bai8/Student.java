package OopExercise.bai8;

public class Student {
  public String name;
  public int age;
  public String studentClass;

  public Student(String name, int age, String studentClass) {
    this.name = name;
    this.age = age;
    this.studentClass = studentClass;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getStudentClass() {
    return studentClass;
  }
}
