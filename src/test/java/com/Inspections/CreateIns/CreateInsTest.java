package com.Inspections.CreateIns;

import org.example.Inspections.Create;
import com.testComponents.BaseTest;
import org.example.Inspections.SendForInspection;
import org.testng.annotations.Test;

public class CreateInsTest extends BaseTest {
    @Test
    public void CreateInspectionMethod() throws InterruptedException {
        SendForInspection sendForInspection = new SendForInspection(page);
        sendForInspection.GetPOTrnID();
        Create create = new Create(page);
        create.RequesterCreateIns();
    }
}
