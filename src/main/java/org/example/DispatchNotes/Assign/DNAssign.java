package org.example.DispatchNotes.Assign;

import org.example.Inspection.Assign;
import org.example.WorkOrder.Create.CreateWO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DNAssign extends Assign {
    WebDriver page;
    public DNAssign(WebDriver page) throws InterruptedException {
        super(page);
        this.page=page;
    }

    public static void LMAssignDN(String LMId,String Pass,String POTrn,String VendorName,String VendorID,WebDriver page) throws InterruptedException {
        page.findElement(By.id("Input_Email")).sendKeys(LMId);Thread.sleep(1000);
        page.findElement(By.id("Input_Password")).sendKeys(Pass);Thread.sleep(1000);
        page.findElement(By.id("login-submit")).click();Thread.sleep(1000);
        page.findElement(By.id("ni-dispatch-notes")).click();Thread.sleep(3000);
        List<WebElement> rows = page.findElements(By.cssSelector("#listContainer tr td"));
        for (WebElement row : rows) {
            if (row.getText().contains(POTrn)) {
                WebElement btnLink = page.findElement(By.cssSelector(".btn-link"));
                btnLink.click();Thread.sleep(3000);
                break;
            }
        }
        page.findElement(By.id("dropdownMenuButton")).click();Thread.sleep(1000);
        page.findElement(By.id("btnToAssign")).click();Thread.sleep(1000);
        page.findElement(By.id("select2-assignerId-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-search__field")).sendKeys(LMId);Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
        page.findElement(By.id("saveAssine")).click();Thread.sleep(3000);
        CreateWO createWO = new CreateWO(page);
        createWO.LMCreateWO(VendorName,POTrn,VendorID,Pass,LMId,page);
    }
}
