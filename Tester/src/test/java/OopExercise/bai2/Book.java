package OopExercise.bai2;

public class Book extends Document{

  private String writerName;
  private int pageNumber;

  public Book(String writerName, int pageNumber,String documentCode, String imprint, int releaseNumber) {
    super(documentCode,imprint,releaseNumber);
    this.writerName = writerName;
    this.pageNumber = pageNumber;
  }
}
