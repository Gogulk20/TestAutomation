package org.example.POR.ApprovalAssign;

import org.example.LogOut.LogOut;
import org.example.PO.POCreate;
import org.example.PO.POSent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class PMApprovalAssign {
    public static void PORApproval(String Title, String PRGroupB, String PRGroupC, String PRGroupD,
                                   String Pass,String AdminId,String BuyerId, WebDriver page) throws InterruptedException {
        page.findElement(By.xpath("//span[contains(text(), 'My Approvals')]")).click();Thread.sleep(2000);
        page.findElement(By.xpath("//span[contains(text(),'"+Title+"')]")).click();Thread.sleep(2000);
        page.findElement(By.xpath("//button[contains(text(),'Add Approvers')]")).click();Thread.sleep(3000);
        WebElement GroupApproverPopup = page.findElement(By.cssSelector(".modal-content"));
        if (GroupApproverPopup.isEnabled()) {

            WebElement GroupB = page.findElement(By.xpath("//label[contains(text(),'PR Approver Group B')]"));
            if (GroupB.isDisplayed()) {
                page.findElement(By.id("select2-PMBId-container")).click();Thread.sleep(1000);
                page.findElement(By.cssSelector(".select2-search__field")).sendKeys(PRGroupB);Thread.sleep(1000);
                page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
            }
            WebElement GroupC = page.findElement(By.xpath("//label[contains(text(),'PR Approver Group C')]"));
            if (GroupC.isDisplayed()) {
                page.findElement(By.id("select2-departmentManagerId-container")).click();Thread.sleep(1000);
                page.findElement(By.cssSelector(".select2-search__field")).sendKeys(PRGroupC);Thread.sleep(1000);
                page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
            }
            WebElement GroupD = page.findElement(By.xpath("//label[contains(text(),'PR Approver Group D')]"));
            if (GroupD.isDisplayed()) {
                page.findElement(By.id("select2-divisionManagerId-container")).click();Thread.sleep(1000);
                page.findElement(By.cssSelector(".select2-search__field")).sendKeys(PRGroupD);Thread.sleep(1000);
                page.findElement(By.cssSelector(".select2-results__option")).click();Thread.sleep(1000);
                page.findElement(By.id("btnSendUserFromPM")).click();Thread.sleep(2000);
            }
            JavascriptExecutor js = (JavascriptExecutor) page;
            js.executeScript("window.scrollBy(0, 4200)");Thread.sleep(1000);
            page.findElement(By.id("btnApprove")).click();Thread.sleep(1000);
            page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(1000);
            JavascriptExecutor js1 = (JavascriptExecutor) page;
            js1.executeScript("window.scrollBy(0, 1000)");Thread.sleep(1000);
            WebElement Approvals = page.findElement(By.id("approvalPanel"));
            List<WebElement> approvalsIdElements = Approvals.findElements(By.xpath("//main[1]/div[1]/div[3]/div[2]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr/td[3]"));
            List<String> approvalsIds = approvalsIdElements.stream().map(Id->Id.getText()).collect(Collectors.toList());
            for (int i = 1; i < approvalsIds.size(); i++) {
                String id = approvalsIds.get(i);
                LogOut.UserLogOut(page);Thread.sleep(1000);
                page.findElement(By.id("Input_Email")).sendKeys(id);Thread.sleep(1000);
                page.findElement(By.id("Input_Password")).sendKeys(Pass);Thread.sleep(1000);
                page.findElement(By.id("login-submit")).click();Thread.sleep(1000);
                page.findElement(By.xpath("//span[contains(text(), 'My Approvals')]")).click();Thread.sleep(2000);
                page.findElement(By.xpath("//span[contains(text(),'POR : GHB Company PVT LMT')]")).click();Thread.sleep(1000);
                JavascriptExecutor js3 = (JavascriptExecutor) page;
                js3.executeScript("window.scrollBy(0, 4250)");Thread.sleep(1000);
                page.findElement(By.id("btnApprove")).click();Thread.sleep(1000);
                page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(1000);
                LogOut.UserLogOut(page);Thread.sleep(1000);
            }
        }
        else if (!GroupApproverPopup.isEnabled()) {
            JavascriptExecutor js = (JavascriptExecutor) page;
            js.executeScript("window.scrollBy(0, 4200)");Thread.sleep(1000);
            page.findElement(By.id("btnApprove")).click();Thread.sleep(2000);
            page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(1000);
            JavascriptExecutor js1 = (JavascriptExecutor) page;
            js1.executeScript("window.scrollBy(0, 950)");
            Thread.sleep(1000);
            WebElement approvals = page.findElement(By.id("approvalPanel"));
            List<WebElement> approvalsIdElements = approvals.findElements(By.xpath("//main[1]/div[1]/div[3]/div[2]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr/td[3]"));
            List<String> approvalsIds = approvalsIdElements.stream().map(Id -> Id.getText()).collect(Collectors.toList());
            for (int i = 0; i < approvalsIds.size(); i++) {
                String id = approvalsIds.get(i);
                LogOut.UserLogOut(page);Thread.sleep(1000);
                page.findElement(By.id("Input_Email")).sendKeys(id);Thread.sleep(1000);
                page.findElement(By.id("Input_Password")).sendKeys(Pass);Thread.sleep(1000);
                page.findElement(By.id("login-submit")).click();Thread.sleep(2000);
                page.findElement(By.xpath("//span[contains(text(), 'My Approvals')]")).click();Thread.sleep(3000);
                page.findElement(By.xpath("//span[contains(text(),'POR : GHB Company PVT LMT')]")).click();Thread.sleep(3000);
                JavascriptExecutor js2 = (JavascriptExecutor) page;
                js2.executeScript("window.scrollBy(0, 4200)");Thread.sleep(1000);
                page.findElement(By.id("btnApprove")).click();Thread.sleep(1000);
                page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(1000);
                LogOut.UserLogOut(page);Thread.sleep(1000);
            }
        }
        POCreate.BuyerCreatePO(AdminId,Pass,Title,page);
        POSent.POSentToVendor(BuyerId,Pass,Title,page);
    }
}
