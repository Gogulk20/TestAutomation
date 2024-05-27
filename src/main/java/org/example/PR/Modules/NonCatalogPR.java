package org.example.PR.Modules;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NonCatalogPR {

    public static void NonCatalogCreateButton(WebDriver page) throws InterruptedException {
        page.findElement(By.cssSelector(".btn-primary")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//div/table/tbody/tr[2]/td[1]/a[1]")).click();Thread.sleep(1000);
    }
    public static void NonCatalogTitle(String Title, WebDriver page) throws InterruptedException {
        page.findElement(By.id("title")).sendKeys(Title);Thread.sleep(1000);

    }
    public static void NonCatalogProject(String Project, WebDriver page) throws InterruptedException {
        page.findElement(By.id("select2-projectId-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector("input[class='select2-search__field']")).sendKeys(Project);Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option--highlighted")).click();Thread.sleep(1000);
    }
    public static void NonCatalogWbs(String Wbs, WebDriver page) throws InterruptedException {
        page.findElement(By.id("select2-wbsId-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector("input[class='select2-search__field']")).sendKeys(Wbs);Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
    }
    public static void NonCatalogIncoterm(String Incterm, WebDriver page) throws InterruptedException {
        page.findElement(By.id("select2-incoterm-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector("input[class='select2-search__field']")).sendKeys(Incterm);Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
    }
    public static void NonCatalogShippingAdds(String Address, WebDriver page) throws InterruptedException {
        page.findElement(By.id("select2-shippingaddressId-container")).click();Thread.sleep(1000);
//        page.findElement(By.cssSelector("input[class='select2-search__field']")).sendKeys(Address);Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
    }
    public static void NonCatalogShippingMode(String Mode, WebDriver page) throws InterruptedException {
        page.findElement(By.id("select2-shippingmodeid-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector("input[class='select2-search__field']")).sendKeys(Mode);Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 100)", "");
    }
    public static void NonCatalogQuotationRequiredBy(WebDriver page) throws InterruptedException {
        WebElement Date = page.findElement(By.xpath("//main[1]/div[1]/form[1]/div[1]/div[2]/div[2]/div[1]/input[2]"));
        Date.click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".today")).click();Thread.sleep(1000);
    }
    public static void NonCatalogExpectedPOIssue(WebDriver page) throws InterruptedException {
        WebElement Date = page.findElement(By.xpath("//main[1]/div[1]/form[1]/div[1]/div[2]/div[2]/div[2]/input[2]"));Thread.sleep(1000);
        Date.click();Thread.sleep(1000);
        List<WebElement> elements = page.findElements(By.cssSelector("span.flatpickr-day.today"));
        elements.get(1).click();Thread.sleep(1000);
        }
    public static void NonCatalogExpectedDelivery( WebDriver page) throws InterruptedException {
        page.findElement(By.xpath("//main[1]/div[1]/form[1]/div[1]/div[2]/div[2]/div[3]/input[2]")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//div[6]/div[2]/div[1]/div[2]/div[1]/span[42]")).click();Thread.sleep(1000);
    }
    public static void NonCatalogBuyerManager(String Bm, WebDriver page) throws InterruptedException {
        page.findElement(By.id("select2-buyerManagerId-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector("input[class='select2-search__field']")).sendKeys(Bm);Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
    }
    public static void NonCatalogProjectManager(String Pm, WebDriver page) throws InterruptedException {
        page.findElement(By.id("select2-projectManagerId-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector("input[class='select2-search__field']")).sendKeys(Pm);Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
    }
    public static void NonCatalogOrderIntake(String OI, WebDriver page) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 500)", "");Thread.sleep(1000);
        page.findElement(By.id("orderintakeid")).sendKeys(OI);Thread.sleep(1000);
        JavascriptExecutor js1 = (JavascriptExecutor) page;
        js1.executeScript("window.scrollBy(0, 600)");
    }
    public static void NonCatalogTargetPrice(String TP, WebDriver page) throws InterruptedException {
        page.findElement(By.id("targetpriceid")).sendKeys(TP);Thread.sleep(1000);
    }
    public static void NonCatalogWarranty(WebDriver page) throws InterruptedException {
        page.findElement(By.id("select2-warrantyrequirementsid-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
    }
    public static void NonCatalogPriceValidity(WebDriver page) throws InterruptedException {
        page.findElement(By.id("select2-pricevalidityid-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 600)");
    }
    public static void NonCatalogItems(String ItemsQty, WebDriver page) throws InterruptedException {
        //Items Category
        page.findElement(By.id("addLineRequisitionItems")).click();Thread.sleep(1000);
        page.findElement(By.id("select2-categoryid-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
        //Items
        page.findElement(By.id("select2-itemid-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
        //Quantity
        page.findElement(By.id("quantity")).sendKeys(ItemsQty);Thread.sleep(1000);
        page.findElement(By.id("saveRequisitionItem")).click();Thread.sleep(1000);
    }
    public static void NonCatalogNotes(String PRNotes, WebDriver page) throws InterruptedException {
        page.findElement(By.id("notes")).sendKeys(PRNotes);Thread.sleep(1000);
    }
    public static void NonCatalogAttachments(String File1, String File2, WebDriver page) throws InterruptedException {
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
    public static void NonCatalogCreaete(WebDriver page) throws InterruptedException {
        page.findElement(By.id("btnCreate")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();Thread.sleep(4000);
    }
}


