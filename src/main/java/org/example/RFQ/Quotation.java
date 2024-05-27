package org.example.RFQ;

import org.example.LogOut.LogOut;
import org.example.Methods.NonCatalogMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Quotation extends NonCatalogMethods {
    WebDriver page;
    public Quotation(WebDriver page) {
        this.page=page;
    }

    public void QuotationSubmission(String VendorId, String Pass, String Title, String InctLocation, String QuoRefNum, String Gst, String File1, String File2, WebDriver page) throws InterruptedException {
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
            page.findElement(By.xpath("//span[contains(text(),'" + Title + "')]")).click();Thread.sleep(1000);
            page.findElement(By.id("btnSendQuote")).click();Thread.sleep(1000);
            page.findElement(By.id("incotermLocation")).sendKeys(InctLocation);Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 500)");Thread.sleep(1000);
        page.findElement(By.id("quotationReferenceNumber")).sendKeys(QuoRefNum);Thread.sleep(1000);
        page.findElement(By.xpath("//main[1]/div[1]/form[1]/div[1]/div[2]/div[2]/div[13]/div[6]/div[1]/input[2]")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//div[5]/div[2]/div[1]/div[2]/div[1]/span[42]")).click();Thread.sleep(1000);
        page.findElement(By.id("liquidatedComplyId")).click();Thread.sleep(1000);
        page.findElement(By.id("rohsComplyId")).click();Thread.sleep(1000);
        page.findElement(By.id("warrantyRequirementsComplyId")).click();Thread.sleep(1000);
        JavascriptExecutor js1 = (JavascriptExecutor) page;
        js1.executeScript("window.scrollBy(0, 500)");Thread.sleep(1000);

        double[] rate = {150.32, 100.65, 481.0, 145.0, 160.3};
        int[] discount = {22, 14, 13, 26, 19};
        List<WebElement> table = page.findElements(By.xpath("//main[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr"));

        if (table.size() <= rate.length) {
            for (int i = 0; i < table.size(); i++) {
                int index = i + 1;
                page.findElement(By.id("hsCode-" + index)).sendKeys("1234");
                page.findElement(By.id("make-" + index)).sendKeys("7851");
                page.findElement(By.id("model-" + index)).sendKeys("65456");
                page.findElement(By.id("partNumber-" + index)).sendKeys("53212");
                page.findElement(By.id("countryOfOrigin-" + index)).sendKeys("IND");
                String rateValues = String.valueOf(rate[i]);
                page.findElement(By.id("rate-" + index)).sendKeys(rateValues);
                String discountValues = String.valueOf(discount[i]);
                page.findElement(By.id("discount-" + index)).clear();
                page.findElement(By.id("discount-" + index)).sendKeys(discountValues);
                page.findElement(By.id("leadTime-" + index)).sendKeys("34");
                page.findElement(By.id("notes-" + index)).sendKeys("NA");
            }
        }
        page.findElement(By.id("gstId")).sendKeys(Gst);Thread.sleep(1000);
        JavascriptExecutor js2 = (JavascriptExecutor) page;
        js2.executeScript("window.scrollBy(0, 500)");Thread.sleep(1000);
        page.findElement(By.id("attachFile")).click();Thread.sleep(1000);
        WebElement file = page.findElement(By.id("formFilePreupload"));Thread.sleep(1000);
        file.sendKeys(File1);Thread.sleep(3000);
        page.findElement(By.id("select2-attachmentTypeId-container")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//li[contains(text(),'Technical')]")).click();Thread.sleep(1000);
        page.findElement(By.id("attachmentSaveId")).click();Thread.sleep(1000);
        page.findElement(By.id("attachFile")).click();Thread.sleep(1000);
        WebElement file2 = page.findElement(By.id("formFilePreupload"));Thread.sleep(1000);
        file2.sendKeys(File2);Thread.sleep(3000);
        page.findElement(By.id("select2-attachmentTypeId-container")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//li[contains(text(),'Commercial')]")).click();Thread.sleep(1000);
        page.findElement(By.id("attachmentSaveId")).click();Thread.sleep(1000);
        JavascriptExecutor js4 = (JavascriptExecutor) page;
        js4.executeScript("window.scrollBy(0, 500)");Thread.sleep(1000);
        page.findElement(By.id("btnCreate")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(2000);
        LogOut.UserLogOut(page);
    }

}
