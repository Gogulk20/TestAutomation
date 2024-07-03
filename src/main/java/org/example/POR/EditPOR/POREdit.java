package org.example.POR.EditPOR;

import org.example.Login.LogIn;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.Variables.YKMain.*;

public class POREdit {
    WebDriver page;
    public POREdit(WebDriver page){
        this.page=page;
        PageFactory.initElements(page,this);
    }

    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TrnTitle;
    @FindBy(xpath = "//span[contains(text(),'Purchase Order Requests')]")
    WebElement PORModule;
    @FindBy(id = "btnEdit")
    WebElement EditButton;
    @FindBy(id = "btnUpdate")
    WebElement UpdateButton;
    @FindBy(css = ".bootbox-accept")
    WebElement SubmitButton;

    public void POREditpage() throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(BuyerId, Pass);Thread.sleep(1000);
        PORModule.click();Thread.sleep(3000);
        TrnTitle.click();Thread.sleep(3000);
        EditButton.click();Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 3600)"); Thread.sleep(1000);
        UpdateButton.click();Thread.sleep(2000);
        SubmitButton.click();Thread.sleep(3000);
    }
}
