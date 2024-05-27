package org.example.LogOut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOut {
    public static void UserLogOut(WebDriver page) throws InterruptedException {
        page.findElement(By.cssSelector(".avatar-img")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector("a[onclick='user_logout()']")).click();Thread.sleep(1000);
    }
}
