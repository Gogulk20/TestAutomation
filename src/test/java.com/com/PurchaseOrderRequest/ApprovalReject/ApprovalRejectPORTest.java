package com.PurchaseOrderRequest.ApprovalReject;

import com.testComponents.BaseTest;
import org.example.POR.Approval.ApprovalRejectPOR;
import org.example.POR.SendForApproval.PORSendForApproval;
import org.testng.annotations.Test;

public class ApprovalRejectPORTest extends BaseTest {

    @Test
    public void ApprovalrejectMethod() throws InterruptedException {
        PORSendForApproval porSendForApproval = new PORSendForApproval(page);
        porSendForApproval.PMIDLogin();
        ApprovalRejectPOR approvalRejectPOR = new ApprovalRejectPOR(page);
        approvalRejectPOR.PORApproval();
    }
}
