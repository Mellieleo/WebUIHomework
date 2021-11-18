package org.example.Lesson6.Tumblr_Refractor;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;

public class Tumblr_Tests {
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
    void createPost() {
        new DashboardPage(driver);
        new TextCreator(driver).callTextCreator();
        new CreatePost(driver)
                .inputTitle("Another Interesting Title")
                .inputPost("Why would you make a website like this?")
                .clickSaveAndCloseButton()
                .switchToMain();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//main")));
        Assertions.assertTrue(driver.findElement(By.xpath("//header[@aria-label='Posted by randomtesterftw']")).isDisplayed());
    }

    @Test
    void likeRadarPost() {
        new DashboardPage(driver);
        new LikePost(driver).likePost("//aside/descendant::");
        Assertions.assertTrue(driver.findElement(By.xpath("//button[contains(@aria-label, 'Like')]/span/*[name()='svg']" +
                "[@fill='RGB(var(--red))']")).isDisplayed());
    }

    @AfterEach
    void tearDown() {
        LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry browserLog : browserLogs) {
            Allure.addAttachment("Log entry: ", browserLog.getMessage());
        }
        driver.quit();
    }

    static void login(WebDriver driver) {
        driver.get("https://www.tumblr.com/login");
        new Login(driver)
                .fillLogin("legenbarneydary@yahoo.com")
                .fillPassword("CpdaM6W7W7CbusA")
                .submitLogin();
    }
}
