package com.RequestForQuotation.ReadyForEvaluation;

import org.example.RFQ.ReadyForEvaluation.ReadyForEvaluation;
import com.testComponents.BaseTest;
import org.testng.annotations.Test;

public class ReadyForEvaluationTest extends BaseTest {
    @Test
    public void ReadyForEvaluationMethod() throws InterruptedException {
        ReadyForEvaluation readyForEvaluation = new ReadyForEvaluation(page);
        readyForEvaluation.BuyerSentRFE();
    }
}
