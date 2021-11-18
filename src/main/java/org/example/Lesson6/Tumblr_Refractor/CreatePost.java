package org.example.Lesson6.Tumblr_Refractor;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePost extends BaseViewTumblr{
    public CreatePost(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//div[@aria-label='Post title']")
    public WebElement title;

    @Step("Ввод текста заголовка поста")
    public CreatePost inputTitle(String text) {
        title.sendKeys(text);
        return this;
    }

    @FindBy (xpath = "//div[@aria-label='Post body']")
    public WebElement post;

    @Step("Ввод текста тела поста")
    public CreatePost inputPost(String text) {
        post.sendKeys(text);
        return this;
    }

    @FindBy(xpath = "//button[.='Post']")
    public WebElement saveAndCloseButton;

    @Step("Нажатие на кнопку создания пароля")
    public CreatePost clickSaveAndCloseButton() {
        saveAndCloseButton.click();
        return this;
    }

    @Step("Переход на дефолтный фрейм страницы")
    public CreatePost switchToMain() {
        driver.switchTo().defaultContent();
        return this;
    }
}
