package com.RequestForQuotation.Suspend;

import com.testComponents.BaseTest;
import org.example.RFQ.Suspend.SuspendRFQ;
import org.testng.annotations.Test;

public class RFQSuspendTest extends BaseTest {
    @Test
    public void RFQSuspendMethod() throws InterruptedException {
        SuspendRFQ suspendRFQ = new SuspendRFQ(page);
        suspendRFQ.BuyerSuspendRFQ();
    }
}
