package com.WorkOrder.CreateWO;

import com.testComponents.BaseTest;
import org.example.DispatchNotes.Assign.DNAssign;
import org.example.WorkOrder.Create.CreateWO;
import org.testng.annotations.Test;

public class CreateWorkOrderTest extends BaseTest {
    @Test
    public void CreateWorkOrderMethod() throws InterruptedException {
        DNAssign dnAssign = new DNAssign(page);
        dnAssign.GetPOTrnNum();
        CreateWO createWO = new CreateWO(page);
        createWO.LMCreateWO(VendorName);
    }
}
