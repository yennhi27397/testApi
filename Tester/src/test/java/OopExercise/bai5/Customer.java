package OopExercise.bai5;

public class Customer {
  public String name;
  public int age;
  protected int identification;

  public Customer(String name, int age, int identification) {
    this.name = name;
    this.age = age;
    this.identification = identification;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public int getIdentification() {
    return identification;
  }


}

