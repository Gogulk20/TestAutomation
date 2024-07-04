package com.OrderSchedule.ApproveOS;

import org.example.OrderSchedule.Approve.ApproveOS;
import com.testComponents.BaseTest;
import org.testng.annotations.Test;

public class ApproveOSTest extends BaseTest {
    @Test
    public void ApproveOSMethod() throws InterruptedException {
        ApproveOS approveOS = new ApproveOS(page);
        approveOS.BuyerApproveOS(BuyerId,Pass);
    }
}
