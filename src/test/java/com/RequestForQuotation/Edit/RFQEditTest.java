package com.RequestForQuotation.Edit;

import com.testComponents.BaseTest;
import org.example.RFQ.Edit.RFQEdit;
import org.testng.annotations.Test;

public class RFQEditTest extends BaseTest {
    @Test
    public void RFQEditMethod() throws InterruptedException {
        RFQEdit rfqEdit = new RFQEdit(page);
        rfqEdit.BuyerEditRFQ();
    }
}
