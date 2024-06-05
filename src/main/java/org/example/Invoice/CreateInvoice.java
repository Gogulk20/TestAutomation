package org.example.Invoice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateInvoice {
    WebDriver page;
    public CreateInvoice(WebDriver page){
        this.page=page;
    }
    public void VendorCreateInvoice(String VendorId,String Pass,WebDriver page) throws InterruptedException {
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
        page.findElement(By.xpath("//span[contains(text(),'Invoices')]")).click();Thread.sleep(3000);
        page.findElement(By.xpath("//i[contains(text(),'Create Invoice')]")).click();Thread.sleep(3000);
    }
}
