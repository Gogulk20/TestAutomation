package org.example.PR.Modules;

import org.example.YKMain;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogPR {
    WebDriver page;
    public CatalogPR(WebDriver page){
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(css = ".btn-primary")
    WebElement CreateButton;
    @FindBy(xpath = "//div/table/tbody/tr[1]/td[1]/a[1]")
    WebElement CatalogPRPage;
    @FindBy(id = "title")
    WebElement TrnTitle;
    @FindBy(id = "select2-projectId-container")
    WebElement ProjectFieldClick;
    @FindBy(css = "input[class='select2-search__field']")
    WebElement ProjectCode;
    @FindBy(css = ".select2-results__option--highlighted")
    WebElement SelectProject;
    @FindBy(id = "select2-wbsId-container")
    WebElement WbsFieldClick;
    @FindBy(css = "input[class='select2-search__field']")
    WebElement WbsCode;
    @FindBy(css = ".select2-results__option")
    WebElement SelectWbs;
    @FindBy(id = "select2-vendorId-container")
    WebElement VendorFieldClick;
    @FindBy(css = "input[class='select2-search__field']")
    WebElement VendorName;
    @FindBy(css = ".select2-results__option")
    WebElement SelectVendor;
    @FindBy(id = "select2-rateContractId-container")
    WebElement RCFieldClick;
    @FindBy(css = "input[class='select2-search__field']")
    WebElement RCCode;
    @FindBy(css = ".select2-results__option")
    WebElement SelectRC;
    @FindBy(id = "select2-shippingaddressId-container")
    WebElement ShippingAddressFieldClick;
    @FindBy(css = ".select2-results__option")
    WebElement ShippingAddressSelect;
    @FindBy(id = "select2-shippingModeId-container")
    WebElement ShippingModeFieldClick;
    @FindBy(css = "input[class='select2-search__field']")
    WebElement ShippingModeName;
    @FindBy(css = ".select2-results__option")
    WebElement SelectShippingMode;
    @FindBy(xpath = "//div/div[2]/div[1]/input[2]")
    WebElement ExpectedDateFieldPopup;
    @FindBy(css = ".today")
    WebElement SelectTodayDate;
    @FindBy(xpath = "//main[1]/div[1]/form[1]/div[1]/div[2]/div[2]/div[2]/input[2]")
    WebElement ExpectedDeliveryPopup;
    @FindBy(xpath = "//div[5]/div[2]/div[1]/div[2]/div[1]/span[42]")
    WebElement SelectMaxDate;
    @FindBy(id = "select2-buyerManagerId-container")
    WebElement BMFieldClick;
    @FindBy(css = "input[class='select2-search__field']")
    WebElement BMName;
    @FindBy(css = ".select2-results__option")
    WebElement SelectBM;
    @FindBy(id = "select2-projectManagerId-container")
    WebElement PMFieldClick;
    @FindBy(css = "input[class='select2-search__field']")
    WebElement PMName;
    @FindBy(css = ".select2-results__option")
    WebElement SelectPM;
    @FindBy(id = "orderInTakeId")
    WebElement OIPrice;
    @FindBy(id = "inspectRequired")
    WebElement SelectInspection;
    @FindBy(id = "addLineRequisitionItems")
    WebElement ClickAddLineButton;
    @FindBy(id = "select2-categoryId-container")
    WebElement ClickCategoryField;
    @FindBy(css = ".select2-results__option")
    WebElement SelectCategory;
    @FindBy(id = "select2-itemId-container")
    WebElement ClickItemField;
    @FindBy(css = ".select2-results__option")
    WebElement SelectItem;
    @FindBy(id = "quantity")
    WebElement ItemQuantity;
    @FindBy(id = "saveRequisitionItem")
    WebElement SaveItem;
    @FindBy(id = "notes")
    WebElement Notes;
    @FindBy(id = "attachDocs")
    WebElement ClickAttachmentsButton;
    @FindBy(id = "formFilePreupload")
    WebElement AttachmentField1;
    @FindBy(id = "saveAttachments1")
    WebElement SaveFile1;
    @FindBy(id = "formFilePreupload")
    WebElement AttachmentField2;
    @FindBy(id = "saveAttachments1")
    WebElement SaveFile2;
    @FindBy(id = "submitAttachmentsId")
    WebElement SubmitAttachments;
    @FindBy(id = "btnCreate")
    WebElement ClickCreateButton;
    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    WebElement ClickYes;


    public void CatalogCreateButton() throws InterruptedException {
       CreateButton.click(); Thread.sleep(1000);
       CatalogPRPage.click();Thread.sleep(1000);
    }
    public void CatalogTitle(String Title) throws InterruptedException {
        TrnTitle.sendKeys(Title);Thread.sleep(1000);
    }
    public void CatalogProject(String Project) throws InterruptedException {
        ProjectFieldClick.click();Thread.sleep(1000);
        ProjectCode.sendKeys(Project);Thread.sleep(1000);
        SelectProject.click();Thread.sleep(1000);
    }
    public void CatalogWbs(String Wbs) throws InterruptedException {
        WbsFieldClick.click();Thread.sleep(1000);
        WbsCode.sendKeys(Wbs);Thread.sleep(1000);
        SelectWbs.click();Thread.sleep(1000);
    }
    public  void CatalogVendor(String Vendor) throws InterruptedException {
        VendorFieldClick.click();Thread.sleep(1000);
        VendorName.sendKeys(Vendor);Thread.sleep(1000);
        SelectVendor.click();Thread.sleep(1000);
    }
    public void CatalogRc(String Rc) throws InterruptedException {
        RCFieldClick.click();Thread.sleep(1000);
        RCCode.sendKeys(Rc);Thread.sleep(1000);
        SelectRC.click();Thread.sleep(1000);
    }
    public void CatalogShippingAdds(String Address) throws InterruptedException {
        ShippingAddressFieldClick.click();Thread.sleep(1000);
//        page.findElement(By.cssSelector("input[class='select2-search__field']")).sendKeys(Address);Thread.sleep(1000);
        ShippingAddressSelect.click();Thread.sleep(1000);
    }
    public void CatalogShippingMode(String Mode) throws InterruptedException {
        ShippingModeFieldClick.click();Thread.sleep(1000);
        ShippingModeName.sendKeys(Mode);Thread.sleep(1000);
        SelectShippingMode.click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 100)", "");
    }
    public  void CatalogExpectedPOIssue() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 500)", "");
            WebElement Date = ExpectedDateFieldPopup;Thread.sleep(1000);
        Date.click();Thread.sleep(1000);
        SelectTodayDate.click();
    }
    public void CatalogExpectedDelivery() throws InterruptedException {
        ExpectedDeliveryPopup.click();Thread.sleep(1000);
        SelectMaxDate.click();Thread.sleep(1000);
    }
    public void CatalogBuyerManager(String Bm) throws InterruptedException {
        BMFieldClick.click();Thread.sleep(1000);
        BMName.sendKeys(Bm);Thread.sleep(1000);
        SelectBM.click();Thread.sleep(1000);
    }
    public void CatalogProjectManager(String Pm) throws InterruptedException {
        PMFieldClick.click();Thread.sleep(1000);
        PMName.sendKeys(Pm);Thread.sleep(1000);
        SelectPM.click();Thread.sleep(1000);
    }
    public void CatalogOrderIntake(String OI) throws InterruptedException {
        OIPrice.sendKeys(OI);Thread.sleep(1000);
//        page.findElement(By.id("orderInTakeId")).sendKeys(OI);Thread.sleep(1000);
    }
    public void CatalogInspection() throws InterruptedException {
        SelectInspection.click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 600)");
    }
    public void CatalogItems(String ItemsQty) throws InterruptedException {
        //Items Category
        ClickAddLineButton.click();Thread.sleep(2000);
//        ClickCategoryField.click();Thread.sleep(1000);
//        SelectCategory.click();Thread.sleep(1000);
        //Items
        ClickItemField.click();Thread.sleep(1000);
        SelectItem.click();Thread.sleep(1000);
        //Quantity
        ItemQuantity.sendKeys(ItemsQty);Thread.sleep(1000);
        SaveItem.click();Thread.sleep(1000);
    }
    public void CatalogNotes(String PRNotes) throws InterruptedException {
        Notes.sendKeys(PRNotes);Thread.sleep(1000);
    }
    public void CatalogAttachments(String File1, String File2) throws InterruptedException {
        ClickAttachmentsButton.click();Thread.sleep(1000);
        WebElement file = (AttachmentField1);
        file.sendKeys(File1);Thread.sleep(2000);
        SaveFile1.click();Thread.sleep(1000);
        WebElement file2 = (AttachmentField2);Thread.sleep(1000);
        file2.sendKeys(File2);Thread.sleep(2000);
        SaveFile2.click();Thread.sleep(1000);
        SubmitAttachments.click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 900)");
    }
    public void CatalogCreaete() throws InterruptedException {
        ClickCreateButton.click();Thread.sleep(1000);
        ClickYes.click();Thread.sleep(4000);
    }
}