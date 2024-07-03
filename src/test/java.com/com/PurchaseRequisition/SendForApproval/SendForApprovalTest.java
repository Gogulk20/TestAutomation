package com.PurchaseRequisition.SendForApproval;

import org.example.PR.SendForApproval.PRSendForApproval;
import com.testComponents.BaseTest;
import org.testng.annotations.Test;

public class SendForApprovalTest extends BaseTest {
    @Test
    public void SendForApprovalMethod() throws InterruptedException {
        PRSendForApproval sendForApproval = new PRSendForApproval(page);
        sendForApproval.Approval();
    }
}
