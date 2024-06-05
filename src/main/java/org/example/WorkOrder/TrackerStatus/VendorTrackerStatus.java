package org.example.WorkOrder.TrackerStatus;


import org.example.LogOut.LogOut;
import org.example.WorkOrder.OkForInvoice.OkForInvoice;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class VendorTrackerStatus {
    WebDriver page;
    public VendorTrackerStatus(WebDriver page){
        this.page=page;
    }
    public void VendorUpdateTS(String VendorId, String Pass, String POTrn,String LMId,WebDriver page) throws  InterruptedException{
        page.findElement(By.id("Input_Email")).sendKeys(VendorId);Thread.sleep(1000);
        page.findElement(By.id("Input_Password")).sendKeys(Pass);Thread.sleep(1000);
        page.findElement(By.id("login-submit")).click();Thread.sleep(1000);
        try {
            WebDriverWait wait = new WebDriverWait(page, Duration.ofSeconds(7));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = page.switchTo().alert();
            alert.accept();
            Thread.sleep(1000);
        } catch (NoSuchElementException e){
        }
        page.findElement(By.xpath("//div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")).click();Thread.sleep(1000);
        page.findElement(By.id("glbBtnChangeVendor")).click();Thread.sleep(3000);
        page.findElement(By.xpath("//span[contains(text(),'Work Orders')]")).click();Thread.sleep(1000);
        List<WebElement> rows = page.findElements(By.cssSelector("#listContainer tr td"));
        for (WebElement row : rows) {
            if (row.getText().contains(POTrn)) {
                WebElement btnLink = page.findElement(By.cssSelector(".btn-link"));
                btnLink.click();Thread.sleep(3000);
                break;
            }
        }
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0,1750)");Thread.sleep(1000);
        page.findElement(By.id("select2-statusId-container")).click();Thread.sleep(1000);
        List<WebElement> status = page.findElements(By.xpath("//span[1]/span[1]/span[2]/ul[1]/li"));
        List<String> statusList = status.stream().map(a->a.getText()).collect(Collectors.toList());
        for(int i=0; i<statusList.size();i++){
            String statusName = statusList.get(i);
            WebElement Date = page.findElement(By.xpath("//main[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[5]/div[1]/div[2]/form[1]/div[1]/div[1]/input[2]"));Thread.sleep(1000);
            Date.click();Thread.sleep(1000);
            page.findElement(By.cssSelector(".today")).click();Thread.sleep(1000);
            page.findElement(By.id("select2-statusId-container")).click();Thread.sleep(1000);
            page.findElement(By.xpath("//li[contains(text(), '" + statusName + "')]")).click();
            page.findElement(By.id("btnSubmit")).click();Thread.sleep(1000);
            page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(3000);
            JavascriptExecutor js1 = (JavascriptExecutor) page;
            js1.executeScript("window.scrollBy(0,750)");Thread.sleep(1000);
        }
        LogOut.UserLogOut(page);
        OkForInvoice okForInvoice = new OkForInvoice(page);
        okForInvoice.LMClickOkForInvoice(LMId,Pass,POTrn,page);
    }
}
