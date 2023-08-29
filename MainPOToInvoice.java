import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MainPOToInvoice {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver","C:\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://yef-test.cormsquare.com/Identity/Account/Login");
        driver.manage().window().maximize();
        String Title = "KBJ Company PVT LMT";
        String VendorEmail = "alpha123@cormsquare.com";
        String BuyerEmail = "genpactbuyer@cormsquare.com";
        String RequesterLogin = "requester@cormsquare.com";
        String Password = "Admin@123";

        POToInvoiceFlow.buyerPo(Title, driver);
        POToInvoiceFlow.buyerLogout1(driver);
        POToInvoiceFlow.vendorLogin1(VendorEmail, Password, driver);
        POToInvoiceFlow.vendorPoDetails1(Title, driver);
        POToInvoiceFlow.vendorCreateOSpage("10", "5", "5", driver);
        POToInvoiceFlow.vendorOsnotes("OS Notes", driver);
        POToInvoiceFlow.vendorSubmitButton(driver);
        POToInvoiceFlow.vendorLogout1(driver);
        POToInvoiceFlow.buyerLogin1(BuyerEmail, Password, driver);
        POToInvoiceFlow.buyerPoDetails1(driver);
        POToInvoiceFlow.buyerOsApprove(driver);
        POToInvoiceFlow.buyerLogout2(driver);
        POToInvoiceFlow.vendorLogin2(VendorEmail, Password, driver);
        POToInvoiceFlow.vendorOsDetails1(driver);
        POToInvoiceFlow.vendorLogout2(driver);
        POToInvoiceFlow.requesterLogin(RequesterLogin, Password, driver);
        POToInvoiceFlow.requesterOsDetails(driver);
        POToInvoiceFlow.requesterAssignInspection(RequesterLogin, driver);
        POToInvoiceFlow.requesterCreateInspection(driver);
        POToInvoiceFlow.requesterInspectionNotes("Inspection Notes", "C:\\\\Users\\\\Vidya Abbigeri\\\\Downloads\\\\ExportItems (4).xlsx", driver);
        POToInvoiceFlow.requesterlogout(driver);
        POToInvoiceFlow.vendorLogin3(VendorEmail, Password, driver);
        POToInvoiceFlow.vendorOsDetails2(driver);
        POToInvoiceFlow.vendorCreateDnDate(driver);
        POToInvoiceFlow.vendorDnPackages(driver);
        POToInvoiceFlow.buyerDnCreate(driver);
        POToInvoiceFlow.vendorLogout3(driver);
        POToInvoiceFlow.buyerLogin2(BuyerEmail, Password, driver);
        POToInvoiceFlow.buyerDnDetails(driver);
        POToInvoiceFlow.woCreatePage(driver);
        POToInvoiceFlow.buyerLogout3(driver);
        POToInvoiceFlow.vendorLogin4(VendorEmail, Password, driver);
        POToInvoiceFlow.vendorWoDetails(driver);
        POToInvoiceFlow.vendorInvoicePage(driver);
        POToInvoiceFlow.vendorInvoiceCreate("Purchase", "INV-3223", "Invoice Notes", "PO-", driver);
        POToInvoiceFlow.vendorLogout4(driver);
        POToInvoiceFlow.buyerLogin3(BuyerEmail, Password, driver);
        POToInvoiceFlow.buyerInvoiceDetails(driver);
    }

}

