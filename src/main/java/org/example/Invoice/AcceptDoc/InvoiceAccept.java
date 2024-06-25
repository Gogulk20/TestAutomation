package org.example.Invoice.AcceptDoc;

import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InvoiceAccept {
    WebDriver page;
    public InvoiceAccept(WebDriver page){
        this.page=page;
        PageFactory.initElements(page,this);
    }
    public String AcceptInvoice(String BuyerId, String Pass, String POTrn) throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(BuyerId, Pass);
        page.findElement(By.xpath("//span[contains(text(),'Invoices')]")).click();Thread.sleep(3000);
        List<WebElement> rows = page.findElements(By.cssSelector("#listContainer tr td"));Thread.sleep(1000);
        for (WebElement row : rows) {
            if (row.getText().contains(POTrn)) {
                WebElement btnLink = page.findElement(By.cssSelector(".btn-link"));
                btnLink.click();Thread.sleep(3000);
                break;
            }
        }
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 1500)");Thread.sleep(1000);
        page.findElement(By.xpath("//main[1]/div[1]/div[3]/div[2]/div[1]/div[9]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/button[1]")).click();Thread.sleep(1000);
        page.findElement(By.id("selctAllId")).click();Thread.sleep(1000);
        page.findElement(By.id("acceptCheckListId")).click();Thread.sleep(1000);
        js.executeScript("window.scrollBy(0, 600)");Thread.sleep(1000);
        page.findElement(By.xpath("//main[1]/div[1]/div[3]/div[2]/div[1]/div[9]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td[6]/button[1]")).click();Thread.sleep(1000);
        page.findElement(By.id("acceptCheckListId")).click();Thread.sleep(1000);
        js.executeScript("window.scrollBy(0, 600)");Thread.sleep(1000);
        page.findElement(By.id("btnAccept")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(1000);
        js.executeScript("window.scrollBy(0, -2500)");Thread.sleep(1000);
        page.findElement(By.id("btnSendApproval")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();Thread.sleep(1000);
        js.executeScript("window.scrollBy(0, 2000)");Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(page, Duration.ofSeconds(5));
        WebElement panel1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(text(),'Approver')]")));
        ((JavascriptExecutor) page).executeScript("arguments[0].scrollIntoView(true);", panel1);
        String ApproverUserId = page.findElement(By.xpath("//main[1]/div[1]/div[3]/div[2]/div[1]/div[10]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]")).getText();Thread.sleep(1000);
        LogOut.UserLogOut(page);
        return ApproverUserId;
    }
}
