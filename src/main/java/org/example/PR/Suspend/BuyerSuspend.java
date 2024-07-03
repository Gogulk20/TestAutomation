package org.example.PR.Suspend;

import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.Variables.YKMain.*;

public class BuyerSuspend {
    WebDriver page;
    public BuyerSuspend(WebDriver page){
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(id = "btnSuspend")
    WebElement ClickSuspendButton;
    @FindBy(css = ".bootbox-accept")
    WebElement ClickSubmitButton;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement PRTitle;
    @FindBy(css= ".bootbox-input")
    WebElement Remarks;

    public void BuyerSuspendPR() throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(BuyerId,Pass);Thread.sleep(2000);
        PRTitle.click();Thread.sleep(3000);
        ClickSuspendButton.click();Thread.sleep(1000);
        Remarks.sendKeys("Buyer Suspend");Thread.sleep(1000);
        ClickSubmitButton.click();Thread.sleep(1000);
        LogOut.UserLogOut(page);Thread.sleep(1000);
    }
}
