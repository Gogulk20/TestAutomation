package org.example.RFQ.Edit;

import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.Variables.YKMain.*;

public class RFQEdit {
    WebDriver page;
    public RFQEdit(WebDriver page){
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(id = "btnEditRfq")
    WebElement EditButton;
    @FindBy(id = "btnUpdate")
    WebElement UpdateButton;
    @FindBy(css = ".bootbox-accept")
    WebElement ClickSubmitButton;
    @FindBy(xpath = "//span[contains(text(),'Request For Quotations')]")
    WebElement RFQPage;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TrnTitle;

    public void BuyerEditRFQ() throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(BuyerId,Pass);
        RFQPage.click();Thread.sleep(2000);
        TrnTitle.click();Thread.sleep(2000);
        EditButton.click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0,2500)");
        UpdateButton.click();Thread.sleep(1000);
        ClickSubmitButton.click();Thread.sleep(1000);
        LogOut.UserLogOut(page);Thread.sleep(1000);
    }
}
