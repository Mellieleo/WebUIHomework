package org.example.Lesson6.CRM_Refractor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CounterpartySubMenu extends BaseView {
    public CounterpartySubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Контактные лица']")
    public WebElement counterpartySubMenuItem;

    public void counterpartySubMenuItemClick() {
        counterpartySubMenuItem.click();
    }

}

