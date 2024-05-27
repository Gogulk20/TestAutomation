package org.example.RFQ;

import org.example.LogOut.LogOut;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ReadyForEvaluation {
    WebDriver page;
    public ReadyForEvaluation(WebDriver page) {
        this.page=page;
    }

    public void BuyerSentRFE(String BuyerId, String Pass, String Title, WebDriver page) throws InterruptedException {
        page.findElement(By.id("Input_Email")).sendKeys(BuyerId);Thread.sleep(1000);
        page.findElement(By.id("Input_Password")).sendKeys(Pass);Thread.sleep(1000);
        page.findElement(By.id("login-submit")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//span[contains(text(),'Request For Quotations')]")).click();Thread.sleep(2000);
        page.findElement(By.xpath("//span[contains(text(),'" + Title + "')]")).click();Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 1800)");Thread.sleep(1000);
        page.findElement(By.id("btnReadyForEvalution")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(2000);
        LogOut.UserLogOut(page);
    }
}
