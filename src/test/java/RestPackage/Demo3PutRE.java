package RestPackage;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Demo3PutRE {


    public static HashMap<String, String> map=new HashMap<>();
    @Test
    public void getPut(){

        map.put("name",restUtil.getname());
        map.put("salary",restUtil.getsalary());
        map.put("age",restUtil.getAge());

        RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
        RestAssured.basePath="/update/13548";

        given()
                .contentType("application/json")
                .body(map)
                .when()
                .put()
                .then().statusCode(200).log().all();



    }


}
