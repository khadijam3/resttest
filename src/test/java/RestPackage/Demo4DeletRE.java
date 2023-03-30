package RestPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Demo4DeletRE {
    @Test
    public void deleteEmpRecord(){
        RestAssured.baseURI="https://dummy.restapiexample.com/public/api/v1";
        RestAssured.basePath="/delete/18";
        Response response=
                given()
                        .when()
                        .delete().
                        then().statusCode(200).log().all().extract().response();

        String jsonAsString= response.asString();
        Assert.assertTrue(jsonAsString.contains("success"));
    }
}

