package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Data {

        public static void CatalogPR() throws InterruptedException {
                ChromeOptions options = new ChromeOptions();
                System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
                options.addArguments("--remote-allow-origins=*");
                WebDriver page = new ChromeDriver(options);
                page.get("https://yea-test.cormsquare.com/Identity/Account/Login");
                page.manage().window().maximize();
                String Title = "GHB Company PVT LMT";
                String Project = "E256232Q00";
                String ReqId = "requester@cormsquare.com";
                String Pass = "Admin@123";
                String Wbs = "J11BOPH";
                String Vendor = "Alpha Limited";
                String Rc = "Alpha Rate Contract 2";
                String Address = "200315579";
                String Mode = "Road";
                String Bm = "buyermanager@cormsquare.com";
                String Pm = "projectmanager@cormsquare.com";
                String OI = "9999";
                String ItemsCat = "cable";
                String ItemsQty = "90";
                String PRNotes = "PR Notes";
                String File1 = "C:\\Users\\Vidya Abbigeri\\Downloads\\ExportItems (2).xlsx";
                String File2 = "C:\\Users\\Vidya Abbigeri\\Downloads\\ImportRequisitionItems.xlsx";
                String BuyerId = "buyer@cormsquare.com";
                String PORNotes = "POR Notes";
                String CFO = "cfo@cormsquare.com";
                String PreOrDict = "hazel@sharklasers.com";
                String PRGroupB = "projectmanager3@cormsquare.com";
                String PRGroupC = "departmentmanager@cormsquare.com";
                String PRGroupD = "projectmanager@cormsquare.com";
                LogIn.RequesterId(ReqId, Pass, page);
                CatalogPR.CatalogCreateButton(page);
                CatalogPR.CatalogTitle(Title, page);
                CatalogPR.CatalogProject(Project, page);
                CatalogPR.CatalogWbs(Wbs, page);
                CatalogPR.CatalogVendor(Vendor, page);
                CatalogPR.CatalogRc(Rc, page);
                CatalogPR.CatalogShippingAdds(Address, page);
                CatalogPR.CatalogShippingMode(Mode, page);
                CatalogPR.CatalogExpectedDelivery(page);
                CatalogPR.CatalogExpectedPOIssue(page);
                CatalogPR.CatalogBuyerManager(Bm, page);
                CatalogPR.CatalogProjectManager(Pm, page);
                CatalogPR.CatalogOrderIntake(OI, page);
                CatalogPR.CatalogItems(ItemsQty, page);
                CatalogPR.CatalogNotes(PRNotes, page);
                CatalogPR.CatalogAttachments(File1, File2, page);
                CatalogPR.CatalogCreaete(page);
//            CatalogPR.SendForApproval(page);
                PRSendForApproval.Approval(page);
                CatalogBuyerManagerLogin.BMAssign(Pass, page);
                CatalogAssignBuyer.BuyerAssign(BuyerId,Title,page);
                CatalogPOR.CreatePOR(BuyerId, Pass, Title, PORNotes, page);
                PORSendForApproval.SendForApproval(PreOrDict,Pass, page);
                PORApprovalAssign.PORApproval(Title, PRGroupB, PRGroupC, PRGroupD, page);
        }
}
