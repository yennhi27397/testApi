package OopExercise.bai3;

import java.util.List;

public class CandidateB extends Candidates{

  public CandidateB(int identificationNumber, String name, String address, int priority) {
    super(identificationNumber, name, address, priority, List.of("Math", "Biology","Chemistry"));

  }


}
