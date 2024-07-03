package com.DispatchNotes.EditDN;

import com.testComponents.BaseTest;
import org.example.DispatchNotes.Edit.EditDN;
import org.testng.annotations.Test;

public class EditDNTest extends BaseTest {
    @Test
    public void EditDNMethod() throws InterruptedException {
        EditDN editDN = new EditDN(page);
        editDN.getPOTrnNumber();
        editDN.VendorEditDN();
    }
}
