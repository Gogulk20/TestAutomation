package com.RequestForQuotation.TechnicalEvaluation;

import com.testComponents.BaseTest;
import org.example.RFQ.TE.TEReject.ApproverRejectTE;
import org.testng.annotations.Test;

public class TechnicalEvaluationReject extends BaseTest {

    @Test
    public void TechnicalEvaluationRejectTest() throws InterruptedException {
        ApproverRejectTE approverRejectTE = new ApproverRejectTE(page);
        approverRejectTE.ApproverRejectTE();
    }
}
