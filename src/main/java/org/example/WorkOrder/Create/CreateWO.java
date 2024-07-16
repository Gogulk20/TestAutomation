package org.example.WorkOrder.Create;

import org.example.LogOut.LogOut;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.Variables.YKMain.VendorName;

public class CreateWO {
    WebDriver page;
    public CreateWO(WebDriver page){
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(id = "dropdownMenuButton")
    WebElement AssignButton;
    @FindBy(id = "btnToCreateWorkOrder")
    WebElement CreatWOButton;
    @FindBy(id = "select2-freightForwarderId-container")
    WebElement FFDropdownField;
    @FindBy(css = ".select2-search__field")
    WebElement VendorId;
    @FindBy(css = ".select2-results__option")
    WebElement VendorUserName;
    @FindBy(id = "select2-priority-container")
    WebElement PriorityField;
    @FindBy(css = ".select2-search__field")
    WebElement PriorityTextField;
    @FindBy(css = ".select2-results__option")
    WebElement Priority;
    @FindBy(xpath = "//main[1]/div[1]/form[1]/div[1]/div[2]/div[3]/div[3]/input[2]")
    WebElement DateField;
    @FindBy(xpath = "//div[4]/div[2]/div[1]/div[2]/div[1]/span[42]")
    WebElement MaxDate;
    @FindBy(id = "btnToCreateWorkOrder")
    WebElement CreateButton;
    @FindBy(id = "vendorSendMailBtnId")
    WebElement SubmitButton;
    @FindBy(css = ".bootbox-accept")
    WebElement YesButton;

    public void LMCreateWO() throws InterruptedException {
        AssignButton.click();Thread.sleep(1000);
        CreatWOButton.click();Thread.sleep(3000);
        FFDropdownField.click();Thread.sleep(2000);
        VendorId.sendKeys(VendorName);Thread.sleep(2000);
        VendorUserName.click();Thread.sleep(1000);
        PriorityField.click();Thread.sleep(1000);
        PriorityTextField.sendKeys("High");Thread.sleep(1000);
        Priority.click();Thread.sleep(1000);
        DateField.click();Thread.sleep(1000);
        MaxDate.click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 2800)");;Thread.sleep(1000);
        CreateButton.click();Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) page;
        js1.executeScript("window.scrollBy(0, 600)");Thread.sleep(1000);
        SubmitButton.click();Thread.sleep(1000);
        YesButton.click();Thread.sleep(1000);
        LogOut.UserLogOut(page);
      }
}
