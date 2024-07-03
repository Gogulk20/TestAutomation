package org.example.RFQ.Quotation;

import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
//import org.example.Methods.NonCatalogMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.example.Variables.YKMain.Title;

public class Quotation {
    WebDriver page;
    public Quotation(WebDriver page) {
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(id = "btnSendQuote")
    WebElement SendQuoteButton;
    @FindBy(id = "incotermLocation")
    WebElement IncotermLocation;
    @FindBy(id = "quotationReferenceNumber")
    WebElement QuotationRefNumber;
    @FindBy(xpath = "//main[1]/div[1]/form[1]/div[1]/div[2]/div[2]/div[13]/div[6]/div[1]/input[2]")
    WebElement DatePopup;
    @FindBy(xpath = "//div[5]/div[2]/div[1]/div[2]/div[1]/span[42]")
    WebElement MaxDate;
    @FindBy(id = "liquidatedComplyId")
    WebElement LiquidatedComply;
    @FindBy(id = "rohsComplyId")
    WebElement RohsComply;
    @FindBy(id = "warrantyRequirementsComplyId")
    WebElement WarrentyReqComply;
    @FindBy(xpath = "//main[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr")
    List<WebElement> ListOfItems;
    @FindBy(id = "gstId")
    WebElement GstValue;
    @FindBy(id = "attachFile")
    WebElement AttachFileButton1;
    @FindBy(id = "formFilePreupload")
    WebElement TEFile;
    @FindBy(id = "select2-attachmentTypeId-container")
    WebElement AttachmentType1;
    @FindBy(xpath = "//li[contains(text(),'Technical')]")
    WebElement SelectTE;
    @FindBy(id = "attachmentSaveId")
    WebElement SaveTEFile;
    @FindBy(id = "attachFile")
    WebElement AttachFileButton2;
    @FindBy(id = "formFilePreupload")
    WebElement CEFile;
    @FindBy(id = "select2-attachmentTypeId-container")
    WebElement AttachmentType2;
    @FindBy(xpath = "//li[contains(text(),'Commercial')]")
    WebElement SelectCE;
    @FindBy(id = "attachmentSaveId")
    WebElement SaveCEFile;
    @FindBy(id = "btnCreate")
    WebElement CreateButton;
    @FindBy(css = ".bootbox-accept")
    WebElement OptionYes;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TrnTitle;


    public void QuotationSubmission(String VendorId, String Pass,String InctLocation, String QuoRefNum, String Gst, String File1, String File2) throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.VendorLogin(VendorId,Pass);
        TrnTitle.click();Thread.sleep(2000);
        SendQuoteButton.click();Thread.sleep(2000);
        IncotermLocation.sendKeys(InctLocation);Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 500)");Thread.sleep(1000);
        QuotationRefNumber.sendKeys(QuoRefNum);Thread.sleep(1000);
        DatePopup.click();Thread.sleep(1000);
        MaxDate.click();Thread.sleep(1000);
        LiquidatedComply.click();Thread.sleep(1000);
        RohsComply.click();Thread.sleep(1000);
        WarrentyReqComply.click();Thread.sleep(1000);
        JavascriptExecutor js1 = (JavascriptExecutor) page;
        js1.executeScript("window.scrollBy(0, 500)");Thread.sleep(1000);

        double[] rate = {150.32, 100.65, 481.0, 145.0, 160.3};
        int[] discount = {22, 14, 13, 26, 19};
        List<WebElement> table = ListOfItems;

        if (table.size() <= rate.length) {
            for (int i = 0; i < table.size(); i++) {
                int index = i + 1;
                page.findElement(By.id("hsCode-" + index)).sendKeys("1234");
                page.findElement(By.id("make-" + index)).sendKeys("7851");
                page.findElement(By.id("model-" + index)).sendKeys("65456");
                page.findElement(By.id("partNumber-" + index)).sendKeys("53212");
                page.findElement(By.id("countryOfOrigin-" + index)).sendKeys("IND");
                String rateValues = String.valueOf(rate[i]);
                page.findElement(By.id("rate-" + index)).sendKeys(rateValues);
                String discountValues = String.valueOf(discount[i]);
                page.findElement(By.id("discount-" + index)).clear();
                page.findElement(By.id("discount-" + index)).sendKeys(discountValues);
                page.findElement(By.id("leadTime-" + index)).sendKeys("34");
                page.findElement(By.id("notes-" + index)).sendKeys("NA");
            }
        }
        GstValue.sendKeys(Gst);Thread.sleep(1000);
        JavascriptExecutor js2 = (JavascriptExecutor) page;
        js2.executeScript("window.scrollBy(0, 500)");Thread.sleep(1000);
        AttachFileButton1.click();Thread.sleep(1000);
        WebElement file = TEFile;Thread.sleep(1000);
        file.sendKeys(File1);Thread.sleep(3000);
        AttachmentType1.click();Thread.sleep(1000);
        SelectTE.click();Thread.sleep(1000);
        SaveTEFile.click();Thread.sleep(1000);
        AttachFileButton2.click();Thread.sleep(1000);
        WebElement file2 = CEFile;Thread.sleep(1000);
        file2.sendKeys(File2);Thread.sleep(3000);
        AttachmentType2.click();Thread.sleep(1000);
        SelectCE.click();Thread.sleep(1000);
        SaveCEFile.click();Thread.sleep(1000);
        JavascriptExecutor js4 = (JavascriptExecutor) page;
        js4.executeScript("window.scrollBy(0, 500)");Thread.sleep(1000);
        CreateButton.click();Thread.sleep(1000);
        OptionYes.click();Thread.sleep(2000);
        LogOut.UserLogOut(page);
    }

}
