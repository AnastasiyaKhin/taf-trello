package api;

import io.restassured.response.Response;
import model.ApiUser;
import model.Board;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import steps.ApiSteps;

public class BoardsApiTest {
    private ApiSteps apiSteps;
    private Response response;
    private Response responseUpdate;
    private Board board;
    private ApiUser author = new ApiUser();
    private String title = "Test";

    @Test
    public void testCreateBoard() {
        apiSteps = new ApiSteps();
        response = apiSteps.createBoard(author, title);
        board = response.as(Board.class);

        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void testGetBoard() {
        apiSteps = new ApiSteps();
        response = apiSteps.createBoard(author, title);
        board = response.as(Board.class);

        apiSteps.getBoard(author, board);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(board.getName(), title);
    }

    @Test
    public void testUpdateBoard() {
        String newTitle = "Update Board";
        String requestBody = String.format("{\"name\":\"%s\"}", newTitle);

        apiSteps = new ApiSteps();
        response = apiSteps.createBoard(author, title);
        board = response.as(Board.class);

        responseUpdate = apiSteps.updateBoard(author, requestBody, board);
        Board updateBoard = responseUpdate.as(Board.class);

        Assert.assertEquals(responseUpdate.statusCode(), 200);
        Assert.assertEquals(updateBoard.getName(), newTitle);
    }

    @Test
    public void testDeleteBoard() {
        apiSteps = new ApiSteps();
        response = apiSteps.createBoard(author, title);
        board = response.as(Board.class);
        apiSteps.deleteBoard(author, board);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertNull(board._value, "Board is not delete");
    }

    @AfterMethod
    public void deleteBoard() {
        apiSteps.deleteBoard(author, board);
    }
}
