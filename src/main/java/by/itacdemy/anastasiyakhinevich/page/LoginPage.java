package by.itacdemy.anastasiyakhinevich.page;

import by.itacdemy.anastasiyakhinevich.waiters.Waiters;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class LoginPage extends BasePage {
    @FindBy(xpath = "//div[@data-active='false']//a[contains(text(), 'Log in')]")
    private WebElement loginBtn;
    @FindBy(id = "user")
    private WebElement fieldEmail;
    @FindBy(id = "login")
    private WebElement continueBtn;
    @FindBy(xpath = "//input[@id = 'password']")
    private WebElement fieldPasswd;
    @FindBy(id = "login-submit")
    private WebElement confirmPasswdBtn;
    @FindBy(id = "password-error")
    private WebElement msgErrorPasswd;
    @FindBy(id = "login-error")
    private WebElement msgIncorrectPasswd;
    @FindBy(xpath = "//button[@data-testid='header-member-menu-button']/div")
    private WebElement userName;

    public LoginPage clickLoginButton() {
        loginBtn.click();
        log.info("Click button LogIn");
        return this;
    }

    public LoginPage inputEmail(String data) {
        fieldEmail.sendKeys(data);
        log.info("Input Email in the field");
        return this;
    }

    public LoginPage confirmEmail() {
        continueBtn.click();
        log.info("Click button confirm email");
        return this;
    }

    public LoginPage inputPassword(String data) {
        Waiters.waitForVisibilityOfElement(fieldPasswd);
        fieldPasswd.sendKeys(data);
        log.info("Input password in the field");
        return this;
    }

    public LoginPage confirmPassword() {
        Waiters.waitForElementToBeClickable(confirmPasswdBtn);
        confirmPasswdBtn.click();
        log.info("Click button confirm password");
        return this;
    }

    public String getErrorMessagePassword() {
        Waiters.waitForVisibilityOfElement(msgErrorPasswd);
        String messageError = msgErrorPasswd.getText();
        log.info(String.format("Message of error password - %s",messageError));
        return messageError;
    }

    public String getMessageIncorrectPassword() {
        Waiters.waitForVisibilityOfElement(msgIncorrectPasswd);
        String messageIncorrectPassword = msgIncorrectPasswd.getText();
        log.info(String.format("Message of incorrect password - %s",messageIncorrectPassword));
        return messageIncorrectPassword;
    }
    public String getUserDate(){
        Waiters.waitForVisibilityOfElement(userName);
        return userName.getAttribute("title");
    }
}

