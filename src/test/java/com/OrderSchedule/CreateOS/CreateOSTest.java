package com.OrderSchedule.CreateOS;

import org.example.OrderSchedule.Create.CreateOS;
import com.testComponents.BaseTest;
import org.testng.annotations.Test;

public class CreateOSTest extends BaseTest {
    @Test
    public void CreateOSMethod() throws InterruptedException {
        CreateOS createOS = new CreateOS(page);
        createOS.VendorCreateOS();
    }
}
