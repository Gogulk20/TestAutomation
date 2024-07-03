package com.PurchaseRequisition.Suspend;

import com.testComponents.BaseTest;
import org.example.PR.Suspend.BMSuspend;
import org.testng.annotations.Test;

public class BMSuspendPRTest extends BaseTest {
    @Test
    public void BMSuspendPRMethod() throws InterruptedException {
        BMSuspend bmSuspend = new BMSuspend(page);
        bmSuspend.BMSuspendPR();
    }
}
