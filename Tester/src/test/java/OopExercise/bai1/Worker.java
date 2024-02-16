package OopExercise.bai1;

public class Worker extends Officer {
  private int level;

  public Worker(String name, int age, String gender, String address, int level) {
    super(name, age, gender, address);
    this.level = level;
  }
}
