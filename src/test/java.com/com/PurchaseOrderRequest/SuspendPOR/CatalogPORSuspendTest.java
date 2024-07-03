package com.PurchaseOrderRequest.SuspendPOR;

import com.testComponents.BaseTest;
import org.example.POR.Suspend.CatalogSuspendPOR;
import org.testng.annotations.Test;

public class CatalogPORSuspendTest extends BaseTest {
    @Test
    public void CatalogPORSuspendMethod() throws InterruptedException {
        CatalogSuspendPOR catalogSuspendPOR = new CatalogSuspendPOR(page);
        catalogSuspendPOR.CatalogSuspend();
    }
}
