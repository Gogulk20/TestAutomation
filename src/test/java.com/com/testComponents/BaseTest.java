package com.testComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Login.LogIn;
import org.example.Variables.YKMain;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
        String BrowserName = properties.getProperty("browser");
        if (BrowserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            page = new ChromeDriver();
        } else if (BrowserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Firefox Driver\\geckodriver-v0.34.0-win-aarch64.exe");
            page = new FirefoxDriver();
        } else if (BrowserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Edge Driver\\edgedriver_win64\\Driver_Notes.exe");
            page = new EdgeDriver();
        }
        page.manage().window().maximize();Thread.sleep(1000);
        return page;
    }
@BeforeMethod
    public LogIn lanchApplication() throws IOException, InterruptedException {
        page = InitializeBrowser();
        logIn = new LogIn(page);
        logIn.goTo();Thread.sleep(1000);
        return logIn;
    }

@AfterMethod
public void closeApplicaton() throws InterruptedException {
        page.close();Thread.sleep(2000);
}
}


