package org.example.RFQ.CE;

import org.example.Login.LogIn;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.Variables.YKMain.*;

public class CommercialEvaluation {
    WebDriver page;
    public CommercialEvaluation(WebDriver page) {
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(xpath = "//span[contains(text(),'Request For Quotations')]")
    WebElement RFQPage;
    @FindBy(id = "btnCreateCE")
    WebElement CreateCEButton;
    @FindBy(xpath = "//body[1]/main[1]/div[1]/div[4]/div[1]/div[1]/form[1]/fieldset[1]/div[1]/table[1]/tbody[1]/tr[19]/td[2]/select[1]")
    WebElement SelectionCriteriaField;
    @FindBy(xpath = "//body[1]/main[1]/div[1]/div[4]/div[1]/div[1]/form[1]/fieldset[1]/div[1]/table[1]/tbody[1]/tr[19]/td[2]/select[1]/option[1]")
    WebElement YesOption;
    @FindBy(id = "btnSubmitCE")
    WebElement CESubmitButton;
    @FindBy(css = ".bootbox-accept")
    WebElement YesButton;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TrnTitle;

    public void BuyerCreateCE() throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(BuyerId,Pass);
        RFQPage.click();Thread.sleep(2000);
        TrnTitle.click();Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 2000)");Thread.sleep(1000);
        CreateCEButton.click();
        JavascriptExecutor js1 = (JavascriptExecutor) page;
        js1.executeScript("window.scrollBy(0, 2000)");Thread.sleep(1000);
        js1.executeScript("document.querySelector('.table-responsive').scrollTop=5000");Thread.sleep(1000);
        SelectionCriteriaField.click();Thread.sleep(1000);
        YesOption.click();Thread.sleep(1000);
        CESubmitButton.click();Thread.sleep(1000);
        YesButton.click();Thread.sleep(2000);
        JavascriptExecutor js2 = (JavascriptExecutor) page;
        js2.executeScript("window.scrollBy(0, 1400)");Thread.sleep(1000);
       }
}
