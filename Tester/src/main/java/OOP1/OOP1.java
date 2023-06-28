package OOP1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OOP1 {
  public static void main(String[] args) {
    Map<String, Student1> searchStudentID = new HashMap<>();

    Student1 amy = new Student1("Amy", "nice", 8, "white");// gọi Object
    Student1 nemo = new Student1("Nemo", "hyperactive", 8, "brown");

    List<Student1> student1List = List.of(amy, nemo);
    amy.studyEnglish(student1List);
    searchStudentID.put("12345", nemo);

    Teacher1 sam = new Teacher1("Sam", "friendly", 30, "brown");
    Teacher1 laura = new Teacher1("Laura", "nice", 30, "white");
    List<Teacher1> teacher1List = List.of(sam, laura);

    sam.teachEnglish(student1List);
    laura.earnSalary(sam, 2000);

    Park1.goToWalk(teacher1List, student1List);

    Student1 searchID = searchStudentID.get("1345");
    if (searchID == null) {
      System.out.println("Student didn't find");
    } else {
      System.out.println("Student is " + searchID.getName());
    }
  }
}
