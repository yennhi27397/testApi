package OopExercise.bai3;

import java.util.ArrayList;
import java.util.List;

public class CandidateA extends Candidates {
  public CandidateA(int identificationNumber, String name, String address, int priority) {
    super(identificationNumber, name, address, priority, List.of("Math", "Physic","Chemistry"));
  }

  public List<String> getSubject() {
    return subject;
  }
}

