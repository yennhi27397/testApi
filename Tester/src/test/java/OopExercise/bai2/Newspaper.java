package OopExercise.bai2;

public class Newspaper extends Document{
  private int releaseDay;

  public Newspaper(int releaseDay,String documentCode, String imprint, int releaseNumber) {
    super(documentCode,imprint,releaseNumber);
    this.releaseDay = releaseDay;
  }
}
