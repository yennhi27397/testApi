package com.app.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class BankBadRequestException extends RuntimeException {
  private String errorMsg;
  private String errorCode;
}
