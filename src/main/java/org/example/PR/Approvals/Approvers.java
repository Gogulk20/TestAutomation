package org.example.PR.Approvals;

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

import static org.example.Variables.YKMain.Title;

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
    @FindBy(xpath = "//main[1]/div[1]/div[3]/div[2]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]")
    WebElement ApproversId;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement PRTitle;

    public void PRApproversApprover(String Pass) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(page, Duration.ofSeconds(5));
        WebElement panel1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(text(),'Approver')]")));
        ((JavascriptExecutor) page).executeScript("arguments[0].scrollIntoView(true);", panel1);
        String ApproverUserId = ApproversId.getText();Thread.sleep(1000);
        LogOut.UserLogOut(page);
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(ApproverUserId, Pass);Thread.sleep(1000);
        PRTitle.click();Thread.sleep(2000);
        WebDriverWait wait1 = new WebDriverWait(page, Duration.ofSeconds(5));
        WebElement panel = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(text(),'Approver')]")));
        ((JavascriptExecutor) page).executeScript("arguments[0].scrollIntoView(true);", panel);
        ApproveButton.click();Thread.sleep(1000);
        YesButton.click();Thread.sleep(2000);
        LogOut.UserLogOut(page);Thread.sleep(1000);
    }
}
