package org.example.LogOut;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOut {
//    WebDriver page;
//    public LogOut(WebDriver page){
//        this.page=page;
//        PageFactory.initElements(page,this);
//    }
//    @FindBy(css = ".avatar-img")
//    WebElement UserProfile;
//
//    @FindBy(css = "a[onclick='user_logout()']")
//    WebElement UserIdLogOut;
//
//    public void UserLogOut() throws InterruptedException {
//        UserProfile.click();
//        UserIdLogOut.click();
//    }
        public static void UserLogOut(WebDriver page) throws InterruptedException {
        page.findElement(By.cssSelector(".avatar-img")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector("a[onclick='user_logout()']")).click();Thread.sleep(2000);
    }

}
