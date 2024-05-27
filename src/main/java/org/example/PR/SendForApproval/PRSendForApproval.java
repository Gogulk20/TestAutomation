package org.example.PR.SendForApproval;

import org.example.LogOut.LogOut;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PRSendForApproval {
    public static void Approval(WebDriver page) throws InterruptedException {
        page.findElement(By.xpath("//button[contains(text(),'Send for Approval')]")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();Thread.sleep(2000);
        LogOut.UserLogOut(page);
    }
}
