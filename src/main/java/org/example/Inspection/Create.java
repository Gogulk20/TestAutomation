package org.example.Inspection;

import org.example.DispatchNotes.Create.CreateDN;
import org.example.LogOut.LogOut;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Create {
    WebDriver page;
    public Create(WebDriver page) {
        this.page=page;
    }

    public void RequesterCreateIns(String VendorId, String Pass, String Title, String SourceCountry,
                                   String DestinationCountry, String GrossWeight, String NetWeight,
                                   String Volume, String DNQuantity,String LMId,String POTrn,String VendorName,WebDriver page) throws InterruptedException {
        page.findElement(By.id("btnForCreateInspection")).click();Thread.sleep(1000);
        page.findElement(By.id("physicalInspectionReq")).click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor)page;
        js.executeScript("window.scrollBy(0,1100)");Thread.sleep(1000);
        page.findElement(By.id("btnCreateInspection")).click();Thread.sleep(1000);
        page.findElement(By.cssSelector(".bootbox-accept")).click();Thread.sleep(3000);
        LogOut.UserLogOut(page);
        CreateDN createDN = new CreateDN(page);
        createDN.VendorCreateDN(VendorId, Pass, Title, SourceCountry, DestinationCountry,GrossWeight,NetWeight,Volume,DNQuantity,LMId, POTrn,VendorName,page);
    }
}
