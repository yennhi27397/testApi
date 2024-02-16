package OopExercise.bai3;

import java.util.List;

public class CandidateC extends Candidates{


  public CandidateC(int identificationNumber, String name, String address, int priority) {
    super(identificationNumber, name, address, priority, List.of("Literature","History","Geography"));

  }


}
