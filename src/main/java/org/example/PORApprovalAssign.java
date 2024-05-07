package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class PORApprovalAssign {

    public static void PORApproval(String Title, String PRGroupB, String PRGroupC, String PRGroupD, WebDriver page) throws InterruptedException {
        page.findElement(By.xpath("//span[contains(text(),'Purchase Order Requests')]")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//span[contains(text(),'"+ Title +"')]")).click();Thread.sleep(1000);
        page.findElement(By.xpath("//button[contains(text(),'Add Approvers')]")).click();Thread.sleep(1000);
        WebElement GroupApproverPopup = page.findElement(By.cssSelector(".modal-content"));
        if (GroupApproverPopup.isDisplayed()) {

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
            page.findElement(By.id("btnSendUserFromPM")).click();Thread.sleep(1000);
            JavascriptExecutor js = (JavascriptExecutor) page;
            js.executeScript("window.scrollBy(0, 3000)");Thread.sleep(1000);
            page.findElement(By.id("btnApprove")).click();Thread.sleep(1000);
            page.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();Thread.sleep(1000);
        } else if (!GroupApproverPopup.isDisplayed()) {
            JavascriptExecutor js = (JavascriptExecutor) page;
            js.executeScript("window.scrollBy(0, 3000)");Thread.sleep(1000);
            page.findElement(By.id("btnApprove")).click();Thread.sleep(1000);
            page.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();Thread.sleep(1000);
        }
    }
}
