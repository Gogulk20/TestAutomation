package org.example.PR.AssignBuyer;
import org.example.LogOut.LogOut;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class PRAssignBuyer {
    public static void BuyerAssign(String Bm, String Pass,String BuyerId, String Title, WebDriver page) throws InterruptedException {
        page.findElement(By.id("Input_Email")).sendKeys(Bm);Thread.sleep(1000);
        page.findElement(By.id("Input_Password")).sendKeys(Pass);Thread.sleep(1000);
        page.findElement(By.id("login-submit")).click();Thread.sleep(3000);
        page.findElement(By.xpath("//span[contains(text(),'"+ Title +"')]")).click();Thread.sleep(2000);
        page.findElement(By.id("btnAssignUser")).click();Thread.sleep(1000);
        page.findElement(By.id("select2-bgUser-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector("input[class='select2-search__field']")).sendKeys(BuyerId);Thread.sleep(2000);
        page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
        page.findElement(By.id("saveBuyerUser")).click();Thread.sleep(2000);
        LogOut.UserLogOut(page);Thread.sleep(1000);
    }
}
