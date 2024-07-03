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

    public void InvoiceApprover() throws InterruptedException {
        WebDriverWait wait1 = new WebDriverWait(page, Duration.ofSeconds(5));
        WebElement panel = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(text(),'Approver')]")));
        ((JavascriptExecutor) page).executeScript("arguments[0].scrollIntoView(true);", panel);
        ApproveButton.click();Thread.sleep(1000);
        YesButton.click();Thread.sleep(2000);
    }
}
