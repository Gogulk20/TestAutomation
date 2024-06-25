package org.example.Invoice.Approvers;

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

public class ApprovalApproves {
    WebDriver page;
    public ApprovalApproves(WebDriver page){
        this.page = page;
        PageFactory.initElements(page,this);
    }
    @FindBy(xpath = "//span[contains(text(),'Invoices')]")
    WebElement InvoiceModule;
    @FindBy(css = "#listContainer tr td")
    List<WebElement> InvoiceListPage;
    @FindBy(css = ".btn-link")
    WebElement InvoiceTrn;
    @FindBy(id = "btnApprove")
    WebElement ApproveButton;
    @FindBy(css = ".bootbox-accept")
    WebElement YesButton;

    public void InvoiceApprover(String ApproverUserId, String Pass, String POTrn) throws InterruptedException {
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
        WebDriverWait wait1 = new WebDriverWait(page, Duration.ofSeconds(5));
        WebElement panel = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(text(),'Approver')]")));
        ((JavascriptExecutor) page).executeScript("arguments[0].scrollIntoView(true);", panel);
        ApproveButton.click();Thread.sleep(1000);
        YesButton.click();Thread.sleep(2000);
    }
}
