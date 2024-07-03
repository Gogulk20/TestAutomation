package org.example.POR.Approval;

import org.example.LogOut.LogOut;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.Variables.YKMain.*;

public class ApprovalRejectPOR {
    WebDriver page;

    public ApprovalRejectPOR(WebDriver page) {
        this.page = page;
        PageFactory.initElements(page, this);
    }

    @FindBy(xpath = "//span[contains(text(), 'My Approvals')]")
    WebElement MyApproval;
    @FindBy(xpath = "//button[contains(text(),'Add Approvers')]")
    WebElement AddApprovalsButton;
    @FindBy(xpath = "//main[1]/div[1]/div[6]/div[1]/div[1]")
    WebElement ApprovalPopup;
    @FindBy(xpath = "//label[contains(text(),'PR Approver Group B')]")
    WebElement PRApprovalGroupB;
    @FindBy(id = "select2-PMBId-container")
    WebElement PRGroupBField;
    @FindBy(css = ".select2-search__field")
    WebElement UserId;
    @FindBy(css = ".select2-results__option")
    WebElement User;
    @FindBy(xpath = "//label[contains(text(),'PR Approver Group C')]")
    WebElement PRApprovalGroupC;
    @FindBy(id = "select2-departmentManagerId-container")
    WebElement DepartmentManager;
    @FindBy(xpath = "//label[contains(text(),'PR Approver Group D')]")
    WebElement PRApprovalGroupD;
    @FindBy(id = "select2-divisionManagerId-container")
    WebElement DivisionManager;
    @FindBy(id = "btnSendUserFromPM")
    WebElement SaveUser;
    @FindBy(id = "btnReject")
    WebElement RejectButton;
    @FindBy(css = ".bootbox-accept")
    WebElement YesButton;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TrnTitle;
    @FindBy(xpath = "//th[contains(text(),'Approver')]")
    WebElement ApproveButtonVisibile;
    @FindBy(css = ".bootbox-input")
    WebElement Remarks;


    public void PORApproval() throws InterruptedException {
        MyApproval.click();Thread.sleep(2000);
        TrnTitle.click();Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(page, Duration.ofSeconds(5));
        AddApprovalsButton.click();Thread.sleep(2000);
        try {
            WebElement GroupApproverPopup = ApprovalPopup;
            wait.until(ExpectedConditions.elementToBeClickable(GroupApproverPopup));
            if (GroupApproverPopup.isEnabled()) {
                try {
                    WebElement GroupB = PRApprovalGroupB;
                    WebElement GroupC = PRApprovalGroupC;
                    WebElement GroupD = PRApprovalGroupD;
                    if (GroupB.isDisplayed() && !GroupC.isDisplayed() && !GroupD.isDisplayed()) {
                        PRGroupBField.click();Thread.sleep(1000);
                        UserId.sendKeys(PRGroupB);Thread.sleep(1000);
                        User.click();Thread.sleep(1000);
                        SaveUser.click();Thread.sleep(2000);
                    } else {
                        PRGroupBField.click();Thread.sleep(1000);
                        UserId.sendKeys(PRGroupB);Thread.sleep(1000);
                        User.click();Thread.sleep(1000);
                    }
                    if (GroupC.isDisplayed() && !GroupD.isDisplayed()) {
                        DepartmentManager.click();Thread.sleep(1000);
                        UserId.sendKeys(PRGroupC);Thread.sleep(1000);
                        User.click();Thread.sleep(1000);
                        SaveUser.click();Thread.sleep(2000);
                    } else {
                        DepartmentManager.click();Thread.sleep(1000);
                        UserId.sendKeys(PRGroupC);Thread.sleep(1000);
                        User.click();Thread.sleep(1000);
                    }
                    if (GroupD.isDisplayed()) {
                        DivisionManager.click();Thread.sleep(1000);
                        UserId.sendKeys(PRGroupD);Thread.sleep(1000);
                        User.click();Thread.sleep(1000);
                        SaveUser.click();Thread.sleep(2000);
                    }
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
        }
        WebElement panel = wait.until(ExpectedConditions.visibilityOf(ApproveButtonVisibile));
        ((JavascriptExecutor) page).executeScript("arguments[0].scrollIntoView(true);", panel);
        RejectButton.click();Thread.sleep(3000);
        Remarks.sendKeys("POR reject Remarks");
        YesButton.click();Thread.sleep(3000);
        LogOut.UserLogOut(page);
        try {
            AddApprovalsButton.click();Thread.sleep(3000);
            WebElement GroupApproverPopup = ApprovalPopup;
            if (!GroupApproverPopup.isEnabled()) {
                WebElement panel1 = wait.until(ExpectedConditions.visibilityOf(ApproveButtonVisibile));
                ((JavascriptExecutor) page).executeScript("arguments[0].scrollIntoView(true);", panel1);
                RejectButton.click();Thread.sleep(3000);
                Remarks.sendKeys("POR reject Remarks");
                YesButton.click();Thread.sleep(3000);
            }
        } catch (Exception e) {
    }
    }
}
