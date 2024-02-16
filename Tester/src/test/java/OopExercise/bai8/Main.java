package OopExercise.bai8;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    BorrowManagement borrowManagement = new BorrowManagement();

    Student Loan = new Student("Loan", 16, "12A3");
    Student Toan = new Student("Toan", 16, "12A5");
    Student Thu = new Student("Thu", 15, "11B5");


    Card card1 = new Card(1234, 23,30, 12, Loan );
    Card card2 = new Card(1232, 3,12, 125, Toan );
    Card card3 = new Card(1236, 23,26, 187, Thu );

    borrowManagement.addCard(card1);
    borrowManagement.addCard(card2);
    borrowManagement.addCard(card3);

    //borrowManagement.showCardList();

    /*Card cards = borrowManagement.getBorrowInfoByCode(1236);
    borrowManagement.showBorrowInfoByCode(cards);*/

    borrowManagement.deleteBorrowInfoByCode(1234);
    borrowManagement.showCardList();


  }
}
