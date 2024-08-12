package com.RequestForQuotation.InviteVendor;

import com.testComponents.BaseTest;
import org.example.RFQ.InviteVendor.InviteGuestVendor;
import org.testng.annotations.Test;

public class InviteGuestVendorTest extends BaseTest {
    @Test
    public void GuestVendorMethod() throws InterruptedException {
        InviteGuestVendor inviteGuestVendor = new InviteGuestVendor(page);
        inviteGuestVendor.GuestVendorInvite();
    }
}
