package com.OrderSchedule.RejectOS;

import com.testComponents.BaseTest;
import org.example.OrderSchedule.Reject.OSReject;
import org.testng.annotations.Test;

public class RejectOSTest extends BaseTest {

    @Test
    public void RejectOSMethod() throws InterruptedException {
        OSReject osReject = new OSReject(page);
        osReject.BuyerRejectOS();
    }
}
