package org.example.PR.AssignBuyer;
import org.example.LogOut.LogOut;
import org.example.Login.LogIn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.Variables.YKMain.*;

public class PRAssignBuyer {
    WebDriver page;
    public PRAssignBuyer(WebDriver page){
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(id = "btnAssignUser")
    WebElement ClickAssignBuyerButton;
    @FindBy(id = "select2-bgUser-container")
    WebElement ClickOnBuyerDropdown;
    @FindBy(css = "input[class='select2-search__field']")
    WebElement BuyerName;
    @FindBy(css = ".select2-results__option")
    WebElement SelectBuyer;
    @FindBy(id = "saveBuyerUser")
    WebElement SaveBuyerName;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement PRTitle;

    public void BuyerAssign() throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(Bm,Pass);Thread.sleep(2000);
        PRTitle.click();Thread.sleep(2000);
        ClickAssignBuyerButton.click();Thread.sleep(1000);
        ClickOnBuyerDropdown.click();Thread.sleep(1000);
        BuyerName.sendKeys(BuyerId);Thread.sleep(2000);
        SelectBuyer.click();Thread.sleep(1000);
        SaveBuyerName.click();Thread.sleep(2000);
        LogOut.UserLogOut(page);Thread.sleep(1000);
    }
}
