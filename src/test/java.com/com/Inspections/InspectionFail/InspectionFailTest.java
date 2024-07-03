package com.Inspections.InspectionFail;

import com.testComponents.BaseTest;
import org.example.Inspections.InspectionFail;
import org.example.Inspections.SendForInspection;
import org.testng.annotations.Test;

public class InspectionFailTest extends BaseTest {
    @Test
    public void InspectionFailMethod() throws InterruptedException {
        SendForInspection sendForInspection = new SendForInspection(page);
        sendForInspection.GetPOTrnID();
        InspectionFail inspectionFail = new InspectionFail(page);
        inspectionFail.RequesterFailInspection();
    }
}
