package by.itacdemy.anastasiyakhinevich.steps;

import by.itacdemy.anastasiyakhinevich.model.User;
import by.itacdemy.anastasiyakhinevich.page.LoginPage;

public class LoginStep extends LoginPage {

    public void logIn(User user) {
                clickLoginButton()
                .inputEmail(user.getEmail())
                .confirmEmail()
                .inputPassword(user.getPassword())
                .confirmPassword();
    }
    public String getActualUserDate(){
        return getUserDate();
    }

    public String loginErrorMessagePassword() {
        return getErrorMessagePassword();
    }

    public String loginIncorrectPasswordMessage() {
        return getMessageIncorrectPassword();
    }
}

