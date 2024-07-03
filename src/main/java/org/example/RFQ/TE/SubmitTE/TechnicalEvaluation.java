package org.example.RFQ.TE.SubmitTE;

import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.Variables.YKMain.Title;

public class TechnicalEvaluation {
    WebDriver page;
    public TechnicalEvaluation(WebDriver page) {
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(xpath = "//span[contains(text(),'Request For Quotations')]")
    WebElement RFQpage;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TrnTitle;
    @FindBy(id = "btnCreateTE")
    WebElement CreateTEButton;
    @FindBy(css = ".form-check-input")
    WebElement VendorCheckBox;
    @FindBy(id = "btnCreate")
    WebElement TEEvaluateButton;
    @FindBy(css = ".bootbox-accept")
    WebElement OptionYes;
    @FindBy(id = "btnSendApproval")
    WebElement SendForApprovalButton;
    @FindBy(id = "select2-approverUser-container")
    WebElement UserDropdownField;
    @FindBy(css = ".select2-search__field")
    WebElement UserId;
    @FindBy(css = ".select2-results__option")
    WebElement RequesterId;
    @FindBy(id = "saveApproverAssign")
    WebElement AssignButton;
    @FindBy(css = ".bootbox-accept")
    WebElement YesOption;
    @FindBy(id = "btnApprove")
    WebElement ApproveButton;



    public void RequesterCreateTE(String ReqId, String Pass) throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(ReqId,Pass);
        RFQpage.click();Thread.sleep(2000);
        TrnTitle.click();Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 1700)");Thread.sleep(1000);
        CreateTEButton.click();Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) page;
        js1.executeScript("window.scrollBy(0, 2000)");Thread.sleep(2000);
        VendorCheckBox.click();Thread.sleep(1000);
        TEEvaluateButton.click();Thread.sleep(1000);
        OptionYes.click();Thread.sleep(4000);
        SendForApprovalButton.click();Thread.sleep(2000);
        UserDropdownField.click();Thread.sleep(2000);
        UserId.sendKeys(ReqId);Thread.sleep(2000);
        RequesterId.click();Thread.sleep(2000);
        AssignButton.click();Thread.sleep(2000);
        YesOption.click();Thread.sleep(2000);
        JavascriptExecutor js2 = (JavascriptExecutor) page;
        js2.executeScript("window.scrollBy(0, 1000)");Thread.sleep(1000);
        ApproveButton.click();Thread.sleep(1000);
        OptionYes.click();Thread.sleep(3000);
        LogOut.UserLogOut(page);
    }
}
