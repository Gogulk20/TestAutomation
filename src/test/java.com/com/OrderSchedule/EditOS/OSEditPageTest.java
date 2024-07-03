package com.OrderSchedule.EditOS;

import com.testComponents.BaseTest;
import org.example.Inspections.SendForInspection;
import org.example.OrderSchedule.EditPage.OSEditPage;
import org.testng.annotations.Test;

public class OSEditPageTest extends BaseTest {
    @Test
    public void OSEditPageMethod() throws InterruptedException {
        OSEditPage osEditPage = new OSEditPage(page);
        osEditPage.getPOTrnNumber();
        osEditPage.VendorEditOS();
    }
}
