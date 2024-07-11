package com.testComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.example.Login.LogIn;
import org.example.Variables.YKMain;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest extends YKMain{

    public WebDriver page;
    public LogIn logIn;

    public WebDriver InitializeBrowser() throws IOException, InterruptedException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream( "C:\\Gogul\\Yokogawa\\src\\main\\java\\org\\example\\Resources\\GlobalData.properties");
        properties.load(fileInputStream);
        String BrowserName =  System.getProperty("browser")!=null ? System.getProperty("browser") : properties.getProperty("browser");
//        String BrowserName = properties.getProperty("browser");
        if (BrowserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            page = new ChromeDriver();
        } else if (BrowserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Firefox Driver\\geckodriver.exe");
            page = new FirefoxDriver();
        } else if (BrowserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Edge Driver\\edgedriver_win64\\msedgedriver.exe");
            page = new EdgeDriver();
        }
        page.manage().window().maximize();Thread.sleep(1000);
        return page;
    }
    public String getScreenShot(String testCaseName,WebDriver page) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) page;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+"//reports//"+ testCaseName+".png");
        FileUtils.copyFile(source,file);
        return System.getProperty("user.dir")+"//reports//"+ testCaseName+".png";
    }

@BeforeClass
    public LogIn lanchApplication() throws IOException, InterruptedException {
        page = InitializeBrowser();
        logIn = new LogIn(page);
        logIn.goTo();Thread.sleep(1000);
        return logIn;
    }

@AfterClass
public void closeApplicaton() throws InterruptedException {
        page.close();Thread.sleep(2000);
}
}


