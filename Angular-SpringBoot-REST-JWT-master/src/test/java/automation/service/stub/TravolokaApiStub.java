package automation.service.stub;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.http.HttpStatus;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;

public class TravolokaApiStub {
  private int port;
  private WireMockServer wireMockServer;

  public TravolokaApiStub(int port) throws IOException {
    wireMockServer = new WireMockServer(port);
    wireMockServer.start();

    wireMockServer.stubFor(WireMock.get(WireMock.urlEqualTo("/api/1/balance"))
      .willReturn(WireMock.aResponse()
        .withStatus(HttpStatus.SC_OK)
        .withHeader("content-type", "application/json")
        .withBodyFile("balance.json")));

    wireMockServer.stubFor(WireMock.post(WireMock.urlEqualTo("/api/1/balance"))
      .withRequestBody(equalToJson("{\"amount\":\"100\"}"))
      .willReturn(WireMock.aResponse()
        .withHeader("content-type", "application/json")
        .withStatus(HttpStatus.SC_OK)
        .withBodyFile("BalanceAfterWithdraw.json")));


    //----------------------------

    wireMockServer.stubFor(WireMock.get(WireMock.urlEqualTo("/api/order=1"))
      .withHeader("Authentication", containing("1232131232131"))
      .willReturn(WireMock.aResponse()
        .withStatus(HttpStatus.SC_OK)
        .withBodyFile("employee.sql")));

    wireMockServer.stubFor(WireMock.post(WireMock.urlEqualTo("/api/order"))
      .withHeader("Authentication", containing("1232131232131"))
      .withRequestBody(equalToJson("{}"))
      .willReturn(WireMock.aResponse()
        .withStatus(HttpStatus.SC_OK)
        .withBodyFile("employee.sql")));

    wireMockServer.stubFor(WireMock.delete(WireMock.urlEqualTo("/api/order/1"))
      .withHeader("Authentication", containing("1232131232131"))
      .willReturn(WireMock.aResponse()
        .withStatus(HttpStatus.SC_OK)
        .withBodyFile("employee.sql")));

    wireMockServer.stubFor(WireMock.put(WireMock.urlEqualTo("/api/order/1"))
      .withHeader("Authentication", containing("1232131232131"))
      .withRequestBody(equalToJson("{}"))
      .willReturn(WireMock.aResponse()
        .withStatus(HttpStatus.SC_OK)
        .withBodyFile("employee.sql")));

    wireMockServer.stubFor(WireMock.patch(WireMock.urlEqualTo("/api/order/1"))
      .withHeader("Authentication", containing("1232131232131"))
      .withRequestBody(equalToJson("{}"))
      .willReturn(WireMock.aResponse()
        .withStatus(HttpStatus.SC_OK)
        .withBodyFile("employee.sql")));
  }

  public void stop() {
    wireMockServer.stop();
  }
}
