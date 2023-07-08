package com.app.repo;

import com.app.model.bank.Balance;
import com.app.model.bank.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class BankRepo {

  @Value("${bank.balance.api}")
  private String balanceApi;
  @Value("${bank.withdraw.api}")
  private String withdrawApi;

  public Balance getBalance(String accountId) {
    RestTemplate restTemplate = new RestTemplate();
    try {
      return restTemplate.getForObject(balanceApi.replace("{accountId}", accountId), Balance.class);
    } catch (Exception e) {
      var deBlance = new Balance();
      deBlance.setBalance("UNKNOWN");
      deBlance.setAccountId("UNKNOWN");
      return deBlance;
    }
  }

  public Transaction withdraw(String accountId, String amount) {
    RestTemplate restTemplate = new RestTemplate();
    Map<String, String> requestBody = new HashMap<>();
    requestBody.put("amount", amount);
    return restTemplate.postForObject(
      withdrawApi.replace("{accountId}", accountId)
      , requestBody
      , Transaction.class);
  }
}
