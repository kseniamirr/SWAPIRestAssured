package sw;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;


public class SWConfiguration {
    public static Response response;
    public static String jsonAsString;

    public static void setUp() {
        RestAssured.baseURI = "https://swapi.co/api/";
        RestAssured.basePath = "/people";
    }

    @BeforeTest
    public static void callPeopleAPI() {
 //     response = when().get("/people").then().contentType(ContentType.JSON).extract().response();
//
//        jsonAsString = response.asString();
    }


//        ArrayList<Map<String,?>> jsonAsArrayList = from(response);

        // assertThat(jsonAsArrayList.size(), equalTo(3));
    }

