package org.example.Inspections;

import org.example.LogOut.LogOut;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create {
    WebDriver page;
    public Create(WebDriver page) {
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(id = "btnForCreateInspection")
    WebElement CreateForInspectionButton;
    @FindBy(id = "physicalInspectionReq")
    WebElement PhysicalInspectionRadioButton;
    @FindBy(id = "btnCreateInspection")
    WebElement CreateInspectionButton;
    @FindBy(css = ".bootbox-accept")
    WebElement YesButton;


    public void RequesterCreateIns() throws InterruptedException {
        CreateForInspectionButton.click();Thread.sleep(1000);
        PhysicalInspectionRadioButton.click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor)page;
        js.executeScript("window.scrollBy(0,1100)");Thread.sleep(1000);
        CreateInspectionButton.click();Thread.sleep(1000);
        YesButton.click();Thread.sleep(3000);
        LogOut.UserLogOut(page);
    }
}
