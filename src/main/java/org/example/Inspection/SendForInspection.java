package org.example.Inspection;

import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.example.YKMain.Title;

public class SendForInspection {
    WebDriver page;
    public SendForInspection(WebDriver page) {
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(xpath = "//span[contains(text(),'Purchase Orders')]")
    WebElement PurchaseOrder;
    @FindBy(id = "referenceId")
    WebElement PORefId;
    @FindBy(xpath = "//span[contains(text(),'Order Schedules')]")
    WebElement OrderSchedule;
    @FindBy(css = "#listContainer tr td")
    List<WebElement> OSListPage;
    @FindBy(css = ".btn-link")
    WebElement TRNLink;
    @FindBy(id = "btnSendForInspection")
    WebElement SendForInspectionButton;
    @FindBy(css = ".bootbox-accept")
    WebElement YesOption;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TRNTitle;


    public String VendorSendForInspection(String VendorId, String Pass) throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.VendorLogin(VendorId,Pass);
        PurchaseOrder.click();Thread.sleep(1000);
        TRNTitle.click();Thread.sleep(3000);
        String POTrn = PORefId.getText();
        OrderSchedule.click();Thread.sleep(1000);
        List<WebElement> rows = OSListPage;
        for (WebElement row : rows) {
            if (row.getText().contains(POTrn)) {
                WebElement btnLink = TRNLink;
                btnLink.click();Thread.sleep(1000);
                break;
            }
        }
        SendForInspectionButton.click();Thread.sleep(1000);
        YesOption.click();Thread.sleep(2000);
        LogOut.UserLogOut(page);
        return POTrn;
    }
}
