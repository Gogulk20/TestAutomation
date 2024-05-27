package org.example.PO;


import org.example.LogOut.LogOut;
import org.openqa.selenium.*;

public class POCreate {

    public static void BuyerCreatePO(String AdminId, String Pass, String Title, WebDriver page) throws InterruptedException {
        page.findElement(By.id("Input_Email")).sendKeys(AdminId);Thread.sleep(1000);
        page.findElement(By.id("Input_Password")).sendKeys(Pass);Thread.sleep(1000);
        page.findElement(By.id("login-submit")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//span[contains(text(), 'Purchase Order Requests')]")).click();Thread.sleep(2000);
        page.findElement(By.xpath("//span[contains(text(),'"+Title+"')]")).click();Thread.sleep(3000);
        WebElement createPOContainer = page.findElement(By.id("createPOContainer"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) page;
        jsExecutor.executeScript("arguments[0].removeAttribute('style');", createPOContainer);Thread.sleep(1000);
        page.findElement(By.id("btnCreatePO")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();Thread.sleep(3000);
        LogOut.UserLogOut(page);
    }

}
