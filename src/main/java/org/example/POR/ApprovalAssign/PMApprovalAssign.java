package org.example.POR.ApprovalAssign;

import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.Variables.YKMain.Title;

public class PMApprovalAssign {
    WebDriver page;
    public PMApprovalAssign(WebDriver page){
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(xpath= "//span[contains(text(), 'My Approvals')]")
    WebElement MyApproval;
    @FindBy(xpath= "//button[contains(text(),'Add Approvers')]")
    WebElement AddApprovalsButton;
    @FindBy(xpath= "//main[1]/div[1]/div[6]/div[1]/div[1]")
    WebElement ApprovalPopup;
    @FindBy(xpath= "//label[contains(text(),'PR Approver Group B')]")
    WebElement PRApprovalGroupB;
    @FindBy(id= "select2-PMBId-container")
    WebElement PRGroupBField;
    @FindBy(css= ".select2-search__field")
    WebElement UserId;
    @FindBy(css= ".select2-results__option")
    WebElement User;
    @FindBy(xpath= "//label[contains(text(),'PR Approver Group C')]")
    WebElement PRApprovalGroupC;
    @FindBy(id= "select2-departmentManagerId-container")
    WebElement DepartmentManager;
    @FindBy(xpath= "//label[contains(text(),'PR Approver Group D')]")
    WebElement PRApprovalGroupD;
    @FindBy(id= "select2-divisionManagerId-container")
    WebElement DivisionManager;
    @FindBy(id= "btnSendUserFromPM")
    WebElement SaveUser;
    @FindBy(id= "btnApprove")
    WebElement ApproveButton;
    @FindBy(css= ".bootbox-accept")
    WebElement YesButton;
    @FindBy(id= "approvalPanel")
    WebElement ApprovalList;
    @FindBy(xpath = "//span[contains(text(),'POR : GHB Company PVT LMT')]")
    WebElement PORTitle;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TrnTitle;
    @FindBy(xpath = "//th[contains(text(),'Approver')]")
    WebElement ApproveButtonVisibile;


    public void PORApproval(String PRGroupB, String PRGroupC, String PRGroupD, String Pass) throws InterruptedException {
        MyApproval.click();Thread.sleep(2000);
        TrnTitle.click();Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(page, Duration.ofSeconds(5));
        AddApprovalsButton.click();Thread.sleep(2000);
        try{
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
        ApproveButton.click();Thread.sleep(1000);
        YesButton.click();Thread.sleep(1000);
        JavascriptExecutor js1 = (JavascriptExecutor) page;
        js1.executeScript("window.scrollBy(0, 1000)");Thread.sleep(1000);
        WebElement Approvals = ApprovalList;
        List<WebElement> approvalsIdElements = Approvals.findElements(By.xpath("//main[1]/div[1]/div[3]/div[2]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr/td[3]"));
        List<String> approvalsIds = approvalsIdElements.stream().map(Id -> Id.getText()).collect(Collectors.toList());
        for (int i = 1; i < approvalsIds.size(); i++) {
            String id = approvalsIds.get(i);
            LogOut.UserLogOut(page);Thread.sleep(1000);
            LogIn logIn = new LogIn(page);
            logIn.UserLogin(id, Pass);Thread.sleep(1000);
            MyApproval.click();Thread.sleep(2000);
            PORTitle.click();Thread.sleep(1000);
            WebElement panel1 = wait.until(ExpectedConditions.visibilityOf(ApproveButtonVisibile));
            ((JavascriptExecutor) page).executeScript("arguments[0].scrollIntoView(true);", panel1);
            ApproveButton.click();Thread.sleep(1000);
            YesButton.click();Thread.sleep(2000);
        }
        LogOut.UserLogOut(page);
try {
    AddApprovalsButton.click();Thread.sleep(3000);
    WebElement GroupApproverPopup = ApprovalPopup;
    if (!GroupApproverPopup.isEnabled()) {
        WebElement panel1 = wait.until(ExpectedConditions.visibilityOf(ApproveButtonVisibile));
        ((JavascriptExecutor) page).executeScript("arguments[0].scrollIntoView(true);", panel1);
        ApproveButton.click();Thread.sleep(2000);
        YesButton.click();Thread.sleep(1000);
        JavascriptExecutor js2 = (JavascriptExecutor) page;
        js2.executeScript("window.scrollBy(0, 950)");Thread.sleep(1000);
        WebElement approvals = ApprovalList;
        List<WebElement> approvalsIdElements1 = approvals.findElements(By.xpath("//main[1]/div[1]/div[3]/div[2]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr/td[3]"));
        List<String> approvalsIds1 = approvalsIdElements1.stream().map(Id -> Id.getText()).collect(Collectors.toList());
        for (int i = 0; i < approvalsIds1.size(); i++) {
            String id = approvalsIds1.get(i);
            LogOut.UserLogOut(page);Thread.sleep(1000);
            LogIn logIn = new LogIn(page);
            logIn.UserLogin(id, Pass);Thread.sleep(1000);
            MyApproval.click();Thread.sleep(2000);
            PORTitle.click();Thread.sleep(1000);
            WebElement panel3 = wait.until(ExpectedConditions.visibilityOf(ApproveButtonVisibile));
            ((JavascriptExecutor) page).executeScript("arguments[0].scrollIntoView(true);", panel3);
            ApproveButton.click();Thread.sleep(1000);
            YesButton.click();Thread.sleep(2000);
        }
        LogOut.UserLogOut(page);
    }
}catch (NoSuchElementException element) {
}
    }

    private boolean wait(ExpectedCondition<WebElement> webElementExpectedCondition) {
        return false;
    }
}
