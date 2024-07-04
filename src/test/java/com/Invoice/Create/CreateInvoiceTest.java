package com.Invoice.Create;

import org.example.Invoice.Create.CreateInvoice;
import com.testComponents.BaseTest;
import org.testng.annotations.Test;

public class CreateInvoiceTest extends BaseTest {
    @Test
    public void CreateInvoiceMethod() throws InterruptedException {
        CreateInvoice createInvoice = new CreateInvoice(page);
        createInvoice.VendorCreateInvoice();
    }
}
