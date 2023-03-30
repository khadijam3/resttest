package RestPackage;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasItems;

public class Demo5basicValidationJsON {
    //test status code
    @Test(priority=1)
    public void testStatusCode(){
        //we delete given because we didn't have prerequasit
        //when any gerken come to the top dont need dot (.)
        //given() we can also write single line or multipleline
        //this is single line we can write on one line or as manyline up to us
        //given().when.get("http://jsonplaceholder.typicode.com/posts/5").then().statusCode().log().all();


        when()
                .get("http://jsonplaceholder.typicode.com/posts/5")
                .then()
                .statusCode(200);//.log().all();
    }
//2log response

    @Test(priority=2)
    public void testLogging(){
        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200);
    }
    @Test(priority=4)
    // verify multiple content in response body
    //copy the path on pathfinder then
    public void testMultipleContent(){
        given()
                .when()
                .get("https://reqres.in/api/users/")
                .then()
                .statusCode(200).body("data.first_name", hasItems("Janet","Emma","Eve"))
                .body("data.last_name", hasItems("Weaver","Wong","Holt"))
                .log().all();

    }
    @Test(priority=5)
    //setting parameter and header in get request
    public void testParamAndHeader(){
        given()
                .param("myName","khadija")
                .header("myheader", "lookinginfo")
                .when()
                .get("https://reqres.in/api/users/")
                .then()
                .statusCode(200)
                .log().all();

    }
}

