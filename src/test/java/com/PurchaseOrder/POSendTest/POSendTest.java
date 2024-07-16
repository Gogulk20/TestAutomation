package com.PurchaseOrder.POSendTest;

import org.example.PO.POSent;
import com.testComponents.BaseTest;
import org.testng.annotations.Test;

public class POSendTest extends BaseTest {
    @Test
    public void POSendMethod() throws InterruptedException {
        POSent poSent = new POSent(page);
        poSent.POSentToVendor();
    }
}
