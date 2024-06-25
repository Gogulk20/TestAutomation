package org.example.Invoice.Create;

import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.*;
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
    }

    public void VendorCreateInvoice(String VendorId, String Pass, String POTrn, String INVNumber, String AdminId) throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.VendorLogin(VendorId, Pass);
        page.findElement(By.xpath("//span[contains(text(),'Invoices')]")).click();Thread.sleep(3000);
        page.findElement(By.xpath("//main[1]/div[1]/div[1]/div[1]/div[2]/a[1]")).click();Thread.sleep(3000);
        page.findElement(By.id("select2-companyId-container")).click();Thread.sleep(1000);
        List<WebElement> CompanyDropdown = page.findElements(By.cssSelector(".select2-results"));
        List<String> ComCodeList = CompanyDropdown.stream().map(Id -> Id.getText()).collect(Collectors.toList());
        String[] Company = (POTrn.split("24P"));Thread.sleep(1000);
        String CompanyCode = Company[0].trim();Thread.sleep(1000);
        for (String Code : ComCodeList) {
            if (Code.contains(CompanyCode)) {
                page.findElement(By.xpath("//li[contains(text(),'" + CompanyCode + "')]")).click();Thread.sleep(1000);
                break;
            }
        }
        page.findElement(By.id("select2-typeId-container")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//li[contains(text(),'Purchase Order')]")).click();Thread.sleep(1000);
        page.findElement(By.id("invoiceNumber")).sendKeys(INVNumber);Thread.sleep(1000);
        page.findElement(By.xpath("//main[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[4]/input[2]")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//div[6]/div[2]/div[1]/div[2]/div[1]/span[1]")).click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 500)");Thread.sleep(1000);
        page.findElement(By.id("select2-poId-container")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-search__field")).sendKeys(POTrn);Thread.sleep(1000);
        page.findElement(By.cssSelector(".select2-results__option--highlighted")).click();Thread.sleep(1000);
        js.executeScript("window.scrollBy(0, 600)");Thread.sleep(1000);
        String POCurrency = page.findElement(By.id("USDsubtotalCurrency")).getText();
        String SGDCurrency = page.findElement(By.xpath("//main[1]/div[1]/form[1]/div[6]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/th[2]/h4[1]")).getText();
        String[] CurrencyNameHeader = (SGDCurrency.split(" "));Thread.sleep(1000);
        String SGDCCode = CurrencyNameHeader[0].trim();Thread.sleep(1000);
        try {
            String originalWindow = page.getWindowHandle();
            ((JavascriptExecutor) page).executeScript("window.open('https://yea-test.cormsquare.com/Identity/Account/Login', '_blank');");
            Thread.sleep(1000);
            Set<String> allWindows = page.getWindowHandles();
            for (String windowHandle : allWindows) {
                if (!windowHandle.equals(originalWindow)) {
                    page.switchTo().window(windowHandle);
                    break;
                }
            }
            logIn.UserLogin(AdminId, Pass);
            Thread.sleep(1000);
            JavascriptExecutor js1 = (JavascriptExecutor) page;
            js1.executeScript("document.querySelector('.navbar-vertical-content').scrollTop=5000");
            Thread.sleep(1000);
            page.findElement(By.xpath("//span[contains(text(),'Settings')]")).click();
            Thread.sleep(1000);
            page.findElement(By.xpath("//a[contains(text(),'Currency Exchange Rate')]")).click();
            Thread.sleep(1000);
            page.findElement(By.cssSelector(".form-control-sm")).sendKeys(POCurrency + " " + SGDCCode);
            List<WebElement> rows = page.findElements(By.xpath("//table[@id='tableCurrencyExchangeRate']//tr//td[3]"));
            String ExchangeRate = null;
            for (WebElement row : rows) {
                if (row.getText().contains(SGDCCode)) {
                    WebElement CurrencyRate = page.findElement(By.xpath("//table[@id='tableCurrencyExchangeRate']//tr//td[4]"));
                    ExchangeRate = CurrencyRate.getText();
                    Thread.sleep(1000);
                    break;
                }
            }
            LogOut.UserLogOut(page);
            logIn.VendorLogin(VendorId, Pass);
            page.switchTo().window(originalWindow);
            String text = page.findElement(By.id("USDsubtotal")).getText();
            try {
                NumberFormat format = NumberFormat.getInstance(Locale.US);
                Number number = format.parse(text);
                double USDGivenRate = number.doubleValue();
                double exchangeRateDouble = Double.parseDouble(ExchangeRate);
                double SuTotalCurrency = USDGivenRate * exchangeRateDouble;
                String SuTotalCurrencyString = Double.toString(SuTotalCurrency);
                WebElement sgdSubtotalInput = page.findElement(By.id("SGDsubtotalInput"));
                sgdSubtotalInput.sendKeys(SuTotalCurrencyString);
                Thread.sleep(1000);
//            String CERFieldInvoice = page.findElement(By.id("currencyExchangeRateId")).getText();Thread.sleep(1000);
                String TotalGST = page.findElement(By.id("USDtotalGST")).getText();
                Thread.sleep(1000);
                NumberFormat format1 = NumberFormat.getInstance(Locale.US);
//                Number number = format.parse(CERFieldInvoice);
                Number number1 = format1.parse(TotalGST);
//                double CERField = number.doubleValue();
                double TotalGstValue = number1.doubleValue();
//                System.out.println("Parsed CERField: " + CERField);Thread.sleep(1000);
                System.out.println("Parsed TotalGstValue: " + TotalGstValue);
                Thread.sleep(1000);
                double Gst = exchangeRateDouble * TotalGstValue;
                System.out.println("Calculated GST: " + Gst);
                Thread.sleep(1000);
                try {
                    if (POCurrency.contains(Code1)) {
                        String GstString = String.format(USD_FORMAT, Gst);
                        WebElement gstInputElement = page.findElement(By.id("SGDtotalGSTInput"));
                        gstInputElement.sendKeys(GstString);
                        Thread.sleep(1000);
                    }
                    if (POCurrency.contains(Code2)) {
                        String GstString = String.format(INR_FORMAT, Gst);
                        WebElement gstInputElement = page.findElement(By.id("SGDtotalGSTInput"));
                        gstInputElement.sendKeys(GstString);
                        Thread.sleep(1000);
                    }
                    if (POCurrency.contains(Code3)) {
                        String GstString = String.format(EUR_FORMAT, Gst);
                        WebElement gstInputElement = page.findElement(By.id("SGDtotalGSTInput"));
                        gstInputElement.sendKeys(GstString);
                        Thread.sleep(1000);
                    }
                    if (POCurrency.contains(Code4)) {
                        String GstString = String.format(CAD_FORMAT, Gst);
                        WebElement gstInputElement = page.findElement(By.id("SGDtotalGSTInput"));
                        gstInputElement.sendKeys(GstString);
                        Thread.sleep(1000);
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
        page.findElement(By.id("btnCreate")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(2000);
        LogOut.UserLogOut(page);
    }
}
