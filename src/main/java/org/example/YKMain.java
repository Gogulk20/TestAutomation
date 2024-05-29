package org.example;

//import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Methods.CatalogMethods;
import org.example.Methods.NonCatalogMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YKMain {

    public static void main(String[] args) throws InterruptedException {

//                ChromeOptions options = new ChromeOptions();
//                System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
//                options.addArguments("--remote-allow-origins=*");
//                WebDriver page = new ChromeDriver(options);

        WebDriverManager.chromedriver().setup();
        WebDriver page = new ChromeDriver();
        page.get("https://yea-test.cormsquare.com/Identity/Account/Login");
        page.manage().window().maximize();
        String Title = "GHB Company PVT LMT";
        String Project = "E256232Q00";
        String ReqId = "requester@cormsquare.com";
        String Pass = "Admin@123";
        String Wbs = "J11BOPH";
        String Vendor = "Alpha Limited";
        String Rc = "Alpha Rate Contract 2";
        String Incoterm = "EXW";
        String Address = "200315579";
        String Mode = "Road";
        String Bm = "buyermanager@cormsquare.com";
        String Pm = "projectmanager@cormsquare.com";
        String OI = "9999";
        String TP = "8888";
        String ItemsCat = "cable";
        String ItemsQty = "9";
        String PRNotes = "PR Notes";
        String File1 = "C:\\Users\\Vidya Abbigeri\\Downloads\\ExportItems (2).xlsx";
        String File2 = "C:\\Users\\Vidya Abbigeri\\Downloads\\ImportRequisitionItems.xlsx";
        String BuyerId = "buyer@cormsquare.com";
        String RFQNotes = "Vendor Notes";
        String VendorName = "Alpha Limited";
        String VendorId = "alpha123@cormsquare.com";
        String AdminId = "admin@cormsquare.com";
        String InctLocation = "India";
        String QuoRefNum = "465623";
        String Gst = "21";
        String PORNotes = "POR Notes";
        String CFO = "cfo@cormsquare.com";
        String PreOrDict = "hazel@sharklasers.com";
        String PRGroupB = "projectmanager3@cormsquare.com";
        String PRGroupC = "departmentmanager@cormsquare.com";
        String PRGroupD = "businessunitmanager3@cormsquare.com";
            CatalogMethods.CatalogPR( ReqId,Pass,Title,Project,Wbs,Vendor,Rc,Address,Mode,Bm,Pm,OI,ItemsQty,PRNotes,File1,
                    File2,BuyerId,PORNotes,PreOrDict,PRGroupB,PRGroupC,PRGroupD,AdminId,VendorId,page);
//        NonCatalogMethods.NonCatalog(ReqId,Pass,Title,Project,Wbs,Incoterm,Address,Mode,Bm,Pm,OI,TP,
//                ItemsQty,PRNotes,File1,File2,BuyerId,RFQNotes,VendorName,VendorId,InctLocation,QuoRefNum,Gst,PORNotes,CFO,PreOrDict,
//                PRGroupB,PRGroupC,PRGroupD,AdminId,page);
    }
}
