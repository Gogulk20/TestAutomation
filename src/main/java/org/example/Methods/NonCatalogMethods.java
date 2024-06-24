//package org.example.Methods;
//
//import org.example.PR.AssignBuyer.PRAssignBuyer;
//import org.example.PR.Modules.NonCatalogPR;
//import org.example.PR.SendForApproval.PRSendForApproval;
//import org.example.RFQ.*;
//import org.openqa.selenium.WebDriver;
//
//public class NonCatalogMethods {
//    WebDriver page;
//    public NonCatalogMethods(WebDriver page) {
//        this.page=page;
//    }
//
//    public static Quotation NonCatalog(String ReqId, String Pass, String Title, String Project, String Wbs, String Incoterm,
//                                       String Address, String Mode, String Bm, String Pm, String OI, String TP, String ItemsQty,
//                                       String PRNotes, String File1, String File2, String BuyerId, String RFQNotes,
//                                       String VendorName, String VendorId, String InctLocation, String QuoRefNum, String Gst,
//                                       String PORNotes, String CFO, String PreOrDict, String PRGroupB, String PRGroupC,
//                                       String PRGroupD, String AdminId, String POTrn, String SourceCountry,
//                                       String DestinationCountry, String GrossWeight, String NetWeight,
//                                       String Volume, String DNQuantity, String LMId, WebDriver page) throws InterruptedException {
//        NonCatalogPR nonCatalogPR = new NonCatalogPR(page);
//        nonCatalogPR.NonCatalogCreateButton();
//        nonCatalogPR.NonCatalogTitle(Title);
//        nonCatalogPR.NonCatalogProject(Project);
//        nonCatalogPR.NonCatalogWbs(Wbs);
//        nonCatalogPR.NonCatalogIncoterm(Incoterm);
//        nonCatalogPR.NonCatalogShippingAdds(Address);
//        nonCatalogPR.NonCatalogShippingMode(Mode);
//        nonCatalogPR.NonCatalogQuotationRequiredBy();
//        nonCatalogPR.NonCatalogExpectedPOIssue();
//        nonCatalogPR.NonCatalogExpectedDelivery();
//        nonCatalogPR.NonCatalogBuyerManager(Bm);
//        nonCatalogPR.NonCatalogProjectManager(Pm);
//        nonCatalogPR.NonCatalogInspection();
//        nonCatalogPR.NonCatalogOrderIntake(OI);
//        nonCatalogPR.NonCatalogTargetPrice(TP);
//        nonCatalogPR.NonCatalogWarranty();
//        nonCatalogPR.NonCatalogPriceValidity(page);
//        nonCatalogPR.NonCatalogItems(ItemsQty);
//        nonCatalogPR.NonCatalogNotes(PRNotes);
//        nonCatalogPR.NonCatalogAttachments(File1, File2);
//        nonCatalogPR.NonCatalogCreaete();
//        PRSendForApproval prSendForApproval = new PRSendForApproval(page);
//        prSendForApproval.Approval();
//        PRAssignBuyer prAssignBuyer = new PRAssignBuyer(page);
//        prAssignBuyer.BuyerAssign(Bm,Pass,BuyerId,Title);
//        CreateRFQ createRFQ = new CreateRFQ(page);
//        createRFQ.CreateRFQ(BuyerId, Pass, Title, RFQNotes);
//        VendorInvite vendorInvite = new VendorInvite(page);
//        vendorInvite.InviteVendor(VendorName);
//        Quotation quotation = new Quotation(page);
//        quotation.QuotationSubmission(VendorId,Pass,Title,InctLocation,QuoRefNum,Gst,File1,File2);
//        ReadyForEvaluation readyForEvaluation = new ReadyForEvaluation(page);
//        readyForEvaluation.BuyerSentRFE(BuyerId,Pass,Title);
//        TechnicalEvaluation technicalEvaluation = new TechnicalEvaluation(page);
//        technicalEvaluation.RequesterCreateTE(ReqId,Pass,Title);
//        CommercialEvaluation commercialEvaluation = new CommercialEvaluation(page);
//        commercialEvaluation.BuyerCreateCE(BuyerId, Pass, Title,PORNotes,PreOrDict,PRGroupB,PRGroupC,
//                PRGroupD,AdminId,VendorId,POTrn,ReqId, SourceCountry, DestinationCountry,GrossWeight,
//                NetWeight,Volume,DNQuantity,LMId,VendorName,page);
//        return quotation;
//    }
//}
