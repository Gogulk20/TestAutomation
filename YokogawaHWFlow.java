import org.openqa.selenium.*;

public class YokogawaHWFlow {
    //Login with Requester
    static void loginpage(String ReqEmail, String Password, WebDriver datahw) throws InterruptedException {

        datahw.findElement(By.id("Input_Email")).sendKeys(ReqEmail);Thread.sleep(1000);
        datahw.findElement(By.id("Input_Password")).sendKeys(Password);Thread.sleep(1000);
        datahw.findElement(By.id("login-submit")).click();Thread.sleep(1000);
    }
    //Create button
    static void create(WebDriver datahw) throws InterruptedException {
        datahw.findElement(By.className("btn-primary")).click();Thread.sleep(1000);
        datahw.findElement(By.xpath("//tbody/tr[4]/td[1]/a[1]")).click();Thread.sleep(1000);
    }
    //PR Yokogawa Title
    static void title(String Title, WebDriver datahw) throws InterruptedException {
        datahw.findElement(By.id("title")).sendKeys(Title);Thread.sleep(1000);
    }
    //PR Yokogawa Ship To Yokogawa check bOx
    static void ShipToYokogawa(WebDriver datahw) throws InterruptedException {
        datahw.findElement(By.id("shipToYokogawa")).click();Thread.sleep(1000);
    }
    //PR Yokogawa Project Field
    static void project(String projectCode, WebDriver datahw) throws InterruptedException {
        datahw.findElement(By.id("select2-projectId-container")).click();Thread.sleep(1000);
        datahw.findElement(By.className("select2-search__field")).sendKeys(projectCode);Thread.sleep(1000);
        datahw.findElement(By.className("select2-results__option")).click();Thread.sleep(1000);
    }
    //PR Yokogawa WBS Field
    static void wbs(String wbsCode, WebDriver datahw) throws InterruptedException {
        datahw.findElement(By.id("select2-wbsId-container")).click();Thread.sleep(1000);
        datahw.findElement(By.className("select2-search__field")).sendKeys(wbsCode);Thread.sleep(1000);
        datahw.findElement(By.className("select2-results__option")).click();Thread.sleep(1000);
    }
    //PR Yokogawa Checker Field
    static void checker(String CheckEmail, WebDriver datahw) throws InterruptedException {
        datahw.findElement(By.id("select2-checkerId-container")).click();Thread.sleep(1000);
        datahw.findElement(By.className("select2-search__field")).sendKeys(CheckEmail);Thread.sleep(1000);
        datahw.findElement(By.className("select2-results__option")).click();Thread.sleep(1000);
    }
    //PR Yokogawa Shipping Address Field
    static void shippingAddress(WebDriver datahw) throws InterruptedException {
        datahw.findElement(By.id("select2-shippingaddressId-container")).click();Thread.sleep(1000);
        datahw.findElement(By.className("select2-results__option")).click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) datahw;
        js.executeScript("window.scrollBy(0,350)","");
    }
    //PR Yokogawa Expected Po Date Field
    static void expectedPODate(WebDriver datahw) throws InterruptedException {
        datahw.findElement(By.xpath("//body/main[@id='content']/div[1]/form[1]/div[1]/div[2]/div[2]/div[1]/input[2]")).click();Thread.sleep(1000);
        datahw.findElement(By.xpath("//body/div[4]/div[2]/div[1]/div[2]/div[1]/span[28]")).click();Thread.sleep(1000);
    }
    //PR Yokogawa Expected Delivery date Field
    static void expectedDeliveryDate(WebDriver datahw) throws InterruptedException {
        datahw.findElement(By.xpath("//body/main[@id='content']/div[1]/form[1]/div[1]/div[2]/div[2]/div[2]/input[2]")).click();Thread.sleep(1000);
        datahw.findElement(By.xpath("//body/div[5]/div[2]/div[1]/div[2]/div[1]/span[35]")).click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) datahw;
        js.executeScript("window.scrollBy(0,550)","");Thread.sleep(1000);
    }
    //PR Yokogawa TCAS Field
//    static void Tcas(WebDriver datahw) throws InterruptedException {
//        datahw.findElement(By.id("tcasApplicable")).click();Thread.sleep(1000);
//    }
//PR Yokogawa TCAS Popup Field
//    static void Tcaspopup(WebDriver datahw) throws InterruptedException {
//        datahw.findElement(By.id("q1")).click();
//        datahw.findElement(By.id("q2")).click();
//        datahw.findElement(By.id("q3")).click();
//        datahw.findElement(By.id("q4")).click();
//        datahw.findElement(By.id("q5")).click();
//        datahw.findElement(By.id("q6")).click();
//        datahw.findElement(By.id("q7")).click();
//        datahw.findElement(By.id("q8")).click();Thread.sleep(1000);
//    }
//PR Yokogawa TCAS Number Field
//    static void TcasNumber(String number, WebDriver datahw) throws InterruptedException {
//        datahw.findElement(By.id("tcasNumber")).click();Thread.sleep(1000);
//        datahw.findElement(By.id("tcasNumber")).sendKeys(number);Thread.sleep(1000);
//    }
//PR Yokogawa TCAS Documents Field
//    static void TcasDocument(String docName, WebDriver datahw) throws InterruptedException {
//        WebElement upload = datahw.findElement(By.id("btnFileUpload"));
//        upload.sendKeys(docName);
//    }
//PR Yokogawa HW Items Import Field
    static void hwItems(String hwFile, WebDriver datahw) throws InterruptedException {
        datahw.findElement(By.id("hwItemsId")).click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) datahw;
        js.executeScript("window.scrollBy(0,350)","");Thread.sleep(1000);
        datahw.findElement(By.id("iHWItem")).click();Thread.sleep(1000);
        WebElement upload = datahw.findElement(By.id("formFileHW"));Thread.sleep(1000);
        upload.sendKeys(hwFile);
        datahw.findElement(By.id("btnHWUpload")).click();Thread.sleep(30000);
    }
    //PR Yokogawa Notes Field
    static void notes(String note, WebDriver datahw) throws InterruptedException {Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) datahw;
        js.executeScript("window.scrollBy(0,350)","");Thread.sleep(1000);
        datahw.findElement(By.id("notes")).click();Thread.sleep(1000);
        datahw.findElement(By.id("notes")).sendKeys(note);Thread.sleep(1000);
    }
    //PR Yokogawa Attachments Field
    static void attachments(String file, WebDriver datahw) throws InterruptedException {
        datahw.findElement(By.id("attachDocs")).click();Thread.sleep(1000);
        WebElement upload = datahw.findElement(By.id("formFilePreupload"));Thread.sleep(1000);
        upload.sendKeys(file);Thread.sleep(1000);
        datahw.findElement(By.id("saveAttachments")).click();Thread.sleep(1000);
        datahw.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) datahw;
        js.executeScript("window.scrollBy(0,350)","");Thread.sleep(1000);
    }
    //PR Yokogawa Create Draft Button Field
    static void createDraft(WebDriver datahw) throws InterruptedException {
        datahw.findElement(By.id("btnCreate")).click();Thread.sleep(1000);
        datahw.findElement(By.className("bootbox-accept")).click();Thread.sleep(1000);
    }
    //PR Details - Send for Approval
    static void SendForApproval(WebDriver datahw) throws InterruptedException {
        datahw.findElement(By.id("btnSendApproval")).click();Thread.sleep(1000);
        datahw.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();Thread.sleep(1000);;
    }
    //PR Details - Log Out the Requester ID
    static void requesterlogOut(WebDriver datahw) throws InterruptedException {
        datahw.findElement(By.xpath("//header/div[1]/div[2]/ul[1]/li[3]/div[1]/a[1]/div[1]/img[1]")).click();Thread.sleep(1000);
        datahw.findElement(By.xpath("//a[contains(text(),'out')]")).click();Thread.sleep(1000);
    }
    //PR Yokogawa checker ID - Login
    static void checkerLogin(String CheckEmail, String Password, WebDriver datahw) throws InterruptedException {
        datahw.findElement(By.id("Input_Email")).sendKeys(CheckEmail);Thread.sleep(1000);
        datahw.findElement(By.id("Input_Password")).sendKeys(Password);Thread.sleep(1000);
        datahw.findElement(By.id("login-submit")).click();Thread.sleep(1000);
    }
    //PR Yokogawa Checker Details page
    static void checkerDetailsPage(WebDriver datahw) throws InterruptedException {
        datahw.findElement(By.xpath("//tbody/tr[1]/td[6]/a[1]")).click();;Thread.sleep(1000);
        WebElement button = datahw.findElement(By.id("btnApprove"));
        button.sendKeys(Keys.DOWN);
    }
    //PR Yokogawa Checker Details page - Approve button
    static void approveButton(WebDriver datahw) throws InterruptedException {
        datahw.findElement(By.id("btnApprove")).click();Thread.sleep(1000);
        datahw.findElement(By.className("bootbox-accept")).click();Thread.sleep(1000);
    }
    //PR Yokogawa Checker Logout
    static void logOutChecker(WebDriver datahw) throws InterruptedException {
        datahw.findElement(By.xpath("//header/div[1]/div[2]/ul[1]/li[3]/div[1]/a[1]/div[1]/img[1]")).click();Thread.sleep(1000);
        datahw.findElement(By.xpath("//a[contains(text(),'out')]")).click();Thread.sleep(1000);
    }
    //PR Yokogawa Requester Login
    static void requesterLogin(String ReqEmail, String Password, WebDriver datahw) throws InterruptedException {
        datahw.findElement(By.id("Input_Email")).sendKeys(ReqEmail);Thread.sleep(1000);
        datahw.findElement(By.id("Input_Password")).sendKeys(Password);Thread.sleep(1000);
        datahw.findElement(By.id("login-submit")).click();Thread.sleep(1000);
    }
    //PR Yokogawa Requester Details page
    static void requesterDetails(String Title, WebDriver datahw) throws InterruptedException {
        datahw.findElement(By.xpath("//span[contains(text(),'"+ Title+"')]")).click();Thread.sleep(1000);
    }
    //PR Yokogawa Requester - Create POR button
    static void createPorButton(WebDriver datahw) throws InterruptedException {
        datahw.findElement(By.id("btnCreatePOR")).click();Thread.sleep(1000);
    }
    //PR Yokogawa Create POR page - Standard TF field
    static void createPorPageStf(String stp, WebDriver datahw) throws InterruptedException {
        WebElement stf = datahw.findElement(By.id("standardTF"));
        stf.sendKeys(Keys.DOWN);
        datahw.findElement(By.id("standardTF")).sendKeys(stp);Thread.sleep(1000);
    }
    //PR Yokogawa Create POR page - STTP Discount field
    static void SttpDiscount(String discount, WebDriver datahw) throws InterruptedException {
        WebElement sttp = datahw.findElement(By.xpath("//input[@id='sstpDiscount']"));
        sttp.sendKeys(Keys.DOWN);
        datahw.findElement(By.xpath("//input[@id='sstpDiscount']")).sendKeys(discount);Thread.sleep(1000);
    }
    //PR Yokogawa Create POR page - Additional Notes field
    static void additionalNotes(String notes, WebDriver datahw) throws InterruptedException {
        WebElement note = datahw.findElement(By.id("specialInstructions"));
        note.sendKeys(Keys.DOWN);
        datahw.findElement(By.id("specialInstructions")).sendKeys(notes);Thread.sleep(1000);
    }
    //PR Yokogawa Create POR page - Create POR Button
    static void createPor(WebDriver datahw) throws InterruptedException {
        WebElement button = datahw.findElement(By.id("btnCreate"));
        button.sendKeys(Keys.DOWN);
        button.click();Thread.sleep(1000);
        datahw.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
    }
}