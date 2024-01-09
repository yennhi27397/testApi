package OopExercise.bai1;

public class Engineer extends Officer {
  public String major;

  public Engineer(String name, int age, String gender, String address, String major) {
    super(name, age, gender, address);
    this.major = major;
  }
}
