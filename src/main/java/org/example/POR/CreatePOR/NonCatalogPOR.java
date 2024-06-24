package org.example.POR.CreatePOR;

import org.example.POR.ApprovalAssign.PMApprovalAssign;
import org.example.POR.SendForApproval.PORSendForApproval;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NonCatalogPOR {
    WebDriver page;
    public NonCatalogPOR(WebDriver page) {
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(xpath = "//a[contains(text(),'Create POR')]")
    WebElement CreatePORButton;
    @FindBy(id = "notBelow5L")
    WebElement NotBelow5LRadioButton;
    @FindBy(id = "select2-taxCodeId-container")
    WebElement TaxCodeField;
    @FindBy(css = ".select2-results__option")
    WebElement FirstTaxCode;
    @FindBy(id = "notes")
    WebElement Notes;
    @FindBy(id = "btnCreate")
    WebElement CreateButton;
    @FindBy(xpath = "//button[contains(text(), 'Yes')]")
    WebElement YesOption;

    public void BuyerCreatePOR(String PORNotes) throws InterruptedException {
        CreatePORButton.click();Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 1000)");Thread.sleep(1000);
        NotBelow5LRadioButton.click();Thread.sleep(1000);
        JavascriptExecutor js1 = (JavascriptExecutor) page;
        js1.executeScript("window.scrollBy(0, 1500)");Thread.sleep(1000);
        TaxCodeField.click();Thread.sleep(1000);
        FirstTaxCode.click();Thread.sleep(1000);
        JavascriptExecutor js2 = (JavascriptExecutor) page;
        js2.executeScript("window.scrollBy(0, 700)");Thread.sleep(1000);
        //POR Notes
        Notes.sendKeys(PORNotes);Thread.sleep(1000);
        //POR Create
        CreateButton.click();Thread.sleep(2000);
        YesOption.click();Thread.sleep(3000);
        }
}
