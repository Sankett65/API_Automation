package Demo;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class RESREQ_API {

    @Test
    public void getUserList(){
        Response response = given()
                .header("accept"," application/json")
                .header("Content-Type","application/json")
                .get("https://reqres.in/api/users?page=2");
        response.prettyPrint();
        System.out.println(response);
        Assert.assertEquals(response.statusCode(),200);

    }

    @Test
    public void examle(){
        given()
                .header("accept"," application/json")
                .header("Content-Type","application/json")
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then().statusCode(200).log().all();
    }


}
