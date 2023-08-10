import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class YokogawaHw {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://yef-test.cormsquare.com/Identity/Account/Login");
        driver.manage().window().maximize();
    }
}
