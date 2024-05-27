package org.example.Methods;

import org.example.Login.LogIn;
import org.example.PR.AssignBuyer.PRAssignBuyer;
import org.example.PR.Modules.NonCatalogPR;
import org.example.PR.SendForApproval.PRSendForApproval;
import org.example.RFQ.*;
import org.openqa.selenium.WebDriver;

public class NonCatalogMethods {
    public static VendorInvite NonCatalog(String ReqId, String Pass, String Title, String Project, String Wbs, String Incoterm,
                                          String Address, String Mode, String Bm, String Pm, String OI, String TP, String ItemsQty,
                                          String PRNotes, String File1, String File2, String BuyerId, String RFQNotes,
                                          String VendorName,String VendorId, String InctLocation,String QuoRefNum,String Gst,
                                          String PORNotes, String CFO, String PreOrDict, String PRGroupB, String PRGroupC,
                                          String PRGroupD, String AdminId, WebDriver page) throws InterruptedException {
        LogIn.RequesterId(ReqId,Pass,page);
        NonCatalogPR.NonCatalogCreateButton(page);
        NonCatalogPR.NonCatalogTitle(Title, page);
        NonCatalogPR.NonCatalogProject(Project, page);
        NonCatalogPR.NonCatalogWbs(Wbs, page);
        NonCatalogPR.NonCatalogIncoterm(Incoterm, page);
        NonCatalogPR.NonCatalogShippingAdds(Address, page);
        NonCatalogPR.NonCatalogShippingMode(Mode, page);
        NonCatalogPR.NonCatalogQuotationRequiredBy(page);
        NonCatalogPR.NonCatalogExpectedPOIssue(page);
        NonCatalogPR.NonCatalogExpectedDelivery(page);
        NonCatalogPR.NonCatalogBuyerManager(Bm, page);
        NonCatalogPR.NonCatalogProjectManager(Pm, page);
        NonCatalogPR.NonCatalogOrderIntake(OI, page);
        NonCatalogPR.NonCatalogTargetPrice(TP,page);
        NonCatalogPR.NonCatalogWarranty(page);
        NonCatalogPR.NonCatalogPriceValidity(page);
        NonCatalogPR.NonCatalogItems(ItemsQty, page);
        NonCatalogPR.NonCatalogNotes(PRNotes, page);
        NonCatalogPR.NonCatalogAttachments(File1, File2, page);
        NonCatalogPR.NonCatalogCreaete(page);
        PRSendForApproval.Approval(page);
//        PRBuyerManagerLogin.BMAssign(Pass, page);
        PRAssignBuyer.BuyerAssign(Bm,Pass,BuyerId,Title,page);
        CreateRFQ createRFQ = new CreateRFQ(page);
        createRFQ.CreateRFQ(BuyerId, Pass, Title, RFQNotes, page);
        VendorInvite vendorInvite = new VendorInvite(page);
        vendorInvite.InviteVendor(VendorName,page);
        Quotation quotation = new Quotation(page);
        quotation.QuotationSubmission(VendorId,Pass,Title,InctLocation,QuoRefNum,Gst,File1,File2,page);
        ReadyForEvaluation readyForEvaluation = new ReadyForEvaluation(page);
        readyForEvaluation.BuyerSentRFE(BuyerId,Pass,Title,page);
        TechnicalEvaluation technicalEvaluation = new TechnicalEvaluation(page);
        technicalEvaluation.RequesterCreateTE(ReqId,Pass,Title,page);
        CommercialEvaluation commercialEvaluation = new CommercialEvaluation(page);
        commercialEvaluation.BuyerCreateCE(BuyerId, Pass, Title,PORNotes,PreOrDict,PRGroupB,PRGroupC,PRGroupD,AdminId,page);
//        POSent.POSentToVendor(BuyerId,Pass,Title,page);
        return vendorInvite;
    }
}
