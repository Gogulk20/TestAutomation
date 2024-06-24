package org.example.PO;

import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.example.OrderSchedule.Create.CreateOS;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POSent {
    WebDriver page;
    public POSent(WebDriver page){
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(xpath = "//span[contains(text(), 'Purchase Orders')]")
    WebElement PurchaseOrder;
    @FindBy(id = "btnSendPO")
    WebElement SendForVendorButton;
    @FindBy(id = "vendorSendMailBtnId")
    WebElement SendMailButton;


    public void POSentToVendor(String BuyerId,String Pass,String Title) throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(BuyerId,Pass);Thread.sleep(1000);
        PurchaseOrder.click();Thread.sleep(2000);
        page.findElement(By.xpath("//span[contains(text(),'"+Title+"')]")).click();Thread.sleep(3000);
        SendForVendorButton.click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 900)");Thread.sleep(1000);
        SendMailButton.click();Thread.sleep(1000);
        LogOut.UserLogOut(page);
    }
}
