package oAuthTest;

import io.restassured.path.json.JsonPath;
import oAuthTest.page.LoginRahulPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static io.restassured.RestAssured.given;

public class oAuthTest {
  public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

    WebDriver driver = new ChromeDriver();

    LoginRahulPage loginRahulPage = new LoginRahulPage(driver);

    loginRahulPage.navigate();
    loginRahulPage.enterEmailOrPhoneTextBox("yennhi27397@gmail.com");
    loginRahulPage.clickContinueButton();
    loginRahulPage.enterPasswordTextBox("yennhi27397$");
    loginRahulPage.clickContinueButton();

    String url = driver.getCurrentUrl();
    String partialcode = url.split("code=")[0];


    String getAccessTokenResponse = given().queryParam("code", partialcode)
        .queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
        .queryParam("grant_type", "authorization_code")
        .queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
        .queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
        .when().log().all().post("https://www.googleapis.com/oauth2/v4/token")
        .asString();
    JsonPath jsonPath = new JsonPath(getAccessTokenResponse);
    String accessToken = jsonPath.getString("access_token");


    String accessToken1 = given().queryParam("access_token", accessToken)
        .when().log().all().get("https://rahulshettyacademy.com/getCourse.php")
        .asString();

    System.out.println(accessToken1);
  }
}

