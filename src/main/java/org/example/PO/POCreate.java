package org.example.PO;


import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POCreate {
    WebDriver page;
    public POCreate(WebDriver page){
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(xpath = "//span[contains(text(), 'Purchase Order Requests')]")
    WebElement PurchaseOrderRequest;
    @FindBy(id = "createPOContainer")
    WebElement CreatePOConsole;
    @FindBy(id = "btnCreatePO")
    WebElement CreatePOButton;
    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    WebElement YesButton;

    public void BuyerCreatePO(String AdminId, String Pass, String Title) throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(AdminId,Pass);Thread.sleep(1000);
        PurchaseOrderRequest.click();Thread.sleep(2000);
        page.findElement(By.xpath("//span[contains(text(),'"+Title+"')]")).click();Thread.sleep(3000);
        WebElement createPOContainer = CreatePOConsole;
        JavascriptExecutor jsExecutor = (JavascriptExecutor) page;
        jsExecutor.executeScript("arguments[0].removeAttribute('style');", createPOContainer);Thread.sleep(1000);
        CreatePOButton.click();Thread.sleep(1000);
        YesButton.click();Thread.sleep(3000);
        LogOut.UserLogOut(page);
    }

}
