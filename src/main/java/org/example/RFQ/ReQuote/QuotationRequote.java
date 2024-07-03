package org.example.RFQ.ReQuote;

import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.Variables.YKMain.*;

public class QuotationRequote {
    WebDriver page;
    public QuotationRequote(WebDriver page){
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(id = "vendorSendMailBtnId")
    WebElement MailSubmitButton;
    @FindBy(css = ".bootbox-accept")
    WebElement ClickSubmitButton;
    @FindBy(xpath = "//span[contains(text(),'Request For Quotations')]")
    WebElement RFQPage;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TrnTitle;
    @FindBy(css= ".bootbox-input")
    WebElement Remarks;
    @FindBy(xpath = "//a[contains(text(),'Requote')]")
    WebElement RequoteButton;

    public void BuyerSendRequote() throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(BuyerId,Pass);
        RFQPage.click();Thread.sleep(2000);
        TrnTitle.click();Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 1400)");Thread.sleep(1000);
        RequoteButton.click();Thread.sleep(1000);
        Remarks.sendKeys("RFQ Requote Remarks");Thread.sleep(1000);
        ClickSubmitButton.click();Thread.sleep(1000);
        js.executeScript("window.scrollBy(0, 1700)");Thread.sleep(1000);
        MailSubmitButton.click();Thread.sleep(2000);
        LogOut.UserLogOut(page);Thread.sleep(1000);
    }
}
