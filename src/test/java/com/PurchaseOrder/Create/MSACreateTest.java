package com.PurchaseOrder.Create;

import org.example.PO.POCreate;
import com.testComponents.BaseTest;
import org.testng.annotations.Test;

public class MSACreateTest extends BaseTest {
    @Test
    public void MSACreatePOMethod() throws InterruptedException {
        POCreate poCreate = new POCreate(page);
        poCreate.BuyerCreatePO();
    }
}
