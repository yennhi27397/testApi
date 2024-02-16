package OopExercise.bai4;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    List<Person> family1 = new ArrayList<>();
    Person Thai = new Person("Thai", 45, "KD", 234566);
    Person Thuy = new Person("Thuy", 40, "KD", 234569);
    Person Thu = new Person("Trang", 25, "HS", 234563);
    family1.add(Thai);
    family1.add(Thuy);
    family1.add(Thu);


    List<Person> family2 = new ArrayList<>();
    Person Thanh = new Person("Thanh", 48, "KD", 233566);
    Person Trang = new Person("Trang", 47, "KD", 234269);
    Person Trung = new Person("Trung", 30, "KD", 234863);
    Person Mai = new Person("Mai", 20, "HS", 234823);
    family2.add(Thanh);
    family2.add(Trang);
    family2.add(Trung);
    family2.add(Mai);


    Apartment apartment1 = new Apartment(3, "23 Nguyen Oanh", family1);
    Apartment apartment2 = new Apartment(4, "25 Nguyen Oanh", family2);

    ApartmentManager apartmentManager = new ApartmentManager();

    apartmentManager.addApartment(apartment1);
    apartmentManager.addApartment(apartment2);


//    List<Person> town= apartmentManager.getPersonByName("Thuy");
//    apartmentManager.printPersonInfo(town);

//    Apartment apartment = apartmentManager.getApartmentByPersonID(234823);
//    apartmentManager.printApartmentByPersonID(apartment);

//    apartmentManager.deletePersonInfo(234823);

   apartmentManager.showApartmentInfo();


  }
}
