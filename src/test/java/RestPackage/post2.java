package RestPackage;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class post2 {
    @Test
    public void testpost1() {
        HashMap<String,String> map =new HashMap<>();

        map.put("name","tester");
        map.put("salary","123000");
        map.put("age","25");
        //when you add the jason simple
        //JSONPObject request=new JSONPObject();
        //request.put("Name ","Mores");
        given()
                .header("content-Type","application/json")
                .body(map)
                .when()
                .post("https://dummy.restapiexample.com/api/v1/create")
                .then().statusCode(200).log().all().body("data.name",equalTo("tester"))
                .body("data.salary",equalTo("123000"))
                .body("data.age",equalTo("25"));

    }


}





