package OopExercise.bai6;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
  List<StudentInfo> studentInfoList = new ArrayList<>();

  public void addStudent(StudentInfo school) {
    studentInfoList.add(school);
  }

  public void showStudentInfo() {
    for (StudentInfo studentInfo : studentInfoList)
      System.out.println(String.format("major:%s, name:%s, age:%s, hometown:%s",
          studentInfo.major, studentInfo.student.name, studentInfo.student.age, studentInfo.student.homeTown));
  }

  public List<StudentInfo> getStudentByAge(int age) {
    List<StudentInfo> studentInfos = new ArrayList<>();
    for (StudentInfo studentInfo : studentInfoList) {
      if (studentInfo.student.age == age) {
        studentInfos.add(studentInfo);
      }
    }
    return studentInfos;
  }

  public void showStudentInfo(List<StudentInfo> infos) {
    for (StudentInfo studentInfo : infos) {
      System.out.println(String.format("major:%s, name:%s, age:%s, hometown:%s",
          studentInfo.major, studentInfo.student.name, studentInfo.student.age, studentInfo.student.homeTown));
    }
  }

  public long getTotalStudentByAgeAndHomeTown(int age, String hometown) {
    List<StudentInfo> studentInfos = new ArrayList<>();
    for (StudentInfo studentInfo : studentInfoList) {
      if (studentInfo.student.age == age && studentInfo.student.homeTown.equals(hometown)) {
        studentInfos.add(studentInfo);
      }
    }
    return studentInfos.size();
  }

  public void showStudentInfo(long item) {
    System.out.println("So SV co tuoi 23 va song o DN la " + item);
  }
}




