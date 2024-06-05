package org.example.RFQ;

import org.example.POR.CreatePOR.NonCatalogPOR;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CommercialEvaluation {
    WebDriver page;
    public CommercialEvaluation(WebDriver page) {
        this.page=page;
    }

    public void BuyerCreateCE(String BuyerId, String Pass, String Title,String PORNotes,
                              String PreOrDict,String PRGroupB, String PRGroupC,
                              String PRGroupD,String AdminId,String VendorId,String POTrn,String ReqId,
                              String SourceCountry, String DestinationCountry, String GrossWeight, String NetWeight,
                              String Volume, String DNQuantity,String LMId,String VendorName,WebDriver page) throws InterruptedException {
        page.findElement(By.id("Input_Email")).sendKeys(BuyerId);Thread.sleep(1000);
        page.findElement(By.id("Input_Password")).sendKeys(Pass);Thread.sleep(1000);
        page.findElement(By.id("login-submit")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//span[contains(text(),'Request For Quotations')]")).click();Thread.sleep(2000);
        page.findElement(By.xpath("//span[contains(text(),'" + Title + "')]")).click();Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 2000)");Thread.sleep(1000);
        page.findElement(By.id("btnCreateCE")).click();
        JavascriptExecutor js1 = (JavascriptExecutor) page;
        js1.executeScript("window.scrollBy(0, 2000)");Thread.sleep(1000);
        js1.executeScript("document.querySelector('.table-responsive').scrollTop=5000");Thread.sleep(1000);
        page.findElement(By.xpath("//body[1]/main[1]/div[1]/div[4]/div[1]/div[1]/form[1]/fieldset[1]/div[1]/table[1]/tbody[1]/tr[19]/td[2]/select[1]")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//body[1]/main[1]/div[1]/div[4]/div[1]/div[1]/form[1]/fieldset[1]/div[1]/table[1]/tbody[1]/tr[19]/td[2]/select[1]/option[1]")).click();Thread.sleep(1000);
        page.findElement(By.id("btnSubmitCE")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(2000);
        JavascriptExecutor js2 = (JavascriptExecutor) page;
        js2.executeScript("window.scrollBy(0, 1400)");Thread.sleep(1000);
        page.findElement(By.xpath("//a[contains(text(),'Create POR')]")).click();Thread.sleep(2000);
        NonCatalogPOR nonCatalogPOR = new NonCatalogPOR(page);
        nonCatalogPOR.BuyerCreatePOR(PORNotes,PreOrDict,Pass,Title,PRGroupB,PRGroupC,PRGroupD,AdminId,BuyerId,VendorId,POTrn,ReqId, SourceCountry, DestinationCountry,GrossWeight,NetWeight,Volume,DNQuantity,LMId,VendorName,page);
    }
}
