package OopExercise.bai8;

public class Card {
  protected int code;
  public int borrowDay;
  public int borrowDeadline;
  public int bookNumber;
  public Student student;

  public Card(int code, int borrowDay, int borrowDeadline, int bookNumber, Student student) {
    this.code = code;
    this.borrowDay = borrowDay;
    this.borrowDeadline = borrowDeadline;
    this.bookNumber = bookNumber;
    this.student = student;
  }

  public int getCode() {
    return code;
  }

  public int getBorrowDay() {
    return borrowDay;
  }

  public int getBorrowDeadline() {
    return borrowDeadline;
  }

  public int getBookNumber() {
    return bookNumber;
  }

  public Student getStudent() {
    return student;
  }
}
