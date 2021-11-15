package org.example.Lesson6.Tumblr_Refractor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BaseViewTumblr {
    public Login(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "email")
    public WebElement inputLogin;

    @FindBy(name = "password")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement buttonLogin;

    public Login fillLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    public Login fillPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public void submitLogin() {
        buttonLogin.click();
    }
}
