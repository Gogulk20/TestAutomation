package org.example;
import org.openqa.selenium.*;
public class PORSendForApproval {
    public static void SendForApproval (String PreOrDict, String Pass, WebDriver page) throws InterruptedException {
        page.findElement(By.id("btnNewSendApproval")).click();Thread.sleep(3000);
        WebElement ApprovalPopup = null;
        try {
            ApprovalPopup = page.findElement(By.xpath("//main[1]/div[1]/div[4]/div[1]/div[1]"));
            if (ApprovalPopup.isEnabled()) {
                WebElement ChiefPresidentOrDirector = page.findElement(By.xpath("//label[contains(text(),'President / Director (Corporate)')]"));
                if (ChiefPresidentOrDirector.isDisplayed()) {
                    page.findElement(By.id("select2-role-8-container")).click();Thread.sleep(1000);
                    page.findElement(By.cssSelector(".select2-search__field")).sendKeys(PreOrDict);Thread.sleep(1000);
                    page.findElement(By.cssSelector(".select2-results__option--highlighted")).click();Thread.sleep(1000);
                    page.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();Thread.sleep(3000);
                    JavascriptExecutor js = (JavascriptExecutor) page;
                    js.executeScript("window.scrollBy(0, 3100)"); Thread.sleep(1000);
                    WebElement approvalPanel = page.findElement(By.id("approvalPanel"));
                    approvalPanel.findElements(By.tagName("tr"));
                    String PMId = approvalPanel.findElement(By.xpath("//div[1]/div[3]/div[2]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/table/tbody/tr[1]/td[3]")).getText();
                    LogOut.UserLogOut(page); Thread.sleep(1000);
                    page.findElement(By.id("Input_Email")).sendKeys(PMId); Thread.sleep(1000);
                    page.findElement(By.id("Input_Password")).sendKeys(Pass); Thread.sleep(1000);
                    page.findElement(By.id("login-submit")).click(); Thread.sleep(3000);
                }
            }
        } catch (NoSuchElementException element) {
            JavascriptExecutor js = (JavascriptExecutor) page;
            js.executeScript("window.scrollBy(0, 3100)"); Thread.sleep(1000);
            WebElement approvalPanel = page.findElement(By.id("approvalPanel"));
            approvalPanel.findElements(By.tagName("tr"));
            String PMId = approvalPanel.findElement(By.xpath("//div[1]/div[3]/div[2]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/table/tbody/tr[1]/td[3]")).getText();
            LogOut.UserLogOut(page); Thread.sleep(1000);
            page.findElement(By.id("Input_Email")).sendKeys(PMId); Thread.sleep(1000);
            page.findElement(By.id("Input_Password")).sendKeys(Pass); Thread.sleep(1000);
            page.findElement(By.id("login-submit")).click(); Thread.sleep(3000);
        }
    }
}