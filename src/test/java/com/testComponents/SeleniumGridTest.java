package com.testComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class SeleniumGridTest extends BaseTest{
    @Test
    public void HomePage() throws URISyntaxException, IOException, InterruptedException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("browser");
        WebDriver page = new RemoteWebDriver(new URI("http://192.168.0.133:4444").toURL(),caps);

    }
}
