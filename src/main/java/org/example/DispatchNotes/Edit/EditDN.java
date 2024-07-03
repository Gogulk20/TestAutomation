package org.example.DispatchNotes.Edit;

import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.example.Variables.YKMain.*;

public class EditDN {
    WebDriver page;
    public String POTrn;
    public EditDN(WebDriver page) {
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
    @FindBy(xpath = "//span[contains(text(),'Dispatch Notes')]")
    WebElement DispatchNotes;
    @FindBy(css = "#listContainer tr td")
    List<WebElement> DispathNoteleListPage;
    @FindBy(css = ".btn-link")
    WebElement TRNLink;
    @FindBy(id = "btnEdit")
    WebElement EditButton;
    @FindBy(css = ".bootbox-accept")
    WebElement YesOption;
    @FindBy(id = "btnUpdate")
    WebElement UpdateButton;



    public String getPOTrnNumber() throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.VendorLogin(VendorId, Pass);
        PurchaseOrder.click();Thread.sleep(1000);
        TRNTitle.click();Thread.sleep(3000);
        POTrn = PORefId.getText();
        return POTrn;
    }

    public String VendorEditDN() throws InterruptedException {
        DispatchNotes.click();Thread.sleep(2000);
        List<WebElement> rows = DispathNoteleListPage;
        for (WebElement row : rows) {
            if (row.getText().contains(POTrn)) {
                WebElement btnLink = TRNLink;
                btnLink.click();Thread.sleep(2000);
                break;
            }
        }
        EditButton.click();Thread.sleep(1000);
        JavascriptExecutor js= (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0,1000)");Thread.sleep(1000);
        UpdateButton.click();Thread.sleep(2000);
        YesOption.click();Thread.sleep(2000);
        LogOut.UserLogOut(page);
        return POTrn;
    }
}
