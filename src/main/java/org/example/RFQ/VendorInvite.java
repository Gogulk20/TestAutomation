package org.example.RFQ;

import org.example.LogOut.LogOut;
//import org.example.Methods.NonCatalogMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void InviteVendor(String VendorName) throws InterruptedException {
        JavascriptExecutor js1 = (JavascriptExecutor) page;
        js1.executeScript("window.scrollBy(0, 1100)");Thread.sleep(1000);
        InviteVendorButton.click();Thread.sleep(1000);
        VendorDriodownField.click();Thread.sleep(1000);
        Vendorname.sendKeys(VendorName);Thread.sleep(1000);
        SelectVendor.click();Thread.sleep(1000);
        SaveVendor.click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 1000)");Thread.sleep(1000);
        SubmitVendorMail.click();Thread.sleep(2000);
        LogOut.UserLogOut(page);Thread.sleep(1000);
    }
}
