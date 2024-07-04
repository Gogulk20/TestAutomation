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
        catalogPR.CatalogTitle(Title);
        catalogPR.CatalogProject(Project);
        catalogPR.CatalogWbs(Wbs);
        catalogPR.CatalogVendor(Vendor);
        catalogPR.CatalogRc(Rc);
        catalogPR.CatalogShippingAdds(Address);
        catalogPR.CatalogShippingMode(Mode);
        catalogPR.CatalogExpectedPOIssue();
        catalogPR.CatalogExpectedDelivery();
        catalogPR.CatalogBuyerManager(Bm);
        catalogPR.CatalogProjectManager(Pm);
        catalogPR.CatalogOrderIntake(OI);
        catalogPR.CatalogInspection();
        catalogPR.CatalogItems(ItemsQty);
        catalogPR.CatalogNotes(PRNotes);
        catalogPR.CatalogAttachments(File1, File2);
        catalogPR.CatalogCreaete();
    }
}
