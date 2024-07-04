package com.Inspections.SendForInspections;

import org.example.Inspections.SendForInspection;
import com.testComponents.BaseTest;
import org.testng.annotations.Test;

public class SendForInspectionTest extends BaseTest {
    @Test
    public void SendForInspectionMethod() throws InterruptedException {
        SendForInspection sendForInspection = new SendForInspection(page);
        sendForInspection.getPOTrnNumber();
        sendForInspection.VendorSendForInspection();
    }
}
