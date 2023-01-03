package steps;

import model.User;
import page.LoginPage;

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

