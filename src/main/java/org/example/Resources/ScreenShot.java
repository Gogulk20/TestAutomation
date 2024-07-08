package org.example.Resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class ScreenShot {
    WebDriver page;
    public ScreenShot(WebDriver page) {
        this.page=page;
        PageFactory.initElements(page,this);
    }

    public String getScreenShot(String testCaseName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) page;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+"//reports//"+ testCaseName+".png");
        FileUtils.copyFile(source,file);
        return System.getProperty("user.dir")+"//reports//"+ testCaseName+".png";
    }
}
