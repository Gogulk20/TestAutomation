package org.example.WorkOrder.TrackerStatus;


import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.example.WorkOrder.OkForInvoice.OkForInvoice;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class VendorTrackerStatus {
    WebDriver page;
    public VendorTrackerStatus(WebDriver page){
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(xpath = "//span[contains(text(),'Work Orders')]")
    WebElement WorkOrder;
    @FindBy(css = "#listContainer tr td")
    List<WebElement> WoListapage;
    @FindBy(css = ".btn-link")
    WebElement TRNLink;
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

    public void VendorUpdateTS(String VendorId, String Pass, String POTrn) throws  InterruptedException{
        LogIn logIn = new LogIn(page);
        logIn.VendorLogin(VendorId,Pass);
        WorkOrder.click();Thread.sleep(1000);
        List<WebElement> rows = WoListapage;
        for (WebElement row : rows) {
            if (row.getText().contains(POTrn)) {
                WebElement btnLink = TRNLink;
                btnLink.click();Thread.sleep(3000);
                break;
            }
        }
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
}
