package OopExercise.bai2;

public class Magazine extends Document{
  private int issueNumber;
  private int releaseMonth;

  public Magazine(int issueNumber, int releaseMonth, String documentCode, String imprint, int releaseNumber) {
    super(documentCode,imprint,releaseNumber);
    this.issueNumber = issueNumber;
    this.releaseMonth = releaseMonth;
  }
}
