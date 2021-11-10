package org.example.Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TumblrTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    @BeforeAll
    static void driverSetup() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    void initBrowser() {
        driver = new FirefoxDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        login(driver);
    }

    @Test
    void likeOwnPostTest() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@aria-label='Inbox']")));
        driver.get("https://www.tumblr.com/blog/randomtesterftw");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[.='Mass Post Editor']")));
        driver.findElement(By.xpath("//button[contains(@aria-label, 'Like')]")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//button[contains(@aria-label, 'Like')]/span/*[name()='svg']" +
                "[@fill='RGB(var(--red))']")).isDisplayed());
    }

    @Test
    void likeRadarPostTest() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//aside/descendant::header[@role='banner']")));
        driver.findElement(By.xpath("//aside/descendant::button[contains(@aria-label, 'Like')]")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//button[contains(@aria-label, 'Like')]/span/*[name()='svg']" +
                "[@fill='RGB(var(--red))']")).isDisplayed());
    }

    @Test
    void createPostTest() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@aria-label='Inbox']")));
        driver.get("https://www.tumblr.com/new/text");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@title='Post forms']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Post forms']")));
        driver.findElement(By.xpath("//div[@aria-label='Post title']")).sendKeys("Another Post");
        driver.findElement((By.xpath("//div[@aria-label='Post body']"))).sendKeys("If you see that," +
                " the test was successful");
        driver.findElement(By.xpath("//button[.='Post']")).click();
        driver.switchTo().defaultContent();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//main")));
        Assertions.assertTrue(driver.findElement(By.xpath("//header[@aria-label='Posted by randomtesterftw']")).isDisplayed());
    }

    @Test
    void reblogPostTest() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//main")));
        driver.findElement(By.xpath("//a[@aria-label='Reblog']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@title='Post forms']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Post forms']")));
        driver.findElement(By.xpath("//button[.='Reblog']")).click();
        driver.switchTo().defaultContent();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//aside/descendant::header[@role='banner']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//a[contains(@aria-label, 'Reblog')]/*[name()='svg']" +
                "[@fill='RGB(var(--green))']")).isDisplayed());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    static void login(WebDriver driver) {
        driver.get("https://www.tumblr.com/login");
        driver.findElement(By.name("email")).sendKeys("legenbarneydary@yahoo.com");
        driver.findElement(By.name("password")).sendKeys("CpdaM6W7W7CbusA");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
