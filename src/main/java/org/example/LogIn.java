package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn{

    //    public static void RequesterId(WebDriver page){
//        page.findElement(By.id("Input_Email")).sendKeys("requester@cormsquare.com");
//        page.findElement(By.id("Input_Password")).sendKeys("Admin@123");
//        page.findElement(By.id("login-submit")).click();
//
//
//    }
    public static void RequesterId(String ReqId, String Pass, WebDriver page) {
        page.findElement(By.id("Input_Email")).sendKeys(ReqId);
        page.findElement(By.id("Input_Password")).sendKeys(Pass);
        page.findElement(By.id("login-submit")).click();
    }
}