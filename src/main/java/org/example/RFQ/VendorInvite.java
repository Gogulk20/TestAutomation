package org.example.RFQ;

import org.example.LogOut.LogOut;
import org.example.Methods.NonCatalogMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class VendorInvite extends NonCatalogMethods {
WebDriver page;
    public VendorInvite(WebDriver page) {
        this.page=page;
    }

    public void InviteVendor(String VendorId, WebDriver page) throws InterruptedException {
        JavascriptExecutor js1 = (JavascriptExecutor) page;
        js1.executeScript("window.scrollBy(0, 1100)");Thread.sleep(1000);
        page.findElement(By.id("addRequestForQuotationVendors")).click();Thread.sleep(1000);
        page.findElement(By.id("select2-vendorId-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-search__field")).sendKeys(VendorId);Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
        page.findElement(By.id("saveRequestForQuotationVendor")).click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 1000)");Thread.sleep(1000);
        page.findElement(By.id("vendorSendMailBtnId")).click();Thread.sleep(2000);
        LogOut.UserLogOut(page);Thread.sleep(1000);
    }
}
