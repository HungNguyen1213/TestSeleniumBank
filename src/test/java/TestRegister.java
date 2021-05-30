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
    public void testLoginSuccess() throws InterruptedException {
        txtFullName.sendKeys("Nguyễn Huy Hùng");
        txtUsername.sendKeys("hungnh");
        txtPassword.sendKeys("huyhung99");
        txtConfirmPassword.sendKeys("huyhung99");
        txtDob.sendKeys("20/10/1999");
        txtEmail.sendKeys("hungnh99.ptit@gmail.com");
        txtPhone.sendKeys("0364441092");
        txtPermanentAddress.sendKeys("Số nhà 108/58 Trần Phú");
        txtHometown.sendKeys("Hà Nam");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("168596751");

        btnRegister.click();

        Thread.sleep(3000);

        String expectedTitle = "Customer | Register Successfully";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void testFullnameEmpty() throws InterruptedException {
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("Số nhà 108/58 Trần Phú");
        txtHometown.sendKeys("Hà Nội");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

        Assert.assertTrue(txtFullName.isDisplayed());
    }

    @Test
    public void testUsernameEmpty() throws InterruptedException {
        txtFullName.sendKeys("Nguyễn Văn Chung");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("Số nhà 108/58 Trần Phú");
        txtHometown.sendKeys("Hà Nội");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

    }

    @Test
    public void testPasswordEmpty() {
        txtUsername.sendKeys("jinylove");
        txtFullName.sendKeys("Nguyễn Văn Chung");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("Số nhà 108/58 Trần Phú");
        txtHometown.sendKeys("Hà Nội");
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

    }

    @Test
    public void testConfirmPasswordEmpty() {
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtFullName.sendKeys("Nguyễn Văn Chung");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("Số nhà 108/58 Trần Phú");
        txtHometown.sendKeys("Hà Nội");
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
    }

    @Test
    public void testDateOfBirthEmpty() throws InterruptedException {
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtFullName.sendKeys("Nguyễn Văn Chung");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("Số nhà 108/58 Trần Phú");
        txtHometown.sendKeys("Hà Nội");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

    }

    @Test
    public void testCINumberEmpty() throws InterruptedException {
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("Số nhà 108/58 Trần Phú");
        txtHometown.sendKeys("Hà Nội");
        txtBalance.sendKeys("88888888");
        txtFullName.sendKeys("Nguyễn Văn Chung");

        btnRegister.click();

        Thread.sleep(1000);

    }

    @Test
    public void testEmailEmpty() throws InterruptedException {
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtFullName.sendKeys("Nguyễn Văn Chung");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("Số nhà 108/58 Trần Phú");
        txtHometown.sendKeys("Hà Nội");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

    }

    @Test
    public void testPhoneEmpty() throws InterruptedException {
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtFullName.sendKeys("Nguyễn Văn Chung");
        txtPermanentAddress.sendKeys("Số nhà 108/58 Trần Phú");
        txtHometown.sendKeys("Hà Nội");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

    }

    @Test
    public void testPermanentAddressEmpty() throws InterruptedException {
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtFullName.sendKeys("Nguyễn Văn Chung");
        txtHometown.sendKeys("Hà Nội");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

    }

    @Test
    public void testHometownEmpty() throws InterruptedException {
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("Số nhà 108/58 Trần Phú");
        txtFullName.sendKeys("Nguyễn Văn Chung");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

    }

    @Test
    public void testBalanceEmpty() throws InterruptedException {
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("Số nhà 108/58 Trần Phú");
        txtHometown.sendKeys("Hà Nội");
        txtFullName.sendKeys("Nguyễn Văn Chung");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

    }

    @Test
    public void testUsernameFormat() throws InterruptedException {
        txtFullName.sendKeys("Nguyễn Văn Chung");
        txtUsername.sendKeys("nguyễnchung");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("Số nhà 108/58 Trần Phú");
        txtHometown.sendKeys("Hà Nội");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

    }

    @Test
    public void testPasswordFormat() throws InterruptedException {
        txtFullName.sendKeys("Nguyễn Văn Chung");
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("321acd");
        txtConfirmPassword.sendKeys("321acd");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("Số nhà 108/58 Trần Phú");
        txtHometown.sendKeys("Hà Nội");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

    }

    @Test
    public void testConfirmPasswordFormat() {
        txtFullName.sendKeys("Nguyễn Văn Chung");
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove123");
        txtConfirmPassword.sendKeys("jinylove321");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("Số nhà 108/58 Trần Phú");
        txtHometown.sendKeys("Hà Nội");
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

    }

    @Test
    public void testDateOfBirthFormat() throws InterruptedException {
        txtFullName.sendKeys("Nguyễn Văn Chung");
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/thang5-1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("Số nhà 108/58 Trần Phú");
        txtHometown.sendKeys("Hà Nội");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

    }

    @Test
    public void testCINumberFormat() throws InterruptedException {
        txtFullName.sendKeys("Nguyễn Văn Chung");
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("Số nhà 108/58 Trần Phú");
        txtHometown.sendKeys("Hà Nội");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("98765ABCD");

        btnRegister.click();

        Thread.sleep(1000);

    }

    @Test
    public void testEmailFormat() throws InterruptedException {
        txtFullName.sendKeys("Nguyễn Văn Chung");
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname.gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("Số nhà 108/58 Trần Phú");
        txtHometown.sendKeys("Hà Nội");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

    }

    @Test
    public void testPhoneFormat() throws InterruptedException {
        txtFullName.sendKeys("Nguyễn Văn Chung");
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("038ACDBA");
        txtPermanentAddress.sendKeys("Số nhà 108/58 Trần Phú");
        txtHometown.sendKeys("Hà Nội");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

    }

    @Test
    public void testBalanceFormat() throws InterruptedException {
        txtFullName.sendKeys("Nguyễn Văn Chung");
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("Số nhà 108/58 Trần Phú");
        txtHometown.sendKeys("Hà Nội");
        txtBalance.sendKeys("888AABC88");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

    }

    @Test
    public void testLogic1() throws InterruptedException {
        //Đang ki trung username
        txtFullName.sendKeys("Nguyễn Văn Chung");
        txtUsername.sendKeys("congtm");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("Số nhà 108/58 Trần Phú");
        txtHometown.sendKeys("Hà Nội");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

    }

    @Test
    public void testLogic2() throws InterruptedException {
        //Dang ki trung Account number
        txtFullName.sendKeys("Nguyễn Văn Chung");
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("Số nhà 108/58 Trần Phú");
        txtHometown.sendKeys("Hà Nội");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

    }

    @Test
    public void testLogic3() throws InterruptedException {
        //Date of birth lon hon ngay hien tai
        txtFullName.sendKeys("Nguyễn Văn Chung");
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("29/12/2021");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("Số nhà 108/58 Trần Phú");
        txtHometown.sendKeys("Hà Nội");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

    }

    @Test
    public void testLogic4() throws InterruptedException {
        //Khach hang < 15 tuoi
        txtFullName.sendKeys("Nguyễn Văn Chung");
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("29/12/2014");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("Số nhà 108/58 Trần Phú");
        txtHometown.sendKeys("Hà Nội");
        txtBalance.sendKeys("88888888");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

    }

    @Test
    public void testLogic5() throws InterruptedException {
        //Balance < 50000
        txtFullName.sendKeys("Nguyễn Văn Chung");
        txtUsername.sendKeys("jinylove");
        txtPassword.sendKeys("jinylove");
        txtConfirmPassword.sendKeys("jinylove");
        txtDob.sendKeys("19/05/1999");
        txtEmail.sendKeys("noname@gmail.com");
        txtPhone.sendKeys("0383893425");
        txtPermanentAddress.sendKeys("Số nhà 108/58 Trần Phú");
        txtHometown.sendKeys("Hà Nội");
        txtBalance.sendKeys("0");
        txtCINumber.sendKeys("987654321");

        btnRegister.click();

        Thread.sleep(1000);

    }
}
