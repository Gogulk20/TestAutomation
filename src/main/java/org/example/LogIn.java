package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogIn{

    public static void RequesterId(String ReqId, String Pass, WebDriver page){
        page.findElement(By.id("Input_Email")).sendKeys(ReqId);
        page.findElement(By.id("Input_Password")).sendKeys(Pass);
        page.findElement(By.id("login-submit")).click();


    }

}
