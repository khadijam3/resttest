package RestPackage;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Demo1GetRE {


    @Test
    public void demoGet(){
        given()
                .when()
                .get("https://dummy.restapiexample.com/api/v1/employee/12")
                .then().statusCode(200).log().all()
                .body("data.employee_name",equalTo("Quinn Flynn"))
                .body("data.employee_salary",equalTo(342000))
                .body("data.employee_age",equalTo(22))
                .statusLine("HTTP/1.1 200 OK");








    }


}

