package RestPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Demo2PosrRE {

    public static HashMap<String, String> map=new HashMap<>();
    @BeforeMethod
    public void PostData(){
        map.put("name",restUtil.getname());
        map.put("salary",restUtil.getsalary());
        map.put("age",restUtil.getAge());


        RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
        RestAssured.basePath="/create";
    }
    @Test
    public void postTest(){
        Response response=
                given()
                        .contentType("application/json")
                        .body(map)
                        .when()
                        . post()
                        .then().statusCode(200).log().all().extract().response();

        String jsonAsString= response.asString();
        Assert.assertTrue(jsonAsString.contains("123"));
        Assert.assertTrue(jsonAsString.contains("tester"));
        Assert.assertTrue(jsonAsString.contains("25"));
    }}
