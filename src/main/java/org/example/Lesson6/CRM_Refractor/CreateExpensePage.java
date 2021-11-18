package org.example.Lesson6.CRM_Refractor;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateExpensePage extends BaseView {
    public CreateExpensePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_expense_request[description]")
    public WebElement inputDescription;

    @Step("Заполнение описания")
    public CreateExpensePage fillDescription(String description) {
        inputDescription.sendKeys(description);
        return this;
    }

    @FindBy(name = "crm_expense_request[businessUnit]")
    public WebElement selectBusinessUnit;

    @Step("Выбор бизнес-юнита")
    public CreateExpensePage selectBusinessUnit(String option) {
        new Select(selectBusinessUnit).selectByVisibleText(option);
        return this;
    }

    @FindBy(name = "crm_expense_request[expenditure]")
    public WebElement selectExpenditure;

    @Step("Выбор группы расходов")
    public CreateExpensePage selectExpenditure(String option) {
        new Select(selectExpenditure).selectByVisibleText(option);
        return this;
    }

    @FindBy(xpath = "//input[contains(@id, 'datePlan') and @placeholder='Укажите дату']")
    public WebElement plannedDate;

    @FindBy(xpath = "//a[contains(@class,'ui-state-default')]")
    public List<WebElement> calendarDates;

    @Step("Выбор даты")
    public CreateExpensePage selectPlannedDate(String date) {
        plannedDate.click();
        calendarDates.stream().filter(element -> element.getText().equals(date)).findFirst().get().click();
        return this;
    }

    @FindBy(xpath = "//input[contains(@id, 'crm_expense_request_sumPlan-uid')]")
    public WebElement inputSumPlan;

    @Step("Заполнение суммы")
    public CreateExpensePage fillInputSumPlan(String sum) {
        inputSumPlan.sendKeys(sum);
        return this;
    }

    public static final String byXpathSaveAndCloseButtonLocator = "//button[contains(., 'Сохранить и закрыть')]";
    @FindBy(xpath = byXpathSaveAndCloseButtonLocator)
    public WebElement saveAndCloseButton;

    @Step("Нажатие кнопки сохранения и закрытия")
    public CreateExpensePage clickSaveAndCloseButton() {
        saveAndCloseButton.click();
        return this;
    }
}