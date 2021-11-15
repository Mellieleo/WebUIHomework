package org.example.Lesson6.CRM_Refractor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CounterpartyPage extends BaseView {

    public CounterpartyPage(WebDriver driver) {
        super(driver);
    }

    private final String byXpathButtonCreateContactRequestLocator = "//a[.='Создать контактное лицо']";
    @FindBy(xpath = byXpathButtonCreateContactRequestLocator)
    public WebElement buttonCreateContactRequest;

    public CreateContactPage clickCreateContactRequest() {
        webDriverWait.until(ExpectedConditions.visibilityOf(loader));
        webDriverWait.until(ExpectedConditions.invisibilityOf(loader));
        buttonCreateContactRequest.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CreateContactPage.byXpathSaveAndCloseButtonLocator)));
        return new CreateContactPage(driver);
    }
}
