package org.example.OrderSchedule.Create;

import org.example.LogOut.LogOut;
import org.example.OrderSchedule.Approve.ApproveOS;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateOS {
    WebDriver page;
    public CreateOS(WebDriver page) {
        this.page=page;
    }
    public void VendorCreateOS(String VendorId, String Pass, String Title,String BuyerId, String POTrn,String CheckerId, String SourceCountry,
                               String DestinationCountry, String GrossWeight, String NetWeight,
                               String Volume, String DNQuantity,String LMId,String VendorName,WebDriver page) throws InterruptedException {
        page.findElement(By.id("Input_Email")).sendKeys(VendorId);Thread.sleep(1000);
        page.findElement(By.id("Input_Password")).sendKeys(Pass);Thread.sleep(1000);
        page.findElement(By.id("login-submit")).click();Thread.sleep(1000);
        try {
            WebDriverWait wait = new WebDriverWait(page, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = page.switchTo().alert();
            alert.accept();
            Thread.sleep(1000);
        } catch (NoSuchElementException e){
        }
        page.findElement(By.xpath("//div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")).click();Thread.sleep(1000);
        page.findElement(By.id("glbBtnChangeVendor")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//span[contains(text(),'Purchase Orders')]")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//span[contains(text(),'" + Title + "')]")).click();Thread.sleep(3000);
        page.findElement(By.id("btnCreateOR")).click();Thread.sleep(2000);
//        page.findElement(By.xpath("//main[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[2]/div[1]/input[2]")).click();Thread.sleep(1000);
        WebElement Date = page.findElement(By.xpath("//main[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[2]/div[1]/input[2]"));Thread.sleep(1000);
        Date.click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".today")).click();Thread.sleep(1000);
        page.findElement(By.id("notes")).sendKeys("Notes");Thread.sleep(1000);
        JavascriptExecutor js= (JavascriptExecutor)page;
        js.executeScript("window.scrollBy(0,500)");Thread.sleep(1000);
        page.findElement(By.id("btnCreate")).click();Thread.sleep(3000);
        page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(3000);
        LogOut.UserLogOut(page);
        ApproveOS approveOS = new ApproveOS(page);
        approveOS.BuyerApproveOS(BuyerId,Pass,Title,VendorId,POTrn,CheckerId, SourceCountry, DestinationCountry,GrossWeight,NetWeight,Volume,DNQuantity,LMId,VendorName,page);
    }
}
