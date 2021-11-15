package org.example.Lesson6.Tumblr_Refractor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LikePost extends BaseViewTumblr{
    public LikePost(WebDriver driver) {
        super(driver);
    }
    public static String likeXpath = "button[contains(@aria-label, 'Like')]";

    public void likePost(String xpath) {
        driver.findElement(By.xpath(xpath+likeXpath)).click();
    }
}
