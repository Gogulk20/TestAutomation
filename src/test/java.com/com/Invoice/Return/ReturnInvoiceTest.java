package com.Invoice.Return;

import com.testComponents.BaseTest;
import org.example.Invoice.Return.ReturnInvoice;
import org.testng.annotations.Test;

public class ReturnInvoiceTest extends BaseTest {

    @Test
    public void ReturnInvoiceMethod() throws InterruptedException {
        ReturnInvoice returnInvoice = new ReturnInvoice(page);
        returnInvoice.BuyerReturnInvoice();
    }
}
