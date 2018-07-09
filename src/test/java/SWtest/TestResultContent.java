package SWtest;

import common.Constants;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.when;

public class TestResultContent {

    List<Map> expectedResultList;
    List<Map> actualResultList;

    @BeforeTest
    public void testResultsContents() {
        JsonPath actualJsonPath = when().get("https://swapi.co/api/people").then().contentType(ContentType.JSON).extract().response().jsonPath();
        actualResultList = actualJsonPath.getList("results");

        JsonPath expectedJsonPath = new JsonPath(Constants.ETALON_JSON_STRING);
        expectedResultList = expectedJsonPath.getList("results");
    }

    @Test
    public void testResultArraySize() {
        Assert.assertEquals(actualResultList.size(), expectedResultList.size(), "Results array size is not correct");
    }

    @Test
    public void testResultArrayContent() {
        int i = 0;
        for (Map<String, ?> actualResult : actualResultList) {
            testResultElement(actualResult, expectedResultList.get(i++));
        }
    }

    private void testResultElement(Map<String, ?> actualResult, Map<String, ?> expectedResult) {
        Assert.assertEquals(actualResult.get("name"), expectedResult.get("name"), "Name is not equal");
    }
}
