package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CatalogBuyerManagerAssign {

    public static void BMAssign(String Pass, WebDriver page) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 100)", "");Thread.sleep(1000);
        String name = page.findElement(By.cssSelector("div.row div.col-md-4.mb-3:nth-child(21) > span.text-dark")).getText();
        LogOut.UserLogOut(page);
        page.findElement(By.id("Input_Email")).sendKeys(name);Thread.sleep(1000);
        page.findElement(By.id("Input_Password")).sendKeys(Pass);Thread.sleep(1000);
        page.findElement(By.id("login-submit")).click();Thread.sleep(2000);
        }
    }

