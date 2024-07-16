package org.example.DispatchNotes.Edit;

import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

import static org.example.Variables.YKMain.*;

public class EditDN {
    WebDriver page;
    public String POTrn;
    public EditDN(WebDriver page) {
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(xpath = "//span[contains(text(),'Purchase Orders')]")
    WebElement PurchaseOrder;
    @FindBy(id = "referenceId")
    WebElement PORefId;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TRNTitle;
    @FindBy(xpath = "//span[contains(text(),'Dispatch Notes')]")
    WebElement DispatchNotes;
    @FindBy(css = "#listContainer tr td")
    List<WebElement> DispathNoteleListPage;
    @FindBy(css = ".btn-link")
    WebElement TRNLink;
    @FindBy(id = "btnEdit")
    WebElement EditButton;
    @FindBy(css = ".bootbox-accept")
    WebElement YesOption;
    @FindBy(id = "btnUpdate")
    WebElement UpdateButton;



    public String getPOTrnNumber() throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.VendorLogin(VendorId, Pass);
        PurchaseOrder.click();Thread.sleep(1000);
        TRNTitle.click();Thread.sleep(3000);
        POTrn = PORefId.getText();
        return POTrn;
    }

    public String VendorEditDN() throws InterruptedException {
        DispatchNotes.click();Thread.sleep(2000);
        List<WebElement> rows = DispathNoteleListPage;Thread.sleep(1000);
        List<WebElement> ListPage = rows.stream().filter(g->g.getText().contains(POTrn)).map(g->getTrnNumber(g)).collect(Collectors.toList());Thread.sleep(1000);
        ListPage.forEach(g->g.click());Thread.sleep(3000);
        EditButton.click();Thread.sleep(1000);
        JavascriptExecutor js= (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0,1000)");Thread.sleep(1000);
        UpdateButton.click();Thread.sleep(2000);
        YesOption.click();Thread.sleep(2000);
        LogOut.UserLogOut(page);
        return POTrn;
    }
    private static WebElement getTrnNumber(WebElement g) {
        WebElement TRNLink = g.findElement(By.xpath("ancestor::tr[1]/td[2]/div[1]/a[1]/span[1]"));
        return TRNLink;
    }
}
