package Demo;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class XMLParsingResponse {

    //   Approach 1
    @Test
    public void parsingXmlResponse(){

        given()

                .when()
                .get("http://restapi.adequateshop.com/api/Traveler?page=1")

                .then()
                .statusCode(200)
                .body("TravelerinformationResponse.page",equalTo("1"))
                .body("TravelerinformationResponse.travelers.Travelerinformation[0].name",equalTo("Developer"));

    }

    @Test
    public void parsingXmlResponseusingApporach2(){

       Response response= given()

                        .when()
                        .get("http://restapi.adequateshop.com/api/Traveler?page=1");

        Assert.assertEquals(response.statusCode(),200);

        Assert.assertEquals(response.xmlPath().get("TravelerinformationResponse.page").toString(),"1");

        Assert.assertEquals(response.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name"),"Developer");


        XmlPath obj = new XmlPath(response.asString());

        List<String> numberoftraveller=obj.getList("TravelerinformationResponse.travelers.Travelerinformation");

        Assert.assertEquals(numberoftraveller.size(),10);

        List<String> nameoftravellers=obj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
        System.out.println(nameoftravellers);


        boolean status = false;
        for (String name:nameoftravellers){
          //  System.out.println(name);
            if (name.equals("Developer")){
                System.out.println("Name Found");
                status=true;
                break;
            }
        }

        Assert.assertEquals(status,true);

    }
}
