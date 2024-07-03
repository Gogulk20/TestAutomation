package org.example.Invoice.AcceptDoc;

import org.example.LogOut.LogOut;
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

public class InvoiceAccept {
    WebDriver page;
    String POTrn;
    public InvoiceAccept(WebDriver page){
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
    @FindBy(id = "selctAllId")
    WebElement SelectAllCheckBox;
    @FindBy(id = "acceptCheckListId")
    WebElement AcceptButton;
    @FindBy(xpath = "//main[1]/div[1]/div[3]/div[2]/div[1]/div[9]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td[6]/button[1]")
    WebElement CheckListButton2;
    @FindBy(id = "acceptCheckListId")
    WebElement AcceptButton2;
    @FindBy(id = "btnAccept")
    WebElement VerifyButton;
    @FindBy(css = ".bootbox-accept")
    WebElement SubmitButton;
    @FindBy(id = "btnSendApproval")
    WebElement SendForApprovalButton;
    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    WebElement YesButton;
    @FindBy(xpath = "//main[1]/div[1]/div[3]/div[2]/div[1]/div[10]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]")
    WebElement ApproversId;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TRNTitle;
    @FindBy(id = "referenceId")
    WebElement PORefId;
    @FindBy(xpath = "//span[contains(text(),'Purchase Orders')]")
    WebElement PurchaseOrder;

    public String AcceptInvoice() throws InterruptedException {
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
        SelectAllCheckBox.click();Thread.sleep(1000);
        AcceptButton.click();Thread.sleep(1000);
        js.executeScript("window.scrollBy(0, 600)");Thread.sleep(1000);
        CheckListButton2.click();Thread.sleep(1000);
        AcceptButton2.click();Thread.sleep(1000);
        js.executeScript("window.scrollBy(0, 600)");Thread.sleep(1000);
        VerifyButton.click();Thread.sleep(1000);
        SubmitButton.click();Thread.sleep(1000);
        js.executeScript("window.scrollBy(0, -2500)");Thread.sleep(1000);
        SendForApprovalButton.click();Thread.sleep(1000);
        YesButton.click();Thread.sleep(1000);
        js.executeScript("window.scrollBy(0, 2000)");Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(page, Duration.ofSeconds(5));
        WebElement panel1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(text(),'Approver')]")));
        ((JavascriptExecutor) page).executeScript("arguments[0].scrollIntoView(true);", panel1);
        return POTrn;
    }
    public void ApproverID() throws InterruptedException {
        String ApproverUserId = ApproversId.getText();Thread.sleep(1000);
        LogOut.UserLogOut(page);
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(ApproverUserId, Pass);Thread.sleep(1000);
        InvoiceModule.click();Thread.sleep(3000);
        List<WebElement> rows1 = InvoiceListPage;Thread.sleep(1000);
        for (WebElement row : rows1) {
            if (row.getText().contains(POTrn)) {
                WebElement btnLink = InvoiceTrn;
                btnLink.click();Thread.sleep(3000);
                break;
            }
        }
    }
}
