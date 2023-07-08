package com.app.model.bank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Balance {
  private String accountId;
  private String balance;
}
