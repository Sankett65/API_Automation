package Demo;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class JsonParsingResponseData{


    //   Approach 1
    @Test
    public void approach1(){

               given()

                .when()
                       .get("https://reqres.in/api/users?page=2")

                .then()
                       .statusCode(200)
                       .body("data[0].id",equalTo(7))
                       .body("data[5].first_name",equalTo("Rachel"));
    }

    //  Approach 2

    @Test
    public void approach2(){

        Response response= given()
                .when()
                .get("https://reqres.in/api/users?page=2");

//        Assert.assertEquals(response.statusCode(),200);
//
//        String name=response.jsonPath().get("data[5].first_name").toString();
//        Assert.assertEquals(name,"Rachel");

        // JsonOject Class

        JSONObject data= new JSONObject(response.asString());   // converting response to jsonObject

       // To get every users first name
//        for (int i =0;i<data.getJSONArray("data").length();i++){
//            String name=data.getJSONArray("data").getJSONObject(i).get("first_name").toString();
//            System.out.println("First Name is :- "+name);
//        }

        //  to see if rachel name is there or not

        boolean status = false;

        for (int i =0;i<data.getJSONArray("data").length();i++){
            String name=data.getJSONArray("data").getJSONObject(i).get("first_name").toString();
            System.out.println("First Name is :- "+name);

            if (name.equals("Rachel")){
                status=true;
                System.out.println("Rachel name is present");
                break;
            }
        }

    }
}
