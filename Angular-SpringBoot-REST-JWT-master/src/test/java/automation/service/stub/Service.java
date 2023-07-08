package automation.service.stub;

import java.io.IOException;

public class Service {
  public static void main(String[] args) throws IOException {
    BankApiStub bankApiStub = new BankApiStub(9090);
  }
}
