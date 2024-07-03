package org.example.RFQ.Suspend;

import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.Variables.YKMain.*;

public class SuspendRFQ {
    WebDriver page;
    public SuspendRFQ(WebDriver page){
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(id = "btnToSuspendRfq")
    WebElement ClickSuspendButton;
    @FindBy(css = ".bootbox-accept")
    WebElement ClickSubmitButton;
    @FindBy(xpath = "//span[contains(text(),'Request For Quotations')]")
    WebElement RFQPage;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TrnTitle;
    @FindBy(css= ".bootbox-input")
    WebElement Remarks;

    public void BuyerSuspendRFQ() throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(BuyerId,Pass);
        RFQPage.click();Thread.sleep(2000);
        TrnTitle.click();Thread.sleep(3000);
        ClickSuspendButton.click();Thread.sleep(1000);
        Remarks.sendKeys("Buyer Suspend RFQ");Thread.sleep(1000);
        ClickSubmitButton.click();Thread.sleep(3000);
        LogOut.UserLogOut(page);Thread.sleep(1000);
    }
}
