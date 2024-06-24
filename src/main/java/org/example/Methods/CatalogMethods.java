package org.example.Methods;

import org.example.*;
import org.example.Login.LogIn;
import org.example.PR.AssignBuyer.PRAssignBuyer;
import org.example.PR.Modules.CatalogPR;
import org.example.POR.ApprovalAssign.PMApprovalAssign;
import org.example.POR.CreatePOR.CatalogPOR;
import org.example.POR.SendForApproval.PORSendForApproval;
import org.example.PR.SendForApproval.PRSendForApproval;
import org.openqa.selenium.WebDriver;

public class CatalogMethods extends YKMain{
        public CatalogMethods(WebDriver page) {
                super(page);
        }

        public static void CatalogPR(String ReqId, String Pass, String Title, String Project,
                                     String Wbs, String Vendor, String Rc, String Address,
                                     String Mode, String Bm, String Pm, String OI, String ItemsQty,
                                     String PRNotes, String File1, String File2, String BuyerId,
                                     String PORNotes, String PreOrDict, String PRGroupB, String PRGroupC,
                                     String PRGroupD, String AdminId, String VendorId, String POTrn, String SourceCountry,
                                     String DestinationCountry, String GrossWeight, String NetWeight,
                                     String Volume, String DNQuantity, String LMId, String VendorName, WebDriver page) throws InterruptedException {
//                CatalogPOR.CreatePOR(BuyerId, Pass, Title, PORNotes, page);
//                PORSendForApproval.SendForApproval(PreOrDict,Pass, page);
//                PMApprovalAssign.PORApproval(Title, PRGroupB, PRGroupC, PRGroupD, Pass,AdminId,BuyerId,VendorId,POTrn,ReqId, SourceCountry, DestinationCountry,GrossWeight,NetWeight,Volume,DNQuantity,LMId,VendorName,page);


        }
}
