package OopExercise.bai8;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.List;

public class BorrowManagement {

  List<Card> cardList = new ArrayList<>();

  public void addCard(Card card) {
    cardList.add(card);
  }

  public void showCardList() {
    for (Card card1 : cardList) {
      System.out.println(String.format("code:%s, borrowDay:%s, borrowDeadline:%s, bookNumber:%s, name:%s, age:%s, studentClass:%s",
          card1.code, card1.borrowDay, card1.borrowDeadline, card1.bookNumber,
          card1.student.name, card1.student.age, card1.student.studentClass));
    }
  }

  public Card getBorrowInfoByCode(int code) {
    for (Card card : cardList) {
      if (card.getCode() == code) {
        return card;
      }
    }
    return null;
  }

  public void showBorrowInfoByCode(Card card) {
      System.out.println(String.format("code:%s, borrowDay:%s, borrowDeadline:%s, bookNumber:%s, name:%s, age:%s, studentClass:%s",
          card.code, card.borrowDay, card.borrowDeadline, card.bookNumber,
          card.student.name, card.student.age, card.student.studentClass));
    }


  public void deleteBorrowInfoByCode(int code) {
     Card card = getBorrowInfoByCode(code);
    if (card != null) {
      cardList.remove(card);
    }
  }


}
