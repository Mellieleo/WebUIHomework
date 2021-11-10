package org.example.Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TumblrTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        Actions act = new Actions(driver);
        driver.get("https://www.tumblr.com/login");
        login(driver);
        Thread.sleep(15000); //сайт довольно тяжелый, приходится ждать полной загрузки страницы
        likeRadarPostTest(driver);
        likeOwnPostTest(driver);

        Thread.sleep(5000);
        driver.quit();
    }

    static void likeOwnPostTest(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(@aria-label, 'Account')]")).click();
        driver.findElement(By.xpath("//span[.= 'randomtesterftw']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[contains(@aria-label, 'Like')]")).click();
    }

    static void likeRadarPostTest(WebDriver driver) {
        driver.findElement(By.xpath("//aside/descendant::button[contains(@aria-label, 'Like')]")).click();
    }

    static void login(WebDriver driver) {
        driver.findElement(By.name("email")).sendKeys("legenbarneydary@yahoo.com");
        driver.findElement(By.name("password")).sendKeys("CpdaM6W7W7CbusA");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
