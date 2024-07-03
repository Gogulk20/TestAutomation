package com.DispatchNotes.CreateDN;

import org.example.DispatchNotes.Create.CreateDN;
import com.testComponents.BaseTest;
import org.testng.annotations.Test;

public class CreateDNTest extends BaseTest {
    @Test
    public void CreateDNMethod() throws InterruptedException {
        CreateDN createDN = new CreateDN(page);
        createDN.VendorCreateDN();
    }
}
