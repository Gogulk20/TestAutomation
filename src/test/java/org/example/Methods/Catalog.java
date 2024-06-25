package org.example.Methods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.DispatchNotes.Assign.DNAssign;
import org.example.DispatchNotes.Create.CreateDN;
import org.example.Inspection.Assign;
import org.example.Inspection.Create;
import org.example.Inspection.SendForInspection;
import org.example.Invoice.AcceptDoc.InvoiceAccept;
import org.example.Invoice.Approvers.ApprovalApproves;
import org.example.Invoice.Create.CreateInvoice;
import org.example.Login.LogIn;
import org.example.OrderSchedule.Approve.ApproveOS;
import org.example.OrderSchedule.Create.CreateOS;
import org.example.PO.POCreate;
import org.example.PO.POSent;
import org.example.POR.ApprovalAssign.PMApprovalAssign;
import org.example.POR.CreatePOR.CatalogPOR;
import org.example.POR.SendForApproval.PORSendForApproval;
import org.example.PR.Approvals.Approvers;
import org.example.PR.AssignBuyer.PRAssignBuyer;
import org.example.PR.Modules.CatalogPR;
import org.example.PR.SendForApproval.PRSendForApproval;
import org.example.Variables.YKMain;
import org.example.WorkOrder.Create.CreateWO;
import org.example.WorkOrder.TrackerStatus.VendorTrackerStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Catalog extends YKMain {

    public Catalog(WebDriver page) {
        super(page);
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver page = new ChromeDriver();
        LogIn logIn = new LogIn(page);
        logIn.goTo();
        page.manage().window().maximize();
        logIn.UserLogin(ReqId,Pass);
        CatalogPR catalogPR = new CatalogPR(page);
        catalogPR.CatalogCreateButton();
        catalogPR.CatalogTitle(Title);
        catalogPR.CatalogProject(Project);
        catalogPR.CatalogWbs(Wbs);
        catalogPR.CatalogVendor(Vendor);
        catalogPR.CatalogRc(Rc);
        catalogPR.CatalogShippingAdds(Address);
        catalogPR.CatalogShippingMode(Mode);
        catalogPR.CatalogExpectedPOIssue();
        catalogPR.CatalogExpectedDelivery();
        catalogPR.CatalogBuyerManager(Bm);
        catalogPR.CatalogProjectManager(Pm);
        catalogPR.CatalogOrderIntake(OI);
        catalogPR.CatalogInspection();
        catalogPR.CatalogItems(ItemsQty);
        catalogPR.CatalogNotes(PRNotes);
        catalogPR.CatalogAttachments(File1, File2);
        catalogPR.CatalogCreaete();
        //Requester Send for Approval
        PRSendForApproval sendForApproval = new PRSendForApproval(page);
        sendForApproval.Approval();
        //PMApprove the PR
        Approvers approvers = new Approvers(page);
        approvers.PRApproversApprover(Pass);
        //BuyerManager Assign Buyer
        PRAssignBuyer prAssignBuyer = new PRAssignBuyer(page);
        prAssignBuyer.BuyerAssign(Bm,Pass,BuyerId);
        //Buyer Create the POR
        CatalogPOR catalogPOR = new CatalogPOR(page);
        catalogPOR.CreatePOR(BuyerId,Pass,PORNotes);
        //Buyer Send For Approval
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
        //LM will assign the LM user ID
        DNAssign dnAssign = new DNAssign(page);
        dnAssign.LMAssignDN(LMId,Pass,POTrn);
        //LM will create the WO
        CreateWO createWO = new CreateWO(page);
        createWO.LMCreateWO(VendorName);
        //Vendor will update the WO Status
        VendorTrackerStatus vendorTrackerStatus = new VendorTrackerStatus(page);
        vendorTrackerStatus.VendorUpdateTS(VendorId,Pass,POTrn);
        //Vendor Create the Invoice
        CreateInvoice createInvoice = new CreateInvoice(page);
        createInvoice.VendorCreateInvoice(VendorId,Pass,POTrn,INVNumber,AdminId);
        //Buyer Accept the Invoice
        InvoiceAccept invoiceAccept = new InvoiceAccept(page);
        String ApproverUserId = invoiceAccept.AcceptInvoice(BuyerId,Pass,POTrn);
        //Finance Checker Approve the Invoice
        ApprovalApproves approvalApproves = new ApprovalApproves(page);
        approvalApproves.InvoiceApprover(ApproverUserId,Pass,POTrn);
    }
}
