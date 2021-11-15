package org.example.Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class CRMTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void driverSetup() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    void initBrowser() {
        driver = new FirefoxDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        login(driver);
    }

    @Test
    void createContactTest() {
        driver.get("https://crm.geekbrains.space/contact/create");

        driver.findElement(By.xpath("//input[contains(@id, 'crm_contact_lastName')]")).sendKeys("-Moltres");
        driver.findElement(By.xpath("//input[contains(@id, 'crm_contact_firstName')]")).sendKeys("Zapdos");
        driver.findElement(By.xpath("//span[.='Укажите организацию']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[.='1234124']")));
        driver.findElement(By.xpath("//div[.='1234124']")).click();

        driver.findElement(By.xpath("//input[contains(@id, 'crm_contact_jobTitle')]")).sendKeys("Articuno");
        driver.findElement(By.xpath("//button[contains(., 'Сохранить и закрыть')]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(., 'Контактные лица')]")));

        List<WebElement> names = driver.findElements(By.xpath("//td[contains(@class, 'fio')]"));
        Assertions.assertEquals("-Moltres Zapdos", names.get(3).getText());
    }

    @Test
    void createExpenseTest() {
        driver.get("https://crm.geekbrains.space/expense-request/create");
        driver.findElement(By.name("crm_expense_request[description]")).sendKeys("test");

        Select selectBusinessUnit = new Select(driver.findElement(By.name("crm_expense_request[businessUnit]")));
        selectBusinessUnit.selectByVisibleText("Research & Development");

        Select expenditureSelect = new Select(driver.findElement(By.name("crm_expense_request[expenditure]")));
        expenditureSelect.selectByVisibleText("01101 - ОС: вычислительная техника инфраструктуры");

        driver.findElement(By.xpath("//input[contains(@id, 'datePlan') and @placeholder='Укажите дату']")).click();
        driver.findElement(By.xpath("//a[.='21']")).click();
        driver.findElement(By.xpath("//input[contains(@id, 'crm_expense_request_sumPlan-uid')]")).sendKeys("100");

        driver.findElement(By.xpath("//button[contains(., 'Сохранить и закрыть')]")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(., 'Заявки на расходы')]")));

        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='flash-messages-holder']/div[contains(.,'сохранена')]"))
                .isDisplayed());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    static void login(WebDriver driver) {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
