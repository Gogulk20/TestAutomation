import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TestClass {


     static void POToInvoice() throws InterruptedException {

        String Title = "KBW Company PVT LMT";
        // TODO Auto-generated method stub
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://yef-test.cormsquare.com/Identity/Account/Login");
        driver.manage().window().maximize();
        driver.findElement(By.id("Input_Email")).sendKeys("requester@cormsquare.com");
        Thread.sleep(1000);
        driver.findElement(By.id("Input_Password")).sendKeys("Admin@123");
        Thread.sleep(1000);
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(1000);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0, 350)", "");Thread.sleep(1000);


       // driver.findElement(By.xpath("//span[contains(text(),'Requisitions')]")).click();Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'" + Title + "')]")).click();Thread.sleep(1000);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0, 350)", "");

        String buyerId = "genpactlead@cormsquare.com";

        WebElement managerId = driver.findElement(By.xpath("//span[contains(text(),'Buyer Manager :')]"));Thread.sleep(1000);
        String bgm = managerId.getText();

        driver.findElement(By.xpath("//header/div[1]/div[2]/ul[1]/li[3]/div[1]/a[1]/div[1]/img[1]")).click();Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'out')]")).click();Thread.sleep(1000);

        if(buyerId.equals(bgm))
        {
            driver.findElement(By.id("Input_Email")).sendKeys("genpactlead@cormsquare.com");Thread.sleep(1000);
            driver.findElement(By.id("Input_Password")).sendKeys("Admin@123");Thread.sleep(1000);
            driver.findElement(By.id("login-submit")).click();Thread.sleep(1000);
        } 
        else
        {
            driver.findElement(By.id("Input_Email")).sendKeys("buyermanager@cormsquare.com");Thread.sleep(1000);
            driver.findElement(By.id("Input_Password")).sendKeys("Admin@123");Thread.sleep(1000);
            driver.findElement(By.id("login-submit")).click();Thread.sleep(1000);
        }
    }
}

