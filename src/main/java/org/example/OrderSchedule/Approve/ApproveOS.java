package org.example.OrderSchedule.Approve;

import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.Variables.YKMain.*;

public class ApproveOS {
    WebDriver page;
    public ApproveOS(WebDriver page) {
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(xpath = "//span[contains(text(),'Purchase Orders')]")
    WebElement PurchaseOrder;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TRNTitle;
    @FindBy(id = "BtnToApproveOS")
    WebElement ViewOrderScheduleButton;
    @FindBy(id = "btnApprove")
    WebElement ApproveButton;
    @FindBy(css = ".bootbox-accept")
    WebElement YesOption;


    public void BuyerApproveOS() throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(BuyerId,Pass);Thread.sleep(1000);
        PurchaseOrder.click();Thread.sleep(1000);
        TRNTitle.click();Thread.sleep(3000);
        ViewOrderScheduleButton.click();Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0,500)");Thread.sleep(1000);
        ApproveButton.click();Thread.sleep(1000);
        YesOption.click();Thread.sleep(2000);
        LogOut.UserLogOut(page);
    }
}
