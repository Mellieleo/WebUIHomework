package org.example.Lesson6.CRM_Refractor;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CounterpartySubMenu extends BaseView {
    public CounterpartySubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Контактные лица']")
    public WebElement counterpartySubMenuItem;

    @Step("Клик на подменю 'Контрагенты'")
    public void counterpartySubMenuItemClick() {
        counterpartySubMenuItem.click();
    }

}

