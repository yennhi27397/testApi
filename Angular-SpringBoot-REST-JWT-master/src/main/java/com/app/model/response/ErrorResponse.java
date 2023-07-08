/**
 * This is the common structure for all responses
 * if the response contains a list(array) then it will have 'items' field
 * if the response contains a single item then it will have 'item'  field
 */


package com.app.model.response;

import lombok.Builder;
import lombok.Data;

@Data //for getters and setters
@Builder
public class ErrorResponse {
  private int status;
  private String error;
  private String message;
}
