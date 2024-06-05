package org.example.Inspection;

import org.example.LogOut.LogOut;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SendForInspection {
    WebDriver page;
    public SendForInspection(WebDriver page) {
        this.page=page;
    }

    public void VendorSendForInspection(String VendorId, String Pass, String Title,String POTrn,String CheckerId, String SourceCountry,
                                        String DestinationCountry, String GrossWeight, String NetWeight,
                                        String Volume, String DNQuantity,String LMId, String VendorName,WebDriver page) throws InterruptedException {
        page.findElement(By.id("Input_Email")).sendKeys(VendorId);
        page.findElement(By.id("Input_Password")).sendKeys(Pass);
        page.findElement(By.id("login-submit")).click();
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
        page.findElement(By.xpath("//span[contains(text(),'Purchase Order')]")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//span[contains(text(),'" + Title + "')]")).click();Thread.sleep(3000);
        POTrn = page.findElement(By.id("trnsactionId")).getText();
        page.findElement(By.xpath("//span[contains(text(),'Order Schedules')]")).click();Thread.sleep(1000);
        List<WebElement> rows = page.findElements(By.cssSelector("#listContainer tr td"));
        for (WebElement row : rows) {
            if (row.getText().contains(POTrn)) {
                WebElement btnLink = page.findElement(By.cssSelector(".btn-link"));
                btnLink.click();Thread.sleep(1000);
                break;
            }
        }
        page.findElement(By.id("btnSendForInspection")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(2000);
        LogOut.UserLogOut(page);
        Assign assign = new Assign(page);
        assign.RequesterAssignIns(CheckerId,Pass,Title,VendorId, SourceCountry, DestinationCountry,GrossWeight,NetWeight,Volume,DNQuantity,LMId, POTrn,VendorName,page);
    }
}
