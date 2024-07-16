package com.RequestForQuotation.Quotation;

import org.example.RFQ.Quotation.Quotation;
import com.testComponents.BaseTest;
import org.testng.annotations.Test;

public class QuotationTest extends BaseTest {
    @Test
    public void QuotationMenthod() throws InterruptedException {
        Quotation quotation = new Quotation(page);
        quotation.QuotationSubmission();
    }
}
