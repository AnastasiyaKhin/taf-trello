package by.itacdemy.anastasiyakhinevich.tests.ui;

import lombok.extern.log4j.Log4j2;
import by.itacdemy.anastasiyakhinevich.model.User;
import org.testng.Assert;
import by.itacdemy.anastasiyakhinevich.steps.LoginStep;
import org.testng.annotations.Test;

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
