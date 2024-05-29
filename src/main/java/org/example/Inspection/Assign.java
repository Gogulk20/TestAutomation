package org.example.Inspection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Assign {
    WebDriver page;
    public Assign(WebDriver page){
        this.page=page;
    }
    public void RequesterAssignIns(String ReqId,String Pass,String Title,WebDriver page) throws InterruptedException {
        page.findElement(By.id("Input_Email")).sendKeys(ReqId);Thread.sleep(1000);
        page.findElement(By.id("Input_Password")).sendKeys(Pass);Thread.sleep(1000);
        page.findElement(By.id("login-submit")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//span[contains(text(),'Purchase Orders')]")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//span[contains(text(),'" + Title + "')]")).click();Thread.sleep(3000);
        String POTrn = page.findElement(By.id("transactionIdLink")).getText();
        System.out.println(POTrn);
        page.findElement(By.xpath("//span[contains(text(),'Order Schedules')]")).click();Thread.sleep(1000);
        List<WebElement> rows = page.findElements(By.cssSelector("#listContainer tr td"));
        for (WebElement row : rows) {
            if (row.getText().contains(POTrn)) {
                WebElement btnLink = page.findElement(By.cssSelector(".btn-link"));
                btnLink.click();Thread.sleep(1000);
                break;
            }
        }
        page.findElement(By.id("btnAssignInspector")).click();Thread.sleep(1000);
        page.findElement(By.id("select2-InspectionId-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-search__field")).sendKeys(ReqId);Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
        page.findElement(By.id("saveInspector")).click();Thread.sleep(3000);
        Create create = new Create(page);
        create.RequesterCreateIns(page);
    }
}
