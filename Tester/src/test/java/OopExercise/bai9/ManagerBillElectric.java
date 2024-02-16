package OopExercise.bai9;

import java.util.ArrayList;
import java.util.List;

public class ManagerBillElectric {

  List<Family> familyList = new ArrayList<>();

  List<Bill> billList = new ArrayList<>();

  public void addFamily(Family family) {
    familyList.add(family);
  }

  public void addBill(Bill bill) {
    billList.add(bill);
  }

  public void showFamilyInfo() {
    for (Family family : familyList) {
      System.out.println(String.format("name:%s, address:%s, electricityMeterCode:%s",
          family.name, family.address, family.electricityMeterCode));
    }
  }

  public void showBillInfo() {
    for (Bill bill : billList) {
      System.out.println(String.format("name:%s, address:%s, electricityMeterCode:%s, oldElectricityIndicator:%s, newElectricityIndicator:%s, totalPay:%s",
          bill.family.name, bill.family.address, bill.family.electricityMeterCode,
          bill.oldElectricityIndicator, bill.newElectricityIndicator, bill.totalPay));
    }
  }

  public Family getFamilyInfoByElectricityMeterCode(int electricityMeterCode) {
    for (Family family : familyList) {
      if (family.getElectricityMeterCode() == electricityMeterCode) {
        return family;
      }
    }
    return null;
  }

  public void showFamilyInfo1(Family family) {
    System.out.println(String.format("name:%s, address:%s, electricityMeterCode:%s",
        family.name, family.address, family.electricityMeterCode));
  }

  public void deleteFamilyInfoByElectricityMeterCode(int electricityMeterCode) {
    Family family = getFamilyInfoByElectricityMeterCode(electricityMeterCode);
    if (family != null) {
      familyList.remove(family);
    }
  }

  public Bill getBillByElectricityMeterCode(int electricityMeterCode) {
    for (Bill bill : billList) {
      if (bill.family.electricityMeterCode == electricityMeterCode) {
        return bill;
      }
    }
    return null;
  }

  public void showBillByElectricityMeterCode(Bill bill) {
    System.out.println(String.format("name:%s, address:%s, electricityMeterCode:%s, oldElectricityIndicator:%s, newElectricityIndicator:%s, totalPay:%s",
        bill.family.name, bill.family.address, bill.family.electricityMeterCode,
        bill.oldElectricityIndicator, bill.newElectricityIndicator, bill.totalPay));
  }

  public float getTotalOfBill(int electricityMeterCode) {
    Bill bill = getBillByElectricityMeterCode(electricityMeterCode);
    float total = (bill.getNewElectricityIndicator() - bill.getOldElectricityIndicator()) * 5;
    return total;

  }

  public void showTotalOfBill(float bill){
    System.out.println("Total of bill is: "+ bill);
  }
}
