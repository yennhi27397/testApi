package OopExercise.bai7;

import java.util.ArrayList;
import java.util.List;

public class OfficerManager {

  List<Officer> officerList = new ArrayList<>();

  public void addOffice(Officer officer) {
    officerList.add(officer);
  }

  public void showOfficerInfo() {
    for (Officer officer : officerList) {
      System.out.println(String.format("luongCung:%s, luongThuong:%s, tienPhat:%s, name:%s, age:%s, hometown:%s, code number:%s ",
          officer.luongCung, officer.luongThuong, officer.tienPhat, officer.teacher.name,
          officer.teacher.age, officer.teacher.homeTown, officer.teacher.codeNumber));
    }
  }

  public void printOfficerInfo() {
    for (Officer officer : officerList)
      System.out.println(String.format("luongCung:%s, luongThuong:%s, tienPhat:%s, name:%s, age:%s, hometown:%s, code number:%s ",
          officer.luongCung, officer.luongThuong, officer.tienPhat, officer.teacher.name,
          officer.teacher.age, officer.teacher.homeTown, officer.teacher.codeNumber));
  }


  public void printOfficerInfo(Officer officer) {
    System.out.println(String.format("luongCung:%s, luongThuong:%s, tienPhat:%s, name:%s, age:%s, hometown:%s, code number:%s ",
        officer.luongCung, officer.luongThuong, officer.tienPhat, officer.teacher.name,
        officer.teacher.age, officer.teacher.homeTown, officer.teacher.codeNumber));
  }

  public Officer getOfficerByCodeNumber(int codeNumber) {
    for (Officer officer : officerList) {
      if (officer.teacher.getCodeNumber() == codeNumber) {
        return officer;
      }
    }
    return null;
  }


  public float checkOutSalary(int codeNumber) {
    Officer officer = getOfficerByCodeNumber(codeNumber);
    float salary = (officer.luongCung + officer.luongThuong) - officer.tienPhat;
    return salary;
  }

  public void printSalary(float salary) {
    System.out.println("Total of salary: " + salary);
  }

//  public Teacher getTeacherByCodeNumber(int codenumber) {
//    for (Officer officer : officerList) {
//      for (Teacher teacher : officer.teacher.getCodeNumber()) {
//        if (teacher.getCodeNumber() == codenumber) {
//          return teacher;
//        }
//      }
//    }
//    return null;
//  }


  public void deleteOfficer(int codeNumber) {
    Officer officer = getOfficerByCodeNumber(codeNumber);
  }
}

