package OopExercise.bai6;

public class Main {
  public static void main(String[] args) {

    Student thanh = new Student("Thanh", 23, "DN");
    Student thao = new Student("Thao", 21, "Ho Chi Minh");
    Student trang = new Student("Trang", 23, "DN");

    StudentInfo student1 = new StudentInfo("Kinh Te", thanh);
    StudentInfo student2 = new StudentInfo("Ke Toan", thao);
    StudentInfo student3 = new StudentInfo("Nhan Su", trang);

    StudentManager studentManager = new StudentManager();

    studentManager.addStudent(student1);
    studentManager.addStudent(student2);
    studentManager.addStudent(student3);

//    studentManager.showStudentInfo();
//    List<StudentInfo> studentInfo = studentManager.getStudentByAge(21);

     long item = studentManager.getTotalStudentByAgeAndHomeTown(23, "DN");
    studentManager.showStudentInfo(item);


  }
}
