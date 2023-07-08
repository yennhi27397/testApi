package com.app.model.customer;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class WithdrawRequest {
  private Integer accountId;
  private String amount;
}
