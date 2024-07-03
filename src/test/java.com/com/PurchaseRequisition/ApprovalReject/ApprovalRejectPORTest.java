package com.PurchaseRequisition.ApprovalReject;

import com.testComponents.BaseTest;
import org.example.PR.ApproverReject.ApproverRejectPR;
import org.example.PR.SendForApproval.PRSendForApproval;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ApprovalRejectPORTest extends BaseTest {
    @Test
    public void ApprovalRejectPRMethod() throws InterruptedException {
        PRSendForApproval sendForApproval = new PRSendForApproval(page);
        sendForApproval.GetApprovalId();
        ApproverRejectPR approverRejectPR = new ApproverRejectPR(page);
        approverRejectPR.PRApproversReject();
    }
}
