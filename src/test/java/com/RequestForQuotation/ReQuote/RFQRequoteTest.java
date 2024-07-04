package com.RequestForQuotation.ReQuote;

import com.testComponents.BaseTest;
import org.example.RFQ.ReQuote.QuotationRequote;
import org.testng.annotations.Test;

public class RFQRequoteTest extends BaseTest {
    @Test
    public void RFQRequoteMenthod() throws InterruptedException {
        QuotationRequote quotationRequote = new QuotationRequote(page);
        quotationRequote.BuyerSendRequote();
    }
}
