package OopExercise.bai4;

import java.util.ArrayList;
import java.util.List;

public class ApartmentManager {
  List<Apartment> town = new ArrayList<>();

  public void addApartment(Apartment resident) {
    town.add(resident);
  }

  public void showApartmentInfo() {
    for (Apartment apartment : town) {
      for (Person person : apartment.personalInformation) {
        System.out.println(String.format("numberMembers:%s, apartmentNumber:%s, name:%s, age:%s, career:%s, identification:%s",
            apartment.numberMembers, apartment.apartmentNumber, person.name, person.age, person.career, person.identification));
      }
    }
  }

  public List<Person> getPersonByName(String name) {
    List<Person> personList = new ArrayList<>();
    for (Apartment apartment : town) {
      for (Person person : apartment.personalInformation) {
        if (person.getName().equals(name)) {
          personList.add(person);
        }
      }
    }
    return personList;
  }

  public void printPersonInfo(List<Person> people) {
    for (Person person : people) {
      System.out.println(String.format("name:%s, age:%s, career:%s, identification:%s",
          person.name, person.age, person.career, person.identification));
    }
  }

  public Person getPersonByID(int ID) {
    for (Apartment apartment : town) {
      for (Person person : apartment.personalInformation) {
        if (person.getIdentification() == ID) {
          return person;
        }
      }
    }
    return null;
  }

  public void printPersonInfo(Person person) {
    System.out.println(String.format("name:%s, age:%s, career:%s, identification:%s",
        person.name, person.age, person.career, person.identification));

  }


  public Apartment getApartmentByPersonID(int ID) {
    for (Apartment apartment : town) {
      for (Person person : apartment.personalInformation) {
        if (person.getIdentification() == ID) {
          return apartment;
        }
      }
    }
    return null;
  }


  public void printApartmentByPersonID(Apartment apartment) {
    for (Person person : apartment.personalInformation) {
      System.out.println(String.format("numberMembers:%s, apartmentNumber:%s, name:%s, age:%s, career:%s, identification:%s",
          apartment.numberMembers, apartment.apartmentNumber, person.name, person.age, person.career, person.identification));
    }
  }

  public void deletePersonInfo(int id) {
    Apartment apartment = getApartmentByPersonID(id);
    Person person = getPersonByID(id);
    if (person != null) {
      apartment.personalInformation.remove(person);
    }
  }


}





