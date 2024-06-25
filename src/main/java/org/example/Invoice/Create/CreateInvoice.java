package org.example.Invoice.Create;

import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

public class CreateInvoice {
    private static final String USD_FORMAT = "%.3f";
    private static final String INR_FORMAT = "%.2f";
    private static final String EUR_FORMAT = "%.4f";
    private static final String CAD_FORMAT = "%.3f";
    private static final String Code1 = "USD";
    private static final String Code2 = "INR";
    private static final String Code3 = "EUR";
    private static final String Code4 = "CAD";
    WebDriver page;

    public CreateInvoice(WebDriver page) {
        this.page = page;
        PageFactory.initElements(page,this);
    }
    @FindBy(xpath = "//span[contains(text(),'Invoices')]")
    WebElement InvoiceModule;
    @FindBy(xpath = "//main[1]/div[1]/div[1]/div[1]/div[2]/a[1]")
    WebElement CreateInvoiceButton;
    @FindBy(id = "select2-companyId-container")
    WebElement CompanyField;
    @FindBy(css = ".select2-results")
    List<WebElement> CompanyDropdownField;
    @FindBy(id = "select2-typeId-container")
    WebElement PurchaseType;
    @FindBy(xpath = "//li[contains(text(),'Purchase Order')]")
    WebElement PurchaseOrder;
    @FindBy(id = "invoiceNumber")
    WebElement InvoiceNumberField;
    @FindBy(xpath = "//main[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[4]/input[2]")
    WebElement InvoiceDateField;
    @FindBy(xpath = "//div[6]/div[2]/div[1]/div[2]/div[1]/span[1]")
    WebElement InvoiceMaxDate;
    @FindBy(id = "select2-poId-container")
    WebElement PONumberField;
    @FindBy(css = ".select2-search__field")
    WebElement PONumber;
    @FindBy(css = ".select2-results__option--highlighted")
    WebElement GivenPONumber;
    @FindBy(id = "USDsubtotalCurrency")
    WebElement POSubTotalCurrency;
    @FindBy(xpath = "//main[1]/div[1]/form[1]/div[6]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/th[2]/h4[1]")
    WebElement SGDCurrencyCode;
    @FindBy(xpath = "//span[contains(text(),'Settings')]")
    WebElement SettingsModule;
    @FindBy(xpath = "//a[contains(text(),'Currency Exchange Rate')]")
    WebElement CurrencyExchangeRate;
    @FindBy(css = ".form-control-sm")
    WebElement SearchField;
    @FindBy(xpath = "//table[@id='tableCurrencyExchangeRate']//tr//td[3]")
    List<WebElement> CurrrencyExchangeRateListPage;
    @FindBy(xpath = "//table[@id='tableCurrencyExchangeRate']//tr//td[4]")
    WebElement CurrencyExchangeAmount;
    @FindBy(id = "USDsubtotal")
    WebElement POSubTotal;
    @FindBy(id = "SGDsubtotalInput")
    WebElement SGDSubTotalField;
    @FindBy(id = "USDtotalGST")
    WebElement POGSTAmount;
    @FindBy(id = "SGDtotalGSTInput")
    WebElement SGDGSTField;
    @FindBy(id = "btnCreate")
    WebElement CreateButton;
    @FindBy(css = ".bootbox-accept")
    WebElement YesButton;


    public void VendorCreateInvoice(String VendorId, String Pass, String POTrn, String INVNumber, String AdminId) throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.VendorLogin(VendorId, Pass);
        InvoiceModule.click();Thread.sleep(3000);
        CreateInvoiceButton.click();Thread.sleep(3000);
        CompanyField.click();Thread.sleep(1000);
        List<WebElement> CompanyDropdown = CompanyDropdownField;
        List<String> ComCodeList = CompanyDropdown.stream().map(Id -> Id.getText()).collect(Collectors.toList());
        String[] Company = (POTrn.split("24P"));Thread.sleep(1000);
        String CompanyCode = Company[0].trim();Thread.sleep(1000);
        for (String Code : ComCodeList) {
            if (Code.contains(CompanyCode)) {
                page.findElement(By.xpath("//li[contains(text(),'" + CompanyCode + "')]")).click();Thread.sleep(1000);
                break;
            }
        }
        PurchaseType.click();Thread.sleep(1000);
        PurchaseOrder.click();Thread.sleep(1000);
        InvoiceNumberField.sendKeys(INVNumber);Thread.sleep(1000);
        InvoiceDateField.click();Thread.sleep(1000);
        InvoiceMaxDate.click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 500)");Thread.sleep(1000);
        PONumberField.click();Thread.sleep(1000);
        PONumber.sendKeys(POTrn);Thread.sleep(1000);
        GivenPONumber.click();Thread.sleep(1000);
        js.executeScript("window.scrollBy(0, 600)");Thread.sleep(1000);
        String POCurrency = POSubTotalCurrency.getText();
        String SGDCurrency = SGDCurrencyCode.getText();
        String[] CurrencyNameHeader = (SGDCurrency.split(" "));Thread.sleep(1000);
        String SGDCCode = CurrencyNameHeader[0].trim();Thread.sleep(1000);
        try {
            String originalWindow = page.getWindowHandle();
            ((JavascriptExecutor) page).executeScript("window.open('https://yea-test.cormsquare.com/Identity/Account/Login', '_blank');");Thread.sleep(1000);
            Set<String> allWindows = page.getWindowHandles();
            for (String windowHandle : allWindows) {
                if (!windowHandle.equals(originalWindow)) {
                    page.switchTo().window(windowHandle);
                    break;
                }
            }
            logIn.UserLogin(AdminId, Pass);Thread.sleep(1000);
            JavascriptExecutor js1 = (JavascriptExecutor) page;
            js1.executeScript("document.querySelector('.navbar-vertical-content').scrollTop=5000");Thread.sleep(1000);
            SettingsModule.click();Thread.sleep(1000);
            CurrencyExchangeRate.click();Thread.sleep(1000);
            SearchField.sendKeys(POCurrency + " " + SGDCCode);
            List<WebElement> rows = CurrrencyExchangeRateListPage;
            String ExchangeRate = null;
            for (WebElement row : rows) {
                if (row.getText().contains(SGDCCode)) {
                    WebElement CurrencyRate = CurrencyExchangeAmount;
                    ExchangeRate = CurrencyRate.getText();Thread.sleep(1000);
                    break;
                }
            }
            LogOut.UserLogOut(page);
            logIn.VendorLogin(VendorId, Pass);
            page.switchTo().window(originalWindow);
            String text = POSubTotal.getText();
            try {
                NumberFormat format = NumberFormat.getInstance(Locale.US);
                Number number = format.parse(text);
                double USDGivenRate = number.doubleValue();
                double exchangeRateDouble = Double.parseDouble(ExchangeRate);
                double SuTotalCurrency = USDGivenRate * exchangeRateDouble;
                String SuTotalCurrencyString = Double.toString(SuTotalCurrency);
                WebElement sgdSubtotalInput = SGDSubTotalField;
                sgdSubtotalInput.sendKeys(SuTotalCurrencyString);Thread.sleep(1000);
                String TotalGST = POGSTAmount.getText();Thread.sleep(1000);
                NumberFormat format1 = NumberFormat.getInstance(Locale.US);
                Number number1 = format1.parse(TotalGST);
                double TotalGstValue = number1.doubleValue();Thread.sleep(1000);
                double Gst = exchangeRateDouble * TotalGstValue;Thread.sleep(1000);
                try {
                    if (POCurrency.contains(Code1)) {
                        String GstString = String.format(USD_FORMAT, Gst);
                        WebElement gstInputElement = SGDGSTField;
                        gstInputElement.sendKeys(GstString);Thread.sleep(1000);
                    }
                    if (POCurrency.contains(Code2)) {
                        String GstString = String.format(INR_FORMAT, Gst);
                        WebElement gstInputElement = SGDGSTField;
                        gstInputElement.sendKeys(GstString);Thread.sleep(1000);
                    }
                    if (POCurrency.contains(Code3)) {
                        String GstString = String.format(EUR_FORMAT, Gst);
                        WebElement gstInputElement = SGDGSTField;
                        gstInputElement.sendKeys(GstString);Thread.sleep(1000);
                    }
                    if (POCurrency.contains(Code4)) {
                        String GstString = String.format(CAD_FORMAT, Gst);
                        WebElement gstInputElement = SGDGSTField;
                        gstInputElement.sendKeys(GstString);Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                }
            }catch (InterruptedException e) {
        }
        } catch (ParseException e) {
        }
        js.executeScript("window.scrollBy(0, 600)");Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(page, Duration.ofSeconds(10));
        try {
            WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#doc1")));
            fileInput.sendKeys(Paths.get("C:\\Users\\Vidya Abbigeri\\Downloads\\ExportItems (12).xlsx").toString());Thread.sleep(2000);
        } catch (NoSuchElementException elementException) {
        }
        CreateButton.click();Thread.sleep(1000);
        YesButton.click();Thread.sleep(2000);
        LogOut.UserLogOut(page);
    }
}
