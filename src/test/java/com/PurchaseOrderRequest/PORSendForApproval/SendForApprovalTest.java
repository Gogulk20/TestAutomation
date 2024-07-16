package com.PurchaseOrderRequest.PORSendForApproval;

import org.example.POR.SendForApproval.PORSendForApproval;
import com.testComponents.BaseTest;
import org.testng.annotations.Test;

public class SendForApprovalTest extends BaseTest {
    @Test
    public void SendForApprovalMethod() throws InterruptedException {
        PORSendForApproval porSendForApproval = new PORSendForApproval(page);
        porSendForApproval.SendForApproval();
    }
}
