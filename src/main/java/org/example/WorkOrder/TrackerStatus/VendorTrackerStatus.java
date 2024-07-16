package org.example.WorkOrder.TrackerStatus;


import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

import static org.example.Variables.YKMain.*;

public class VendorTrackerStatus {
    WebDriver page;
    public VendorTrackerStatus(WebDriver page){
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(xpath = "//span[contains(text(),'Purchase Orders')]")
    WebElement PurchaseOrder;
    @FindBy(id = "referenceId")
    WebElement PORefId;
    @FindBy(xpath = "//span[contains(text(),'Work Orders')]")
    WebElement WorkOrder;
    @FindBy(css = "#listContainer tr td")
    List<WebElement> WoListapage;
    @FindBy(id = "select2-statusId-container")
    WebElement StatusField;
    @FindBy(xpath = "//span[1]/span[1]/span[2]/ul[1]/li")
    List<WebElement> ListOFStatus;
    @FindBy(xpath = "//main[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[5]/div[1]/div[2]/form[1]/div[1]/div[1]/input[2]")
    WebElement DateField;
    @FindBy(css = ".today")
    WebElement TodayDate;
    @FindBy(id = "btnSubmit")
    WebElement SubmitButton;
    @FindBy(css = ".bootbox-accept")
    WebElement YesButton;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TRNTitle;

    public void VendorUpdateTS() throws  InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.VendorLogin(VendorId, Pass);
        PurchaseOrder.click();Thread.sleep(1000);
        TRNTitle.click();Thread.sleep(3000);
        String POTrn = PORefId.getText();
        WorkOrder.click();
        Thread.sleep(1000);
        List<WebElement> rows = WoListapage;Thread.sleep(1000);
        List<WebElement> ListPage = rows.stream().filter(g->g.getText().contains(POTrn)).map(g->getTrnNumber(g)).collect(Collectors.toList());Thread.sleep(1000);
        ListPage.forEach(g->g.click());Thread.sleep(3000);

    }
    public void VendorTrackerStatus() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0,1750)");Thread.sleep(1000);
        StatusField.click();Thread.sleep(1000);
        List<WebElement> status = ListOFStatus;
        List<String> statusList = status.stream().map(a->a.getText()).collect(Collectors.toList());
        for(int i=0; i<statusList.size();i++){
            String statusName = statusList.get(i);
            WebElement Date = DateField;Thread.sleep(1000);
            Date.click();Thread.sleep(1000);
            TodayDate.click();Thread.sleep(1000);
            StatusField.click();Thread.sleep(1000);
            page.findElement(By.xpath("//li[contains(text(), '" + statusName + "')]")).click();
            SubmitButton.click();Thread.sleep(1000);
            YesButton.click();Thread.sleep(3000);
            JavascriptExecutor js1 = (JavascriptExecutor) page;
            js1.executeScript("window.scrollBy(0,750)");Thread.sleep(1000);
        }
        LogOut.UserLogOut(page);
    }
    private static WebElement getTrnNumber(WebElement g) {
        WebElement TRNLink = g.findElement(By.xpath("ancestor::tr[1]/td[2]/div[1]/a[1]/span[1]"));
        return TRNLink;
    }
}
