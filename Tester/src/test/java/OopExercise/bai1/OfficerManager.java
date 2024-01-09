package OopExercise.bai1;

import java.util.ArrayList;
import java.util.List;

public class OfficerManager {

  List<Officer> humanResources = new ArrayList<>();

  public void addNewOfficer(Officer officer) {
    humanResources.add(officer);
  }

  public Officer searchOfficerByName(String name) {
    for (Officer officer : humanResources) {
      if (officer.getName().equals(name)) {
        return officer;
      }
    }
    return null;
  }

  public void showOfficerInformation() {
    for (Officer officer : humanResources) {
      System.out.println(String.format("name:%s, age:%s, gender:%s, address:%s",
          officer.name, officer.age, officer.gender, officer.address));
    }
  }

  public void printOfficerDetail(Officer officer){
    System.out.println(String.format("name:%s, age:%s, gender:%s, address:%s",
        officer.name, officer.age, officer.gender, officer.address));
  }
}




