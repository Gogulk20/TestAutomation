package org.example.Methods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.DispatchNotes.Assign.DNAssign;
import org.example.DispatchNotes.Create.CreateDN;
import org.example.Inspection.Assign;
import org.example.Inspection.Create;
import org.example.Inspection.SendForInspection;
import org.example.Invoice.Create.CreateInvoice;
import org.example.Login.LogIn;
import org.example.OrderSchedule.Approve.ApproveOS;
import org.example.OrderSchedule.Create.CreateOS;
import org.example.PO.POCreate;
import org.example.PO.POSent;
import org.example.POR.ApprovalAssign.PMApprovalAssign;
import org.example.POR.CreatePOR.NonCatalogPOR;
import org.example.POR.SendForApproval.PORSendForApproval;
import org.example.PR.Approvals.Approvers;
import org.example.PR.AssignBuyer.PRAssignBuyer;
import org.example.PR.Modules.NonCatalogPR;
import org.example.PR.SendForApproval.PRSendForApproval;
import org.example.RFQ.*;
import org.example.WorkOrder.Create.CreateWO;
import org.example.WorkOrder.OkForInvoice.OkForInvoice;
import org.example.WorkOrder.TrackerStatus.VendorTrackerStatus;
import org.example.YKMain;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NonCatalog extends YKMain {

    public NonCatalog(WebDriver page) {
        super(page);
    }
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver page = new ChromeDriver();
        LogIn logIn = new LogIn(page);
        logIn.goTo();
        page.manage().window().maximize();
        logIn.UserLogin(ReqId,Pass);
        NonCatalogPR nonCatalogPR = new NonCatalogPR(page);
        nonCatalogPR.NonCatalogCreateButton();
        nonCatalogPR.NonCatalogTitle(Title);
        nonCatalogPR.NonCatalogProject(Project);
        nonCatalogPR.NonCatalogWbs(Wbs);
        nonCatalogPR.NonCatalogIncoterm(Incoterm);
        nonCatalogPR.NonCatalogShippingAdds(Address);
        nonCatalogPR.NonCatalogShippingMode(Mode);
        nonCatalogPR.NonCatalogQuotationRequiredBy();
        nonCatalogPR.NonCatalogExpectedPOIssue();
        nonCatalogPR.NonCatalogExpectedDelivery();
        nonCatalogPR.NonCatalogBuyerManager(Bm);
        nonCatalogPR.NonCatalogProjectManager(Pm);
        nonCatalogPR.NonCatalogInspection();
        nonCatalogPR.NonCatalogOrderIntake(OI);
        nonCatalogPR.NonCatalogTargetPrice(TP);
        nonCatalogPR.NonCatalogWarranty();
        nonCatalogPR.NonCatalogPriceValidity(page);
        nonCatalogPR.NonCatalogItems(ItemsQty);
        nonCatalogPR.NonCatalogNotes(PRNotes);
        nonCatalogPR.NonCatalogAttachments(File1, File2);
        nonCatalogPR.NonCatalogCreaete();
        //Send For Approval
        PRSendForApproval prSendForApproval = new PRSendForApproval(page);
        prSendForApproval.Approval();
        //PMApprove the PR
        Approvers approvers = new Approvers(page);
        approvers.PRApproversApprover(Pass);
        //Assign Buyer
        PRAssignBuyer prAssignBuyer = new PRAssignBuyer(page);
        prAssignBuyer.BuyerAssign(Bm,Pass,BuyerId);
        //Buyer create RFQ
        CreateRFQ createRFQ = new CreateRFQ(page);
        createRFQ.CreateRFQ(BuyerId, Pass, RFQNotes);
        // Buyer InviteVendor
        VendorInvite vendorInvite = new VendorInvite(page);
        vendorInvite.InviteVendor(VendorName);
        //Vendor Submits the Quotation
        Quotation quotation = new Quotation(page);
        quotation.QuotationSubmission(VendorId,Pass,InctLocation,QuoRefNum,Gst,File1,File2);
        //Buyer Send for Evaluation
        ReadyForEvaluation readyForEvaluation = new ReadyForEvaluation(page);
        readyForEvaluation.BuyerSentRFE(BuyerId,Pass);
        //Requester Create TE
        TechnicalEvaluation technicalEvaluation = new TechnicalEvaluation(page);
        technicalEvaluation.RequesterCreateTE(ReqId,Pass);
        //Buyer Create CE
        CommercialEvaluation commercialEvaluation = new CommercialEvaluation(page);
        commercialEvaluation.BuyerCreateCE(BuyerId,Pass,Title);
        //Buyer Create POR
        NonCatalogPOR nonCatalogPOR = new NonCatalogPOR(page);
        nonCatalogPOR.BuyerCreatePOR(PORNotes);
        //Buyer Send for Approval
        PORSendForApproval porSendForApproval = new PORSendForApproval(page);
        porSendForApproval.SendForApproval(PreOrDict,Pass);
        //PM Assign Approval
        PMApprovalAssign pmApprovalAssign = new PMApprovalAssign(page);
        pmApprovalAssign.PORApproval(PRGroupB,PRGroupC,PRGroupD,Pass);
        //Admin Create the PO
        POCreate poCreate = new POCreate(page);
        poCreate.BuyerCreatePO(AdminId,Pass,Title);
        //Buyer Send PO to Vendor
        POSent poSent = new POSent(page);
        poSent.POSentToVendor(BuyerId,Pass,Title);
        //Vendor Will create the OS
        CreateOS createOS = new CreateOS(page);
        createOS.VendorCreateOS(VendorId,Pass);
        //Buyer will approve the OS
        ApproveOS approveOS = new ApproveOS(page);
        approveOS.BuyerApproveOS(BuyerId,Pass,Title);
        //Vendor Send For Inspection
        SendForInspection sendForInspection = new SendForInspection(page);
        String POTrn = sendForInspection.VendorSendForInspection(VendorId,Pass);
        //Requester will Assign the Inspector
        Assign assign = new Assign(page);
        assign.RequesterAssignIns(ReqId,Pass,POTrn);
        //Requester will Create Inspection
        Create create = new Create(page);
        create.RequesterCreateIns();
        //Vendor will create the DN
        CreateDN createDN = new CreateDN(page);
        createDN.VendorCreateDN(VendorId,Pass,SourceCountry,DestinationCountry,GrossWeight,NetWeight,Volume,DNQuantity);
        //LM will assign the LM ID
        DNAssign dnAssign = new DNAssign(page);
        dnAssign.LMAssignDN(LMId,Pass,POTrn);
        //LM will create the WO
        CreateWO createWO = new CreateWO(page);
        createWO.LMCreateWO(VendorName);
        //Vendor will update the WO Status
        VendorTrackerStatus vendorTrackerStatus = new VendorTrackerStatus(page);
        vendorTrackerStatus.VendorUpdateTS(VendorId,Pass,POTrn);
        //LM will click on OkForinvoice
        OkForInvoice okForInvoice = new OkForInvoice(page);
        okForInvoice.LMClickOkForInvoice(LMId,Pass,POTrn);
        //Vendor Create the Invoice
        CreateInvoice createInvoice = new CreateInvoice(page);
        createInvoice.VendorCreateInvoice(VendorId,Pass,POTrn,INVNumber,AdminId);
    }
}
