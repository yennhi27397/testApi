package OopExercise.bai7;

import java.util.HashMap;

public class Main {
  public static void main(String[] args) {

    OfficerManager officerManager = new OfficerManager();

    Teacher hoai = new Teacher("Hoai", 34, "Ho Chi Minh", 34563);
    Teacher thanh = new Teacher("Thanh", 37, "Nha Trang", 34469);
    Teacher thu = new Teacher("Thu", 43, "Can Tho", 34599);
    Teacher minh = new Teacher("Minh", 33, "Da Nang", 34500);
    Teacher linh = new Teacher("Linh", 30, "Ho Chi Minh", 30063);


    Officer officer1 = new Officer(5676f, 5845f, 200f, hoai);
    Officer officer2 = new Officer(5634f, 6754f, 100f, thu);
    Officer officer3 = new Officer(5421f, 5856f, 0, thanh);
    Officer officer4 = new Officer(6643f, 4385f, 150f, minh);
    Officer officer5 = new Officer(5687f, 4998f, 200f, linh);

    officerManager.addOffice(officer1);
    officerManager.addOffice(officer2);
    officerManager.addOffice(officer3);
    officerManager.addOffice(officer4);
    officerManager.addOffice(officer5);


    officerManager.printOfficerInfo();

//    officerManager.deleteOfficer(30063);
//    officerManager.printOfficerInfo();

//    Officer officer = officerManager.getOfficerByCodeNumber(34500);
//    officerManager.printOfficerInfo(officer);

//    officerManager.showOfficerInfo();

//    float salary = officerManager.checkOutSalary(34563);
//    officerManager.printSalary(salary);

  /*  HashMap<String, Integer> information = new HashMap<>();

    information.put("Thanh", 30);
    information.put("Thao", 23);
    information.put("Huy", 34);

    for (String i : information.keySet()) {
      System.out.println("Name: " + i + " and age: " + information.get(i));
*/

    }
  }
