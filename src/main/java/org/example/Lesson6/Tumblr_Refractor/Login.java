package org.example.Lesson6.Tumblr_Refractor;

import io.qameta.allure.Step;
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

    @Step("Заполнение логина")
    public Login fillLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    @Step("Заполнение пароля")
    public Login fillPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    @Step("Нажатие на кнопку входа в систему")
    public void submitLogin() {
        buttonLogin.click();
    }
}
