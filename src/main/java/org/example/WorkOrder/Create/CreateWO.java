package org.example.WorkOrder.Create;

import org.example.LogOut.LogOut;
import org.example.WorkOrder.TrackerStatus.VendorTrackerStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CreateWO {
    WebDriver page;
    public CreateWO(WebDriver page){
        this.page=page;
    }
    public void LMCreateWO(String VendorName,String POTrn,String VendorID, String Pass,String LMId,WebDriver page) throws InterruptedException {
        page.findElement(By.id("dropdownMenuButton")).click();Thread.sleep(1000);
        page.findElement(By.id("btnToCreateWorkOrder")).click();Thread.sleep(3000);
        page.findElement(By.id("select2-freightForwarderId-container")).click();Thread.sleep(2000);
        page.findElement(By.cssSelector(".select2-search__field")).sendKeys(VendorName);Thread.sleep(2000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
        page.findElement(By.id("select2-priority-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-search__field")).sendKeys("High");Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//main[1]/div[1]/form[1]/div[1]/div[2]/div[3]/div[3]/input[2]")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//div[4]/div[2]/div[1]/div[2]/div[1]/span[42]")).click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 2800)");;Thread.sleep(1000);
        page.findElement(By.id("btnToCreateWorkOrder")).click();Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) page;
        js1.executeScript("window.scrollBy(0, 600)");Thread.sleep(1000);
        page.findElement(By.id("vendorSendMailBtnId")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(1000);
        LogOut.UserLogOut(page);
        VendorTrackerStatus vendorTrackerStatus = new VendorTrackerStatus(page);
        vendorTrackerStatus.VendorUpdateTS(VendorID,Pass,POTrn,LMId,page);
    }
}
