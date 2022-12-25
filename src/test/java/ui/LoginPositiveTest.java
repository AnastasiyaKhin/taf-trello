package ui;

import lombok.extern.log4j.Log4j2;
import model.User;
import org.testng.Assert;
import steps.LoginStep;
import org.testng.annotations.Test;
import ui.BaseTest;

@Log4j2
public class LoginPositiveTest extends BaseTest {

    @Test
    void testLogin() {
        log.info("Test login");

        LoginStep loginStep = new LoginStep();
        String expectedDataUser = "Anastasiya (oanastasia058)";

        loginStep.logIn(new User());

        Assert.assertEquals(loginStep.getActualUserDate(),expectedDataUser,"User's data does not match the data entered during login");
    }
}
