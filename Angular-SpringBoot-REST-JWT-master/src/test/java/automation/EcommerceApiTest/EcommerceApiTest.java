package automation.EcommerceApiTest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class EcommerceApiTest {
  public static void main(String[] args) {

    //Login and get Token
    RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
      .setContentType(ContentType.JSON).build();

    LoginRequest loginRequest = new LoginRequest();
    loginRequest.setUserEmail("yennhi27397@gmail.com");
    loginRequest.setUserPassword("Hello123@");

    RequestSpecification requestSpecification = given().log().all().spec(req).body(loginRequest);
    LoginResponse response = requestSpecification.when().post("/api/ecom/auth/login")
      .then().log().all().statusCode(200).extract().response().as(LoginResponse.class);

    System.out.println("Token: " + response.getToken());
    String token = response.getToken();
    System.out.println("userId: " + response.getUserId());
    String userId = response.getUserId();
    System.out.println("message: " + response.getMessage());


    //Create product
    RequestSpecification createProduct = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
      .addHeader("Authorization", token).build();

    RequestSpecification req1 = given().spec(createProduct).param("productName", "Clothes")
      .param("productAddedBy", userId).param("productCategory", "fashion")
      .param("productSubCategory", "shirts").param("productPrice", 11500)
      .param("productDescription", "Addias Originals").param("productFor", "women")
      .multiPart("productImage", new File("C:\\Users\\Admin\\Pictures\\java\\Screenshot 2023-08-30 104703.png"));

    String res = req1.when().post("/api/ecom/product/add-product")
      .then().log().all().extract().response().asString();

    JsonPath js = new JsonPath(res);
    String productId = js.get("productId");
    System.out.println("productId: " + productId);


    //Create Order
    RequestSpecification createOrder = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
      .addHeader("Authorization", token).setContentType(ContentType.JSON).build();

    OrderDetail orderDetail = new OrderDetail();
    orderDetail.setCountry("USA");
    orderDetail.setProductOrderedId(productId);

    List<OrderDetail> orderDetailList = new ArrayList<>();
    orderDetailList.add(orderDetail);

    Orders orders = new Orders();
    orders.setOrder(orderDetailList);

    RequestSpecification req2 = given().spec(createOrder).body(orders);
    String responseCreateOrder = req2.when().post("/api/ecom/order/create-order")
      .then().log().all().extract().response().asString();

    System.out.println(responseCreateOrder);

//Delete Product
    RequestSpecification deleteProduct = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
      .addHeader("Authorization", token).setContentType(ContentType.JSON).build();

    RequestSpecification del = given().spec(deleteProduct).pathParam("productId",productId);
      String result = del.when().delete("/api/ecom/product/delete-product/{productId}")
      .then().log().all().extract().response().asString();
    System.out.println(result);
  }
}
