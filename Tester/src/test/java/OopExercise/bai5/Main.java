package OopExercise.bai5;


public class Main {
  public static void main(String[] args) {
    Room roomA = new RoomA("A", 500);
    Room roomB = new RoomB("B", 300);
    Room roomC = new RoomC("C", 100);


    Customer thu = new Customer("Thu", 34, 12345);
    Customer nga = new Customer("Nga", 45, 12385);
    Customer thanh = new Customer("Thanh", 23, 15345);


    Order order1 = new Order(3, roomA, thu);
    Order order2 = new Order(2, roomB, nga);
    Order order3 = new Order(1, roomC, thanh);

    HotelManager manager = new HotelManager();

    manager.addOrder(order1);
    manager.addOrder(order2);
    manager.addOrder(order3);

    manager.showOrder();

//    Order order = manager.getOrderByCustomerID(12345);
//    manager.showOrderByCustomerID(order);
//    manager.deleteOrderByCustomerID(12345);
//    manager.showOrder();

//    int day = manager.numDayRent(12385);
//    manager.printDayRent(day);

//    manager.totalOrderByID(12385);

    int total = manager.totalOrderByID(15345);
    manager.printTotalOfBill(total);
  }
}
