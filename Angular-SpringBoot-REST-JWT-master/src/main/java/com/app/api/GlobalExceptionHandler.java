package com.app.api;

import com.app.exception.BadRequestException;
import com.app.exception.BankBadRequestException;
import com.app.model.response.ErrorResponse;
import com.app.model.response.OperationResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import static com.app.model.response.OperationResponse.ResponseStatusEnum;

/*
@ControllerAdvice tells your spring application that this class will do the exception handling for your application.
@RestController will make it a controller and let this class render the response.
Use @ExceptionHandler annotation to define the class of Exception it will catch. (A Base class will catch all the Inherited and extended classes)
*/
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
  @ExceptionHandler(value = DataIntegrityViolationException.class)
  public Object handleBaseException(DataIntegrityViolationException e) {
    if (e.getCause() instanceof ConstraintViolationException) {
      ErrorResponse resp = ErrorResponse.builder()
        .status(400)
        .error("Constraint Violation of Resource")
        .message(e.getMessage())
        .build();
      return ResponseEntity.status(400).body(resp);
    }
    OperationResponse resp = new OperationResponse();
    resp.setOperationStatus(ResponseStatusEnum.ERROR);
    resp.setOperationMessage(e.getRootCause().getMessage());
    return resp;
  }

  @ExceptionHandler(value = {BadRequestException.class, HttpMessageNotReadableException.class})
  public ResponseEntity handleBadRequestException(RuntimeException e) {
    ErrorResponse resp = ErrorResponse.builder()
      .status(400)
      .error("Bad request data")
      .message("RequestBody is valid")
      .build();
    return ResponseEntity.status(400).body(resp);
  }

  @ExceptionHandler(value = {BankBadRequestException.class})
  public ResponseEntity handleBankBadRequestException(BankBadRequestException e) {
    ErrorResponse resp = ErrorResponse.builder()
      .status(400)
      .error("BANKING_INTERNAL_ERROR")
      .build();
    return ResponseEntity.status(400).body(resp);
  }
}
