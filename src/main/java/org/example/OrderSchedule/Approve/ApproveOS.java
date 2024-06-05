package org.example.OrderSchedule.Approve;

import org.example.Inspection.SendForInspection;
import org.example.LogOut.LogOut;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ApproveOS {
    WebDriver page;
    public ApproveOS(WebDriver page) {
        this.page=page;
    }

    public void BuyerApproveOS(String BuyerId, String Pass, String Title,String VendorId,String POTrn,String CheckerId, String SourceCountry,
                               String DestinationCountry, String GrossWeight, String NetWeight,
                               String Volume, String DNQuantity,String LMId,String VendorName,WebDriver page) throws InterruptedException {
        page.findElement(By.id("Input_Email")).sendKeys(BuyerId);
        page.findElement(By.id("Input_Password")).sendKeys(Pass);
        page.findElement(By.id("login-submit")).click();
        page.findElement(By.xpath("//span[contains(text(),'Purchase Orders')]")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//span[contains(text(),'" + Title + "')]")).click();Thread.sleep(3000);
        page.findElement(By.id("BtnToApproveOS")).click();Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0,500)");Thread.sleep(1000);
        page.findElement(By.id("btnApprove")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(2000);
        LogOut.UserLogOut(page);
        SendForInspection sendForInspection = new SendForInspection(page);
        sendForInspection.VendorSendForInspection(VendorId, Pass, Title,POTrn,CheckerId, SourceCountry, DestinationCountry,GrossWeight,NetWeight,Volume,DNQuantity,LMId,VendorName,page);
    }
}
