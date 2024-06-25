package org.example.POR.SendForApproval;
import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PORSendForApproval {
    WebDriver page;
    public PORSendForApproval(WebDriver page){
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(id = "btnNewSendApproval")
    WebElement SendForApprovalButton;
    @FindBy(xpath = "//main[1]/div[1]/div[5]/div[1]/div[1]")
    WebElement ApprovalAssignPopup;
    @FindBy(xpath = "//label[contains(text(),'Chief Financial Officer')]")
    WebElement CFOTitle;
    @FindBy(xpath = "/html[1]/body[1]/main[1]/div[1]/div[5]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/span[1]/span[1]/span[1]/span[1]")
    WebElement CFOField;
    @FindBy(css = ".select2-results__option--highlighted")
    WebElement CFOUser;
    @FindBy(xpath = "//label[contains(text(),'President / Director (Corporate)')]")
    WebElement ChiefPresidentOrDirectorTitle;
    @FindBy(id = "select2-role-8-container")
    WebElement ChiefPresidentOrDirectorField;
    @FindBy(css = ".select2-search__field")
    WebElement ChiefPresidentOrDirectorTextField;
    @FindBy(css = ".select2-results__option--highlighted")
    WebElement ChiefPresidentOrDirectorUser;
    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    WebElement SubmitButton;
    @FindBy(id = "approvalPanel")
    WebElement ApprovalList;

    public void SendForApproval (String PreOrDict, String Pass) throws InterruptedException {
        SendForApprovalButton.click();Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(page,Duration.ofSeconds(5));
        try {
            WebElement ApprovalPopup = ApprovalAssignPopup;Thread.sleep(1000);
            WebElement ChiefFO = CFOTitle;Thread.sleep(1000);
            WebElement ChiefPresidentOrDirector = ChiefPresidentOrDirectorTitle;Thread.sleep(1000);
            if (ApprovalPopup.isEnabled()) {
            boolean isChiefPresidentOrDirectorVisible = false;
            try {
                isChiefPresidentOrDirectorVisible = wait.until(ExpectedConditions.visibilityOf(ChiefPresidentOrDirector)).isDisplayed();
            } catch (TimeoutException e) {
                isChiefPresidentOrDirectorVisible = false;
            }
            if (ChiefFO.isDisplayed() && !isChiefPresidentOrDirectorVisible){
//                if (ChiefFO.isDisplayed() && !wait(ExpectedConditions.visibilityOf(ChiefPresidentOrDirectorTitle))) {
                        CFOField.click();
                        CFOUser.click();
                        SubmitButton.click();Thread.sleep(3000);
                }
            }
        try{
//        WebElement ChiefPresidentOrDirector1 = wait.until(ExpectedConditions.visibilityOf(ChiefPresidentOrDirectorTitle));
                if (ChiefFO.isDisplayed() && ChiefPresidentOrDirector.isDisplayed()) {
                    CFOField.click();
                    CFOUser.click();
                }
                if (ChiefPresidentOrDirector.isDisplayed()) {
//                    ChiefPresidentOrDirectorField.click();Thread.sleep(1000);
//                    ChiefPresidentOrDirectorTextField.sendKeys(PreOrDict);Thread.sleep(1000);
//                    ChiefPresidentOrDirectorUser.click();Thread.sleep(1000);
//                    SubmitButton.click();Thread.sleep(3000);
//                    JavascriptExecutor js = (JavascriptExecutor) page;
//                    js.executeScript("window.scrollBy(0, 3100)"); Thread.sleep(1000);
//                    WebElement approvalPanel = ApprovalList;
//                    approvalPanel.findElements(By.tagName("tr"));
//                    String PMId = approvalPanel.findElement(By.xpath("//div[1]/div[3]/div[2]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/table/tbody/tr[1]/td[3]")).getText();
//                    LogOut.UserLogOut(page); Thread.sleep(1000);
//                    LogIn logIn = new LogIn(page);
//                    logIn.UserLogin(PMId,Pass);Thread.sleep(3000);
                SubmitButton.click();Thread.sleep(3000);
                }
            }catch (NoSuchElementException e) {
        }
        }
        catch (NoSuchElementException e) {
        }
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 3600)"); Thread.sleep(1000);
        WebElement approvalPanel = ApprovalList;
        approvalPanel.findElements(By.tagName("tr"));
        String PMId = approvalPanel.findElement(By.xpath("//div[1]/div[3]/div[2]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/table/tbody/tr[1]/td[3]")).getText();
        LogOut.UserLogOut(page); Thread.sleep(1000);
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(PMId,Pass);Thread.sleep(3000);

    }

    private boolean wait(ExpectedCondition<WebElement> webElementExpectedCondition) {
        return false;
    }


}