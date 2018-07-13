import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

 class Configuration {

    private final static String PEOPLEPOINT = "https://swapi.co/api/people/1";

    private static Response doGetRequest(String serviceURL) {
        RestAssured.defaultParser = Parser.JSON;
        return
                given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                        when().get(serviceURL).
                        then().contentType(ContentType.JSON).extract().response();
    }

     static Response getPeopleResponse() {
         return doGetRequest(PEOPLEPOINT);
    }

    static Starship getStarshipResponse(String starshipURL) {
        Response response = doGetRequest(starshipURL);
        return response.getBody().as(Starship.class);
    }

}
