package Demo;

import io.restassured.matcher.RestAssuredMatchers;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class Xmlschema {

        @Test
        public void schema(){

            File file= new File("D:\\Automation Api\\Automation\\src\\test\\java\\output.xsd");

            given()
                    .when()
                    .get("http://restapi.adequateshop.com/api/Traveler")
                    .then()
                    .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath(String.valueOf(file)));

    }

}
