package OopExercise.bai9;

public class Bill {

  public Family family;
  public float oldElectricityIndicator;
  public float newElectricityIndicator;
  public float totalPay;

  public Bill(Family family, float oldElectricityIndicator, float newElectricityIndicator, float totalPay) {
    this.family = family;
    this.oldElectricityIndicator = oldElectricityIndicator;
    this.newElectricityIndicator = newElectricityIndicator;
    this.totalPay = totalPay;
  }

  public Family getFamily() {
    return family;
  }

  public float getOldElectricityIndicator() {
    return oldElectricityIndicator;
  }

  public float getNewElectricityIndicator() {
    return newElectricityIndicator;
  }

  public float getTotalPay() {
    return totalPay;
  }
}
