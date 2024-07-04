package com.PurchaseOrderRequest.CreatePORCatalog;

import org.example.POR.CreatePOR.CatalogPOR;
import com.testComponents.BaseTest;
import org.testng.annotations.Test;

public class CatalogCreatePORTest extends BaseTest {
    @Test
    public void CatalogCreatePORMethod() throws InterruptedException {
        CatalogPOR catalogPOR = new CatalogPOR(page);
        catalogPOR.CreatePOR(BuyerId,Pass,PORNotes);
    }
}
