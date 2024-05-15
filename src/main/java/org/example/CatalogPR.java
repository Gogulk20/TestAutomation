package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class CatalogPR {

    public static void CatalogCreateButton(WebDriver page) throws InterruptedException {
        page.findElement(By.cssSelector(".btn-primary")).click();
        Thread.sleep(1000);
        page.findElement(By.xpath("//div/table/tbody/tr[1]/td[1]/a[1]")).click();
        Thread.sleep(1000);
    }
    public static void CatalogTitle(String Title, WebDriver page) throws InterruptedException {
        page.findElement(By.id("title")).sendKeys(Title);Thread.sleep(1000);

    }
    public static void CatalogProject(String Project, WebDriver page) throws InterruptedException {
        page.findElement(By.id("select2-projectId-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector("input[class='select2-search__field']")).sendKeys(Project);Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option--highlighted")).click();Thread.sleep(1000);
    }
    public static void CatalogWbs(String Wbs, WebDriver page) throws InterruptedException {
        page.findElement(By.id("select2-wbsId-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector("input[class='select2-search__field']")).sendKeys(Wbs);Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
    }
    public static void CatalogVendor(String Vendor, WebDriver page) throws InterruptedException {
        page.findElement(By.id("select2-vendorId-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector("input[class='select2-search__field']")).sendKeys(Vendor);Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
    }
    public static void CatalogRc(String Rc, WebDriver page) throws InterruptedException {
        page.findElement(By.id("select2-rateContractId-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector("input[class='select2-search__field']")).sendKeys(Rc);Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
    }
    public static void CatalogShippingAdds(String Address, WebDriver page) throws InterruptedException {
        page.findElement(By.id("select2-shippingaddressId-container")).click();Thread.sleep(1000);
//        page.findElement(By.cssSelector("input[class='select2-search__field']")).sendKeys(Address);Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
    }
    public static void CatalogShippingMode(String Mode, WebDriver page) throws InterruptedException {
        page.findElement(By.id("select2-shippingModeId-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector("input[class='select2-search__field']")).sendKeys(Mode);Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 100)", "");
    }
    public static void CatalogExpectedPOIssue(WebDriver page) throws InterruptedException {
        WebElement Date = page.findElement(By.xpath("//div/div[2]/div[1]/input[2]"));Thread.sleep(1000);
        Date.click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".today")).click();
    }
    public static void CatalogExpectedDelivery( WebDriver page) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 500)", "");
        page.findElement(By.xpath("//div/div[2]/div[2]/input[2]")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector("body > div.flatpickr-calendar.animate.arrowTop.arrowLeft.open > div.flatpickr-innerContainer > div > div.flatpickr-days > div > span:nth-child(30)")).click();
    }
    public static void CatalogBuyerManager(String Bm, WebDriver page) throws InterruptedException {
        page.findElement(By.id("select2-buyerManagerId-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector("input[class='select2-search__field']")).sendKeys(Bm);Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
    }
    public static void CatalogProjectManager(String Pm, WebDriver page) throws InterruptedException {
        page.findElement(By.id("select2-projectManagerId-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector("input[class='select2-search__field']")).sendKeys(Pm);Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
    }
    public static void CatalogOrderIntake(String OI, WebDriver page) throws InterruptedException {
        page.findElement(By.id("orderInTakeId")).sendKeys(OI);Thread.sleep(1000);
//        page.findElement(By.id("orderInTakeId")).sendKeys(OI);Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 600)");
    }
    public static void CatalogItems(String ItemsQty, WebDriver page) throws InterruptedException {
        //Items Category
        page.findElement(By.id("addLineRequisitionItems")).click();Thread.sleep(1000);
        page.findElement(By.id("select2-categoryId-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
        //Items
        page.findElement(By.id("select2-itemId-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
        //Quantity
        page.findElement(By.id("quantity")).sendKeys(ItemsQty);Thread.sleep(1000);
        page.findElement(By.id("saveRequisitionItem")).click();Thread.sleep(1000);
    }
    public static void CatalogNotes(String PRNotes, WebDriver page) throws InterruptedException {
        page.findElement(By.id("notes")).sendKeys(PRNotes);Thread.sleep(1000);
    }
    public static void CatalogAttachments(String File1, String File2, WebDriver page) throws InterruptedException {
        page.findElement(By.id("attachDocs")).click();Thread.sleep(1000);
        WebElement file = (page.findElement(By.id("formFilePreupload")));
        file.sendKeys(File1);Thread.sleep(2000);
        page.findElement(By.id("saveAttachments1")).click();Thread.sleep(1000);
        WebElement file2 = (page.findElement(By.id("formFilePreupload")));Thread.sleep(1000);
        file2.sendKeys(File2);Thread.sleep(2000);
        page.findElement(By.id("saveAttachments1")).click();Thread.sleep(1000);
        page.findElement(By.id("submitAttachmentsId")).click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 600)");
    }
    public static void CatalogCreaete(WebDriver page) throws InterruptedException {
        page.findElement(By.id("btnCreate")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();Thread.sleep(4000);
    }
}