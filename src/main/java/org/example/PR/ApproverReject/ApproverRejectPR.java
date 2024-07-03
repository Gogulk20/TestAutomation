package org.example.PR.ApproverReject;

import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.Variables.YKMain.*;

public class ApproverRejectPR {
    WebDriver page;
    public ApproverRejectPR(WebDriver page) {
        this.page=page;
        PageFactory.initElements(page,this);

    }
    @FindBy(id= "btnReject")
    WebElement RejectButton;
    @FindBy(css= ".bootbox-input")
    WebElement Remarks;
    @FindBy(css= ".bootbox-accept")
    WebElement SubmitButton;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement PRTitle;


    public void PRApproversReject() throws InterruptedException {
        PRTitle.click();Thread.sleep(2000);
        WebDriverWait wait1 = new WebDriverWait(page, Duration.ofSeconds(5));
        WebElement panel = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(text(),'Approver')]")));
        ((JavascriptExecutor) page).executeScript("arguments[0].scrollIntoView(true);", panel);
        RejectButton.click();Thread.sleep(1000);
        Remarks.sendKeys("PR Reject");Thread.sleep(1000);
        SubmitButton.click();Thread.sleep(2000);
        LogOut.UserLogOut(page);Thread.sleep(1000);
    }
}
