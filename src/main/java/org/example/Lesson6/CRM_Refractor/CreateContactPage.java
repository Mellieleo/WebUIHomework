package org.example.Lesson6.CRM_Refractor;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateContactPage extends BaseView {
    public CreateContactPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[contains(@id, 'crm_contact_lastName')]")
    public WebElement inputSurname;

    @Step("Заполнение фамилии")
    public CreateContactPage fillSurname(String description) {
        inputSurname.sendKeys(description);
        return this;
    }

    @FindBy(xpath = "//input[contains(@id, 'crm_contact_firstName')]")
    public WebElement inputName;

    @Step("Заполнение имени")
    public CreateContactPage fillName(String description) {
        inputName.sendKeys(description);
        return this;
    }

    @FindBy(xpath = "//span[.='Укажите организацию']")
    public WebElement chooseOrganisation;
    @FindBy(xpath = "//div[.='1234124']")
    public WebElement organisation;

    @Step("Выбор организации")
    public CreateContactPage selectOrganisation() {
        chooseOrganisation.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[.='1234124']")));
        organisation.click();
        return this;
    }

    @FindBy(xpath = "//input[contains(@id, 'crm_contact_jobTitle')]")
    public WebElement inputTitle;

    @Step("Заполнение должности")
    public CreateContactPage fillTitle(String title) {
        inputTitle.sendKeys(title);
        return this;
    }

    public static final String byXpathSaveAndCloseButtonLocator = "//button[contains(., 'Сохранить и закрыть')]";
    @FindBy(xpath = byXpathSaveAndCloseButtonLocator)
    public WebElement saveAndCloseButton;

    @Step("Надатие кнопки сохранения и закрытия")
    public CreateContactPage clickSaveAndCloseButton() {
        saveAndCloseButton.click();
        return this;
    }
}
