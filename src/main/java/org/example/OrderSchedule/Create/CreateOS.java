package org.example.OrderSchedule.Create;

import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.Variables.YKMain.*;

public class CreateOS {
    WebDriver page;
    public CreateOS(WebDriver page) {
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(xpath = "//span[contains(text(),'Purchase Orders')]")
    WebElement PurchaseOrder;
    @FindBy(id = "btnCreateOR")
    WebElement CreateOSButton;
    @FindBy(xpath = "//main[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[2]/div[1]/input[2]")
    WebElement DateField;
    @FindBy(css = ".today")
    WebElement TodayDate;
    @FindBy(id = "notes")
    WebElement OSNotes;
    @FindBy(id = "btnCreate")
    WebElement CreateButton;
    @FindBy(css = ".bootbox-accept")
    WebElement YesOption;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TRNTitle;

    public void VendorCreateOS() throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.VendorLogin(VendorId,Pass);Thread.sleep(1000);
        PurchaseOrder.click();Thread.sleep(1000);
        TRNTitle.click();Thread.sleep(3000);
        CreateOSButton.click();Thread.sleep(2000);
//        page.findElement(By.xpath("//main[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[2]/div[1]/input[2]")).click();Thread.sleep(1000);
        WebElement Date = DateField;Thread.sleep(1000);
        Date.click();Thread.sleep(1000);
        TodayDate.click();Thread.sleep(1000);
        OSNotes.sendKeys("Notes");Thread.sleep(1000);
        JavascriptExecutor js= (JavascriptExecutor)page;
        js.executeScript("window.scrollBy(0,500)");Thread.sleep(1000);
        CreateButton.click();Thread.sleep(3000);
        YesOption.click();Thread.sleep(3000);
        LogOut.UserLogOut(page);
        }
}
