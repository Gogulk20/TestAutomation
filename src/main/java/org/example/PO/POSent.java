package org.example.PO;

import org.example.LogOut.LogOut;
import org.example.OrderSchedule.Create.CreateOS;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class POSent {

    public static void POSentToVendor(String BuyerId,String Pass,String Title,String VendorId,String CheckerId, WebDriver page) throws InterruptedException {
        page.findElement(By.id("Input_Email")).sendKeys(BuyerId);Thread.sleep(1000);
        page.findElement(By.id("Input_Password")).sendKeys(Pass);Thread.sleep(1000);
        page.findElement(By.id("login-submit")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//span[contains(text(), 'Purchase Orders')]")).click();Thread.sleep(2000);
        page.findElement(By.xpath("//span[contains(text(),'"+Title+"')]")).click();Thread.sleep(3000);
        page.findElement(By.id("btnSendPO")).click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 900)");Thread.sleep(1000);
        page.findElement(By.id("vendorSendMailBtnId")).click();Thread.sleep(1000);
        LogOut.UserLogOut(page);
        CreateOS createOS = new CreateOS(page);
        createOS.VendorCreateOS(VendorId, Pass, Title,BuyerId,CheckerId,page);
    }
}
