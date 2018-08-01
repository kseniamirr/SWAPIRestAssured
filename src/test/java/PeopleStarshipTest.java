import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class PeopleStarshipTest {

    final static String peoplePoint = "https://swapi.co/api/people/1";
    final static List<Starship> starshipsExpectedResultList = new ArrayList<Starship>();


    public static Response doGetRequest(String serviceURL) {
        RestAssured.defaultParser = Parser.JSON;
        return
                given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                        when().get(serviceURL).
                        then().contentType(ContentType.JSON).extract().response();
    }

    public Response getPeopleResponse() {
        Response response = doGetRequest(peoplePoint);
        return response;
    }

    public Starship getStarshipResponse(String starshipURL) {
        Response response = doGetRequest(starshipURL);
        Starship starship = response.getBody().as(Starship.class);
        return starship;
    }

    @Test
    public void getStarships() {
        Response response = getPeopleResponse();
        List<String> starshipList = response.jsonPath().getList("starships");
        int counter = 0;

        for (String starshipURL : starshipList) {
            Starship starshipActualResult = getStarshipResponse(starshipURL);
            Starship starhipExpectedResult = starshipsExpectedResultList.get(counter);
            counter = counter + 1;
            assertStarship(starshipActualResult, starhipExpectedResult);
        }

    }

    public void assertStarship(Starship strActualResult, Starship strExpectedResult) {
        assertThat(strActualResult.getModel(), equalTo(strExpectedResult.getModel()));
        assertThat(strActualResult.getManufacturer(), equalTo(strExpectedResult.getManufacturer()));
           }

    @BeforeTest
    public static void expectedResult() {

        Starship starship12 = new Starship("X-wing1", "T-65 X-wing", "Incom Corporation", 149999,
                12.5, 1050, 1, 0, 110, "1 week", 1.0, 100, "Starfighter",
                new ArrayList<String>(), new ArrayList<String>(), "2014-12-12T11:19:05.340000Z", "2014-12-22T17:35:44.491233Z", "https://swapi.co/api/starships/12/");

        Starship starship22 = new Starship("Imperial shuttle", "Lambda-class T-4a shuttle", "Sienar Fleet Systems", 240000,
                20, 850, 6, 20, 80000, "2 months", 1.0, 50, "Armed government transport",
                new ArrayList<String>(), new ArrayList<String>(), "2014-12-15T13:04:47.235000Z", "2014-12-22T17:35:44.795405Z", "https://swapi.co/api/starships/22/");

        starshipsExpectedResultList.add(starship12);
        starshipsExpectedResultList.add(starship22);

    }
}
