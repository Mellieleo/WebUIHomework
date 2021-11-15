package org.example.Lesson6.Tumblr_Refractor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseViewTumblr {

    WebDriver driver;
    WebDriverWait webDriverWait;

    public BaseViewTumblr(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
}
