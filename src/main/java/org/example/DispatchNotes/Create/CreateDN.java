package org.example.DispatchNotes.Create;

import org.example.DispatchNotes.Assign.DNAssign;
import org.example.JavaStreams;
import org.example.LogOut.LogOut;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateDN {
    WebDriver page;
    public CreateDN(WebDriver page) {
        this.page=page;
    }
    public void VendorCreateDN(String VendorId, String Pass, String Title, String SourceCountry,
                               String DestinationCountry, String GrossWeight, String NetWeight,
                               String Volume, String DNQuantity, String LMId,String POTrn,String VendorName,WebDriver page) throws InterruptedException {
        page.findElement(By.id("Input_Email")).sendKeys("alpha123@cormsquare.com");Thread.sleep(1000);
        page.findElement(By.id("Input_Password")).sendKeys(Pass);
        page.findElement(By.id("login-submit")).click();
        try {
            WebDriverWait wait = new WebDriverWait(page, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = page.switchTo().alert();
            alert.accept();Thread.sleep(1000);
        } catch (NoSuchElementException e){
        }
        page.findElement(By.xpath("//div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")).click();Thread.sleep(1000);
        page.findElement(By.id("glbBtnChangeVendor")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//span[contains(text(),'Purchase Order')]")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//span[contains(text(),'" + Title + "')]")).click();Thread.sleep(3000);
        page.findElement(By.id("btnCreateDispatchNote")).click();Thread.sleep(1000);
        JavascriptExecutor js= (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0,-750)");Thread.sleep(1000);
        page.findElement(By.id("select2-sourceCountryId-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-search__field")).sendKeys(SourceCountry);Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
        page.findElement(By.id("select2-destinationCountryId-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-search__field")).sendKeys(DestinationCountry);Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
        JavascriptExecutor js1= (JavascriptExecutor) page;
        js1.executeScript("window.scrollBy(0,600)");Thread.sleep(1000);
        page.findElement(By.id("addDispatchNotePackages")).click();Thread.sleep(1000);
        page.findElement(By.id("select2-packagetypeId-container")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//li[contains(text(),'Carton')]")).click();Thread.sleep(1000);
        page.findElement(By.id("grossWeight")).sendKeys(GrossWeight);Thread.sleep(1000);
        page.findElement(By.id("netWeight")).sendKeys(NetWeight);Thread.sleep(1000);
        page.findElement(By.id("volume")).sendKeys(Volume);Thread.sleep(1000);
        page.findElement(By.id("quantity")).sendKeys(DNQuantity);Thread.sleep(1000);
        page.findElement(By.id("saveDispatchNotePackages")).click();Thread.sleep(1000);
        JavascriptExecutor js2= (JavascriptExecutor) page;
        js2.executeScript("window.scrollBy(0,1000)");Thread.sleep(1000);
        page.findElement(By.id("btnCreate")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(3000);
        LogOut.UserLogOut(page);
        DNAssign dnAssign = new DNAssign(page);
        dnAssign.LMAssignDN(LMId,Pass,POTrn,VendorName,VendorId,page);
    }
}
