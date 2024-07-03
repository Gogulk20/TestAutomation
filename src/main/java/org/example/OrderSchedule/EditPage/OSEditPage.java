package org.example.OrderSchedule.EditPage;

import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.example.Variables.YKMain.*;

public class OSEditPage {
    WebDriver page;
    public String POTrn;
    public OSEditPage(WebDriver page) {
        this.page=page;
        PageFactory.initElements(page,this);
    }

    @FindBy(xpath = "//span[contains(text(),'Order Schedules')]")
    WebElement OrderSchedule;
    @FindBy(css = "#listContainer tr td")
    List<WebElement> OSListPage;
    @FindBy(css = ".btn-link")
    WebElement TRNLink;
    @FindBy(id = "btnEdit")
    WebElement EditButton;
    @FindBy(id = "btnUpdate")
    WebElement UpdateButton;
    @FindBy(css = ".bootbox-accept")
    WebElement YesButton;
    @FindBy(id = "referenceId")
    WebElement PORefId;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TRNTitle;
    @FindBy(xpath = "//span[contains(text(),'Purchase Orders')]")
    WebElement PurchaseOrder;

    public String getPOTrnNumber() throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.VendorLogin(VendorId, Pass);
        PurchaseOrder.click();Thread.sleep(1000);
        TRNTitle.click();Thread.sleep(3000);
        POTrn = PORefId.getText();
        return POTrn;
    }
    public void VendorEditOS() throws InterruptedException {
        OrderSchedule.click();Thread.sleep(2000);
        List<WebElement> rows = OSListPage;
        for (WebElement row : rows) {
            if (row.getText().contains(POTrn)) {
                WebElement btnLink = TRNLink;
                btnLink.click();Thread.sleep(2000);
                break;
            }
        }
        EditButton.click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0,800)");Thread.sleep(1000);
        UpdateButton.click();Thread.sleep(2000);
        YesButton.click();Thread.sleep(2000);
        LogOut.UserLogOut(page);
    }
}
