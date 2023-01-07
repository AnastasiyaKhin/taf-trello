package by.itacdemy.anastasiyakhinevich.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import by.itacdemy.anastasiyakhinevich.model.ApiUser;
import by.itacdemy.anastasiyakhinevich.model.Board;
import by.itacdemy.anastasiyakhinevich.utils.ConfigEnum;
import by.itacdemy.anastasiyakhinevich.utils.ConfigReader;

public class ApiSteps {

    private final String END_POINT = ConfigReader.getValue(ConfigEnum.API_URL);

    public Response createBoard(ApiUser author, String title) {

        Response response = RestAssured.given()
                .queryParam("name", title)
                .queryParam("key", author.getApiKey())
                .queryParam("token", author.getApiToken())
                .header("Content-type", "application/json")
            .when()
                .log().all()
                .post(END_POINT);
        response.then()
                .log().all();
        return response;
    }

    public Response deleteBoard(ApiUser author, Board board) {
        Response response = RestAssured.given()
                .queryParam("key", author.getApiKey())
                .queryParam("token", author.getApiToken())
                .header("Content-type", "application/json")
            .when()
                .log().all()
                .delete(END_POINT + board.getId());
        response.then()
                .log().all();
        return response;
    }

    public Response getBoard(ApiUser author, Board board) {
        Response response = RestAssured.given()
                .queryParam("key", author.getApiKey())
                .queryParam("token", author.getApiToken())
                .header("Content-type", "application/json")
            .when()
                .log().all()
                .get(END_POINT + board.getId());
        response.then()
                .log().all();
        return response;
    }

    public Response updateBoard(ApiUser author, String requestBody, Board board) {
        Response responseUpdate = RestAssured.given()
                .queryParam("key", author.getApiKey())
                .queryParam("token", author.getApiToken())
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
            .when()
                .log().all()
                .put(END_POINT + board.getId());
        responseUpdate.then()
                .log().all();
        return responseUpdate;
    }
}
