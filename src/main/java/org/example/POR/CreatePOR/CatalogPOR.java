package org.example.POR.CreatePOR;

import org.example.Login.LogIn;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.Variables.YKMain.Title;

public class CatalogPOR {
    WebDriver page;
    public CatalogPOR(WebDriver page){
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(id = "btnCreatePOR")
    WebElement CreatePORButton;
    @FindBy(id = "select2-taxCodeId-container")
    WebElement TaxCodeField;
    @FindBy(css = ".select2-results__option")
    WebElement FirstTaxCode;
    @FindBy(id = "notes")
    WebElement Notes;
    @FindBy(id = "btnCreate")
    WebElement CreateButton;
    @FindBy(xpath = "//button[contains(text(), 'Yes')]")
    WebElement YesButton;
    @FindBy(xpath = "//span[contains(text(),'" + Title + "')]")
    WebElement PRTitle;


    public void CreatePOR (String BuyerId, String Pass, String PORNotes) throws InterruptedException {
        LogIn logIn = new LogIn(page);
        logIn.UserLogin(BuyerId,Pass);Thread.sleep(1000);
        PRTitle.click();Thread.sleep(2000);
        CreatePORButton.click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 1750)");Thread.sleep(1000);
        //Tax Code dropdown
        TaxCodeField.click();Thread.sleep(1000);
        FirstTaxCode.click();Thread.sleep(1000);
        JavascriptExecutor js1 = (JavascriptExecutor) page;
        js1.executeScript("window.scrollBy(0, 900)");Thread.sleep(1000);
        //POR Notes
        Notes.sendKeys(PORNotes);
        //POR Create
        CreateButton.click();Thread.sleep(2000);
        YesButton.click();Thread.sleep(3000);
    }
}
