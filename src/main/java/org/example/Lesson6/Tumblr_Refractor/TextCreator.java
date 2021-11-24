package org.example.Lesson6.Tumblr_Refractor;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TextCreator extends BaseViewTumblr {
    public TextCreator(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@aria-label='Text']")
    public WebElement textCreatorCaller;

    public static String iFrame = "//iframe[@title='Post forms']";

    @Step("Открытие формы создания поста, переключение фреймов")
    public CreatePost callTextCreator() {
        textCreatorCaller.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(iFrame)));
        driver.switchTo().frame(driver.findElement(By.xpath(iFrame)));
        return new CreatePost(driver);
    }
}
