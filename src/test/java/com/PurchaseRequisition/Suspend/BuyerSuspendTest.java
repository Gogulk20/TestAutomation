package com.PurchaseRequisition.Suspend;

import com.testComponents.BaseTest;
import org.example.PR.Suspend.BuyerSuspend;
import org.testng.annotations.Test;

public class BuyerSuspendTest extends BaseTest {
    @Test
    public void BuyerSuspendPRMethod() throws InterruptedException {
        BuyerSuspend buyerSuspend = new BuyerSuspend(page);
        buyerSuspend.BuyerSuspendPR();
    }
}
