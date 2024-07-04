package org.example.Inspections;

import org.example.Login.LogIn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.example.Variables.YKMain.ReqId;

public class Assign {
    WebDriver page;
    public Assign(WebDriver page){
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(xpath = "//span[contains(text(),'Order Schedules')]")
    WebElement OrderSchedule;
    @FindBy(css = "#listContainer tr td")
    List<WebElement> OrderScheduleListPage;
    @FindBy(css = ".btn-link")
    WebElement TRNLink;
    @FindBy(id = "btnAssignInspector")
    WebElement AssignInspectorButton;
    @FindBy(id = "select2-InspectionId-container")
    WebElement AssignInspectorField;
    @FindBy(css = ".select2-search__field")
    WebElement InspectorID;
    @FindBy(css = ".select2-results__option")
    WebElement Inspector;
    @FindBy(id = "saveInspector")
    WebElement SaveInspector;

    public void RequesterAssignIns() throws InterruptedException {
        AssignInspectorButton.click();Thread.sleep(1000);
        AssignInspectorField.click();Thread.sleep(1000);
        InspectorID.sendKeys(ReqId);Thread.sleep(1000);
        Inspector.click();Thread.sleep(1000);
        SaveInspector.click();Thread.sleep(3000);
    }
}
