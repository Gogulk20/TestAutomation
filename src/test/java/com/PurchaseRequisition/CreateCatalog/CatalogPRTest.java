package com.PurchaseRequisition.CreateCatalog;

import org.example.PR.Create.CatalogPR;
import com.testComponents.BaseTest;
import org.testng.annotations.Test;

public class CatalogPRTest extends BaseTest {
    @Test
    public void CatalogPurchaseRequisitionMethod() throws InterruptedException {
        logIn.UserLogin(ReqId,Pass);
        CatalogPR catalogPR = new CatalogPR(page);
        catalogPR.CatalogCreateButton();
        catalogPR.CatalogTitle();
        catalogPR.CatalogProject();
        catalogPR.CatalogWbs();
        catalogPR.CatalogVendor();
        catalogPR.CatalogRc();
        catalogPR.CatalogShippingAdds();
        catalogPR.CatalogShippingMode();
        catalogPR.CatalogExpectedPOIssue();
        catalogPR.CatalogExpectedDelivery();
        catalogPR.CatalogBuyerManager();
        catalogPR.CatalogProjectManager();
        catalogPR.CatalogOrderIntake();
        catalogPR.CatalogInspection();
        catalogPR.CatalogItems();
        catalogPR.CatalogNotes();
        catalogPR.CatalogAttachments();
        catalogPR.CatalogCreaete();
    }
}
