package org.example.DispatchNotes.Create;

import org.example.DispatchNotes.Assign.DNAssign;
import org.example.JavaStreams;
import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.example.YKMain.Title;

public class CreateDN {
    private static final Logger log = LoggerFactory.getLogger(CreateDN.class);
    WebDriver page;
    public CreateDN(WebDriver page) {
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(xpath = "//span[contains(text(),'Purchase Order')]")
    WebElement PurchaseOrder;
    @FindBy(id = "btnCreateDispatchNote")
    WebElement CreateDNButton;
    @FindBy(id = "select2-sourceCountryId-container")
    WebElement SourceCountryField;
    @FindBy(css = ".select2-search__field")
    WebElement SourceCountryName;
    @FindBy(css = ".select2-results__option")
    WebElement CountryName;
    @FindBy(id = "select2-destinationCountryId-container")
    WebElement DestinationCountryFied;
    @FindBy(css = ".select2-search__field")
    WebElement DestinationCountryName;
    @FindBy(id = "addDispatchNotePackages")
    WebElement AddPackageButton;
    @FindBy(id = "select2-packagetypeId-container")
    WebElement PackageField;
    @FindBy(xpath = "//li[contains(text(),'Carton')]")
    WebElement PackageName;
    @FindBy(id = "grossWeight")
    WebElement GrossWeightNumber;
    @FindBy(id = "netWeight")
    WebElement NetWeightNumber;
    @FindBy(id = "volume")
    WebElement VolumeNumber;
    @FindBy(id = "quantity")
    WebElement PackageQuantity;
    @FindBy(id = "saveDispatchNotePackages")
    WebElement SaveButton;
    @FindBy(id = "btnCreate")
    WebElement CreateButton;
    @FindBy(css = ".bootbox-accept")
    WebElement YesButton;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TRNTitle;


    public void VendorCreateDN(String VendorId, String Pass, String SourceCountry,
                               String DestinationCountry, String GrossWeight, String NetWeight,
                               String Volume, String DNQuantity) throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.VendorLogin(VendorId,Pass);
        PurchaseOrder.click();Thread.sleep(1000);
        TRNTitle.click();Thread.sleep(3000);
        CreateDNButton.click();Thread.sleep(1000);
        JavascriptExecutor js= (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0,-750)");Thread.sleep(2000);
        SourceCountryField.click();Thread.sleep(1000);
        SourceCountryName.sendKeys(SourceCountry);Thread.sleep(1000);
        CountryName.click();Thread.sleep(1000);
        DestinationCountryFied.click();Thread.sleep(1000);
        DestinationCountryName.sendKeys(DestinationCountry);Thread.sleep(1000);
        CountryName.click();Thread.sleep(1000);
        JavascriptExecutor js1= (JavascriptExecutor) page;
        js1.executeScript("window.scrollBy(0,600)");Thread.sleep(1000);
        AddPackageButton.click();Thread.sleep(1000);
        PackageField.click();Thread.sleep(1000);
        PackageName.click();Thread.sleep(1000);
        GrossWeightNumber.sendKeys(GrossWeight);Thread.sleep(1000);
        NetWeightNumber.sendKeys(NetWeight);Thread.sleep(1000);
        VolumeNumber.sendKeys(Volume);Thread.sleep(1000);
        PackageQuantity.sendKeys(DNQuantity);Thread.sleep(1000);
        SaveButton.click();Thread.sleep(1000);
        JavascriptExecutor js2= (JavascriptExecutor) page;
        js2.executeScript("window.scrollBy(0,1000)");Thread.sleep(1000);
        CreateButton.click();Thread.sleep(1000);
        YesButton.click();Thread.sleep(3000);
        LogOut.UserLogOut(page);
    }
}
