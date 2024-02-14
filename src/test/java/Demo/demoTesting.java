package Demo;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class demoTesting {

    @Test(priority = 0)
    public void postmethod(){

//        HashMap<Object, Object> data = new HashMap<>();
//        data.put("id",1201);
//        data.put("username","Sanket");
//        data.put("firstName","Sanket");
//        data.put("lastName","Jadhav");
//        data.put("email","sanket@gmail.com");
//        data.put("password","Sanket");
//        data.put("phone","9847628174");
//        data.put("userStatus",10);

//        Using the JsonObject
//        JSONObject data1= new JSONObject();
//        data1.put("id",1201);
//        data1.put("username","Sanket");
//        data1.put("firstName","Sanket");
//        data1.put("lastName","Jadhav");
//        data1.put("email","sanket@gmail.com");
//        data1.put("password","Sanket");
//        data1.put("phone","9847628174");
//        data1.put("userStatus",10);
//
//        Response response = given()
//                .header("accept"," application/json")
//                .header("Content-Type","application/json")
//                .body(data1.toString())
//                .when().post("https://petstore.swagger.io/v2/user");
//        System.out.println(response.prettyPrint());
//        Assert.assertEquals(response.statusCode(),200);
//
//

        Response response = given()
                .header("accept"," application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": 1201,\n" +
                        "  \"username\": \"Sanket\",\n" +
                        "  \"firstName\": \"Sanket\",\n" +
                        "  \"lastName\": \"Jadhav\",\n" +
                        "  \"email\": \"sanket@gmail.com\",\n" +
                        "  \"password\": \"Sanket\",\n" +
                        "  \"phone\": \"9847628174\",\n" +
                        "  \"userStatus\": 10\n" +
                        "}"

                )
                .when().post("https://petstore.swagger.io/v2/user");
        System.out.println(response.prettyPrint());
                 Assert.assertEquals(response.statusCode(),200);
    }

    @Test(priority = 1)
    public void getmethod(){
        Response response = given()
                .header("accept"," application/json")
                .header("Content-Type","application/json")
                .queryParam("username","Sanket")
                .queryParam("Password","Sanket")
                .get("https://petstore.swagger.io/v2/user/login?username=username&password=Password");
        System.out.println(response.asString());
        Assert.assertEquals(response.statusCode(),200);

    }

    @Test(priority = 2)
    public void putMethod(){
        Response response = given()
                .header("accept"," application/json")
                .header("Content-Type","application/json")
                .queryParam("username","Sanket")
                .body("{\n" +
                        "\"id\": 1201,\n" +
                        "\"username\": \"Sanket\",\n" +
                        "\"firstName\": \"Sanket\",\n" +
                        "\"lastName\": \"Jadhav\",\n" +
                        "\"email\": \"jadhav.sanket@gmail.com\",\n" +
                        "\"password\": \"Sanket\",\n" +
                        "\"phone\": \"9847628174\",\n" +
                        " \"userStatus\": 10\n" +
                        "}")
                        .put("https://petstore.swagger.io/v2/user/username");
//                      .put("https://petstore.swagger.io/v2/user/Sanket");
        Assert.assertEquals(response.statusCode(),200);
    }


    @Test(priority = 3)
    public void deleteMethod(){
        Response response = given()
                .header("accept"," application/json")
//                .queryParam("Username","Sanket")
                .pathParams("Username","Sanket")
                .when().delete("https://petstore.swagger.io/v2/user/{Username}");
                response.prettyPrint();
        Assert.assertEquals(response.statusCode(),200);
    }


    @Test(priority = 4)
    public void postmethodWithList(){
        Response response = given()
                .header("accept"," application/json")
                .header("Content-Type","application/json")
                .body("[\n" +
                        "  {\n" +
                        "    \"id\": 1012,\n" +
                        "    \"username\": \"Aditya\",\n" +
                        "    \"firstName\": \"Aditya\",\n" +
                        "    \"lastName\": \"Sharma\",\n" +
                        "    \"email\": \"string\",\n" +
                        "    \"password\": \"Aditya\",\n" +
                        "    \"phone\": \"string\",\n" +
                        "    \"userStatus\": 1\n" +
                        "  },\n" +
                        "{\n" +
                        "    \"id\": 1013,\n" +
                        "    \"username\": \"Swapnil\",\n" +
                        "    \"firstName\": \"Swapnil\",\n" +
                        "    \"lastName\": \"Patil\",\n" +
                        "    \"email\": \"string\",\n" +
                        "    \"password\": \"Swapnil\",\n" +
                        "    \"phone\": \"string\",\n" +
                        "    \"userStatus\": 10\n" +
                        "  }\n" +
                        "]"

                ).when().post("https://petstore.swagger.io/v2/user/createWithList");
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(),200);
    }


    @Test(priority = 5)
    public void getWithLogin(){
        Response response = given()
                .header("accept"," application/json")
                .queryParam("Username","Aditya")
                .when().get("https://petstore.swagger.io/v2/user/Aditya");
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(),200);
    }


    @Test
    public void petpostMethod(){
        File file = new File("C:\\Users\\HP\\OneDrive\\Desktop\\dog.jpg");
        Response response = given()
                .header("accept"," application/json")
                .header("Content-Type","multipart/form-data")
                .multiPart(file)
                .when()
                .post("https://petstore.swagger.io/v2/pet/1012/uploadImage");

              response.prettyPrint();
        Assert.assertEquals(response.statusCode(),200);

    }

}
