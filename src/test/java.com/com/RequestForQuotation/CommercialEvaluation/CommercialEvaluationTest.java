package com.RequestForQuotation.CommercialEvaluation;

import org.example.RFQ.CE.CommercialEvaluation;
import com.testComponents.BaseTest;
import org.testng.annotations.Test;

public class CommercialEvaluationTest extends BaseTest {
    @Test
    public void CommercialEvaluationMethod() throws InterruptedException {
        CommercialEvaluation commercialEvaluation = new CommercialEvaluation(page);
        commercialEvaluation.BuyerCreateCE(BuyerId,Pass,Title);
    }
}
