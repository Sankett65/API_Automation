package Demo;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;


public class HeaderAndCookiesAndLog {

    @Test
    public void getSinglecookie(){

        Response response= given()
                .when()
                .get("https://www.google.com/");

        String cookie=response.getCookie("AEC");

        System.out.println("Value of cookie AEC :-"+cookie);
    }

    @Test
    public void getEverycookiesPresent(){

        Response response= given()
                .when()
                .get("https://www.google.com/");

       Map<String,String> cookies= response.getCookies();
        System.out.println(cookies.keySet());

       for (String k :cookies.keySet()){
            String x=response.cookie(k);
           System.out.println(k+"----->"+x );
       }
    }

    @Test
    public void getHeaderPresent(){

        Response response= given()
                .when()
                .get("https://www.google.com/");

        String header=response.getHeader("Server");

        System.out.println("Value of Header server :-"+header);

    }


    @Test
    public void getEveryheaderPresent(){

        Response response= given()
                .when()
                .get("https://www.google.com/");

        Headers header= response.getHeaders();
        //System.out.println(header);

        for (Header h :header){
            System.out.println(h.getName()+"----->"+h.getValue() );
        }
    }


    @Test
    public void log(){
        given()
                .when()
                .get("https://www.google.com/")
                .then()
//                .log().all();
//                .log().cookies();
//                .log().headers();
                .log().body();
    }

}
