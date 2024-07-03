package com.RequestForQuotation.Quotation;

import com.testComponents.BaseTest;
import org.example.RFQ.Quotation.ReSubmitQuotation;
import org.testng.annotations.Test;

public class ReSubmitQuotationTest extends BaseTest {
    @Test
    public void ReSubmitQuotationMethod() throws InterruptedException {
        ReSubmitQuotation reSubmitQuotation = new ReSubmitQuotation(page);
        reSubmitQuotation.VendorReSubmitQuotation();
    }
}
