package com.Inspections.Assigns;

import org.example.Inspections.Assign;
import com.testComponents.BaseTest;
import org.example.Inspections.SendForInspection;
import org.testng.annotations.Test;

public class AssignInspectionTest extends BaseTest {
    @Test
    public void AssignInspectionMethod() throws InterruptedException {
        SendForInspection sendForInspection = new SendForInspection(page);
        sendForInspection.GetPOTrnID();
        Assign assign = new Assign(page);
        assign.RequesterAssignIns(ReqId,Pass);
    }
}
