package org.example.RFQ.ReadyForEvaluation;

import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.Variables.YKMain.*;

public class ReadyForEvaluation {
    WebDriver page;
    public ReadyForEvaluation(WebDriver page) {
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(xpath = "//span[contains(text(),'Request For Quotations')]")
    WebElement RFQPage;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TrnTitle;
    @FindBy(id = "btnReadyForEvalution")
    WebElement ReadyForEvaluationButton;
    @FindBy(css = ".bootbox-accept")
    WebElement OptionYes;


    public void BuyerSentRFE() throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(BuyerId,Pass);
        RFQPage.click();Thread.sleep(2000);
        TrnTitle.click();Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 1700)");Thread.sleep(1000);
        ReadyForEvaluationButton.click();Thread.sleep(1000);
        OptionYes.click();Thread.sleep(2000);
        LogOut.UserLogOut(page);
    }
}
