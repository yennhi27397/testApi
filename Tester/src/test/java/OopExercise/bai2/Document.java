package OopExercise.bai2;

public class Document {
  protected String DocumentCode;
  protected String Imprint;
  protected int ReleaseNumber;

  public Document(String documentCode, String imprint, int releaseNumber) {
    DocumentCode = documentCode;
    Imprint = imprint;
    ReleaseNumber = releaseNumber;
  }

  public String getDocumentCode() {
    return DocumentCode;
  }

  public void setDocumentCode(String documentCode) {
    DocumentCode = documentCode;
  }

  public String getImprint() {
    return Imprint;
  }

  public void setImprint(String imprint) {
    Imprint = imprint;
  }

  public int getReleaseNumber() {
    return ReleaseNumber;
  }

  public void setReleaseNumber(int releaseNumber) {
    ReleaseNumber = releaseNumber;
  }
}
