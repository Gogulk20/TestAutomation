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
        nonCatalogPR.NonCatalogTitle(Title);
        nonCatalogPR.NonCatalogProject(Project);
        nonCatalogPR.NonCatalogWbs(Wbs);
        nonCatalogPR.NonCatalogIncoterm(Incoterm);
        nonCatalogPR.NonCatalogShippingAdds(Address);
        nonCatalogPR.NonCatalogShippingMode(Mode);
        nonCatalogPR.NonCatalogQuotationRequiredBy();
        nonCatalogPR.NonCatalogExpectedPOIssue();
        nonCatalogPR.NonCatalogExpectedDelivery();
        nonCatalogPR.NonCatalogBuyerManager(Bm);
        nonCatalogPR.NonCatalogProjectManager(Pm);
        nonCatalogPR.NonCatalogInspection();
        nonCatalogPR.NonCatalogOrderIntake(OI);
        nonCatalogPR.NonCatalogTargetPrice(TP);
        nonCatalogPR.NonCatalogWarranty();
        nonCatalogPR.NonCatalogPriceValidity(page);
        nonCatalogPR.NonCatalogItems(ItemsQty);
        nonCatalogPR.NonCatalogNotes(PRNotes);
        nonCatalogPR.NonCatalogAttachments(File1, File2);
        nonCatalogPR.NonCatalogCreaete();
    }
}
