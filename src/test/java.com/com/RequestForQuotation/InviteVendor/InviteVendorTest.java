package com.RequestForQuotation.InviteVendor;

import org.example.RFQ.InviteVendor.VendorInvite;
import com.testComponents.BaseTest;
import org.testng.annotations.Test;

public class InviteVendorTest extends BaseTest {
    @Test
    public void InviteVendorMenthod() throws InterruptedException {
        VendorInvite vendorInvite = new VendorInvite(page);
        vendorInvite.InviteVendor();
    }
}
