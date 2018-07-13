import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

public class PeopleStarshipTest {
    private final static List<Starship> starshipsExpectedResultList = new ArrayList<>();

    @Test
    public void getStarships() {
        Response response = Configuration.getPeopleResponse();
        List<String> starshipList = response.jsonPath().getList("starships");
        List<Starship> actualStarshipList = starshipList.stream().map(Configuration::getStarshipResponse).collect(Collectors.toList());
        assertEquals(starshipsExpectedResultList, actualStarshipList);
//        int ExpectedIndex;
//        for (String starshipURL : starshipList) {
//            Starship starshipActualResult = Configuration.getStarshipResponse(starshipURL);
//            ExpectedIndex = starshipsExpectedResultList.indexOf(starshipActualResult);
//           Assert.assertNotEquals("starship object is not defined as expected", -1, starshipActualResult.getName());
//            Starship starhipExpectedResult = starshipsExpectedResultList.get(ExpectedIndex);
//            assertStarship(starshipActualResult, starhipExpectedResult);
//        }
//    }
//
//    private void assertStarship(Starship strActualResult, Starship strExpectedResult) {
//        assertThat(strActualResult.getModel(), equalTo(strExpectedResult.getModel()));
//        assertThat(strActualResult.getManufacturer(), equalTo(strExpectedResult.getManufacturer()));
    }

    @BeforeTest
    private static void expectedResult() {

        Starship starship12 = new Starship("X-wing", "T-65 X-wing", "Incom Corporation", 149999,
                12.5, 1050, 1, 0, 110, "1 week", 1.0, 100, "Starfighter",
                new ArrayList<>(), new ArrayList<>(), "2014-12-12T11:19:05.340000Z", "2014-12-22T17:35:44.491233Z", "https://swapi.co/api/starships/12/");

        Starship starship22 = new Starship("Imperial shuttle", "Lambda-class T-4a shuttle", "Sienar Fleet Systems", 240000,
                20, 850, 6, 20, 80000, "2 months", 1.0, 50, "Armed government transport",
                new ArrayList<>(), new ArrayList<>(), "2014-12-15T13:04:47.235000Z", "2014-12-22T17:35:44.795405Z", "https://swapi.co/api/starships/22/");

        starshipsExpectedResultList.add(starship12);
        starshipsExpectedResultList.add(starship22);
    }
}



