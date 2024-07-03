package org.example.PR.Edit;

import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.Variables.YKMain.*;

public class PREdit {
    WebDriver page;
    public PREdit(WebDriver page){
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(id = "btnEdit")
    WebElement EditButton;
    @FindBy(id = "btnUpdate")
    WebElement UpdateButton;
    @FindBy(css = ".bootbox-accept")
    WebElement ClickSubmitButton;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement PRTitle;

    public void RequesiterEditPR() throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(ReqId,Pass);Thread.sleep(2000);
        PRTitle.click();Thread.sleep(3000);
        EditButton.click();Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0,2500)");
        UpdateButton.click();Thread.sleep(1000);
        ClickSubmitButton.click();Thread.sleep(2000);
        LogOut.UserLogOut(page);Thread.sleep(1000);
    }
}