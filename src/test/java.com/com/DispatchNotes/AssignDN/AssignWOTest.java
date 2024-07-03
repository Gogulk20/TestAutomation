package com.DispatchNotes.AssignDN;

import org.example.DispatchNotes.Assign.DNAssign;
import com.testComponents.BaseTest;
import org.testng.annotations.Test;

public class AssignWOTest extends BaseTest {
    @Test
    public void AssignWOMethod() throws InterruptedException {
        DNAssign dnAssign = new DNAssign(page);
        dnAssign.GetPOTrnNum();
        dnAssign.LMAssignDN();
    }
}
