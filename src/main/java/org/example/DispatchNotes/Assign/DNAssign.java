package org.example.DispatchNotes.Assign;

import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

import static org.example.Variables.YKMain.*;
import static org.example.Variables.YKMain.Pass;

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
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement TRNTitle1;
    @FindBy(xpath = "//span[contains(text(),'Purchase Orders')]")
    WebElement PurchaseOrder;
    @FindBy(id = "referenceId")
    WebElement PONumber;


    public String GetPOTrnNum() throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(BuyerId,Pass);Thread.sleep(1000);
        PurchaseOrder.click();Thread.sleep(1000);
        TRNTitle1.click();Thread.sleep(3000);
        String POTRNNum = PONumber.getText();
        LogOut.UserLogOut(page);
        logIn.UserLogin(LMId,Pass);Thread.sleep(1000);
        DispatchNote.click();Thread.sleep(2000);
        List<WebElement> rows = DiscpatchNoteList;Thread.sleep(1000);
        List<WebElement> ListPage = rows.stream().filter(g->g.getText().contains(POTRNNum)).map(g->getTrnNumber(g)).collect(Collectors.toList());Thread.sleep(1000);
        ListPage.forEach(g->g.click());Thread.sleep(3000);
        return POTRNNum;
    }
    public void LMAssignDN() throws InterruptedException {
        AssignDropdownButton.click();Thread.sleep(1000);
        AssignButton.click();Thread.sleep(1000);
        UserField.click();Thread.sleep(1000);
        UserId.sendKeys(LMId);Thread.sleep(1000);
        LMUserId.click();Thread.sleep(1000);
        SubmitButton.click();Thread.sleep(3000);
        }
    private static WebElement getTrnNumber(WebElement g) {
        WebElement TRNLink = g.findElement(By.xpath("ancestor::tr[1]/td[2]/div[1]/a[1]/span[1]"));
        return TRNLink;
    }
}
