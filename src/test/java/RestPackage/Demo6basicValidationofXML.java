package RestPackage;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Demo6basicValidationofXML {
    //find single content in xml
    @Test(priority = 1)
    public void singleContentInXMl() {
        given()
                .when()
                .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
                .then()
                .statusCode(200).body("CUSTOMER.ID", equalTo("15"))
                .log().all();

    }
    @Test(priority = 2)
    public void multipleContentInXMl() {
        //find multiple content in xml
        given()
                .when()
                .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
                .then()
                .statusCode(200).body("CUSTOMER.ID", equalTo("15"))
                .body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
                .body("CUSTOMER.LASTNAME", equalTo("Clancy"))
                .body("CUSTOMER.STREET", equalTo("319 Upland Pl."))
                .body("CUSTOMER.CITY", equalTo("Seattle"));

    }
    //find multiple content in xml in one go
    @Test(priority = 3)
    public void multipleContentInXMlInOneGo() {
        //find multiple content in xml
        given()
                .when()
                .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
                .then()
                .statusCode(200).body("CUSTOMER.text()", equalTo("15BillClancy319 Upland Pl.Seattle"));


    }
    @Test(priority = 4)
    public void singleDataWithXpath1() {
        //find value useing xml path in xml response
        given()
                .when()
                .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
                .then()
                .statusCode(200).body(hasXPath("/CUSTOMER/FIRSTNAME ", containsString("Bill")));
    }
    @Test(priority = 4)
    public void singleDataWithXpath2() {
        //find value useing xml path in xml response
        given()
                .when()
                .get("http://thomas-bayer.com/sqlrest/INVOICE")
                .then()
                .statusCode(200).body(hasXPath("/INVOICEList/INVOICE[text()= '25'] ")).log().all();
    }
}