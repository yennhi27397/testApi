package OopExercise.bai2;

import java.util.ArrayList;
import java.util.List;

public class BookManagement {

  List<Document> library = new ArrayList<>();

  public void addNewDocument(Document document) {
    library.add(document);
  }

  public void deleteDocumentByDocumentCode(String documentCode) {
    for (Document document : library) {
      if (document.getDocumentCode().equals(documentCode)) {
        library.remove(document);
      }
    }
  }

  public void showDocumentInformation() {
    for (Document document : library) {
      System.out.println(String.format("DocumentCode:%s, ImPrint:%s, releaseNumber:%s",
          document.DocumentCode, document.Imprint, document.ReleaseNumber));
    }
  }

  public Document getDocumentByCode(String code) {
    for (Document document : library) {
      if (document.getDocumentCode().equals(code)) {
        return document;
      }
    }
    return null;
  }

  // in document
  public void printDocumentDetail(Document document) {
    System.out.println(String.format("DocumentCode:%s, InPrint:%s, releaseNumber:%s",
        document.DocumentCode, document.Imprint, document.ReleaseNumber));

  }


  // tim tat ca document ma co release number la 3
  public List<Document> getDocumentByReleaseNumber(int releaseNumber) {
    List<Document> documents = new ArrayList<>();
    for (Document doc : library) {
      if (doc.getReleaseNumber() == releaseNumber) {
        documents.add(doc);
      }
    }
    return documents;
  }


  public void printDocumentsDetail(List<Document> items) {
    for (Document doc : items) {
      System.out.println(String.format("DocumentCode:%s, ImPrint:%s, releaseNumber:%s",
          doc.DocumentCode, doc.Imprint, doc.ReleaseNumber));
    }
  }

  // chi lay Book co release number bang 3
  public List<Document> getBookByReleaseNumber(int releaseNumber){
    List<Document> documents = new ArrayList<>();
    for (Document doc : library) {
      if (doc.getReleaseNumber() == releaseNumber && doc instanceof Book) {
        documents.add(doc);
      }
    }
    return documents;
  }

}










