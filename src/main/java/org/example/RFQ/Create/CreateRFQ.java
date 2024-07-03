package org.example.RFQ.Create;

import org.example.Login.LogIn;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.Variables.YKMain.Title;

public class CreateRFQ {
    WebDriver page;

    public CreateRFQ(WebDriver page) {
        this.page = page;
        PageFactory.initElements(page,this);
    }
    @FindBy(xpath = "//span[contains(text(), 'Requisitions')]")
    WebElement ClickRequisition;
    @FindBy(id = "btnCreateRFQ")
    WebElement ClickCreateRfqButton;
    @FindBy(id = "notes")
    WebElement RfqNotes;
    @FindBy(id = "btnCreate")
    WebElement CreateButton;
    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    WebElement ClickYes;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TrnTitle;

    public void CreateRFQ(String BuyerId, String Pass, String RFQNotes) throws InterruptedException {
        LogIn logIn= new LogIn(page);
        logIn.UserLogin(BuyerId,Pass);Thread.sleep(1000);
        ClickRequisition.click();Thread.sleep(2000);
        TrnTitle.click();Thread.sleep(2000);
        ClickCreateRfqButton.click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 2000)");Thread.sleep(1000);
        RfqNotes.sendKeys(RFQNotes);Thread.sleep(1000);
        CreateButton.click();Thread.sleep(1000);
        ClickYes.click();Thread.sleep(2000);
        }
}
