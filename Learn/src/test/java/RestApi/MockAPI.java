package RestApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MockAPI {

    public RequestSpecification requestSpecification;

    public ResponseSpecification responseSpecification;

    public Response response;



    @BeforeTest
    public void createBookRequest(){
        RestAssured.baseURI="https://mocki.io/v1/da984a70-67bb-47f1-b695-8986b898a475";
        requestSpecification= RestAssured.given();
    }

    @Test(priority=1)
    public void executeTest(){
        response= requestSpecification.when().get();
    }

    @Test(priority=2)
    public void validateBookResponse(){
        System.out.println(response.asPrettyString());
        System.out.println(response.statusCode());
    }

}
