package RestPackage;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CreateNewEMP {
    @Test
    public void  createNewEmp(){
        HashMap<String, String> map=new HashMap<>();
        map.put("id","13");
        map.put("email","khadija.habi@reqtes.in");
        map.put("first_name", "khadija");
        map.put("last_name", "rasikh");
        map.put( "avatar", "https://reqres.in/img/faces/12-image.jpg");


        given()
                .header("content-Type","application/json")
                .body(map)
                .when()
                .post("https://reqres.in/api/users")
                .then().statusCode(201).log().all();
    }

    public void getAllEmployees(){

        given()
                .when()
                .get("https://reqres.in/api/users/12")
                .then().statusCode(200).log().all();
    }



    public void  createPutRe(){
        HashMap<String, String> map=new HashMap<>();
        map.put("id","13");
        map.put("email","massoud.habi@reqtes.in");
        map.put("first_name", "Massoud");
        map.put("last_name", "Rasolj");
        map.put( "avatar", "https://reqres.in/img/faces/12-image.jpg");
        given()
                .header("content-Type","application/json")
                .body(map)
                .when()
                .post("https://reqres.in/api/users")
                .then().statusCode(201).log().all();
    }

}
