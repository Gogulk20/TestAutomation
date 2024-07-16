package com.PurchaseOrderRequest.ApprovalsAssign;

import org.example.POR.ApprovalAssign.PMApprovalAssign;
import com.testComponents.BaseTest;
import org.example.POR.SendForApproval.PORSendForApproval;
import org.testng.annotations.Test;

public class AssignApprovalsTest extends BaseTest {
    @Test
    public void ApprovalsAssignMethod() throws InterruptedException {
        PORSendForApproval porSendForApproval = new PORSendForApproval(page);
        porSendForApproval.PMIDLogin();
        PMApprovalAssign pmApprovalAssign = new PMApprovalAssign(page);
        pmApprovalAssign.PORApproval();
    }
}
