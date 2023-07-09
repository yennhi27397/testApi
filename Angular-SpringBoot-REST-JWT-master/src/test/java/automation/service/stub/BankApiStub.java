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
        .withBody("__files/balance.json")));

    // GET Balance, 400
    wireMockServer.stubFor(WireMock.get(WireMock.urlEqualTo("/api/2/balance"))
      .willReturn(WireMock.aResponse()
        .withStatus(HttpStatus.SC_BAD_REQUEST)
        .withHeader("content-type", "application/json")
        .withBody("__files/NotFoundAccount.json")));

    // GET Balance, 500
    wireMockServer.stubFor(WireMock.get(WireMock.urlEqualTo("/api/3/balance"))
      .willReturn(WireMock.aResponse()
        .withStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR)
        .withHeader("content-type", "application/json")
        .withBody("__files/InternalServerError.json")));

    //POST Withdraw,200
    wireMockServer.stubFor(WireMock.post(WireMock.urlEqualTo("/api/1/withdraw"))
      .withRequestBody(equalToJson(CommonUtil.readBody("__files/requestBodyWithdraw.json")))
      .willReturn(WireMock.aResponse()
        .withHeader("content-type", "application/json")
        .withStatus(HttpStatus.SC_OK)
        .withBody("__files/Transaction.json")));

    //POST Withdraw,400
    wireMockServer.stubFor(WireMock.post(WireMock.urlEqualTo("/api/1/withdraw"))
      .withRequestBody(equalToJson(CommonUtil.readBody("__files/RequestBodyCanNotWithdraw.json")))
      .willReturn(WireMock.aResponse()
        .withHeader("content-type", "application/json")
        .withStatus(HttpStatus.SC_BAD_REQUEST)
        .withBody(CommonUtil.readBody("__files/Transaction400_Insufficient_Fund.json"))));

    //POST Withdraw,400
    wireMockServer.stubFor(WireMock.post(WireMock.urlEqualTo("/api/2/withdraw"))
      .withRequestBody(equalToJson(CommonUtil.readBody("__files/RequestBodyWithdraw.json")))
      .willReturn(WireMock.aResponse()
        .withHeader("content-type", "application/json")
        .withStatus(HttpStatus.SC_BAD_REQUEST)
        .withBody("__files/TransactionCanNotFindCustomerID.json")));

    //POST Withdraw,500
    wireMockServer.stubFor(WireMock.post(WireMock.urlEqualTo("/api/3/withdraw"))
      .withRequestBody(equalToJson(CommonUtil.readBody("__files/RequestBodyWithdraw.json")))
      .willReturn(WireMock.aResponse()
        .withHeader("content-type", "application/json")
        .withStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR)
        .withBody("__files/TransactionInternalServerError.json")));

  }

  public void stop() {
    wireMockServer.stop();
  }
}

