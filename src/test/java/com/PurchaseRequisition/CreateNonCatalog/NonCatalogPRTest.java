package com.PurchaseRequisition.CreateNonCatalog;

import org.example.PR.Create.NonCatalogPR;
import com.testComponents.BaseTest;
import org.testng.annotations.Test;

public class NonCatalogPRTest extends BaseTest {
    @Test
    public void NonCatalogPRMethod() throws InterruptedException {
        logIn.UserLogin(ReqId,Pass);
        NonCatalogPR nonCatalogPR = new NonCatalogPR(page);
        nonCatalogPR.NonCatalogCreateButton();
        nonCatalogPR.NonCatalogTitle();
        nonCatalogPR.NonCatalogProject();
        nonCatalogPR.NonCatalogWbs();
        nonCatalogPR.NonCatalogIncoterm();
        nonCatalogPR.NonCatalogShippingAdds();
        nonCatalogPR.NonCatalogShippingMode();
        nonCatalogPR.NonCatalogQuotationRequiredBy();
        nonCatalogPR.NonCatalogExpectedPOIssue();
        nonCatalogPR.NonCatalogExpectedDelivery();
        nonCatalogPR.NonCatalogBuyerManager();
        nonCatalogPR.NonCatalogProjectManager();
        nonCatalogPR.NonCatalogInspection();
        nonCatalogPR.NonCatalogOrderIntake();
        nonCatalogPR.NonCatalogTargetPrice();
        nonCatalogPR.NonCatalogWarranty();
        nonCatalogPR.NonCatalogPriceValidity();
        nonCatalogPR.NonCatalogItems();
        nonCatalogPR.NonCatalogNotes();
        nonCatalogPR.NonCatalogAttachments();
        nonCatalogPR.NonCatalogCreaete();
    }
}
