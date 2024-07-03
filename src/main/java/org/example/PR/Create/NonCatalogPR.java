package org.example.PR.Create;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NonCatalogPR {
    WebDriver page;
    public NonCatalogPR(WebDriver page){
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(css = ".btn-primary")
    WebElement CreateButton;
    @FindBy(xpath = "//div/table/tbody/tr[2]/td[1]/a[1]")
    WebElement CatalogPRPage;

    public void NonCatalogCreateButton() throws InterruptedException {
        CreateButton.click(); Thread.sleep(1000);
        CatalogPRPage.click();Thread.sleep(1000);
    }
    @FindBy(id = "title")
    WebElement TrnTitle;

    public void NonCatalogTitle(String Title) throws InterruptedException {
        TrnTitle.sendKeys(Title);Thread.sleep(1000);
    }
    @FindBy(id = "select2-projectId-container")
    WebElement ProjectFieldClick;
    @FindBy(css = "input[class='select2-search__field']")
    WebElement ProjectName;
    @FindBy(css = ".select2-results__option--highlighted")
    WebElement SelectProject;

    public void NonCatalogProject(String Project) throws InterruptedException {
        ProjectFieldClick.click();Thread.sleep(1000);
        ProjectName.sendKeys(Project);Thread.sleep(1000);
        SelectProject.click();Thread.sleep(2000);
    }
    @FindBy(id = "select2-wbsId-container")
    WebElement WbsFieldClick;
    @FindBy(css = "input[class='select2-search__field']")
    WebElement WbsCode;
    @FindBy(css = ".select2-results__option")
    WebElement SelectWbs;
    public void NonCatalogWbs(String Wbs) throws InterruptedException {
        WbsFieldClick.click();Thread.sleep(1000);
        WbsCode.sendKeys(Wbs);Thread.sleep(1000);
        SelectWbs.click();Thread.sleep(1000);
    }
    @FindBy(id = "select2-incoterm-container")
    WebElement IncotermFieldClick;
    @FindBy(css = "input[class='select2-search__field']")
    WebElement IncotermName;
    @FindBy(css = ".select2-results__option")
    WebElement SelectIncoterm;

    public void NonCatalogIncoterm(String Incterm) throws InterruptedException {
        IncotermFieldClick.click();Thread.sleep(1000);
        IncotermName.sendKeys(Incterm);Thread.sleep(1000);
        SelectIncoterm.click();Thread.sleep(1000);
    }
    @FindBy(id = "select2-shippingaddressId-container")
    WebElement ShippingAddressFieldClick;
    @FindBy(css = ".select2-results__option")
    WebElement SelectShippingAddress;

    public  void NonCatalogShippingAdds(String Address) throws InterruptedException {
        ShippingAddressFieldClick.click();Thread.sleep(1000);
//        page.findElement(By.cssSelector("input[class='select2-search__field']")).sendKeys(Address);Thread.sleep(1000);
        SelectShippingAddress.click();Thread.sleep(1000);
    }
    @FindBy(id = "select2-shippingmodeid-container")
    WebElement ShippingModeFieldClick;
    @FindBy(css = "input[class='select2-search__field']")
    WebElement ShippingModeName;
    @FindBy(css = ".select2-results__option")
    WebElement SelectShippingMode;


    public void NonCatalogShippingMode(String Mode) throws InterruptedException {
        ShippingModeFieldClick.click();Thread.sleep(1000);
        ShippingModeName.sendKeys(Mode);Thread.sleep(1000);
        SelectShippingMode.click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 100)", "");
    }
    @FindBy(xpath = "//main[1]/div[1]/form[1]/div[1]/div[2]/div[2]/div[1]/input[2]")
    WebElement QuotationRequiredDate;
    @FindBy(css = ".today")
    WebElement SelectTodaysDate;

    public void NonCatalogQuotationRequiredBy() throws InterruptedException {
        WebElement Date = QuotationRequiredDate;
        Date.click();Thread.sleep(1000);
        SelectTodaysDate.click();Thread.sleep(1000);
    }
    @FindBy(xpath = "//main[1]/div[1]/form[1]/div[1]/div[2]/div[2]/div[2]/input[2]")
    WebElement ExpectedPOIssueField;
    @FindBy(css ="span.flatpickr-day.today")
    List<WebElement> SelectDateField;

    public void NonCatalogExpectedPOIssue() throws InterruptedException {
        WebElement Date = ExpectedPOIssueField;Thread.sleep(1000);
        Date.click();Thread.sleep(1000);
        List<WebElement> elements = SelectDateField;
        elements.get(1).click();Thread.sleep(1000);
    }
    @FindBy(xpath = "//main[1]/div[1]/form[1]/div[1]/div[2]/div[2]/div[3]/input[2]")
    WebElement ExpectedDeliveryDateField;
    @FindBy(xpath = "//div[6]/div[2]/div[1]/div[2]/div[1]/span[42]")
    WebElement SelectMaxDates;

    public void NonCatalogExpectedDelivery() throws InterruptedException {
        ExpectedDeliveryDateField.click();Thread.sleep(1000);
        SelectMaxDates.click();Thread.sleep(1000);
    }
    @FindBy(id = "select2-buyerManagerId-container")
    WebElement BMFieldClick;
    @FindBy(css = "input[class='select2-search__field']")
    WebElement BMName;
    @FindBy(css = ".select2-results__option")
    WebElement SelectBM;

    public void NonCatalogBuyerManager(String Bm) throws InterruptedException {
        BMFieldClick.click();Thread.sleep(1000);
        BMName.sendKeys(Bm);Thread.sleep(1000);
        SelectBM.click();Thread.sleep(1000);
    }
    @FindBy(id = "select2-projectManagerId-container")
    WebElement PMFieldClick;
    @FindBy(css = "input[class='select2-search__field']")
    WebElement PMName;
    @FindBy(css = ".select2-results__option")
    WebElement SelectPM;

    public void NonCatalogProjectManager(String Pm) throws InterruptedException {
        PMFieldClick.click();Thread.sleep(1000);
        PMName.sendKeys(Pm);Thread.sleep(1000);
        SelectPM.click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 150)");Thread.sleep(1000);
    }
    @FindBy(id = "inspectrequired")
    WebElement InspectionYes;

    public void NonCatalogInspection() throws InterruptedException {
        InspectionYes.click();Thread.sleep(1000);
    }
    @FindBy(id = "orderintakeid")
    WebElement OIPrice;

    public void NonCatalogOrderIntake(String OI) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 500)", "");Thread.sleep(1000);
        OIPrice.sendKeys(OI);Thread.sleep(1000);
        JavascriptExecutor js1 = (JavascriptExecutor) page;
        js1.executeScript("window.scrollBy(0, 600)");
    }
    @FindBy(id = "targetpriceid")
    WebElement TPPrice;

    public void NonCatalogTargetPrice(String TP) throws InterruptedException {
        TPPrice.sendKeys(TP);Thread.sleep(1000);
    }
    @FindBy(id = "select2-warrantyrequirementsid-container")
    WebElement WarrantyFieldClick;
    @FindBy(css = ".select2-results__option")
    WebElement SelectWarranty;

    public void NonCatalogWarranty() throws InterruptedException {
        WarrantyFieldClick.click();Thread.sleep(1000);
        SelectWarranty.click();Thread.sleep(1000);
    }
    @FindBy(id = "select2-pricevalidityid-container")
    WebElement PriceValidityFieldClick;
    @FindBy(css = ".select2-results__option")
    WebElement SelectPriceValidity;

    public void NonCatalogPriceValidity(WebDriver page) throws InterruptedException {
        PriceValidityFieldClick.click();Thread.sleep(1000);
        SelectPriceValidity.click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 600)");
    }
    @FindBy(id = "addLineRequisitionItems")
    WebElement AddLineItemButton;
//    @FindBy(id = "select2-categoryid-container")
//    WebElement ItemCategoryFieldClcik;
//    @FindBy(css = ".select2-results__option")
//    WebElement SelectItemCategory;
    @FindBy(id = "select2-itemid-container")
    WebElement ItemFieldClick;
    @FindBy(css = ".select2-results__option")
    WebElement SelectItem;
    @FindBy(id = "quantity")
    WebElement ItemQuantity;
    @FindBy(id = "saveRequisitionItem")
    WebElement SaveItemButtom;

    public void NonCatalogItems(String ItemsQty) throws InterruptedException {
        //Items Category
        AddLineItemButton.click();Thread.sleep(2000);
//        ItemCategoryFieldClcik.click();Thread.sleep(1000);
//        SelectItemCategory.click();Thread.sleep(1000);
        //Items
        ItemFieldClick.click();Thread.sleep(1000);
        SelectItem.click();Thread.sleep(1000);
        //Quantity
        ItemQuantity.sendKeys(ItemsQty);Thread.sleep(1000);
        SaveItemButtom.click();Thread.sleep(1000);
    }
    @FindBy(id = "notes")
    WebElement Notes;

    public void NonCatalogNotes(String PRNotes) throws InterruptedException {
        Notes.sendKeys(PRNotes);Thread.sleep(1000);
    }
    @FindBy(id = "attachDocs")
    WebElement ClickAttachmentButton;
    @FindBy(id = "formFilePreupload")
    WebElement AttachField1;
    @FindBy(id = "saveAttachments1")
    WebElement SaveFiel1;
    @FindBy(id = "formFilePreupload")
    WebElement AttachField2;
    @FindBy(id = "saveAttachments1")
    WebElement SaveFiel2;
    @FindBy(id = "submitAttachmentsId")
    WebElement SubmitAttachments;

    public void NonCatalogAttachments(String File1, String File2) throws InterruptedException {
        ClickAttachmentButton.click();Thread.sleep(1000);
        WebElement file = (AttachField1);
        file.sendKeys(File1);Thread.sleep(2000);
        SaveFiel1.click();Thread.sleep(1000);
        WebElement file2 = (AttachField2);Thread.sleep(1000);
        file2.sendKeys(File2);Thread.sleep(2000);
        SaveFiel2.click();Thread.sleep(1000);
        SubmitAttachments.click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 600)");
    }
    @FindBy(id = "btnCreate")
    WebElement ClickCreateButton;
    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    WebElement ClickYesOptoin;

    public void NonCatalogCreaete() throws InterruptedException {
        ClickCreateButton.click();Thread.sleep(1000);
        ClickYesOptoin.click();Thread.sleep(4000);
    }
}


