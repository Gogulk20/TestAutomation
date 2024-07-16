package org.example.OrderSchedule.EditPage;

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

public class OSEditPage {
    WebDriver page;
    public String POTrn;
    public OSEditPage(WebDriver page) {
        this.page=page;
        PageFactory.initElements(page,this);
    }

    @FindBy(xpath = "//span[contains(text(),'Order Schedules')]")
    WebElement OrderSchedule;
    @FindBy(xpath = "/html[1]/body[1]/main[1]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr/td[3]")
    List<WebElement> OSListPage;
    @FindBy(id = "btnEdit")
    WebElement EditButton;
    @FindBy(id = "btnUpdate")
    WebElement UpdateButton;
    @FindBy(css = ".bootbox-accept")
    WebElement YesButton;
    @FindBy(id = "referenceId")
    WebElement PORefId;
    @FindBy(xpath = "//span[contains(text(),'"+Title+"')]")
    WebElement TRNTitle;
    @FindBy(xpath = "//span[contains(text(),'Purchase Orders')]")
    WebElement PurchaseOrder;

    public String getPOTrnNumber() throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.VendorLogin(VendorId, Pass);
        PurchaseOrder.click();Thread.sleep(1000);
        try{
            TRNTitle.click();Thread.sleep(3000);
        }catch (Exception e){
            JavascriptExecutor js = (JavascriptExecutor) page;
            js.executeScript("window.scrollBy(0,800)");Thread.sleep(1000);
        }
        POTrn = PORefId.getText();
        return POTrn;
    }
    public void VendorEditOS() throws InterruptedException {
        OrderSchedule.click();Thread.sleep(2000);
        List<WebElement> rows = OSListPage;Thread.sleep(1000);
        List<WebElement> ListPage = rows.stream().filter(g->g.getText().contains(POTrn)).map(g->getTrnNumber(g)).collect(Collectors.toList());Thread.sleep(1000);
        ListPage.forEach(g->g.click());Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0,800)");Thread.sleep(1000);
        UpdateButton.click();Thread.sleep(2000);
        YesButton.click();Thread.sleep(2000);
        LogOut.UserLogOut(page);
    }

    private static WebElement getTrnNumber(WebElement g) {
        WebElement TRNLink = g.findElement(By.xpath("ancestor::tr[1]/td[2]/div[1]/a[1]/span[1]"));
        return TRNLink;
    }
}