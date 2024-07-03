package com.PurchaseRequisition.Assign;

import org.example.PR.AssignBuyer.PRAssignBuyer;
import com.testComponents.BaseTest;
import org.testng.annotations.Test;

public class AssignBuyerTest extends BaseTest {
    @Test
    public void AssignBuyerMethod() throws InterruptedException {
        PRAssignBuyer prAssignBuyer = new PRAssignBuyer(page);
        prAssignBuyer.BuyerAssign();
    }
}
