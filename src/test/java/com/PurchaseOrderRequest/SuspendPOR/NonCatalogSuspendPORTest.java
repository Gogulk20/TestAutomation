package com.PurchaseOrderRequest.SuspendPOR;

import com.testComponents.BaseTest;
import org.example.POR.Suspend.NonCatalogSuspendPOR;
import org.testng.annotations.Test;

public class NonCatalogSuspendPORTest extends BaseTest {
    @Test
    public void NonCatalogPORSuspendMethod() throws InterruptedException {
        NonCatalogSuspendPOR nonCatalogSuspendPOR = new NonCatalogSuspendPOR(page);
        nonCatalogSuspendPOR.NonCatalogSuspend();
    }
}
