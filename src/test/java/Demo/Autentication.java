package Demo;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Autentication {


    @Test
    public void basicauthentication(){

                 given()
                         .auth().basic("postman","password")
                .when()
                         .get("http://postman-echo.com/basic-auth")
                .then()
                         .statusCode(200)
                         .body("authenticated",equalTo(true))
                         .log().all();

    }
}
