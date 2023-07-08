package com.app.model.bank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Transaction extends Balance {
  private String transactionId;
  private String status;
  private String amount;
  private String errorCode;
}
