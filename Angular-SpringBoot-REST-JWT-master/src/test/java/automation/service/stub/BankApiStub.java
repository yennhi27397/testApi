package automation.service.stub;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import common.CommonUtil;
import org.apache.http.HttpStatus;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;

// WireMock
public class BankApiStub {
  private int port;
  // support api pha ke.
  private WireMockServer wireMockServer;

  public BankApiStub(int port) throws IOException {
    // call fake object API
    wireMockServer = new WireMockServer(port);
    wireMockServer.start();

    // GET Balance, 200
    // call path param
    wireMockServer.stubFor(WireMock.get(WireMock.urlEqualTo("/api/1/balance"))
      // return response
      .willReturn(WireMock.aResponse()
        // test status
        .withStatus(HttpStatus.SC_OK)
        // json content type
        .withHeader("content-type", "application/json")
        // read response body
        .withBody(CommonUtil.readFileContent("__files/balance.json"))));

    // GET Balance, 400
    // call path param
    wireMockServer.stubFor(WireMock.get(WireMock.urlEqualTo("/api/2/balance"))
      // return response
      .willReturn(WireMock.aResponse()
        // test status
        .withStatus(HttpStatus.SC_BAD_REQUEST)
        // json content type
        .withHeader("content-type", "application/json")
        // read response body
        .withBody(CommonUtil.readFileContent("__files/NotFoundAccount.json"))));


    // GET Balance, 500
    wireMockServer.stubFor(WireMock.get(WireMock.urlEqualTo("/api/5/balance"))
      .willReturn(WireMock.aResponse()
        .withHeader("content-type", "application/json")
        .withStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR)
        .withBody(CommonUtil.readFileContent("__files/InternalServerError.json"))));


    ///POST Withdraw,200
    wireMockServer.stubFor(WireMock.post(WireMock.urlEqualTo("/api/1/withdraw"))
      // required requestBody.
      .withRequestBody(equalToJson(CommonUtil.readFileContent("__files/RequestBodyWithdraw.json")))
      .willReturn(WireMock.aResponse()
        .withHeader("content-type", "application/json")
        .withStatus(HttpStatus.SC_OK)
        .withBody(CommonUtil.readFileContent("__files/Transaction.json"))));

    //POST Withdraw, 400
    wireMockServer.stubFor(WireMock.post(WireMock.urlEqualTo("/api/2/withdraw"))
      .withRequestBody(equalToJson(CommonUtil.readFileContent("__files/RequestBodyCustomerInsufficientFund.json")))
      .willReturn(WireMock.aResponse()
        .withHeader("content-type", "application/json")
        .withStatus(HttpStatus.SC_BAD_REQUEST)
        .withBody(CommonUtil.readFileContent("__files/Transaction400_Insufficient_Fund.json"))));


    //POST Withdraw Not Found CustomerID, 400
    wireMockServer.stubFor(WireMock.post(WireMock.urlEqualTo("/api/3/withdraw"))
      .withRequestBody(equalToJson(CommonUtil.readFileContent("__files/RequestBodyCanNotFindCustomerID.json")))
      .willReturn(WireMock.aResponse()
        .withHeader("content-type", "application/json")
        .withStatus(HttpStatus.SC_BAD_REQUEST)
        .withBody(CommonUtil.readFileContent("__files/TransactionCanNotFindCustomerID.json"))));


    //POST Withdraw INTERNAL SERVER ERROR, 500
    wireMockServer.stubFor(WireMock.post(WireMock.urlEqualTo("/api/4/withdraw"))
      .withRequestBody(equalToJson(CommonUtil.readFileContent("__files/RequestBodyWithdraw.json")))
      .willReturn(WireMock.aResponse()
        .withHeader("content-type", "application/json")
        .withStatus(HttpStatus.SC_BAD_REQUEST)
        .withBody(CommonUtil.readFileContent("__files/TransactionInternalServerError.json"))));
  }


  public void stop() {
    wireMockServer.stop();
  }
}

