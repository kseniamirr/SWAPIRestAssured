package SWtest;

import common.Constants;
import common.EndPoint;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class PeopleTest {
    public static Response response;
    public static String jsonAsString;


    @Test
    public void testResultsContents1() {
        Response response = when().get("https://swapi.co/api/people").then().contentType(ContentType.JSON).extract().response();
        JsonPath jsonPath = response.jsonPath();
        List<Map> resultList = jsonPath.getList("results");
        assertEquals("Results array size is not correct", 10, resultList.size());
        testResultsAllElementContect(resultList.get(0));
    }

    public void testResultsAllElementContect(Map resultsElement) {
        assertEquals("Hair_color is not correct", "blond", resultsElement.get("hair_color"));
        List<String> films = (List<String>) resultsElement.get("films");
        return;
    }


    @Test
    public void getValidateStatusCode() {
        given().then().statusCode(200).log().all();
    }

    @Test
    public void checkHairColor() {
        given().get("https://swapi.co/api/people/1").then().assertThat().body("hair_color", equalTo("blond"));
    }

    @Test
    public void checkFirstName() {
        Response response = given().get(EndPoint.GET_PEOPLE_Param);
        response.then().body("name", equalTo("Luke Skywalker")).body("mass", equalTo("77"));
    }

    @Test
    public void checkCountOfPeople() {
        Response response = when().get("https://swapi.co/api/people").then().contentType(ContentType.JSON).extract().response();
        assertEquals("Value of \'count\' doesn't match", 87, response.path("count"));
    }

    @Test
    public void testResultsContent() {
        Response response = when().get("https://swapi.co/api/people").then().contentType(ContentType.JSON).extract().response();
        JsonPath jsonPath = response.jsonPath();
        List<Map> resultList = jsonPath.getList("results");
        assertEquals("Results array size is not correct", 10, resultList.size());
        testResultsFirstElementContect(resultList.get(0));

    }

    public void testResultsFirstElementContect(Map resultsElement) {
        assertEquals("Results[0].Name is not correct", "Luke Skywalker", resultsElement.get("name"));
    }

    @Test
    private void checkFilmsArraysAreEqual() {
        List<String> list11 = new ArrayList<String>(Arrays.asList("https://swapi.co/api/films/2/", "https://swapi.co/api/films/6/", "https://swapi.co/api/films/3/", "https://swapi.co/api/films/1/", "https://swapi.co/api/films/7/"));
        response = when().get("https://swapi.co/api/people").then().contentType(ContentType.JSON).extract().response();
        JsonPath jsonPath = response.jsonPath();

        List<String> list2 = response.jsonPath().get("results.films[0]");
        assertTrue(list2.equals(list11));

    }

}


    
 