package com.Invoice.AcceptDoc;

import org.example.Invoice.AcceptDoc.InvoiceAccept;
import com.testComponents.BaseTest;
import org.testng.annotations.Test;

public class InvoiceAcceptDocTest extends BaseTest {
    @Test
    public void InvoiceAcceptDocMethod() throws InterruptedException {
        InvoiceAccept invoiceAccept = new InvoiceAccept(page);
        invoiceAccept.AcceptInvoice();
    }
}
