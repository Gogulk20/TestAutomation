package org.example.WorkOrder.OkForInvoice;

import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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


    public void LMClickOkForInvoice(String LMId, String Pass, String POTrn) throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(LMId,Pass);Thread.sleep(1000);
        WorkOrder.click();Thread.sleep(3000);
        List<WebElement> rows = WOListPage;
        for (WebElement row : rows) {
            if (row.getText().contains(POTrn)) {
                WebElement btnLink = TRNLink;
                btnLink.click();Thread.sleep(3000);
                break;
            }
        }
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0,-1750)");Thread.sleep(1000);
        OkForInvoiceButton.click();Thread.sleep(1000);
        YesButton.click();Thread.sleep(1000);
        LogOut.UserLogOut(page);
    }
}
