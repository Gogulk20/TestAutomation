package org.example.Invoice.Approvers;

import org.example.Login.LogIn;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ApprovalApproves {
    WebDriver page;
    public ApprovalApproves(WebDriver page){
        this.page = page;
        PageFactory.initElements(page,this);
    }
    public void InvoiceApprover(String ApproverUserId, String Pass, String POTrn) throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(ApproverUserId, Pass);Thread.sleep(1000);
        page.findElement(By.xpath("//span[contains(text(),'Invoices')]")).click();Thread.sleep(3000);
        List<WebElement> rows1 = page.findElements(By.cssSelector("#listContainer tr td"));Thread.sleep(1000);
        for (WebElement row : rows1) {
            if (row.getText().contains(POTrn)) {
                WebElement btnLink = page.findElement(By.cssSelector(".btn-link"));
                btnLink.click();Thread.sleep(3000);
                break;
            }
        }
        WebDriverWait wait1 = new WebDriverWait(page, Duration.ofSeconds(5));
        WebElement panel = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(text(),'Approver')]")));
        ((JavascriptExecutor) page).executeScript("arguments[0].scrollIntoView(true);", panel);
        page.findElement(By.id("btnApprove")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(2000);
    }
}
