package org.example.PR.SendForApproval;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PRSendForApproval {
    WebDriver page;
    public PRSendForApproval(WebDriver page){
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(xpath = "//button[contains(text(),'Send for Approval')]")
    WebElement ClickSendForApprovalButton;
    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    WebElement ClickYes;


    public void Approval() throws InterruptedException {
        ClickSendForApprovalButton.click();Thread.sleep(1000);
        ClickYes.click();Thread.sleep(2000);
            }
}
