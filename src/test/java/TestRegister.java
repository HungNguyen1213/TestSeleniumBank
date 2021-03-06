import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class TestRegister {
    WebDriver driver;
    WebElement txtFullName;
    WebElement txtUsername;
    WebElement txtPassword;
    WebElement txtConfirmPassword;
    WebElement txtDob;
    WebElement txtCINumber;
    WebElement txtEmail;
    WebElement txtPhone;
    WebElement txtPermanentAddress;
    WebElement txtHometown;
    WebElement txtNumberAccount;
    WebElement txtBalance;
    WebElement btnRegister;
    @BeforeTest
    public void initDriver(){
        //Khai driver
        System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void initTest(){
        //Mo trang web
        driver.get("http://localhost:8080/customer/register");
        driver.manage().window().maximize();
        //init Element
        txtFullName = driver.findElement(By.id("name"));
        txtUsername = driver.findElement(By.id("username"));
        txtPassword = driver.findElement(By.id("password"));
        txtConfirmPassword = driver.findElement(By.id("confirm-password"));
        txtDob = driver.findElement(By.id("birthday"));
        txtCINumber = driver.findElement(By.id("idNumber"));
        txtEmail = driver.findElement(By.id("email"));
        txtPhone = driver.findElement(By.id("phone"));
        txtPermanentAddress = driver.findElement(By.id("permanent-address"));
        txtHometown = driver.findElement(By.id("home-town"));
        txtNumberAccount = driver.findElement(By.id("number-account"));
        txtBalance = driver.findElement(By.id("balance"));
        btnRegister = driver.findElement(By.id("btnRegister"));
    }

    @AfterTest
    public void closeTest(){
        driver.close();
    }

    @Test
    public void testRegisterSuccess() throws InterruptedException {
        txtFullName.sendKeys("Nguy???n Huy H??ng");
        txtUsername.sendKeys("hungnh");
        txtPassword.sendKeys("huyhung99");
        txtConfirmPassword.sendKeys("huyhung99");
        txtDob.sendKeys("20/10/1999");
        txtEmail.sendKeys("hungnh99.ptit@gmail.com");
        txtPhone.sendKeys("0364441092");
        txtPermanentAddress.sendKeys("S??? nh?? 108/58 Tr???n Ph??");
        txtHometown.sendKeys("H?? Nam");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("168596751");

        btnRegister.click();

        Thread.sleep(3000);

        String expectedTitle = "Customer | Register Successfully";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }


    //
    //Test de trong cac truong
    //
    //


    @Test
    public void testFullnameEmpty() throws InterruptedException {
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("S??? nh?? 108/58 Tr???n Ph??");
        txtHometown.sendKeys("H?? N???i");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

        Assert.assertTrue(txtFullName.isDisplayed());
    }

    @Test
    public void testUsernameEmpty() throws InterruptedException {
        txtFullName.sendKeys("Nguy???n V??n Chung");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("S??? nh?? 108/58 Tr???n Ph??");
        txtHometown.sendKeys("H?? N???i");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

        Assert.assertTrue(txtUsername.isDisplayed());
    }

    @Test
    public void testPasswordEmpty() {
        txtUsername.sendKeys("jinylove");
        txtFullName.sendKeys("Nguy???n V??n Chung");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("S??? nh?? 108/58 Tr???n Ph??");
        txtHometown.sendKeys("H?? N???i");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);

        Alert alert = wait.until(new ExpectedCondition<Alert>() {
            @NullableDecl
            @Override
            public Alert apply(@NullableDecl WebDriver webDriver) {
                return driver.switchTo().alert();
            }
        });
        alert.accept();

        Assert.assertTrue(txtPassword.isDisplayed());
    }

    @Test
    public void testConfirmPasswordEmpty() {
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtFullName.sendKeys("Nguy???n V??n Chung");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("S??? nh?? 108/58 Tr???n Ph??");
        txtHometown.sendKeys("H?? N???i");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);

        Alert alert = wait.until(new ExpectedCondition<Alert>() {
            @NullableDecl
            @Override
            public Alert apply(@NullableDecl WebDriver webDriver) {
                return driver.switchTo().alert();
            }
        });
        alert.accept();
        Assert.assertTrue(txtConfirmPassword.isDisplayed());
    }

    @Test
    public void testDateOfBirthEmpty() throws InterruptedException {
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtFullName.sendKeys("Nguy???n V??n Chung");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("S??? nh?? 108/58 Tr???n Ph??");
        txtHometown.sendKeys("H?? N???i");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

        Assert.assertTrue(txtDob.isDisplayed());

    }

    @Test
    public void testCINumberEmpty() throws InterruptedException {
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("S??? nh?? 108/58 Tr???n Ph??");
        txtHometown.sendKeys("H?? N???i");
        txtBalance.sendKeys("88888888");
        txtFullName.sendKeys("Nguy???n V??n Chung");

        btnRegister.click();

        Thread.sleep(1000);

        Assert.assertTrue(txtCINumber.isDisplayed());
    }

    @Test
    public void testEmailEmpty() throws InterruptedException {
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtFullName.sendKeys("Nguy???n V??n Chung");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("S??? nh?? 108/58 Tr???n Ph??");
        txtHometown.sendKeys("H?? N???i");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

        Assert.assertTrue(txtEmail.isDisplayed());
    }

    @Test
    public void testPhoneEmpty() throws InterruptedException {
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtFullName.sendKeys("Nguy???n V??n Chung");
        txtPermanentAddress.sendKeys("S??? nh?? 108/58 Tr???n Ph??");
        txtHometown.sendKeys("H?? N???i");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

        Assert.assertTrue(txtPhone.isDisplayed());
    }

    @Test
    public void testPermanentAddressEmpty() throws InterruptedException {
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtFullName.sendKeys("Nguy???n V??n Chung");
        txtHometown.sendKeys("H?? N???i");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

        Assert.assertTrue(txtPermanentAddress.isDisplayed());
    }

    @Test
    public void testHometownEmpty() throws InterruptedException {
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("S??? nh?? 108/58 Tr???n Ph??");
        txtFullName.sendKeys("Nguy???n V??n Chung");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

        Assert.assertTrue(txtHometown.isDisplayed());
    }

    @Test
    public void testBalanceEmpty() throws InterruptedException {
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("S??? nh?? 108/58 Tr???n Ph??");
        txtHometown.sendKeys("H?? N???i");
        txtFullName.sendKeys("Nguy???n V??n Chung");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

        Assert.assertTrue(txtBalance.isDisplayed());
    }

    //
    //Test sai dinh dang cac truong
    //
    //

    //method checkMessage from alert
    public void checkAlert(String expectedMessage){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Alert alert = null;
        try{
            alert = wait.until(new ExpectedCondition<Alert>() {
                @NullableDecl
                @Override
                public Alert apply(@NullableDecl WebDriver webDriver) {
                    try{
                        return driver.switchTo().alert();
                    }
                    catch(NoAlertPresentException e){
                        return null;
                    }
                }
            });
        } catch(WebDriverException ignored){}
        if(alert!=null){
            Assert.assertEquals(expectedMessage, alert.getText());
            alert.accept();
        }
        else Assert.assertNotNull(null);
    }

    @Test
    public void testUsernameFormat() {
        txtFullName.sendKeys("Nguy???n V??n Chung");
        txtUsername.sendKeys("nguy???nchung");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("S??? nh?? 108/58 Tr???n Ph??");
        txtHometown.sendKeys("H?? N???i");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        String expectedMessage = "Username nh???p sai ?????nh d???ng.";
        checkAlert(expectedMessage);
    }

    @Test
    public void testPasswordFormat() {
        txtFullName.sendKeys("Nguy???n V??n Chung");
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("321acd");
        txtConfirmPassword.sendKeys("321acd");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("S??? nh?? 108/58 Tr???n Ph??");
        txtHometown.sendKeys("H?? N???i");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        String expectedMessage = "Password nh???p sai ?????nh d???ng.";
        checkAlert(expectedMessage);
    }

    @Test
    public void testConfirmPasswordFormat() {
        //Kiem tra password nhap lai co khop voi password da nhap o tren ko
        txtFullName.sendKeys("Nguy???n V??n Chung");
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove123");
        txtConfirmPassword.sendKeys("jinylove321");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("S??? nh?? 108/58 Tr???n Ph??");
        txtHometown.sendKeys("H?? N???i");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        String expectedMessage = "password and confirm password are not matching";
        checkAlert(expectedMessage);
    }

    @Test
    public void testDateOfBirthFormat() {
        txtFullName.sendKeys("Nguy???n V??n Chung");
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/thang5-1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("S??? nh?? 108/58 Tr???n Ph??");
        txtHometown.sendKeys("H?? N???i");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        String expectedMessage = "Date of birth nh???p sai ?????nh d???ng.";
        checkAlert(expectedMessage);
    }

    @Test
    public void testCINumberFormat() {
        txtFullName.sendKeys("Nguy???n V??n Chung");
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("S??? nh?? 108/58 Tr???n Ph??");
        txtHometown.sendKeys("H?? N???i");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("98765ABCD");

        btnRegister.click();

        String expectedMessage = "Citizen identification number nh???p sai ?????nh d???ng.";
        checkAlert(expectedMessage);

    }

    @Test
    public void testEmailFormat() {
        txtFullName.sendKeys("Nguy???n V??n Chung");
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname.gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("S??? nh?? 108/58 Tr???n Ph??");
        txtHometown.sendKeys("H?? N???i");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Assert.assertTrue(txtEmail.isDisplayed());
    }

    @Test
    public void testPhoneFormat() {
        txtFullName.sendKeys("Nguy???n V??n Chung");
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("038ACDBA");
        txtPermanentAddress.sendKeys("S??? nh?? 108/58 Tr???n Ph??");
        txtHometown.sendKeys("H?? N???i");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        String expectedMessage = "Phone nh???p sai ?????nh d???ng.";
        checkAlert(expectedMessage);
    }

    @Test
    public void testBalanceFormat() {
        txtFullName.sendKeys("Nguy???n V??n Chung");
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("S??? nh?? 108/58 Tr???n Ph??");
        txtHometown.sendKeys("H?? N???i");
        txtBalance.sendKeys("888AABC88");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        String expectedMessage = "Balance nh???p sai ?????nh d???ng.";
        checkAlert(expectedMessage);
    }


    //
    //Test sai logic
    //
    //

    @Test
    public void testLogic1() {
        //??ang ki trung username
        txtFullName.sendKeys("Nguy???n V??n Chung");
        txtUsername.sendKeys("congtm");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("S??? nh?? 108/58 Tr???n Ph??");
        txtHometown.sendKeys("H?? N???i");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        String expectedMessage = "????ng k?? th???t b???i. Username ???? t???n t???i.";
        checkAlert(expectedMessage);
    }

    @Test
    public void testLogic2() {
        //Dang ki trung Account number
        txtFullName.sendKeys("Nguy???n V??n Chung");
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("S??? nh?? 108/58 Tr???n Ph??");
        txtHometown.sendKeys("H?? N???i");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        String expectedMessage = "????ng k?? th???t b???i. Number account ???? t???n t???i.";
        checkAlert(expectedMessage);
    }

    @Test
    public void testLogic3() {
        //Date of birth lon hon ngay hien tai
        txtFullName.sendKeys("Nguy???n V??n Chung");
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("29/12/2021");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("S??? nh?? 108/58 Tr???n Ph??");
        txtHometown.sendKeys("H?? N???i");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        String expectedMessage = "Ng??y sinh kh??ng ???????c ph??p l???n h??n ng??y hi???n t???i.";
        checkAlert(expectedMessage);
    }

    @Test
    public void testLogic4() {
        //Khach hang < 15 tuoi
        txtFullName.sendKeys("Nguy???n V??n Chung");
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("29/12/2014");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("S??? nh?? 108/58 Tr???n Ph??");
        txtHometown.sendKeys("H?? N???i");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        String expectedMessage = "Kh??ch h??ng ch??a ????? 15 tu???i ????? ????ng k?? t??i kho???n.";
        checkAlert(expectedMessage);
    }

    @Test
    public void testLogic5() {
        //Balance < 50000
        txtFullName.sendKeys("Nguy???n V??n Chung");
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("S??? nh?? 108/58 Tr???n Ph??");
        txtHometown.sendKeys("H?? N???i");
        txtBalance.sendKeys("0");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        String expectedMessage = "S??? d?? ph???i >= 50000";
        checkAlert(expectedMessage);
    }
}
