package OopExercise;

import java.util.ArrayList;
import java.util.List;

public class filterInArrayObject {

  public static void main(String[] args) {
    // filter in array, object
    List<Integer> array1 = List.of(1,3,5,34,24,43,5,2);
    List<Integer> number = new ArrayList<>();
    for (int i : array1){
      if (i<10){
        number.add(i);
      }
    }
    System.out.println("Cac so nho hon 10 la: " + number);


    List<Student> studentList = new ArrayList<>();
    studentList.add(new Student(26,"Nhi"));
    studentList.add(new Student(31,"Doan"));
    studentList.add(new Student(24,"Vy"));
    List<Student> studentList1 = new ArrayList<>();
    for (Student student: studentList){
      if (student.age<30){
        studentList1.add(student);
      }
    }
    for (Student i : studentList1){
      System.out.print(i.name+" ");
    }
  }
}
