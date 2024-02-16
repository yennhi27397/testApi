package OopExercise.bai5;

public class Order {
  public int numberOfDayRent;
  public Room room;
  public Customer customer;

  public Order(int numberOfDayRent, Room room, Customer customer) {
    this.numberOfDayRent = numberOfDayRent;
    this.room = room;
    this.customer = customer;
  }

  public int getNumberOfDayRent(){
    return numberOfDayRent;
  }
  public Room getRoom(){
    return room;
  }
  public Customer getCustomer(){
    return customer;
  }





}
