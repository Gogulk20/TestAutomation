package org.example.Inspections;

import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.example.Variables.YKMain.*;

public class SendForInspection {
    WebDriver page;
    public String POTrn;
    public SendForInspection(WebDriver page) {
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(xpath = "//span[contains(text(),'Purchase Orders')]")
    WebElement PurchaseOrder;
    @FindBy(id = "referenceId")
    WebElement PORefId;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TRNTitle;
    @FindBy(id = "referenceId")
    WebElement PONumber;
    @FindBy(xpath = "//span[contains(text(),'Order Schedules')]")
    WebElement OrderSchedule;
    @FindBy(css = "#listContainer tr td")
    List<WebElement> OrderScheduleListPage;
    @FindBy(css = "#listContainer tr td")
    List<WebElement> OSListPage;
    @FindBy(css = ".btn-link")
    WebElement TRNLink;
    @FindBy(id = "btnSendForInspection")
    WebElement SendForInspectionButton;
    @FindBy(css = ".bootbox-accept")
    WebElement YesOption;



    public String getPOTrnNumber() throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.VendorLogin(VendorId, Pass);
        PurchaseOrder.click();Thread.sleep(1000);
        TRNTitle.click();Thread.sleep(3000);
        POTrn = PORefId.getText();
        return POTrn;
    }

    public String VendorSendForInspection() throws InterruptedException {
        OrderSchedule.click();Thread.sleep(2000);
        List<WebElement> rows = OSListPage;
        for (WebElement row : rows) {
            if (row.getText().contains(POTrn)) {
                WebElement btnLink = TRNLink;
                btnLink.click();Thread.sleep(2000);
                break;
            }
        }
        SendForInspectionButton.click();Thread.sleep(1000);
        YesOption.click();Thread.sleep(2000);
        LogOut.UserLogOut(page);
        return POTrn;
    }
    public void GetPOTrnID() throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(BuyerId,Pass);Thread.sleep(1000);
        PurchaseOrder.click();Thread.sleep(1000);
        TRNTitle.click();Thread.sleep(3000);
        String POTRNNum = PONumber.getText();
        LogOut.UserLogOut(page);
        logIn.UserLogin(ReqId,Pass);Thread.sleep(1000);
        OrderSchedule.click();Thread.sleep(2000);
        List<WebElement> rows = OrderScheduleListPage;
        for (WebElement row : rows) {
            if (row.getText().contains(POTRNNum)) {
                WebElement btnLink = TRNLink;
                btnLink.click();Thread.sleep(1000);
                break;
            }
        }
    }
}
