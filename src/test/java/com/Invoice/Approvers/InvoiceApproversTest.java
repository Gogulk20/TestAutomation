package com.Invoice.Approvers;

import org.example.Invoice.AcceptDoc.InvoiceAccept;
import org.example.Invoice.Approvers.ApprovalApproves;
import com.testComponents.BaseTest;
import org.testng.annotations.Test;

public class InvoiceApproversTest extends BaseTest {
    @Test
    public void InvoiceApproversMethod() throws InterruptedException {
        InvoiceAccept invoiceAccept = new InvoiceAccept(page);
        invoiceAccept.ApproverID();
        ApprovalApproves approvalApproves = new ApprovalApproves(page);
        approvalApproves.InvoiceApprover();
    }
}
