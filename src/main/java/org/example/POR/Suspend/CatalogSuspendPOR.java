package org.example.POR.Suspend;

import org.example.Login.LogIn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.Variables.YKMain.*;

public class CatalogSuspendPOR {
    WebDriver page;
    String PMId;
    public CatalogSuspendPOR(WebDriver page){
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TrnTitle;
    @FindBy(xpath = "//span[contains(text(),'Purchase Order Requests')]")
    WebElement PORModule;
    @FindBy(id = "btnToSuspendPOR")
    WebElement SuspendButton;
    @FindBy(css = ".bootbox-accept")
    WebElement SubmitButton;

public void CatalogSuspend() throws InterruptedException {
    LogIn logIn = new LogIn(page);
    logIn.UserLogin(BuyerId, Pass);Thread.sleep(1000);
    PORModule.click();Thread.sleep(3000);
    TrnTitle.click();Thread.sleep(3000);
    SuspendButton.click();Thread.sleep(2000);
    SubmitButton.click();Thread.sleep(2000);
}
}
