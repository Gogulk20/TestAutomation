import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class LoginList {
    public static void ListCredentials() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        options.addArguments("--remote-allow-origins=*");
        WebDriver logindriver = new ChromeDriver(options);
        logindriver.get("https://yef-test.cormsquare.com/Identity/Account/Login");
        logindriver.manage().window().maximize();

        String[] userId = {"requester@cormsquare.com", "checker@cormsquare.com", "projectmanager@cormsquare.com",
                "genpactlead@cormsquare.com", "genpactbuyer@cormsquare.com", "buyermanager@cormsquare.com",
                "buyer@cormsquare.com", "admin@cormsquare.com", "alpha123@cormsquare.com"};
        String password = "Admin@123";
        String[] modulesBuyerPortal = {"Requisitions", "Request For Quotations", "Purchase Order Requests", "Purchase Orders",
                "Order Schedules", "Inspections", "Dispatch Notes", "Goods Receipts", "Work Orders", "Invoices"};
        String[] modulesVendorPortal = {"Request For Quotations", "Purchase Orders", "Order Schedules", "Inspections",
                "Dispatch Notes", "Work Orders", "Invoices"};

        String id = "alpha123@cormsquare.com";

        for (String currentUser : userId) {
            int i = 0;
            if (!currentUser.equals(id)) {
                logindriver.findElement(By.id("Input_Email")).sendKeys(currentUser);
                logindriver.findElement(By.id("Input_Password")).sendKeys(password);
                logindriver.findElement(By.id("login-submit")).click();
                Thread.sleep(3000);

                for (String module1 : modulesBuyerPortal) {
                    try {
                        String moduleIDBuyer = "ni-" + module1.toLowerCase().replace(" ", "-");
                        logindriver.findElement(By.id(moduleIDBuyer)).click();
                        Thread.sleep(3000);

                        WebElement data = logindriver.findElement(By.id("listContainer"));
                        if (data.isDisplayed()) {
                            System.out.println("Elements is present on the WebPage " + currentUser + " " + module1);
                        } else {
                            System.out.println("No Such Elements found on the WebPage " + currentUser + " " + module1);
                        }
                    } catch (Exception context) {
                        System.out.println(module1 + " " + currentUser);
                        context.printStackTrace();
                    }
                }
            } else {
                logindriver.findElement(By.id("Input_Email")).sendKeys(currentUser);
                logindriver.findElement(By.id("Input_Password")).sendKeys(password);
                logindriver.findElement(By.id("login-submit")).click();
                Thread.sleep(3000);

                for (String module2 : modulesVendorPortal) {
                    String moduleIDVendor = "//*[contains(text(), '" + module2 + "')]";
                    logindriver.findElement(By.xpath(moduleIDVendor)).click();
                    Thread.sleep(3000);

                    WebElement data = logindriver.findElement(By.id("listContainer"));
                    if (data.isDisplayed()) {
                        System.out.println("Elements is present on the WebPage " + currentUser + " " + module2);
                    } else {
                        System.out.println("No Such Elements found on the WebPage " + currentUser + " " + module2);
                    }
                }
            }
            //Login Avatar Button
            logindriver.findElement(By.xpath("//header/div[1]/div[2]/ul[1]/li[3]/div[1]/a[1]/div[1]/img[1]")).click();
            Thread.sleep(3000);
            logindriver.findElement(By.xpath("//a[@onclick='user_logout()']")).click();
            Thread.sleep(3000);
        }
    }
}

