package com.WorkOrder.TrackerStatus;

import com.testComponents.BaseTest;
import org.example.WorkOrder.TrackerStatus.VendorTrackerStatus;
import org.testng.annotations.Test;

public class TrackerStatusTest extends BaseTest {
    @Test
    public void TrackerStatusMethod() throws InterruptedException {
        VendorTrackerStatus vendorTrackerStatus = new VendorTrackerStatus(page);
        vendorTrackerStatus.VendorUpdateTS();
        vendorTrackerStatus.VendorTrackerStatus();
    }
}
