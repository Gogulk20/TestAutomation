package com.PurchaseRequisition.Edit;

import com.testComponents.BaseTest;
import org.example.PR.Edit.PREdit;
import org.testng.annotations.Test;

public class PREditTest extends BaseTest {
    @Test
    public void PREditMethod() throws InterruptedException {
        PREdit prEdit = new PREdit(page);
        prEdit.RequesiterEditPR();
    }
}
