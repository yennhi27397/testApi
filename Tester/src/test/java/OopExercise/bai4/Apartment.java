package OopExercise.bai4;

import java.util.List;

public class Apartment {
  protected int numberMembers;
  protected String apartmentNumber;
  protected List<Person> personalInformation;

  public Apartment(int numberMembers, String apartmentNumber, List<Person> personalInformation) {
    this.numberMembers = numberMembers;
    this.apartmentNumber = apartmentNumber;
    this.personalInformation = personalInformation;
  }

  public int getNumberMembers(){
    return this.numberMembers;
  }

  public String getApartmentNumber(){
    return this.apartmentNumber;
  }

  public List<Person> getPersonalInformation(){
    return this.personalInformation;
  }


}

