package com.DispatchNotes.ReturnDN;

import com.testComponents.BaseTest;
import org.example.DispatchNotes.Return.DNReturn;
import org.testng.annotations.Test;

public class DNReturnPageTest extends BaseTest {
    @Test
    public void DNReturnMethod() throws InterruptedException {
        DNReturn dnReturn = new DNReturn(page);
        dnReturn.GetPOTrnNum();
        dnReturn.LMreturnDN();
    }
}