package api;

import org.testng.annotations.Test;
import util.ConfigEnum;
import util.ConfigReader;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class BoardsApiTest {
    private final String apiKey = ConfigReader.getValue(ConfigEnum.API_KEY);
    private final String apiToken = ConfigReader.getValue(ConfigEnum.API_TOKEN);
    private final String endPoint = ConfigReader.getValue(ConfigEnum.API_URL);
    private String title = "Test";

    @Test
    void testCreateBoard() {

        given()
                .queryParam("name",title)
                .queryParam("key",apiKey)
                .queryParam("token",apiToken)
                .header("Content-type", "application/json")
        .when()
                .log().all()
                .post(endPoint)
        .then()
                .log().all()
                .statusCode(200);

    }
    @Test
    void testGetBoard(){
//        String endPoint = "https://api.trello.com/1/boards/{id}?key=APIKey&token=APIToken"; Это из документации!!!
        String id = "63a72633758c7c01e1115678"; // как достать id из теста выше???? (пока взяла из респонса теста createBoard)

        given()
                .queryParam("key",apiKey)
                .queryParam("token",apiToken)
                .header("Content-type", "application/json")
        .when()
                .log().all()
                .get(endPoint + id)

        .then()
                .log().all()
                .statusCode(200)
                .body("name",equalTo(title));

    }
    @Test
    void testUpdateBoard(){
//        String endPoint = "https://api.trello.com/1/boards/{id}?key=APIKey&token=APIToken"; Это из документации
        String id = "63a72633758c7c01e1115678"; // как достать id из теста выше???? (пока взяла из респонса теста createBoard)
        String newTitle = "Update Board";
        String requestBody = String.format("{\"name\":\"%s\"}", newTitle);

        given()
                .queryParam("key",apiKey)
                .queryParam("token",apiToken)
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
        .when()
                .log().all()
                .put(endPoint + id)
        .then()
                .log().all()
                .statusCode(200)
                .body("name",equalTo(newTitle));
    }
    @Test
    void testDeleteBoard(){
        String id = "63a72633758c7c01e1115678"; // как достать id из теста выше???? (пока взяла из респонса теста createBoard)
        given()
                .queryParam("key",apiKey)
                .queryParam("token",apiToken)
                .header("Content-type", "application/json")
        .when()
                .log().all()
                .delete(endPoint + id)
        .then()
                .log().all()
                .statusCode(200);
    }
}
