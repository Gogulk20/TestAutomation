package org.example.Methods;

import org.example.*;
import org.example.Login.LogIn;
import org.example.PO.POCreate;
import org.example.PO.POSent;
import org.example.PR.AssignBuyer.PRAssignBuyer;
import org.example.PR.Modules.CatalogPR;
import org.example.POR.ApprovalAssign.PMApprovalAssign;
import org.example.POR.CreatePOR.CatalogPOR;
import org.example.POR.SendForApproval.PORSendForApproval;
import org.example.PR.SendForApproval.PRSendForApproval;
import org.openqa.selenium.WebDriver;

public class CatalogMethods extends YKMain{
        public static void CatalogPR(String ReqId, String Pass, String Title, String Project, String Wbs, String Vendor, String Rc, String Address, String Mode, String Bm, String Pm, String OI, String ItemsQty, String PRNotes, String File1, String File2, String BuyerId, String PORNotes, String PreOrDict, String PRGroupB, String PRGroupC, String PRGroupD, String AdminId, String prGroupD, WebDriver page) throws InterruptedException {
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
                CatalogPR.CatalogInspection(page);
                CatalogPR.CatalogItems(ItemsQty, page);
                CatalogPR.CatalogNotes(PRNotes, page);
                CatalogPR.CatalogAttachments(File1, File2, page);
                CatalogPR.CatalogCreaete(page);
                CatalogPR.CatalogCreateButton(page);
                PRSendForApproval.Approval(page);
                PRBuyerManagerLogin.BMAssign(Pass, page);
                PRAssignBuyer.BuyerAssign(Bm,Pass,BuyerId,Title,page);
                CatalogPOR.CreatePOR(BuyerId, Pass, Title, PORNotes, page);
                PORSendForApproval.SendForApproval(PreOrDict,Pass, page);
                PMApprovalAssign.PORApproval(Title, PRGroupB, PRGroupC, PRGroupD, Pass,AdminId,BuyerId, page);
                POCreate.BuyerCreatePO(AdminId,Pass,Title,page);
                POSent.POSentToVendor(BuyerId,Pass,Title,page);
        }
}
