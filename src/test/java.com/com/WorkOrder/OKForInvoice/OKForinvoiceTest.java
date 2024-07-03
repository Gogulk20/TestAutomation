package com.WorkOrder.OKForInvoice;

import com.testComponents.BaseTest;
import org.example.DispatchNotes.Assign.DNAssign;
import org.example.WorkOrder.OkForInvoice.OkForInvoice;
import org.testng.annotations.Test;

public class OKForinvoiceTest extends BaseTest {
    @Test
    public void OkForInvoice() throws InterruptedException {
        OkForInvoice okForInvoice = new OkForInvoice(page);
        okForInvoice.GetPOTrnNum();
        okForInvoice.LMClickOkForInvoice();
    }
}
