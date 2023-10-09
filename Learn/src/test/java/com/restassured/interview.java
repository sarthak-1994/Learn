package com.restassured;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class interview {

    public static void main(String[] args) {

        //Automate get request
        RestAssured.baseURI = "https://reqres.in/";
        Response response = given().queryParam("page", "2").when().get("/api/users");
        Assert.assertEquals(response.statusCode(), 200);
        JSONObject jsonObject = new JSONObject(response.asString());
        String id = jsonObject.getJSONArray("data").getJSONObject(0).get("id").toString();
        Assert.assertEquals(id, "7");

        //Automate Post request-
         String body="{\n" +
                 "    \"name\": \"morpheus\",\n" +
                 "    \"job\": \"leader\"\n" +
                 "}";

        Map<String,String> query=new HashMap<>();
        query.put("name","morpheus");
        query.put("job","leader");

       Response postResponse =given().body(body).when().post("/api/users");
       JSONObject postObject=new JSONObject(postResponse.asString());
       String name= postObject.getString("id");
       System.out.println(name);


       // automate delete Request -

         Response deleteResponse= given().when().delete("/api/users/2");
         int statusCode= deleteResponse.statusCode();
         Assert.assertEquals(statusCode,204);


         // File upload

       Response response1= given().multiPart("file",new File(""))
               .when().post("");
       int status= response1.getStatusCode();

       //Sending Multiple value in header
        given().header("application","json","jsaj");

        //use map for header when you are not passing multiple value for single header as map don't allow duplicate key.
        Map<String,String> header=new HashMap<>();
        header.put("SDSA","SDA");
        header.put("dsa","sad");
        given().headers(header);



    }

}
