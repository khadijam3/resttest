package RestPackage;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class videoGame {
    @Test
    public void test_videoGame(){
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then().statusCode(200);
    }
    @Test
    public void post_request(){
        HashMap<String, String> data=new HashMap<>();
        data.put("name", "morpheus");
        data.put("job", "leader");
        data.put("id", "94");
        data.put("createdAt", "2022-11-22T21:24:31.684Z");
        Response res=
                given()
                        .contentType("application/json")
                        .body(data)
                        .when()
                        .post("https://reqres.in/api/users")
                        .then()
                        .statusCode(201).log().body()
                        .extract().response();
        String jsonString= res.asString();
        Assert.assertTrue(jsonString.contains("name"));



    }
    @Test
    public void get_post(){
        given()
                .when()
                .get("https://reqres.in/api/users/6")
                .then().statusCode(200).log().body();


    }


}

