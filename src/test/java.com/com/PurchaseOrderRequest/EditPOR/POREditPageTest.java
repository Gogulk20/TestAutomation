package com.PurchaseOrderRequest.EditPOR;

import com.testComponents.BaseTest;
import org.example.POR.EditPOR.POREdit;
import org.testng.annotations.Test;

public class POREditPageTest extends BaseTest {
    @Test
    public void POREditPageMethod() throws InterruptedException {
        POREdit porEdit = new POREdit(page);
        porEdit.POREditpage();
    }
}
