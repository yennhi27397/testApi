package OopExercise.bai9;

public class Main {
  public static void main(String[] args) {
    ManagerBillElectric managerBillElectric = new ManagerBillElectric();

    Family family1 = new Family("Quang", "123 Thong Nhat", 123);
    Family family2 = new Family("Nhan", "1278 Thong Nhat", 173);
    Family family3 = new Family("Quan", "133 Thong Nhat", 223);

    Bill bill1 = new Bill(family1, 24.3f, 25.7f, 267.34f);
    Bill bill2 = new Bill(family2, 21.9f, 54.7f, 484.29f);
    Bill bill3 = new Bill(family3, 44.3f, 53.5f, 698.02f);

   /* managerBillElectric.addFamily(family1);
    managerBillElectric.addFamily(family2);
    managerBillElectric.addFamily(family3);*/

    //managerBillElectric.showFamilyInfo();

   /* Family family = managerBillElectric.getFamilyInfoByElectricityMeterCode(23);
    managerBillElectric.showFamilyInfo1(family);*/

/*    managerBillElectric.deleteFamilyInfoByElectricityMeterCode(123);
    managerBillElectric.showFamilyInfo();*/


    managerBillElectric.addBill(bill1);
    managerBillElectric.addBill(bill2);
    managerBillElectric.addBill(bill3);

    //managerBillElectric.showBillInfo();

  /*  Bill bill = managerBillElectric.getBillByElectricityMeterCode(123);
    managerBillElectric.showBillByElectricityMeterCode(bill);*/

    float bill = managerBillElectric.getTotalOfBill(173);
    managerBillElectric.showTotalOfBill(bill);



  }
}
