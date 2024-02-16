package OopExercise.bai3;

import java.util.ArrayList;
import java.util.List;

public class Candidates {
  protected int identificationNumber;
  protected String name;
  protected String address;
  protected int priority;
  protected List<String> subject = new ArrayList<>();


  public Candidates(int identificationNumber, String name, String address, int priority, List<String> subject) {
    this.identificationNumber = identificationNumber;
    this.name = name;
    this.address = address;
    this.priority = priority;
    this.subject = subject;
  }

  protected int getIdentificationNumber() {
    return identificationNumber;
  }


  protected List<String> getSubject() {
    return subject;
  }
}


