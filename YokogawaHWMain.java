import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class YokogawaHWMain {
    public static void YokogawaHWFlow() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver","C:\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");
        options.addArguments("--remote-allow-origins=*");
        WebDriver datahw = new ChromeDriver(options);
        datahw.get("https://yef-test.cormsquare.com/Identity/Account/Login");
        datahw.manage().window().maximize();
        String ReqEmail = "requester@cormsquare.com";
        String CheckEmail = "checker@cormsquare.com";
        String Password = "Admin@123";
        String Title = "JNK Company PVT LMT";

//        YokogawaHWFlow.loginpage(ReqEmail, Password, datahw);
//        YokogawaHWFlow.create(datahw);
//        YokogawaHWFlow.title(Title, datahw);
//        YokogawaHWFlow.ShipToYokogawa(datahw);
//        YokogawaHWFlow.project("E213991B00", datahw);
//        YokogawaHWFlow.wbs("J11PJTE24", datahw);
//        YokogawaHWFlow.checker(CheckEmail, datahw);
//        YokogawaHWFlow.shippingAddress(datahw);
//        YokogawaHWFlow.expectedPODate(datahw);
//        YokogawaHWFlow.expectedDeliveryDate(datahw);
////        YokogawaHWFlow.Tcas(datahw);
////        YokogawaHWFlow.Tcaspopup(datahw);
////        YokogawaHWFlow.TcasNumber("234324", datahw);
////        YokogawaHWFlow.TcasDocument("", datahw);s
//        YokogawaHWFlow.hwItems("C:\\Users\\Vidya Abbigeri\\Downloads\\ImportRequisitionYokogawaPOCHWItems (4).xlsx", datahw);
//        YokogawaHWFlow.notes("PR Notes", datahw);
//        YokogawaHWFlow.attachments("C:\\Users\\Vidya Abbigeri\\Downloads\\ExportItems (4).xlsx", datahw);
//        YokogawaHWFlow.createDraft(datahw);
//        YokogawaHWFlow.SendForApproval(datahw);
//        YokogawaHWFlow.requesterlogOut(datahw);
//        YokogawaHWFlow.checkerLogin(CheckEmail, Password,  datahw);
//        YokogawaHWFlow.checkerDetailsPage(datahw);
//        YokogawaHWFlow.approveButton(datahw);
//        YokogawaHWFlow.logOutChecker(datahw);
        YokogawaHWFlow.requesterLogin(ReqEmail, Password, datahw);
        YokogawaHWFlow.requesterDetails(Title, datahw);
        YokogawaHWFlow.createPorButton(datahw);
        YokogawaHWFlow.createPorPageStf("3", datahw);
        YokogawaHWFlow.SttpDiscount("2", datahw);
        YokogawaHWFlow.additionalNotes("Additional Terms and Conditions", datahw);
        YokogawaHWFlow.createPor(datahw);
    }
}
