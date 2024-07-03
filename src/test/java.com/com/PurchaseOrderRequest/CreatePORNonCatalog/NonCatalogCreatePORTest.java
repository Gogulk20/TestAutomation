package com.PurchaseOrderRequest.CreatePORNonCatalog;

import org.example.POR.CreatePOR.NonCatalogPOR;
import com.testComponents.BaseTest;
import org.testng.annotations.Test;

public class NonCatalogCreatePORTest extends BaseTest {
    @Test
    public void NonCatalogCreatePORMethod() throws InterruptedException {
        NonCatalogPOR nonCatalogPOR = new NonCatalogPOR(page);
        nonCatalogPOR.BuyerCreatePOR();
    }
}
