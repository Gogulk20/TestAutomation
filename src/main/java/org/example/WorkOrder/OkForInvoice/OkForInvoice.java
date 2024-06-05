package org.example.WorkOrder.OkForInvoice;

import org.example.LogOut.LogOut;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OkForInvoice {
    WebDriver page;
    public OkForInvoice(WebDriver page){
        this.page=page;
    }
    public void LMClickOkForInvoice(String LMId, String Pass,String POTrn,WebDriver page) throws InterruptedException {
        page.findElement(By.id("Input_Email")).sendKeys(LMId);Thread.sleep(1000);
        page.findElement(By.id("Input_Password")).sendKeys(Pass);Thread.sleep(1000);
        page.findElement(By.id("login-submit")).click();Thread.sleep(1000);
        page.findElement(By.id("ni-work-orders")).click();Thread.sleep(3000);
        List<WebElement> rows = page.findElements(By.cssSelector("#listContainer tr td"));
        for (WebElement row : rows) {
            if (row.getText().contains(POTrn)) {
                WebElement btnLink = page.findElement(By.cssSelector(".btn-link"));
                btnLink.click();Thread.sleep(3000);
                break;
            }
        }
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0,-1750)");Thread.sleep(1000);
        page.findElement(By.id("btnOkforInvoice")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(1000);
        LogOut.UserLogOut(page);
    }
}
