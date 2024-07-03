package org.example.RFQ.Quotation;

import org.example.Login.LogIn;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.Variables.YKMain.*;

public class ReSubmitQuotation {
    WebDriver page;
    public ReSubmitQuotation(WebDriver page){
        this.page=page;
        PageFactory.initElements(page,this);
        }
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TrnTitle;
    @FindBy(id = "btnEditQuote")
    WebElement RequoteButton;
    @FindBy(id = "btnUpdate")
    WebElement SubmitRequoteButton;
    @FindBy(css = ".bootbox-accept")
    WebElement YesButton;

public void VendorReSubmitQuotation() throws InterruptedException {
    LogIn logIn = new LogIn(page);
    logIn.VendorLogin(VendorId,Pass);
    TrnTitle.click();Thread.sleep(2000);
    RequoteButton.click();Thread.sleep(2000);
    JavascriptExecutor js = (JavascriptExecutor) page;
    js.executeScript("window.scrollBy(0, 2700)");Thread.sleep(1000);
    SubmitRequoteButton.click();Thread.sleep(1000);
    YesButton.click();Thread.sleep(3000);
}
}