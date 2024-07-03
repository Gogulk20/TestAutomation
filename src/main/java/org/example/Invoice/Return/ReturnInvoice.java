package org.example.Invoice.Return;

import org.example.Login.LogIn;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.example.Variables.YKMain.*;

public class ReturnInvoice {

    WebDriver page;
    String POTrn;
    public ReturnInvoice(WebDriver page){
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(xpath = "//span[contains(text(),'Invoices')]")
    WebElement InvoiceModule;
    @FindBy(css = "#listContainer tr td")
    List<WebElement> InvoiceListPage;
    @FindBy(css = ".btn-link")
    WebElement InvoiceTrn;
    @FindBy(xpath = "//main[1]/div[1]/div[3]/div[2]/div[1]/div[9]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/button[1]")
    WebElement AcceptButton1;
    @FindBy(id = "addToReviewId")
    WebElement AddToQuoeueButton;
    @FindBy(css = ".bootbox-accept")
    WebElement SubmitButton;
    @FindBy(css = ".bootbox-input")
    WebElement Remarks;
    @FindBy(id = "btnReturn")
    WebElement ReturnButton;
    @FindBy(id = "vendorSendMailBtnId")
    WebElement MailSubmitButton;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TRNTitle;
    @FindBy(id = "referenceId")
    WebElement PORefId;
    @FindBy(xpath = "//span[contains(text(),'Purchase Orders')]")
    WebElement PurchaseOrder;

    public void BuyerReturnInvoice() throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(BuyerId, Pass);
        PurchaseOrder.click();Thread.sleep(1000);
        TRNTitle.click();Thread.sleep(3000);
        POTrn = PORefId.getText();
        InvoiceModule.click();Thread.sleep(3000);
        List<WebElement> rows = InvoiceListPage;Thread.sleep(1000);
        for (WebElement row : rows) {
            if (row.getText().contains(POTrn)) {
                WebElement btnLink = InvoiceTrn;
                btnLink.click();Thread.sleep(3000);
                break;
            }
        }
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 1650)");Thread.sleep(1000);
        AcceptButton1.click();Thread.sleep(1000);
        AddToQuoeueButton.click();Thread.sleep(1000);
        js.executeScript("window.scrollBy(0, 600)");Thread.sleep(1000);
        ReturnButton.click();Thread.sleep(1000);
        Remarks.sendKeys("Invoice Remarks");Thread.sleep(1000);
        SubmitButton.click();Thread.sleep(1000);
        js.executeScript("window.scrollBy(0, 700)");Thread.sleep(1000);
        MailSubmitButton.click();Thread.sleep(1000);
    }
}
