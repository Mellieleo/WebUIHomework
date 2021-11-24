package org.example.Lesson6.Tumblr_Refractor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePost extends BaseViewTumblr{
    public CreatePost(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//div[@aria-label='Post title']")
    public WebElement title;

    public CreatePost inputTitle(String text) {
        title.sendKeys(text);
        return this;
    }

    @FindBy (xpath = "//div[@aria-label='Post body']")
    public WebElement post;

    public CreatePost inputPost(String text) {
        post.sendKeys(text);
        return this;
    }

    @FindBy(xpath = "//button[.='Post']")
    public WebElement saveAndCloseButton;

    public CreatePost clickSaveAndCloseButton() {
        saveAndCloseButton.click();
        return this;
    }

    public CreatePost switchToMain() {
        driver.switchTo().defaultContent();
        return this;
    }
}
