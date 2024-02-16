package OopExercise.bai1;

public class Staff extends Officer {
  private String work;

  public Staff(String name, int age, String gender, String address, String work) {
    super(name, age, gender, address);
    this.work = work;
  }
}
