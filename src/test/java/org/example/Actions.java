package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Actions {

    public static void ActionsTest() throws IOException {

        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");
        options.addArguments("--remote-allow-origins=*");
        WebDriver actiondriver = new ChromeDriver(options);
        actiondriver.get("https://the-internet.herokuapp.com/");
//        MultipleWindows(actiondriver);
//        Frames(actiondriver);
//        Assignment(actiondriver);
//        Calender(actiondriver);
//        ColumnAndRows(actiondriver);
//        AutoSuggText(actiondriver);
        BrokenLink(actiondriver);

    }

    static String Frames(WebDriver actiondriver) {
        actiondriver.findElement(By.xpath("//a[contains(text(), 'Nested Frames')]")).click();
        actiondriver.switchTo().frame(actiondriver.findElement(By.xpath("//frameset[1]/frame[1]")));
        actiondriver.switchTo().frame("frame-middle");
        String s = actiondriver.findElement(By.id("content")).getText();
        //This code userd to string reverse
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        System.out.println(sb);
        return sb.toString();
    }

    static void MultipleWindows(WebDriver actiondriver) {
        actiondriver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
        actiondriver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
        actiondriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        Set<String> window = actiondriver.getWindowHandles();
        Iterator<String> it = window.iterator();
        String parent = it.next();
        actiondriver.switchTo().window(it.next());
        System.out.println(actiondriver.findElement(By.cssSelector(".example")).getText());
        actiondriver.switchTo().window(parent);
        System.out.println(actiondriver.findElement(By.xpath("//div[@id='content']/div/h3")).getText());
//        String text = actiondriver.findElement(By.id("content")).getText().split("Click")[0];
//        //String tesxt1 = text.split("Click")[0];
//        System.out.println(text);
    }

    static void Assignment(WebDriver actiondriver) {
        actiondriver.get("https://rahulshettyacademy.com/AutomationPractice/");
        actiondriver.findElement(By.id("checkBoxOption2")).click();
        String name = actiondriver.findElement(By.xpath("//body/div[1]/div[4]/fieldset[1]/label[2]")).getText().trim();
        WebElement dropDown = actiondriver.findElement(By.id("dropdown-class-example"));
        Select option = new Select(dropDown);
        option.selectByVisibleText(name);
        actiondriver.findElement(By.id("name")).sendKeys(name);
        actiondriver.findElement(By.id("alertbtn")).click();
        Alert message = actiondriver.switchTo().alert();
        String text = message.getText();
        if (text.contains(name)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }

    static void Calender(WebDriver actiondriver) {

        actiondriver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        String date = "16";
        String month = "6";
        String Year = "2028";
        actiondriver.findElement(By.cssSelector("div[class='react-date-picker__inputGroup']")).click();
        actiondriver.findElement(By.xpath("//span/div/div/div/button[3]")).click();
        actiondriver.findElement(By.xpath("//span/div/div/div/button[3]")).click();
        actiondriver.findElement(By.xpath("//*[contains(text(),'" + Year + "')]")).click();
        actiondriver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month) - 1).click();
        actiondriver.findElement(By.xpath("//abbr[contains(text(),'" + date + "')]")).click();

    }

    static void ColumnAndRows(WebDriver actiondriver) throws InterruptedException {
        actiondriver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement data = actiondriver.findElement(By.id("product"));
        System.out.println(data.findElements(By.tagName("tr")).size());
        System.out.println(data.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
        List<WebElement> columnName = data.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
        for (int i = 0; i < columnName.size(); i++) {
            System.out.println(columnName.get(i).getText());
        }

//        actiondriver.manage().window().maximize(); Thread.sleep(1000);
//        JavascriptExecutor js = (JavascriptExecutor)actiondriver;
//        js.executeScript("window.scrollBy(0,550)");
//        List <WebElement> rows = actiondriver.findElements(By.cssSelector(".table-display td:nth-child(1)"));
//        System.out.println(rows.size());
//        List <WebElement> columns = actiondriver.findElements(By.xpath("//div/fieldset/table/tbody/tr[2]/td"));
//        System.out.println(columns.size());
//        List <WebElement> columnName = actiondriver.findElements(By.xpath("//div/fieldset/table/tbody/tr[3]/td"));
//        for (int i=0; i<columnName.size();i++){
//            System.out.println(columnName.get(i).getText());
//        }
    }

    static void AutoSuggText(WebDriver actiondriver) throws InterruptedException {
        actiondriver.get("https://rahulshettyacademy.com/AutomationPractice/");
        actiondriver.findElement(By.id("autocomplete")).click();
        actiondriver.findElement(By.id("autocomplete")).sendKeys("Ind");
        Thread.sleep(2000);
        List<WebElement> options = actiondriver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));

        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("India")) {
                option.click();
            }


        }
    }
    static void BrokenLink (WebDriver actiondriver) throws IOException {
        actiondriver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List <WebElement> links = actiondriver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert a = new SoftAssert();
        for (WebElement link : links){
            String url = link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int response = conn.getResponseCode();
            System.out.println(response);
            a.assertTrue(response<400,"The Broken Link is" + link.getText() + "with the code of" + response);
        }
        a.assertAll();


    }

    static void BrokenLink1 (WebDriver actiondriver) throws IOException{
        List <String> name = new ArrayList<String>();
    }

}
