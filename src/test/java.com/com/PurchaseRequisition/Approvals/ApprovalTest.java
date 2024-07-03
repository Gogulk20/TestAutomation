package com.PurchaseRequisition.Approvals;

import org.example.PR.Approvals.Approvers;
import com.testComponents.BaseTest;
import org.example.PR.SendForApproval.PRSendForApproval;
import org.testng.annotations.Test;

public class ApprovalTest extends BaseTest {
    @Test
    public void ApprovalMenthos() throws InterruptedException {
        PRSendForApproval sendForApproval = new PRSendForApproval(page);
        sendForApproval.GetApprovalId();
        Approvers approvers = new Approvers(page);
        approvers.PRApproversApprover();
    }
}
