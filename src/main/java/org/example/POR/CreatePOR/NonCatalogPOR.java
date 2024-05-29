package org.example.POR.CreatePOR;

import org.example.POR.ApprovalAssign.PMApprovalAssign;
import org.example.POR.SendForApproval.PORSendForApproval;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class NonCatalogPOR {
    WebDriver page;
    public NonCatalogPOR(WebDriver page) {
        this.page=page;
    }

    public void BuyerCreatePOR(String PORNotes,String PreOrDict,String Pass,String Title,String PRGroupB, String PRGroupC,
                               String PRGroupD,String AdminId, String BuyerId,String VendorId,String ReqId,WebDriver page) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 1000)");Thread.sleep(1000);
        page.findElement(By.id("notBelow5L")).click();Thread.sleep(1000);
        JavascriptExecutor js1 = (JavascriptExecutor) page;
        js1.executeScript("window.scrollBy(0, 1500)");Thread.sleep(1000);
        page.findElement(By.id("select2-taxCodeId-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
        JavascriptExecutor js2 = (JavascriptExecutor) page;
        js2.executeScript("window.scrollBy(0, 700)");Thread.sleep(1000);
        //POR Notes
        page.findElement(By.id("notes")).sendKeys(PORNotes);Thread.sleep(1000);
        //POR Create
        page.findElement(By.id("btnCreate")).click();Thread.sleep(2000);
        page.findElement(By.xpath("//button[contains(text(), 'Yes')]")).click();Thread.sleep(3000);
        PORSendForApproval.SendForApproval(PreOrDict,Pass,page);
        PMApprovalAssign.PORApproval(Title, PRGroupB, PRGroupC, PRGroupD, Pass, AdminId,BuyerId,VendorId,ReqId,page);
    }
}
