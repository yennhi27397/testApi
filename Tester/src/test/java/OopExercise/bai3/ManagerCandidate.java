package OopExercise.bai3;

import java.util.ArrayList;
import java.util.List;

public class ManagerCandidate {

  List<Candidates> candidatesList = new ArrayList<>();


  public void addNewCandidate(Candidates candidates) {
    candidatesList.add(candidates);
  }

  public void showCandidateAndBlockInfo() {
    for (Candidates candidates : candidatesList) {
      System.out.println(String.format("identificationNumber:%s, name:%s, address:%s, priority:%s, subject:%s",
          candidates.identificationNumber, candidates.name, candidates.address, candidates.priority, candidates.subject));
    }
  }

  public Candidates getCandidateByIdentificationNumber(int Number) {
    for (Candidates candidates : candidatesList) {
      if (candidates.getIdentificationNumber() == Number) {
        return candidates;
      }
    }
    return null;
  }

  public void printCandidateDetail(Candidates candidates) {
    System.out.println(String.format("identificationNumber:%s, name:%s, address:%s, priority:%s",
        candidates.identificationNumber, candidates.name, candidates.address, candidates.priority));
  }

}
