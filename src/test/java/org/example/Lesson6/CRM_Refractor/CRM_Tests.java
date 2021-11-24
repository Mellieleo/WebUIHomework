package org.example.Lesson6.CRM_Refractor;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CRM_Tests {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @Story("CRM Geekbrains")
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
    @DisplayName("Создание нового контактного лица")
    void createContactTest() {
        new MainPage(driver).navigationBar.openNavBarItem("Контрагенты");
        new CounterpartySubMenu(driver).counterpartySubMenuItemClick();
        new CounterpartyPage(driver).clickCreateContactRequest();
        new CreateContactPage(driver)
                .fillSurname("Halpert")
                .fillName("Jim")
                .selectOrganisation()
                .fillTitle("Salesman")
                .clickSaveAndCloseButton();

        webDriverWait.until(ExpectedConditions.invisibilityOf(new BaseView(driver).loader));
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='flash-messages-holder']/div[contains(.,'сохранен')]"))
                .isDisplayed());
    }

    @Test
    @DisplayName("Создание новой заявки на расход")
    void createExpenseTest() {
        new MainPage(driver).navigationBar.openNavBarItem("Расходы");
        new ExpensesSubMenu(driver).expensesSubMenuItemClick();
        new ExpensesPage(driver).clickCreateExpenseRequest();
        new CreateExpensePage(driver)
                .fillDescription("test")
                .selectBusinessUnit("Research & Development")
                .selectExpenditure("01101 - ОС: вычислительная техника инфраструктуры")
                .selectPlannedDate("18")
                .fillInputSumPlan("100")
                .clickSaveAndCloseButton();

        webDriverWait.until(ExpectedConditions.invisibilityOf(new BaseView(driver).loader));
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='flash-messages-holder']/div[contains(.,'сохранена')]"))
                .isDisplayed());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    static void login(WebDriver driver) {
        driver.get("https://crm.geekbrains.space/user/login");
        new LoginPage(driver)
                .fillLogin("Applanatest1")
                .fillPassword("Student2020!")
                .submitLogin();
    }
}
