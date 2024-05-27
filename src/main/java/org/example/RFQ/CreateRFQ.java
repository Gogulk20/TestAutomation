package org.example.RFQ;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CreateRFQ {
    WebDriver page;

    public CreateRFQ(WebDriver page) {
        this.page = page;
    }

    public void CreateRFQ(String BuyerId, String Pass, String Title, String RFQNotes, WebDriver page) throws InterruptedException {
        page.findElement(By.id("Input_Email")).sendKeys(BuyerId);
        page.findElement(By.id("Input_Password")).sendKeys(Pass);
        page.findElement(By.id("login-submit")).click();
        page.findElement(By.xpath("//span[contains(text(), 'Requisitions')]")).click();Thread.sleep(2000);
        page.findElement(By.xpath("//span[contains(text(),'"+Title+"')]")).click();Thread.sleep(2000);
        page.findElement(By.id("btnCreateRFQ")).click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 2000)");Thread.sleep(1000);
        page.findElement(By.id("notes")).sendKeys(RFQNotes);Thread.sleep(1000);
        page.findElement(By.id("btnCreate")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();Thread.sleep(2000);
        }
}
