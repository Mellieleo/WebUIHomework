package org.example.Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CRMTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        Actions act = new Actions(driver);
        driver.get("https://crm.geekbrains.space/user/login");
        login(driver);
        createContactTest(driver, act);
        createExpenseTest(driver, act);

        Thread.sleep(5000);
        driver.quit();
    }

    static void createContactTest(WebDriver driver, Actions act) throws InterruptedException {
        act.moveToElement(driver.findElement(By.xpath("//span[.='Контрагенты']/ancestor::a"))).build().perform();
        driver.findElement(By.xpath("//span[.='Контактные лица']")).click();
        driver.findElement(By.xpath("//a[.='Создать контактное лицо']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[contains(@id, 'crm_contact_lastName')]")).sendKeys("-Moltres");
        driver.findElement(By.xpath("//input[contains(@id, 'crm_contact_firstName')]")).sendKeys("Zapdos");
        driver.findElement(By.xpath("//span[.='Укажите организацию']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[.='1234124']")).click();
        driver.findElement(By.xpath("//input[contains(@id, 'crm_contact_jobTitle')]")).sendKeys("Articuno");
        driver.findElement(By.xpath("//button[contains(., 'Сохранить и закрыть')]")).click();
    }

    static void createExpenseTest(WebDriver driver, Actions actions) throws InterruptedException {
        actions.moveToElement(driver.findElement(By.xpath("//a/span[.='Продажи']"))).build().perform();
        driver.findElement(By.xpath("//span[.='Заявки на расходы']")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[.='Создать заявку на расход']")).click();

        driver.findElement(By.name("crm_expense_request[description]")).sendKeys("test");

        Select selectBusinessUnit = new Select(driver.findElement(By.name("crm_expense_request[businessUnit]")));
        selectBusinessUnit.selectByVisibleText("Research & Development");

        Select expenditureSelect = new Select(driver.findElement(By.name("crm_expense_request[expenditure]")));
        expenditureSelect.selectByVisibleText("01101 - ОС: вычислительная техника инфраструктуры");

        driver.findElement(By.xpath("//input[contains(@id, 'datePlan') and @placeholder='Укажите дату']")).click();
        driver.findElement(By.xpath("//a[.='21']")).click();
        driver.findElement(By.xpath("//input[contains(@id, 'crm_expense_request_sumPlan-uid')]")).sendKeys("100");

        driver.findElement(By.xpath("//button[contains(., 'Сохранить и закрыть')]")).click();
    }

    static void login(WebDriver driver) {
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
