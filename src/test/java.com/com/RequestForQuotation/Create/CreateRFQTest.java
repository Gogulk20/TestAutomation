package com.RequestForQuotation.Create;

import org.example.RFQ.Create.CreateRFQ;
import com.testComponents.BaseTest;
import org.testng.annotations.Test;

public class CreateRFQTest extends BaseTest {
    @Test
    public void CreateRFQMethod() throws InterruptedException {
        CreateRFQ createRFQ = new CreateRFQ(page);
        createRFQ.CreateRFQ(BuyerId, Pass, RFQNotes);
    }

}
