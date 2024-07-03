package org.example.Login;
import org.example.Variables.YKMain;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogIn extends YKMain {
    WebDriver page;
    public LogIn(WebDriver page){
        this.page=page;
        PageFactory.initElements(page,this);
    }
    @FindBy(id = "Input_Email")
    WebElement UserEmail;

    @FindBy(id = "Input_Password")
    WebElement UserPassword;
    @FindBy(id = "login-submit")
    WebElement Submit;
    @FindBy(xpath = "//div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")
    WebElement Vendorname;
    @FindBy(id = "glbBtnChangeVendor")
    WebElement ContinueButton;

    public void UserLogin(String email, String password) throws InterruptedException {
        UserEmail.sendKeys(email);Thread.sleep(1000);
        UserPassword.sendKeys(password);Thread.sleep(1000);
        Submit.click();Thread.sleep(1000);
    }
    public void goTo(){
        page.get("https://yea-test.cormsquare.com/Identity/Account/Login");
    }
    public void VendorLogin(String email, String password) throws InterruptedException {
        UserEmail.sendKeys(email);
        UserPassword.sendKeys(password);
        Submit.click();
        try {
            WebDriverWait wait = new WebDriverWait(page, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = page.switchTo().alert();
            alert.accept();Thread.sleep(1000);
            Vendorname.click();Thread.sleep(1000);
            ContinueButton.click();Thread.sleep(3000);
        } catch (NoSuchElementException e){
        }

    }
    public void ApprovalUserLogin(String UserId, String Pass) {
        UserEmail.sendKeys(UserId);
        UserPassword.sendKeys(Pass);
        Submit.click();
    }
}