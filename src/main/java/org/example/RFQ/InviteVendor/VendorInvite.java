package org.example.RFQ.InviteVendor;

import org.example.LogOut.LogOut;
//import org.example.Methods.NonCatalogMethods;
import org.example.Login.LogIn;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.Variables.YKMain.*;

public class VendorInvite  {
WebDriver page;
    public VendorInvite(WebDriver page) {
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(id = "addRequestForQuotationVendors")
    WebElement InviteVendorButton;
    @FindBy(id = "select2-vendorId-container")
    WebElement VendorDriodownField;
    @FindBy(css = ".select2-search__field")
    WebElement Vendorname;
    @FindBy(css = ".select2-results__option")
    WebElement SelectVendor;
    @FindBy(id = "saveRequestForQuotationVendor")
    WebElement SaveVendor;
    @FindBy(id = "vendorSendMailBtnId")
    WebElement SubmitVendorMail;
    @FindBy(xpath = "//span[contains(text(),'Request For Quotations')]")
    WebElement RFQPage;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TrnTitle;

    public void InviteVendor() throws InterruptedException {
        LogIn logIn= new LogIn(page);
        logIn.UserLogin(BuyerId,Pass);Thread.sleep(1000);
        RFQPage.click();Thread.sleep(2000);
        TrnTitle.click();Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) page;
        js1.executeScript("window.scrollBy(0, 1100)");Thread.sleep(1000);
        InviteVendorButton.click();Thread.sleep(2000);
        VendorDriodownField.click();Thread.sleep(2000);
        Vendorname.sendKeys(VendorName);Thread.sleep(2000);
        SelectVendor.click();Thread.sleep(2000);
        SaveVendor.click();Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 1000)");Thread.sleep(1000);
        SubmitVendorMail.click();Thread.sleep(2000);
    }
}
