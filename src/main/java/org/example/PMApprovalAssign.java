package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.example.LogOut.UserLogOut;

public class PMApprovalAssign {
    public static void PORApproval(String Title, String PRGroupB, String PRGroupC, String PRGroupD, String Pass, WebDriver page) throws InterruptedException {
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
            }
//            JavascriptExecutor js2 = (JavascriptExecutor) page;
//            js2.executeScript("window.scrollBy(0, 1000)");Thread.sleep(1000);
//            String Total = page.findElement(By.id("subtotalId")).getText();
//            double Total1 = Double.parseDouble(Total.replaceAll("[,.]", ""));
//            System.out.println(Total1);
            JavascriptExecutor js = (JavascriptExecutor) page;
            js.executeScript("window.scrollBy(0, 3000)");Thread.sleep(1000);
//            page.findElement(By.id("btnApprove")).click();Thread.sleep(1000);
//            page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(1000);
//            if (Total1 <10000) {
            JavascriptExecutor js1 = (JavascriptExecutor) page;
            js1.executeScript("window.scrollBy(0, 750)");Thread.sleep(1000);
            WebElement Approvals = page.findElement(By.id("approvalPanel"));
            String ApproverId = Approvals.findElement(By.xpath("//div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[3]")).getText();
            UserLogOut(page);Thread.sleep(1000);
            page.findElement(By.id("Input_Email")).sendKeys(ApproverId);Thread.sleep(1000);
            page.findElement(By.id("Input_Password")).sendKeys(Pass);Thread.sleep(1000);
            page.findElement(By.id("login-submit")).click();Thread.sleep(1000);
            page.findElement(By.xpath("//span[contains(text(), 'My Approvals')]")).click();Thread.sleep(2000);
            page.findElement(By.xpath("//span[contains(text(),'POR : GHB Company PVT LMT 240024TRN00507 240024POR00368 Revision No : 0')]")).click();Thread.sleep(1000);
            JavascriptExecutor js2 = (JavascriptExecutor) page;
            js2.executeScript("window.scrollBy(0, 3050)");Thread.sleep(1000);
            page.findElement(By.id("btnApprove")).click();Thread.sleep(1000);
            page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(1000);

//            }
//            else {
            WebElement approvals = page.findElement(By.id("approvalPanel"));
            List<WebElement> approvalsIdElements = approvals.findElements(By.xpath("//main[1]/div[1]/div[3]/div[2]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr/td[3]"));
            List<String> approvalsIds = approvalsIdElements.stream().map(Id->Id.getText()).collect(Collectors.toList());
            for (int i = 0; i < approvalsIds.size(); i++) {
                String id = approvalsIds.get(i);
                UserLogOut(page);Thread.sleep(1000);
                page.findElement(By.id("Input_Email")).sendKeys(id);Thread.sleep(1000);
                page.findElement(By.id("Input_Password")).sendKeys(Pass);Thread.sleep(1000);
                page.findElement(By.id("login-submit")).click();Thread.sleep(1000);
                page.findElement(By.xpath("//span[contains(text(), 'My Approvals')]")).click();Thread.sleep(2000);
                page.findElement(By.xpath("//span[contains(text(),'POR : GHB Company PVT LMT 240024TRN00507 240024POR00368 Revision No : 0')]")).click();Thread.sleep(1000);
                JavascriptExecutor js3 = (JavascriptExecutor) page;
                js3.executeScript("window.scrollBy(0, 3050)");Thread.sleep(1000);
                page.findElement(By.id("btnApprove")).click();Thread.sleep(1000);
                page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(1000);
            }
        }
        else if (!GroupApproverPopup.isEnabled()) {
//            JavascriptExecutor js2 = (JavascriptExecutor) page;
//            js2.executeScript("window.scrollBy(0, 1000)");Thread.sleep(1000);
//            Integer Total = Integer.valueOf(page.findElement(By.id("subtotalId")).getText());
            JavascriptExecutor js = (JavascriptExecutor) page;
            js.executeScript("window.scrollBy(0, 3000)");Thread.sleep(1000);
            page.findElement(By.id("btnApprove")).click();Thread.sleep(2000);
            page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(1000);
//            if (Total < 10000) {
            JavascriptExecutor js1 = (JavascriptExecutor) page;
            js1.executeScript("window.scrollBy(0, 750)");
            Thread.sleep(1000);
            WebElement approvals = page.findElement(By.id("approvalPanel"));
            List<WebElement> approvalsIdElements = approvals.findElements(By.xpath("//main[1]/div[1]/div[3]/div[2]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr/td[3]"));
            List<String> approvalsIds = approvalsIdElements.stream().map(Id -> Id.getText()).collect(Collectors.toList());
            for (int i = 0; i < approvalsIds.size(); i++) {
                String id = approvalsIds.get(i);
                UserLogOut(page);Thread.sleep(1000);
                page.findElement(By.id("Input_Email")).sendKeys(id);Thread.sleep(1000);
                page.findElement(By.id("Input_Password")).sendKeys(Pass);Thread.sleep(1000);
                page.findElement(By.id("login-submit")).click();Thread.sleep(1000);
                page.findElement(By.xpath("//span[contains(text(), 'My Approvals')]")).click();Thread.sleep(2000);
                page.findElement(By.xpath("//span[contains(text(),'POR : GHB Company PVT LMT 240024TRN00507 240024POR00368 Revision No : 0')]")).click();Thread.sleep(1000);
                JavascriptExecutor js2 = (JavascriptExecutor) page;
                js2.executeScript("window.scrollBy(0, 3050)");Thread.sleep(1000);
                page.findElement(By.id("btnApprove")).click();Thread.sleep(1000);
                page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(1000);
            }
            WebElement approvals1 = page.findElement(By.id("approvalPanel"));
            List<WebElement> approvalsIdElements1 = approvals1.findElements(By.xpath("//main[1]/div[1]/div[3]/div[2]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr/td[3]"));
            List<String> approvalsIds1 = approvalsIdElements1.stream().map(Id -> Id.getText()).collect(Collectors.toList());
            for (int i = 0; i < approvalsIds1.size(); i++) {
                String id = approvalsIds1.get(i);
                UserLogOut(page);Thread.sleep(1000);
                page.findElement(By.id("Input_Email")).sendKeys(id);Thread.sleep(1000);
                page.findElement(By.id("Input_Password")).sendKeys(Pass);Thread.sleep(1000);
                page.findElement(By.id("login-submit")).click();Thread.sleep(1000);
                page.findElement(By.xpath("//span[contains(text(), 'My Approvals')]")).click();Thread.sleep(2000);
                page.findElement(By.xpath("//span[contains(text(),'POR : GHB Company PVT LMT 240024TRN00507 240024POR00368 Revision No : 0')]")).click();Thread.sleep(1000);
                JavascriptExecutor js2 = (JavascriptExecutor) page;
                js2.executeScript("window.scrollBy(0, 3050)");Thread.sleep(1000);
                page.findElement(By.id("btnApprove")).click();Thread.sleep(1000);
                page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(1000);
            }
//            }
        }
    }
}
