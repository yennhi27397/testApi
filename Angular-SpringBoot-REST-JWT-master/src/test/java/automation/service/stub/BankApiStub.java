package automation.service.stub;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import common.CommonUtil;
import org.apache.http.HttpStatus;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;

public class BankApiStub {
  private int port;
  // support api pha ke.
  private WireMockServer wireMockServer;

  public BankApiStub(int port) throws IOException {
    wireMockServer = new WireMockServer(port);
    wireMockServer.start();

    // GET Balance, 200
    wireMockServer.stubFor(WireMock.get(WireMock.urlEqualTo("/api/1/balance"))
      .willReturn(WireMock.aResponse()
        .withStatus(HttpStatus.SC_OK)
        .withHeader("content-type", "application/json")
        .withBodyFile("balance.json")));

    // GET Balance, 400
    wireMockServer.stubFor(WireMock.get(WireMock.urlEqualTo("/api/2/balance"))
      .willReturn(WireMock.aResponse()
        .withStatus(HttpStatus.SC_BAD_REQUEST)
        .withHeader("content-type", "application/json")
        .withBodyFile("NotFoundAccount.json")));

    // GET Balance, 500
    wireMockServer.stubFor(WireMock.get(WireMock.urlEqualTo("/api/3/balance"))
      .willReturn(WireMock.aResponse()
        .withStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR)
        .withHeader("content-type", "application/json")
        .withBodyFile("InternalServerError.json")));

    wireMockServer.stubFor(WireMock.post(WireMock.urlEqualTo("/api/1/withdraw"))
      .withRequestBody(equalToJson(CommonUtil.readBody("__files/requestBodyWithdraw.json")))
      .willReturn(WireMock.aResponse()
        .withHeader("content-type", "application/json")
        .withStatus(HttpStatus.SC_OK)
        .withBodyFile("Transaction.json")));
  }

  public void stop() {
    wireMockServer.stop();
  }
}
