package org.example.PR.Approvals;

import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.example.PR.SendForApproval.PRSendForApproval;
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

public class Approvers {
    WebDriver page;
    public Approvers(WebDriver page) {
        this.page=page;
        PageFactory.initElements(page,this);

    }
    @FindBy(id= "btnApprove")
    WebElement ApproveButton;
    @FindBy(css= ".bootbox-accept")
    WebElement YesButton;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement PRTitle;


    public void PRApproversApprover() throws InterruptedException {
        PRTitle.click();Thread.sleep(2000);
        WebDriverWait wait1 = new WebDriverWait(page, Duration.ofSeconds(5));
        WebElement panel = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(text(),'Approver')]")));
        ((JavascriptExecutor) page).executeScript("arguments[0].scrollIntoView(true);", panel);
        ApproveButton.click();Thread.sleep(2000);
        YesButton.click();Thread.sleep(2000);
    }
}
