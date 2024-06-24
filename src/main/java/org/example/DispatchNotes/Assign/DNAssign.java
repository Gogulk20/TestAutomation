package org.example.DispatchNotes.Assign;

import org.example.Inspection.Assign;
import org.example.Login.LogIn;
import org.example.WorkOrder.Create.CreateWO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DNAssign  {
    WebDriver page;
    public DNAssign(WebDriver page) throws InterruptedException {
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(id = "ni-dispatch-notes")
    WebElement DispatchNote;
    @FindBy(css = "#listContainer tr td")
    List<WebElement> DiscpatchNoteList;
    @FindBy(css = ".btn-link")
    WebElement TRNLink;
    @FindBy(id = "dropdownMenuButton")
    WebElement AssignDropdownButton;
    @FindBy(id = "btnToAssign")
    WebElement AssignButton;
    @FindBy(id = "select2-assignerId-container")
    WebElement UserField;
    @FindBy(css = ".select2-search__field")
    WebElement UserId;
    @FindBy(css = ".select2-results__option")
    WebElement LMUserId;
    @FindBy(id = "saveAssine")
    WebElement SubmitButton;


    public void LMAssignDN(String LMId,String Pass,String POTrn) throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(LMId,Pass);Thread.sleep(1000);
        DispatchNote.click();Thread.sleep(3000);
        List<WebElement> rows = DiscpatchNoteList;
        for (WebElement row : rows) {
            if (row.getText().contains(POTrn)) {
                WebElement btnLink = TRNLink;
                btnLink.click();Thread.sleep(3000);
                break;
            }
        }
        AssignDropdownButton.click();Thread.sleep(1000);
        AssignButton.click();Thread.sleep(1000);
        UserField.click();Thread.sleep(1000);
        UserId.sendKeys(LMId);Thread.sleep(1000);
        LMUserId.click();Thread.sleep(1000);
        SubmitButton.click();Thread.sleep(3000);
        }
}
