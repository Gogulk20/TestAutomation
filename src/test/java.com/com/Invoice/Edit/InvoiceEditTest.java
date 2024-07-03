package com.Invoice.Edit;

import com.testComponents.BaseTest;
import org.example.Invoice.EditInvoice.InvoiceEdit;
import org.testng.annotations.Test;

public class InvoiceEditTest extends BaseTest {

    @Test
    public void InvoiceEditMethod() throws InterruptedException {
        InvoiceEdit invoiceEdit = new InvoiceEdit(page);
        invoiceEdit.VendorEditInvoice();
    }
}
