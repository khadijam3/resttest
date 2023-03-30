package RestPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class GetList {

    @Test
    public void get_userList(){
        Response res=
                given()
                        .when()
                        .get("https://reqres.in/api/users?page=2")
                        .then().statusCode(200).log().body().extract().response();
        String jsonString= res.asString();
        assertThat(jsonString, containsString("0"));
    }


}


