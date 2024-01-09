package OopExercise.bai1;

public class Main {
   public static void main(String[] args) {

     Worker Minh = new Worker("Minh",35,"Male","Hoang Hoa Tham",6);
     Worker Thanh = new Worker("Thanh",45,"Male","Hoang Hoa Tham",7);
     Staff Nhan = new Staff("Nhan",23,"Male","Hoang Van Thu","Fix machine");
     Engineer Hoang = new Engineer("Hoang",45,"Male","Nguyen Oanh","Engineer");

     OfficerManager officerManager = new OfficerManager();
     officerManager.addNewOfficer(Thanh);
     officerManager.addNewOfficer(Minh);
     officerManager.addNewOfficer(Nhan);
     officerManager.addNewOfficer(Hoang);


     Officer searchOfficerByName = officerManager.searchOfficerByName("Hoang");
     officerManager.printOfficerDetail(searchOfficerByName);

     //officerManager.showOfficerInformation();
  }
}
