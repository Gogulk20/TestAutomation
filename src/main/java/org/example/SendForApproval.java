package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendForApproval {
    public static void Approval(WebDriver page) throws InterruptedException {
        page.findElement(By.id("btnSendApproval")).click();
        page.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();Thread.sleep(1000);
    }
}
