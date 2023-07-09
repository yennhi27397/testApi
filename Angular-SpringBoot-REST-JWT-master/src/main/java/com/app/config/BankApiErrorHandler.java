package com.app.config;

import com.app.exception.BadRequestException;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class BankApiErrorHandler extends DefaultResponseErrorHandler {

  @Override
  public void handleError(ClientHttpResponse response) throws IOException {
    if (response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError()) {
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.getBody()))) {
        String httpBodyResponse = reader.lines().collect(Collectors.joining());
        throw BadRequestException.builder().errorMsg(httpBodyResponse).build();
      }
    }
  }
}
