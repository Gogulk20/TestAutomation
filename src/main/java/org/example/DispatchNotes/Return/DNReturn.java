package org.example.DispatchNotes.Return;

import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.example.Variables.YKMain.*;
import static org.example.Variables.YKMain.LMId;

public class DNReturn {
    WebDriver page;
    public DNReturn(WebDriver page) throws InterruptedException {
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(id = "ni-dispatch-notes")
    WebElement DispatchNote;
    @FindBy(css = "#listContainer tr td")
    List<WebElement> DiscpatchNoteList;
    @FindBy(css = ".btn-link")
    WebElement TRNLink;
    @FindBy(id = "dropdownMenuButton")
    WebElement AssignDropdownButton;
    @FindBy(id = "btnToReturn")
    WebElement ReturnButton;
    @FindBy(css = ".bootbox-accept")
    WebElement SubmitButton;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TRNTitle1;
    @FindBy(xpath = "//span[contains(text(),'Purchase Orders')]")
    WebElement PurchaseOrder;
    @FindBy(id = "referenceId")
    WebElement PONumber;
    @FindBy(css = ".bootbox-input")
    WebElement Remarks;


    public String GetPOTrnNum() throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(BuyerId,Pass);Thread.sleep(1000);
        PurchaseOrder.click();Thread.sleep(1000);
        TRNTitle1.click();Thread.sleep(3000);
        String POTRNNum = PONumber.getText();
        LogOut.UserLogOut(page);
        logIn.UserLogin(LMId,Pass);Thread.sleep(1000);
        DispatchNote.click();Thread.sleep(2000);
        List<WebElement> rows = DiscpatchNoteList;
        for (WebElement row : rows) {
            if (row.getText().contains(POTRNNum)) {
                WebElement btnLink = TRNLink;
                btnLink.click();Thread.sleep(1000);
                break;
            }
        }
        return POTRNNum;
    }
    public void LMreturnDN() throws InterruptedException {
        AssignDropdownButton.click();Thread.sleep(1000);
        ReturnButton.click();Thread.sleep(2000);
        Remarks.sendKeys("DN Return Remarks");Thread.sleep(2000);
        SubmitButton.click();Thread.sleep(3000);
    }
}
