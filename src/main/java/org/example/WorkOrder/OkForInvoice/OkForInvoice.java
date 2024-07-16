package org.example.WorkOrder.OkForInvoice;

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
import static org.example.Variables.YKMain.Pass;

public class OkForInvoice {
    WebDriver page;
    public OkForInvoice(WebDriver page){
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(id = "ni-work-orders")
    WebElement WorkOrder;
    @FindBy(css = "#listContainer tr td")
    List<WebElement> WOListPage;
    @FindBy(css = ".btn-link")
    WebElement TRNLink;
    @FindBy(id = "btnOkforInvoice")
    WebElement OkForInvoiceButton;
    @FindBy(css = ".bootbox-accept")
    WebElement YesButton;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TRNTitle1;
    @FindBy(xpath = "//span[contains(text(),'Purchase Orders')]")
    WebElement PurchaseOrder;
    @FindBy(id = "referenceId")
    WebElement PONumber;
    @FindBy(id = "ni-dispatch-notes")
    WebElement DispatchNote;
    @FindBy(css = "#listContainer tr td")
    List<WebElement> DiscpatchNoteList;

    public void LMClickOkForInvoice() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0,-1950)");Thread.sleep(1000);
        OkForInvoiceButton.click();Thread.sleep(1000);
        YesButton.click();Thread.sleep(1000);
        LogOut.UserLogOut(page);
    }
    public String GetPOTrnNum() throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(BuyerId,Pass);Thread.sleep(1000);
        PurchaseOrder.click();Thread.sleep(1000);
        TRNTitle1.click();Thread.sleep(3000);
        String POTRNNum = PONumber.getText();
        LogOut.UserLogOut(page);
        logIn.UserLogin(LMId,Pass);Thread.sleep(1000);
        WorkOrder.click();Thread.sleep(2000);
        List<WebElement> rows = WOListPage;Thread.sleep(1000);
        List<WebElement> ListPage = rows.stream().filter(g->g.getText().contains(POTRNNum)).map(g->getTrnNumber(g)).collect(Collectors.toList());Thread.sleep(1000);
        ListPage.forEach(g->g.click());Thread.sleep(3000);
        return POTRNNum;
    }
    private static WebElement getTrnNumber(WebElement g) {
        WebElement TRNLink = g.findElement(By.xpath("ancestor::tr[1]/td[2]/div[1]/a[1]/span[1]"));
        return TRNLink;
    }
}
