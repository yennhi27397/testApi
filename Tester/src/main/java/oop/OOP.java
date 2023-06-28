package oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OOP {
  public static void main(String[] args) {
    Map<String, Student> searchSystem = new HashMap<>();

    Student tracy = new Student("Tracy", "white", "active", 6);
    tracy.learn();
    searchSystem.put("12345", tracy);

    Student nemo = new Student("Nemo", "black ", "active", 5);
    nemo.learn();
    searchSystem.put("23456", nemo);

    Student andrea = new Student("Andrea", "white", "active", 7);
    andrea.learn();
    searchSystem.put("54321", andrea);

    Student nancy = new Student("Nancy", "white", "active", 6);
    nancy.learn();

    Student ken = new Student("Ken", "black", "active", 6);
    ken.learn();

    Teacher Nhi = new Teacher("Nhi", 25, "Female", 2000);
    ArrayList<Student> classroom = new ArrayList<>();
    classroom.add(tracy);
    classroom.add(nemo);
    classroom.add(nancy);
    List<Student> classroom1 = List.of(tracy, nancy, nemo);
    Nhi.teachEnglish(classroom1);
    Nhi.earnMoney();

    Teacher doan = new Teacher("Doan", 32, "Male", 5000);
    doan.teachEnglish(classroom);
    doan.earnMoney();

    doan.love(Nhi);
    Nhi.love(doan);


    Parent vinh = new Parent("Vinh", 50, "male", 3000);
    vinh.paySchoolFee(tracy, 500);

    Parent thang = new Parent("Thang", 35, "Male", 6000);
    thang.paySchoolFee(nemo, 1000);

    Park.allowPeopleToWalk();
    System.out.println(Park.name);
    Park.allowPeopleToPlayBadminton();

    vinh.eat();
    thang.sleep();
    doan.eat();
    doan.sleep();

    Student foundStudent = searchSystem.get("54321");
    if (foundStudent == null) {
      System.out.println("Student didn't found");
    } else {
      System.out.println(foundStudent.getName());
    }
  }
}

