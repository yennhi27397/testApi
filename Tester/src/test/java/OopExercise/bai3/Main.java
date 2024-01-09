package OopExercise.bai3;

public class Main {

  public static void main(String[] args) {

    Candidates minh = new CandidateA(123,"Minh","Hoang Hoa Tham",2);
    Candidates nhan = new CandidateB(345,"Nhan","Nguyen Oanh",4) ;
    Candidates tuyen = new CandidateC(234,"Tuyen","Nguyen Trai",3);
    Candidates trang = new CandidateA(567,"Trang","Nguyen Oanh",4);


    ManagerCandidate admissions = new ManagerCandidate();

    admissions.addNewCandidate(minh);
    admissions.addNewCandidate(nhan);
    admissions.addNewCandidate(trang);
    admissions.addNewCandidate(tuyen);


    admissions.showCandidateAndBlockInfo();

//    Candidates candidates = admissions.getCandidateByIdentificationNumber(234);
//    admissions.printCandidateDetail(candidates);
  }
}
