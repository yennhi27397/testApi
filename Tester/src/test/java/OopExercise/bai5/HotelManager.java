package OopExercise.bai5;

import java.util.ArrayList;
import java.util.List;

public class HotelManager {
  List<Order> orderList = new ArrayList<>();

  public void addOrder(Order order) {
    orderList.add(order);
  }

  public void showOrder() {
    for (Order order : orderList) {
      System.out.println(String.format("numberOfDayRent:%s, room:%s, name:%s, age:%s, identification:%s",
          order.numberOfDayRent, order.room.loai, order.customer.name, order.customer.age, order.customer.identification));
    }
  }

  public Order getOrderByCustomerID(int ID) {
    for (Order order : orderList) {
      if (order.customer.getIdentification() == ID) {
        return order;
      }
    }
    return null;
  }

  public void showOrderByCustomerID(Order order) {
    System.out.println(String.format("numberOfDayRent:%s, loai:%s, name:%s, age:%s, identification:%s",
        order.numberOfDayRent, order.room.loai, order.customer.name, order.customer.age, order.customer.identification));

  }


  public void printOrderDetail(Order order) {
    System.out.println(String.format("numberOfDayRent:%s, room:%s, name:%s, age:%s, identification:%s",
        order.numberOfDayRent, order.room.loai, order.customer.name, order.customer.age, order.customer.identification));
  }

  public void deleteOrderByCustomerID(int ID) {
    Order order = getOrderByCustomerID(ID);
    if (order != null) {
      orderList.remove(order);
    }
  }


  public int totalOrderByID(int ID) {
    Order order = getOrderByCustomerID(ID);
    //so ngay thue * gia phong
    int total = order.numberOfDayRent * order.room.gia;
    return total;
  }

  public void printTotalOfBill(int total) {
    System.out.println("Total of Bill: " + total);
  }


}











