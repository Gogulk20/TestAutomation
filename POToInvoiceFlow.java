import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class POToInvoiceFlow {

    public static void buyerPo(String Title, WebDriver driver) throws InterruptedException{
        driver.findElement(By.xpath("//span[contains(text(),'Purchase Orders')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'"+ Title+"')]")).click();Thread.sleep(1000);
        driver.findElement(By.id("btnSendPO")).clear();Thread.sleep(1000);
        driver.findElement(By.id("vendorSendMailBtnId")).click();
    }
    //PO Details - Log Out the Buyer ID
    static void buyerLogout1(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//header/div[1]/div[2]/ul[1]/li[3]/div[1]/a[1]/div[1]/img[1]")).click();Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'out')]")).click();Thread.sleep(1000);
    }
    //PO Vendor ID - Login
    static void vendorLogin1(String VendorEmail, String Password, WebDriver driver) throws InterruptedException {
        driver.findElement(By.id("Input_Email")).sendKeys(VendorEmail);Thread.sleep(1000);
        driver.findElement(By.id("Input_Password")).sendKeys(Password);Thread.sleep(1000);
        driver.findElement(By.id("login-submit")).click();Thread.sleep(1000);
    }
    static void vendorPoDetails1(String Title, WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Purchase Orders')]")).click();Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'"+ Title+"')]")).click();Thread.sleep(1000);
        driver.findElement(By.id("btnCreateOR")).click();Thread.sleep(1000);
    }
    static void vendorCreateOSpage(String quantity1, String quantity2, String quantity3, WebDriver driver) throws InterruptedException {
        //Create OS Lot 1
        driver.findElement(By.id("btnToAddOS")).click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 350)", "");Thread.sleep(1000);

        //Date Field
        driver.findElement(By.xpath("//body/main[@id='content']/div[1]/form[1]/div[3]/div[1]/div[1]/div[2]/div[1]/input[2]")).click();Thread.sleep(1000);
        Select month = new Select(driver.findElement(By.xpath("//body/div[5]/div[1]/div[1]/div[1]/select[1]")));
        month.selectByVisibleText("November");
        WebElement day = driver.findElement(By.xpath("//span[contains(text(),'27')]"));
        day.click();Thread.sleep(1000);

        //Quantity
        driver.findElement(By.xpath("//input[contains(@name, 'quantity')]")).clear();
        driver.findElement(By.xpath("//input[contains(@name, 'quantity')]")).sendKeys(quantity1);Thread.sleep(1000);

        //Create OS Lot 2
        driver.findElement(By.id("btnToAddOS")).click();Thread.sleep(1000);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0, 650)", "");Thread.sleep(1000);

        //Date Field
        driver.findElement(By.xpath("//body/main[@id='content']/div[1]/form[1]/div[3]/div[2]/div[1]/div[2]/div[1]/input[2]")).click();Thread.sleep(1000);
        Select month1 = new Select(driver.findElement(By.xpath("//body/div[7]/div[1]/div[1]/div[1]/select[1]")));
        month1.selectByVisibleText("November");
        WebElement day1 = driver.findElement(By.xpath("//body/div[7]/div[2]/div[1]/div[2]/div[1]/span[31]"));
        day1.click();Thread.sleep(1000);

        //Quantity
        driver.findElement(By.cssSelector("#quantity-1819-2")).clear();
        driver.findElement(By.cssSelector("#quantity-1819-2")).sendKeys(quantity2);Thread.sleep(1000);
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0, 650)", "");Thread.sleep(1000);

        //Create OS Lot 3
        driver.findElement(By.id("btnToAddOS")).click();Thread.sleep(1000);
        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js3.executeScript("window.scrollBy(0, 650)", "");Thread.sleep(1000);

        //Date Field
        driver.findElement(By.xpath("//body/main[@id='content']/div[1]/form[1]/div[3]/div[3]/div[1]/div[2]/div[1]/input[2]")).click();Thread.sleep(1000);
        Select month2 = new Select(driver.findElement(By.xpath("//body/div[10]/div[1]/div[1]/div[1]/select[1]")));
        month2.selectByVisibleText("November");
        WebElement day2 = driver.findElement(By.xpath("//body/div[10]/div[2]/div[1]/div[2]/div[1]/span[32]"));
        day2.click();Thread.sleep(1000);

        //Quantity
        driver.findElement(By.cssSelector("#quantity-1819-3")).clear();
        driver.findElement(By.cssSelector("#quantity-1819-3")).sendKeys(quantity3);Thread.sleep(1000);
    }
    //OS Notes
    static void vendorOsNotes(String notes, WebDriver driver) throws InterruptedException {
      WebElement note = driver.findElement(By.id("notes"));
      note.sendKeys(Keys.DOWN);
      note.click();
        driver.findElement(By.id("notes")).sendKeys(notes);Thread.sleep(1000);
    }
    //OS Submit button
    static void vendorSubmitButton(WebDriver driver) throws InterruptedException {
        driver.findElement(By.id("btnCreate")).click();Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();Thread.sleep(1000);
    }
    //PO Details - Log Out the Vendor ID
    static void vendorLogout1(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//header/div[1]/div[2]/ul[1]/li[3]/div[1]/a[1]/div[1]/img[1]")).click();Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'out')]")).click();Thread.sleep(1000);
    }
    //PO Yokogawa buyer ID - Login
    static void buyerLogin1(String BuyerEmail, String Password, WebDriver driver) throws InterruptedException {
        driver.findElement(By.id("Input_Email")).sendKeys(BuyerEmail);Thread.sleep(1000);
        driver.findElement(By.id("Input_Password")).sendKeys(Password);Thread.sleep(1000);
        driver.findElement(By.id("login-submit")).click();Thread.sleep(1000);
    }
    //PO details page - View order Schedule
    static void buyerPoDetails1(String Title, WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Purchase Orders')]")).click();Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'"+ Title+"')]")).click();Thread.sleep(1000);
        driver.findElement(By.id("BtnToApproveOS")).click();Thread.sleep(1000);
    }
    //PO Details page - OS Approve
    static void buyerOsApprove(WebDriver driver) throws InterruptedException {
        WebElement approve = driver.findElement(By.id("btnApprove"));
        approve.sendKeys(Keys.DOWN);
        approve.click();
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();Thread.sleep(1000);
    }
    //PO Details - Log Out the Buyer ID
    static void buyerLogout2(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//header/div[1]/div[2]/ul[1]/li[3]/div[1]/a[1]/div[1]/img[1]")).click();Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'out')]")).click();Thread.sleep(1000);
    }
    //PO Details - Login the Vendor ID
    static void vendorLogin2(String VendorEmail, String Password, WebDriver driver) throws InterruptedException {
        driver.findElement(By.id("Input_Email")).sendKeys(VendorEmail);Thread.sleep(1000);
        driver.findElement(By.id("Input_Password")).sendKeys(Password);Thread.sleep(1000);
        driver.findElement(By.id("login-submit")).click();Thread.sleep(1000);
    }
    //OS Details page - Vendor Send For Inspection
    static void vendorOsDetails1(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Order Schedules')]")).click();Thread.sleep(1000);
        driver.findElement(By.xpath("//tbody/tr[1]/td[6]/a[1]")).click();Thread.sleep(1000);
        driver.findElement(By.id("btnSendForInspection")).click();Thread.sleep(1000);
        driver.findElement(By.xpath("//tbody/tr[1]/td[6]/a[1]")).click();Thread.sleep(1000);
    }
    //OS Vendor Logout
    static void vendorLogout2(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//header/div[1]/div[2]/ul[1]/li[3]/div[1]/a[1]/div[1]/img[1]")).click();Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'out')]")).click();Thread.sleep(1000);
    }
    // Requester ID - Login
    static void requesterLogin(String email, String Password, WebDriver driver) throws InterruptedException {
        driver.findElement(By.id("Input_Email")).sendKeys(email);Thread.sleep(1000);
        driver.findElement(By.id("Input_Password")).sendKeys(Password);Thread.sleep(1000);
        driver.findElement(By.id("login-submit")).click();Thread.sleep(1000);
    }
    // OS details page
    static void requesterOsDetails(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Order Schedules')]")).click();Thread.sleep(1000);
        driver.findElement(By.xpath("//tbody/tr[1]/td[7]/a[1]")).click();Thread.sleep(1000);
    }
    // Assign Inspection flow
    static void requesterAssignInspection(String assigner, WebDriver driver) throws InterruptedException {
        driver.findElement(By.id("btnAssignInspector")).click();Thread.sleep(1000);
        driver.findElement(By.id("select2-InspectionId-container")).click();Thread.sleep(1000);
        driver.findElement(By.className("select2-search__field")).sendKeys(assigner);Thread.sleep(1000);
        driver.findElement(By.id("saveInspector")).click();Thread.sleep(1000);
    }
    //Create Inspection page
    static void requesterCreateInspection(WebDriver driver) throws InterruptedException {
        driver.findElement(By.id("btnForCreateInspection")).click();
    }
    static void requesterInspectionNotes(String notes, String filename, WebDriver driver) throws InterruptedException {
       WebElement note =  driver.findElement(By.id("notes"));
       note.sendKeys(Keys.DOWN);
       note.click();
        driver.findElement(By.id("notes")).sendKeys(notes);Thread.sleep(1000);
//Attachments
        driver.findElement(By.id("attachDocs")).click();Thread.sleep(1000);
        WebElement file = (driver.findElement(By.id("formFilePreupload")));
        file.sendKeys(filename);Thread.sleep(1000);
        driver.findElement(By.id("saveAttachments")).click();Thread.sleep(1000);
        driver.findElement(By.className("btn-primary")).click();Thread.sleep(1000);
//Create inspection button
        driver.findElement(By.id("btnCreateInspection")).click();Thread.sleep(1000);
    }
    //Requester Logout
    static void requesterlogout(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//header/div[1]/div[2]/ul[1]/li[3]/div[1]/a[1]/div[1]/img[1]")).click();Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'out')]")).click();Thread.sleep(1000);
    }
    //PO Vendor ID - Login
    static void vendorLogin3(String VendorEmail, String Password, WebDriver driver) throws InterruptedException {
        driver.findElement(By.id("Input_Email")).sendKeys(VendorEmail);Thread.sleep(1000);
        driver.findElement(By.id("Input_Password")).sendKeys(Password);Thread.sleep(1000);
        driver.findElement(By.id("login-submit")).click();Thread.sleep(1000);
    }
    //OS Details page Vendor ID
    static void vendorOsDetails2(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Order Schedules')]")).click();Thread.sleep(1000);
        driver.findElement(By.xpath("//tbody/tr[1]/td[6]/a[1]")).click();Thread.sleep(1000);
        driver.findElement(By.id("btnCreateDispatchNote")).click();Thread.sleep(1000);
    }
    // DN page Create
    static void vendorCreateDnDate(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//body/main[@id='content']/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/input[2]")).click();Thread.sleep(1000);
        Select month = new Select(driver.findElement(By.xpath("//body/div[5]/div[1]/div[1]/div[1]/select[1]")));
        month.selectByVisibleText("November");Thread.sleep(1000);
        WebElement day = driver.findElement(By.xpath("//span[contains(text(),'27')]"));
        day.click();Thread.sleep(1000);
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0, 550)", "");Thread.sleep(1000);
    }
    //DN Packages
    static void vendorDnPackages(WebDriver driver) throws InterruptedException {
        driver.findElement(By.id("addDispatchNotePackages")).click();Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'-- Select Package Type --')]")).click();Thread.sleep(1000);
        driver.findElement(By.className("select2-results__option")).click();Thread.sleep(1000);
        driver.findElement(By.id("grossWeight")).click();Thread.sleep(1000);
        driver.findElement(By.id("grossWeight")).sendKeys("43");Thread.sleep(1000);
        driver.findElement(By.id("netWeight")).click();Thread.sleep(1000);
        driver.findElement(By.id("netWeight")).sendKeys("4");Thread.sleep(1000);
        driver.findElement(By.id("volume")).click();Thread.sleep(1000);
        driver.findElement(By.id("volume")).sendKeys("4");Thread.sleep(1000);
        driver.findElement(By.id("quantity")).click();Thread.sleep(1000);
        driver.findElement(By.id("quantity")).sendKeys("4");Thread.sleep(1000);
        driver.findElement(By.id("description")).click();Thread.sleep(1000);
        driver.findElement(By.id("description")).sendKeys("Description");Thread.sleep(1000);
        driver.findElement(By.id("saveDispatchNotePackages")).click();Thread.sleep(1000);
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0, 550)", "");Thread.sleep(1000);
    }
    //DN Create button in Vendor ID
    static void buyerDnCreate(WebDriver driver) throws InterruptedException {
        WebElement file = (driver.findElement(By.cssSelector("body.pace-done.has-navbar-vertical-aside.navbar-vertical-aside-show-xl.footer-offset:nth-child(3) main.main:nth-child(7) div.content.container-fluid div.card.mb-3.mt-1.mb-lg-5:nth-child(8) div.card-body div.row.mb-3 table.table.table-bordered tbody:nth-child(2) tr:nth-child(3) td:nth-child(4) > button.btn.btn-sm.btn-primary:nth-child(2)")));
        file.sendKeys("C:\\Users\\Vidya Abbigeri\\Downloads\\ImportRequisitionYokogawaPOCHWItems (3).xlsx");Thread.sleep(1000);
        WebElement file1 = (driver.findElement(By.cssSelector("body.pace-done.has-navbar-vertical-aside.navbar-vertical-aside-show-xl.footer-offset:nth-child(3) main.main:nth-child(7) div.content.container-fluid div.card.mb-3.mt-1.mb-lg-5:nth-child(8) div.card-body div.row.mb-3 table.table.table-bordered tbody:nth-child(2) tr:nth-child(5) td:nth-child(4) > button.btn.btn-sm.btn-primary:nth-child(2)")));
        file1.sendKeys("C:\\Users\\Vidya Abbigeri\\Downloads\\ImportRequisitionYokogawaPOCHWItems (3).xlsx");Thread.sleep(1000);
        driver.findElement(By.id("btnCreate")).click();Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();Thread.sleep(1000);
    }
    //DN Vendor Logout
    static void vendorLogout3(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//header/div[1]/div[2]/ul[1]/li[3]/div[1]/a[1]/div[1]/img[1]")).click();Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'out')]")).click();Thread.sleep(1000);
    }
    //DN Buyer ID - Login
    static void buyerLogin2(String BuyerEmail, String Password, WebDriver driver) throws InterruptedException {
        driver.findElement(By.id("Input_Email")).sendKeys(BuyerEmail);Thread.sleep(1000);
        driver.findElement(By.id("Input_Password")).sendKeys(Password);Thread.sleep(1000);
        driver.findElement(By.id("login-submit")).click();Thread.sleep(1000);
    }
    //DN Details page Buyer ID - Assign Buyer
    static void buyerDnDetails(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Dispatch Notes')]")).click();Thread.sleep(1000);
        driver.findElement(By.xpath("//tbody/tr[1]/td[7]/a[1]")).click();Thread.sleep(1000);
        driver.findElement(By.id("btnToAssign")).click();Thread.sleep(1000);
        driver.findElement(By.id("select2-assignerId-container")).click();Thread.sleep(1000);
        driver.findElement(By.xpath("//body/main[@id='content']/div[1]/div[6]/span[1]/span[1]/span[1]/input[1]")).click();Thread.sleep(1000);
        driver.findElement(By.xpath("//body/main[@id='content']/div[1]/div[6]/span[1]/span[1]/span[1]/input[1]")).sendKeys("genpactbuyer@cormsquare.com");Thread.sleep(1000);
        driver.findElement(By.className("select2-results__option--highlighted")).click();Thread.sleep(1000);
        driver.findElement(By.id("saveAssine")).click();Thread.sleep(1000);
    }
    //WO Buyer ID - WO Create page
    static void woCreatePage(WebDriver driver) throws InterruptedException {
        driver.findElement(By.id("btnToCreateWorkOrder")).click();
        //Assigning Freight Forwarder
        driver.findElement(By.xpath("//span[contains(text(),'-- Select Freight Forwarder --')]")).click();Thread.sleep(1000);
        driver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).click();Thread.sleep(1000);
        driver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).sendKeys("alpha limited");Thread.sleep(1000);
        driver.findElement(By.className("select2-results__option--highlighted")).click();Thread.sleep(1000);
        //Priority field
        driver.findElement(By.xpath("//span[contains(text(),'Priority --')]")).click();Thread.sleep(1000);
        driver.findElement(By.id("select2-priority-result-bl68-High")).click();Thread.sleep(1000);
        //Delivery Date
        driver.findElement(By.xpath("//body/main[@id='content']/div[1]/form[1]/div[1]/div[1]/div[2]/div[4]/div[3]/input[2]")).click();
        Select month2 = new Select(driver.findElement(By.xpath("//body/div[4]/div[1]/div[1]/div[1]/select[1]")));
        month2.selectByVisibleText("November");
        WebElement day2 = driver.findElement(By.xpath("//body/div[4]/div[2]/div[1]/div[2]/div[1]/span[28]"));
        day2.click();Thread.sleep(1000);
        //Create WO Button
        WebElement button = driver.findElement(By.id("btnToCreateWorkOrder"));
        button.sendKeys(Keys.DOWN);
        button.click();
        driver.findElement(By.className("bootbox-accept")).click();
    }
    //Buyer Logout
    static void buyerLogout3(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//header/div[1]/div[2]/ul[1]/li[3]/div[1]/a[1]/div[1]/img[1]")).click();Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'out')]")).click();Thread.sleep(1000);
    }
    //Vendor ID - Login
    static void vendorLogin4(String VendorEmail, String Password, WebDriver driver) throws InterruptedException {
        driver.findElement(By.id("Input_Email")).sendKeys(VendorEmail);Thread.sleep(1000);
        driver.findElement(By.id("Input_Password")).sendKeys(Password);Thread.sleep(1000);
        driver.findElement(By.id("login-submit")).click();Thread.sleep(1000);
    }
    //WO Details page
    static void vendorWoDetails(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Work Orders')]")).click();Thread.sleep(1000);
//        driver.findElement(By.xpath("//tbody/tr[1]/td[6]/a[1]")).click();Thread.sleep(1000);
        //1st status
        //Selecting Present Date
        driver.findElement(By.xpath("//span[contains(text(), 'WO-00355')]")).click();Thread.sleep(1000);
        //Status Selection

        String[] status = {"Material_Pick_Up", "ETD", "Arrival_Notification", "Import_Clearance", "Out_for_Delivery", "Delivery_Completed"};
        for (int i = 0; i < status.length; i++) {
            driver.findElement(By.xpath("//body/main[@id='content']/div[1]/div[2]/div[2]/div[1]/div[1]/div[4]/div[1]/div[2]/form[1]/div[1]/div[1]/input[2]")).click();Thread.sleep(1000);
            WebElement presentDateElement = driver.findElement(By.xpath("//span[@class='flatpickr-day today']"));Thread.sleep(1000);
            presentDateElement.click();Thread.sleep(1000);
            driver.findElement(By.id("select2-statusId-container")).click();Thread.sleep(1000);
            driver.findElement(By.className("select2-search__field")).sendKeys(status[i]);Thread.sleep(1000);
            driver.findElement(By.id("select2-statusId-results")).click();Thread.sleep(1000);
            driver.findElement(By.id("btnSubmit")).click();Thread.sleep(1000);
            driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();Thread.sleep(1000);
        }
    }
        //Vendor Invoice Page page
        static void vendorInvoicePage (WebDriver driver) throws InterruptedException {
            driver.findElement(By.xpath("//span[contains(text(),'Invoices')]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//body/main[@id='content']/div[1]/div[1]/div[1]/div[2]/a[1]")).click();
            Thread.sleep(1000);
        }
        //Vendor Invoice Create Page page
        static void vendorInvoiceCreate (String type, String invNum, String notes, String poNum, WebDriver driver) throws
        InterruptedException {
            driver.findElement(By.xpath("//span[contains(text(),'-- Select Invoice Type --')]")).click();
            Thread.sleep(1000);
            driver.findElement(By.className("select2-search__field")).click();
            Thread.sleep(1000);
            driver.findElement(By.className("select2-search__field")).sendKeys(type);
            Thread.sleep(1000);
            driver.findElement(By.className("select2-results__option")).click();
            Thread.sleep(1000);
            //Invoice Number Field
            driver.findElement(By.id("invoiceNumber")).click();
            Thread.sleep(1000);
            driver.findElement(By.id("invoiceNumber")).sendKeys(invNum);
            Thread.sleep(1000);
            //Invoice date Field
            driver.findElement(By.xpath("//body/main[@id='content']/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[3]/input[2]")).click();
            Thread.sleep(1000);
            Select month2 = new Select(driver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/div[1]/select[1]")));
            month2.selectByVisibleText("November");
            WebElement day2 = driver.findElement(By.xpath("//body/div[3]/div[2]/div[1]/div[2]/div[1]/span[28]"));
            day2.click();
            Thread.sleep(1000);
            //Notes Field
            driver.findElement(By.id("notes")).click();
            driver.findElement(By.id("notes")).sendKeys(notes);Thread.sleep(1000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 350)", "");Thread.sleep(1000);
            //Purchase Order Number Field
            driver.findElement(By.xpath("//span[contains(text(),'-- Search by Purchase Order Number --')]")).click();Thread.sleep(1000);
            driver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).click();Thread.sleep(1000);
            driver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).sendKeys(poNum);Thread.sleep(1000);
            driver.findElement(By.className("select2-results__option--highlighted")).click();Thread.sleep(1000);
            JavascriptExecutor js2 = (JavascriptExecutor) driver;
            js2.executeScript("window.scrollBy(0, 750)", "");Thread.sleep(1000);
            //Attachments
            WebElement file = (driver.findElement(By.xpath("//tbody/tr[1]/td[4]/button[1]")));
            file.sendKeys("C:\\Users\\Vidya Abbigeri\\Downloads\\ImportRequisitionYokogawaPOCHWItems (3).xlsx");Thread.sleep(1000);
            //Create Button
            driver.findElement(By.id("btnCreate")).click();
            driver.findElement(By.className("bootbox-accept")).click();
        }
        //Invoice Vendor Logout
        static void vendorLogout4 (WebDriver driver) throws InterruptedException {
            driver.findElement(By.xpath("//header/div[1]/div[2]/ul[1]/li[3]/div[1]/a[1]/div[1]/img[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//a[contains(text(),'out')]")).click();
            Thread.sleep(1000);
        }
        //Buyer ID - Login
        static void buyerLogin3 (String BuyerEmail, String Password, WebDriver driver) throws InterruptedException {
            driver.findElement(By.id("Input_Email")).sendKeys(BuyerEmail);
            Thread.sleep(1000);
            driver.findElement(By.id("Input_Password")).sendKeys(Password);
            Thread.sleep(1000);
            driver.findElement(By.id("login-submit")).click();
            Thread.sleep(1000);
        }
        //Invoice details page
        static void buyerInvoiceDetails (WebDriver driver) throws InterruptedException {
            driver.findElement(By.xpath("//span[contains(text(),'Invoices')]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//tbody/tr[1]/td[7]/a[1]")).click();
            Thread.sleep(1000);
            JavascriptExecutor js2 = (JavascriptExecutor) driver;
            js2.executeScript("window.scrollBy(0, 750)", "");
            Thread.sleep(1000);
            //Invoice 1st CheckList button & popup
            driver.findElement(By.xpath("//tbody/tr[1]/td[6]/button[1]")).click();
            driver.findElement(By.id("selctAllId")).click();
            driver.findElement(By.id("acceptCheckListId")).click();
            JavascriptExecutor js3 = (JavascriptExecutor) driver;
            js3.executeScript("window.scrollBy(0, 350)", "");
            Thread.sleep(1000);
            //Invoice 2nd checklist button & Popup
            driver.findElement(By.xpath("//tbody/tr[2]/td[6]/button[1]")).click();
            driver.findElement(By.id("acceptCheckListId")).click();
            JavascriptExecutor js4 = (JavascriptExecutor) driver;
            js4.executeScript("window.scrollBy(0, 350)", "");
            Thread.sleep(1000);
            //Invoice Verify button
            driver.findElement(By.id("btnAccept")).click();
            driver.findElement(By.className("bootbox-input")).sendKeys("No Remarks");
            driver.findElement(By.xpath("//body/div[4]/div[1]/div[1]/div[3]/button[1]"));
        }
    }