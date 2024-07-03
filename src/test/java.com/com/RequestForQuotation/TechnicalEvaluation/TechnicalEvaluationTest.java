package com.RequestForQuotation.TechnicalEvaluation;

import org.example.RFQ.TE.SubmitTE.TechnicalEvaluation;
import com.testComponents.BaseTest;
import org.testng.annotations.Test;

public class TechnicalEvaluationTest extends BaseTest {
    @Test
    public void TechnicalEvaluationMethod() throws InterruptedException {
        TechnicalEvaluation technicalEvaluation = new TechnicalEvaluation(page);
        technicalEvaluation.RequesterCreateTE(ReqId,Pass);
    }
}
