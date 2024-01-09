package OopExercise.bai9;

public class Family {
  public String name;
  public String address;
  public int electricityMeterCode;

  public Family(String name1, String address1, int electricityMeterCode) {
    this.name = name1;
    this.address = address1;
    this.electricityMeterCode = electricityMeterCode;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public int getElectricityMeterCode() {
    return electricityMeterCode;
  }
}
