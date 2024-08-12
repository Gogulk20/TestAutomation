package org.example.RFQ.InviteVendor;

import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.example.Variables.YKMain.*;

public class InviteGuestVendor {
    WebDriver page;

    public InviteGuestVendor(WebDriver page) {
        this.page = page;
        PageFactory.initElements(page, this);
    }

    public void GuestVendorInvite() throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(BuyerId, Pass);Thread.sleep(1000);
        page.findElement(By.xpath("//span[contains(text(),'Request For Quotations')]")).click();Thread.sleep(2000);
        page.findElement(By.xpath("//span[contains(text(),'" + Title + "')]")).click();Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) page;
        js1.executeScript("window.scrollBy(0, 1100)");Thread.sleep(1000);
        page.findElement(By.id("addRequestForQuotationGuestVendors")).click();Thread.sleep(1000);
        page.findElement(By.id("vendorName")).sendKeys(VendorName);Thread.sleep(1000);
        page.findElement(By.id("vendorEmail")).sendKeys("vendor@sharklasers.com");Thread.sleep(1000);
        page.findElement(By.id("saveRequestForQuotationGuestVendor")).click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 700)");Thread.sleep(1000);
        page.findElement(By.id("vendorSendMailBtnId")).click();Thread.sleep(3000);
        try {
            String originalWindow = page.getWindowHandle();
            ((JavascriptExecutor) page).executeScript("window.open('https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&osid=1&passive=1209600&service=mail&ifkv=AdF4I776KoTuVgmiREjkJ4ATSe99rxApiWKsVA7e7LkYXU4X1BdY3O54tUkFZTY9JoiATMXVUDtiog&ddm=0&flowName=GlifWebSignIn&flowEntry=ServiceLogin', '_blank');");
            Thread.sleep(1000);
            Set<String> allWindows = page.getWindowHandles();
            for (String windowHandle : allWindows) {
                if (!windowHandle.equals(originalWindow)) {
                    page.switchTo().window(windowHandle);
                    break;
                }
            }
            page.findElement(By.id("identifierId")).sendKeys("procure@cormsquare.com");Thread.sleep(2000);
            page.findElement(By.xpath("//span[contains(text(), 'Next')]")).click();Thread.sleep(5000);
            page.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).click();Thread.sleep(1000);
            page.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("Admin@123");Thread.sleep(1000);
            page.findElement(By.xpath("//span[contains(text(), 'Next')]")).click();Thread.sleep(5000);

            WebDriverWait wait = new WebDriverWait(page, Duration.ofSeconds(10));
            boolean found = false;
            while (!found) {
                List<WebElement> mailList = page.findElements(By.xpath("/html[1]/body[1]/div[8]/div[3]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/table[1]/tbody[1]/tr/td[5]"));
                for (WebElement guestVendorMail : mailList) {
                    String mailText = guestVendorMail.getText();
                    if (mailText.contains("vendor@sharklasers.com")) {
                        wait.until(ExpectedConditions.elementToBeClickable(guestVendorMail));
                        guestVendorMail.click();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    try {
                        Thread.sleep(2000); // 1 second
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                js.executeScript("window.scrollBy(0, 1500)");Thread.sleep(1000);
                String MailPassword = page.findElement(By.xpath("//p[contains(text(),'Password')]")).getText();Thread.sleep(1000);
                System.out.println(MailPassword);
                String[] FullPassword = ((MailPassword.split(": ")));Thread.sleep(1000);
                String Password = FullPassword[1].trim();Thread.sleep(1000);
                System.out.println(Password);Thread.sleep(1000);
                page.findElement(By.xpath("//a[contains(text(),'Click here')]")).click();Thread.sleep(4000);
//                page.switchTo().frame(page.findElement(By.cssSelector("div[class='content container-fluid']")));

            }
        } catch (Exception e){
        }
        page.switchTo().frame(page.findElement(By.cssSelector("div[class='content container-fluid']")));
        String email =page.findElement(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/label[1]")).getText();
        System.out.println(email);
        WebElement emailFieldpage = page.findElement(By.id("email"));
        emailFieldpage.sendKeys("744444811");
//                ("vendor@sharklasers.com");Thread.sleep(1000);
        page.findElement(By.cssSelector("#password")).sendKeys("Password");Thread.sleep(1000);
        page.findElement(By.id("btnLogin")).click();Thread.sleep(3000);
    }
}