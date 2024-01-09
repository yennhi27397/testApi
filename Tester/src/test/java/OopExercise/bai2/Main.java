package OopExercise.bai2;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    Book book1 = new Book("Doan", 1000, "1", "1", 1);
    Magazine magazine1 = new Magazine(2, 2, "2", "2", 2);
    Newspaper newspaper1 = new Newspaper(3, "3", "3", 3);
    Magazine magazine3 = new Magazine(3, 3, "3", "3", 3);

    BookManagement bookManagement = new BookManagement();

    bookManagement.addNewDocument(book1);
    bookManagement.addNewDocument(magazine3);
    bookManagement.addNewDocument(newspaper1);
    bookManagement.addNewDocument(magazine1);


    //bookManagement.deleteDocumentByDocumentCode("2");

    bookManagement.showDocumentInformation();

    //Document doc = bookManagement.getDocumentByCode("2");
    //bookManagement.printDocumentDetail(doc);

    //List<Document> items = bookManagement.getDocumentByReleaseNumber(3);

    //bookManagement.printDocumentsDetail(items);

    /*List<Document> result = bookManagement.getBookByReleaseNumber(1);
    bookManagement.printDocumentsDetail(result);*/

  }
}
