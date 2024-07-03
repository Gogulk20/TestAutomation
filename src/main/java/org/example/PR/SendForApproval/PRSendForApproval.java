package org.example.PR.SendForApproval;

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
import static org.example.Variables.YKMain.Pass;

public class PRSendForApproval {
    WebDriver page;
    public String ApproverUserId;

    public PRSendForApproval(WebDriver page) {
        this.page = page;
        PageFactory.initElements(page, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Send for Approval')]")
    WebElement ClickSendForApprovalButton;
    @FindBy(xpath = "//main[1]/div[1]/div[3]/div[2]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]")
    WebElement ApproversId;
    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    WebElement ClickYes;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement PRTitle;



    public void Approval() throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(ReqId, Pass);
        PRTitle.click();Thread.sleep(3000);
        ClickSendForApprovalButton.click();Thread.sleep(1000);
        ClickYes.click();Thread.sleep(2000);
    }

    public String GetApprovalId() throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(ReqId, Pass);Thread.sleep(1000);
        PRTitle.click();Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(page, Duration.ofSeconds(5));
        WebElement panel1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(text(),'Approver')]")));
        ((JavascriptExecutor) page).executeScript("arguments[0].scrollIntoView(true);", panel1);
        ApproverUserId = ApproversId.getText();Thread.sleep(1000);
        LogOut.UserLogOut(page);Thread.sleep(1000);
        logIn.UserLogin(ApproverUserId, Pass);Thread.sleep(1000);
        return ApproverUserId;
    }
}
