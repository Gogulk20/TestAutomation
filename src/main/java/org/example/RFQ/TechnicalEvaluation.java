package org.example.RFQ;

import org.example.LogOut.LogOut;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TechnicalEvaluation {
    WebDriver page;
    public TechnicalEvaluation(WebDriver page) {
        this.page=page;
    }

    public void RequesterCreateTE(String ReqId, String Pass, String Title, WebDriver page) throws InterruptedException {
        page.findElement(By.id("Input_Email")).sendKeys(ReqId);Thread.sleep(1000);
        page.findElement(By.id("Input_Password")).sendKeys(Pass);Thread.sleep(1000);
        page.findElement(By.id("login-submit")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//span[contains(text(),'Request For Quotations')]")).click();Thread.sleep(2000);
        page.findElement(By.xpath("//span[contains(text(),'" + Title + "')]")).click();Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 1800)");Thread.sleep(1000);
        page.findElement(By.id("btnCreateTE")).click();Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) page;
        js1.executeScript("window.scrollBy(0, 2000)");Thread.sleep(1000);
        page.findElement(By.cssSelector(".form-check-input")).click();Thread.sleep(1000);
        page.findElement(By.id("btnCreate")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(2000);
        page.findElement(By.id("btnSendApproval")).click();Thread.sleep(1000);
        page.findElement(By.id("select2-approverUser-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-search__field")).sendKeys(ReqId);Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
        page.findElement(By.id("saveApproverAssign")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(2000);
        JavascriptExecutor js2 = (JavascriptExecutor) page;
        js2.executeScript("window.scrollBy(0, 1150)");Thread.sleep(1000);
        page.findElement(By.id("btnApprove")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(3000);
        LogOut.UserLogOut(page);
    }
}
