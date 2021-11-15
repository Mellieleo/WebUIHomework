package org.example.Lesson6.Tumblr_Refractor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BaseViewTumblr{
    
    public DashboardPage(WebDriver driver) {
        super(driver);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//aside/descendant::header[@role='banner']")));
    }
    
    
}
