package OopExercise.bai6;

public class StudentInfo {
  public String major;
  public Student student;

  public StudentInfo(String major, Student student) {
    this.major = major;
    this.student = student;
  }

  public String getMajor() {
    return major;
  }

  public Student getStudent() {
    return student;
  }
}
