package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CatalogPOR {

    public static void CreatePOR (String BuyerId, String Pass, String Title, String PORNotes, WebDriver page) throws InterruptedException {
        page.findElement(By.id("Input_Email")).sendKeys(BuyerId);Thread.sleep(1000);
        page.findElement(By.id("Input_Password")).sendKeys(Pass);Thread.sleep(1000);
        page.findElement(By.id("login-submit")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//span[contains(text(), '"+Title+"')]")).click();Thread.sleep(2000);
        page.findElement(By.id("btnCreatePOR")).click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 1750)");Thread.sleep(1000);
        page.findElement(By.id("select2-taxCodeId-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
        JavascriptExecutor js1 = (JavascriptExecutor) page;
        js1.executeScript("window.scrollBy(0, 700)");Thread.sleep(1000);
        page.findElement(By.id("notes")).sendKeys(PORNotes);
        page.findElement(By.id("btnCreate")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//button[contains(text(), 'Yes')]")).click();Thread.sleep(2000);
    }
}
