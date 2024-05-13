package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.LogOut.UserLogOut;

public class PORSendForApproval {
    //public static void SendForApproval(String Pass, WebDriver page) throws InterruptedException {
    public static void SendForApproval (String PreOrDict, String Pass, WebDriver page) throws InterruptedException {
        page.findElement(By.id("btnNewSendApproval")).click();
        Thread.sleep(1000);
        WebElement ApprovalPopup = page.findElement(By.cssSelector(".modal-content"));
        if (ApprovalPopup.isEnabled()) {
//            WebElement ChiefFO = page.findElement(By.xpath("//label[contains(text(),'Chief Financial Officer')]"));
//        if (ChiefFO.isDisplayed()){
//            page.findElement(By.id("role-7")).click();
//            page.findElement(By.xpath(".select2-results__option--highlighted")).click();
//        }
            WebElement ChiefPresidentOrDirector = page.findElement(By.xpath("//label[contains(text(),'President / Director (Corporate)')]"));
            if (ChiefPresidentOrDirector.isDisplayed()) {
                page.findElement(By.id("select2-role-8-container")).click();Thread.sleep(1000);
                page.findElement(By.cssSelector(".select2-search__field")).sendKeys(PreOrDict);Thread.sleep(1000);
                page.findElement(By.cssSelector(".select2-results__option--highlighted")).click();Thread.sleep(1000);
                page.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();Thread.sleep(1000);
            }
        }
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 2950)");
        WebElement approvalPanel = page.findElement(By.id("approvalPanel"));
        approvalPanel.findElements(By.tagName("tr"));
        String PMId = approvalPanel.findElement(By.xpath("//div[1]/div[3]/div[2]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/table/tbody/tr[1]/td[3]")).getText();
        LogOut.UserLogOut(page);Thread.sleep(1000);
        page.findElement(By.id("Input_Email")).sendKeys(PMId);Thread.sleep(1000);
        page.findElement(By.id("Input_Password")).sendKeys(Pass);Thread.sleep(1000);
        page.findElement(By.id("login-submit")).click();Thread.sleep(1000);

    }
}