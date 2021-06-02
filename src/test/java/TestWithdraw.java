import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class TestWithdraw {
    WebDriver driver;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bank?serverTimezone=Asia/Ho_Chi_Minh&useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "242999";
    private Connection conn;
    Savepoint savepoint;

    WebElement txtSearch;
    WebElement btnSearch;
    WebElement messError;

    @BeforeTest
    public void initDriver() throws SQLException {
        //Khai báo driver
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void initTest(){
        // Mở trang web
        driver.get("http://localhost:8080/customer");
        driver.manage().window().maximize();
        txtSearch = driver.findElement(By.name("searchKey"));
        btnSearch = driver.findElement(By.id("btn-searchKey"));
    }

    @AfterTest
    public void closeTest() throws SQLException {
        driver.close();
    }


    // tìm khách hàng không đúng số tài khoản - hợp lệ
    @Test   // pass
    public void testFindCustomer_RS24() throws InterruptedException {
        driver.get("http://localhost:8080/customer");
        driver.manage().window().maximize();
        txtSearch = driver.findElement(By.name("searchKey"));
        btnSearch = driver.findElement(By.id("btn-searchKey"));
        txtSearch.sendKeys("12345");
        Thread.sleep(3000);
        btnSearch.click();
        Thread.sleep(3000);
        messError = driver.findElement(By.className("errorMessage"));
        String mes = messError.getText();
        Assert.assertEquals(mes, "Have no result match! Please try again.");
    }

    // tìm khách hàng đúng số tài khoản - hợp lệ
    @Test   // pass
    public void testFindCustomer_RS23() throws InterruptedException, SQLException {
        driver.get("http://localhost:8080/customer");
        driver.manage().window().maximize();
        txtSearch = driver.findElement(By.name("searchKey"));
        btnSearch = driver.findElement(By.id("btn-searchKey"));
        txtSearch.sendKeys("562523");
        Thread.sleep(3000);
        btnSearch.click();
        Thread.sleep(3000);
        WebElement WEnumberAccount = driver.findElement(By.id("number-account"));
        WebElement WEbalance = driver.findElement(By.id("balance"));
        WebElement WEname = driver.findElement(By.id("name"));
        WebElement WEphone = driver.findElement(By.id("phone"));
        WebElement WEidNumber = driver.findElement(By.id("id-number"));
        WebElement WEbtnDetail = driver.findElement(By.id("btn-detail"));
        String sql = "Select a.id, a.balance, c.name, c.id_number, c.phone from account a inner join customer c on a.customer_id = c.id Where a.number_account= 562523";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
            String numberAccount = "562523";
            Long balance = rs.getLong(2);
            String name = rs.getString(3);
            String idNumber = rs.getString(4);
            String phone = rs.getString(5);
            Assert.assertEquals(numberAccount, WEnumberAccount.getText());
            Assert.assertEquals(balance.toString(), WEbalance.getText());
            Assert.assertEquals(name, WEname.getText());
            Assert.assertEquals(phone, WEphone.getText());
            Assert.assertEquals(idNumber, WEidNumber.getText());

        }
    }

    // test tìm kiếm nhập kí từ khác số - không hợp lệ
    @Test   // fail
    public void testFindCustomer_RS22() throws InterruptedException {
        driver.get("http://localhost:8080/customer");
        driver.manage().window().maximize();
        txtSearch = driver.findElement(By.name("searchKey"));
        btnSearch = driver.findElement(By.id("btn-searchKey"));
        txtSearch.sendKeys("abc");
        Thread.sleep(3000);
        btnSearch.click();
        Thread.sleep(3000);
        String mes = driver.switchTo().alert().getText();
        Assert.assertEquals(mes, "Don't allowed to enter letters");
    }

    // nhập tài khoản là toàn là số 0 - không hợp lệ
    @Test   //fail
    public void testFindCustomer_RS26() throws InterruptedException {
        driver.get("http://localhost:8080/customer");
        driver.manage().window().maximize();
        txtSearch = driver.findElement(By.name("searchKey"));
        btnSearch = driver.findElement(By.id("btn-searchKey"));
        txtSearch.sendKeys("000000");
        Thread.sleep(3000);
        btnSearch.click();
        Thread.sleep(3000);
        String mes = driver.switchTo().alert().getText();
        Assert.assertEquals(mes, "account number is not 000000");
    }

    // nhập số tài khoản là số âm - không hợp lệ
    @Test   //fail
    public void testFindCustomer_RS25() throws InterruptedException {
        driver.get("http://localhost:8080/customer");
        driver.manage().window().maximize();
        txtSearch = driver.findElement(By.name("searchKey"));
        btnSearch = driver.findElement(By.id("btn-searchKey"));
        txtSearch.sendKeys("-000001");
        Thread.sleep(3000);
        btnSearch.click();
        Thread.sleep(3000);
        String mes = driver.switchTo().alert().getText();
        Assert.assertEquals(mes, "Account number is not negative.");
    }

    // nhập số tài khoản có 1 số - không hợp lệ
    @Test   //fail
    public void testFindCustomer_RS27() throws InterruptedException {
        driver.get("http://localhost:8080/customer");
        driver.manage().window().maximize();
        txtSearch = driver.findElement(By.name("searchKey"));
        btnSearch = driver.findElement(By.id("btn-searchKey"));
        txtSearch.sendKeys("1");
        Thread.sleep(3000);
        btnSearch.click();
        Thread.sleep(3000);
        String mes = driver.switchTo().alert().getText();
        Assert.assertEquals(mes, "Account number must have 6 digits");
    }

    // nhập số tài khoản có 7 chữ số - không hợp lệ
    @Test   //fail
    public void testFindCustomer_RS28() throws InterruptedException {
        driver.get("http://localhost:8080/customer");
        driver.manage().window().maximize();
        txtSearch = driver.findElement(By.name("searchKey"));
        btnSearch = driver.findElement(By.id("btn-searchKey"));
        txtSearch.sendKeys("1000001");
        Thread.sleep(3000);
        btnSearch.click();
        Thread.sleep(3000);
        String mes = driver.switchTo().alert().getText();
        Assert.assertEquals(mes, "Account number must have 6 digits");
    }

    // test nút bấm có chuyển giao diện đúng chi tiết khách hàng không, và xem dữ liệu ở trang kế tiếp có đúng không
    @Test  // pass
    public void testGUIWebTranfer1() throws InterruptedException, SQLException, ParseException {
        driver.get("http://localhost:8080/customer");
        driver.manage().window().maximize();
        txtSearch = driver.findElement(By.name("searchKey"));
        btnSearch = driver.findElement(By.id("btn-searchKey"));
        txtSearch.sendKeys("562523");
        Thread.sleep(3000);
        btnSearch.click();
        Thread.sleep(3000);
        WebElement btnDetail = driver.findElement(By.id("btn-detail"));
        btnDetail.click();
        Thread.sleep(3000);
        String title = driver.getTitle();
        Assert.assertEquals(title, "Customer | Detail");
        Thread.sleep(3000);
        WebElement WEnumberAccount = driver.findElement(By.id("number-account"));
        WebElement WEUsername = driver.findElement(By.id("username"));
        WebElement WEbalance = driver.findElement(By.id("balance"));
        WebElement WEBirthday = driver.findElement(By.id("birthday"));
        WebElement WEname = driver.findElement(By.id("fullname"));
        WebElement WEpermanentAddress = driver.findElement(By.id("permanent-address"));
        WebElement WEHometown = driver.findElement(By.id("home-town"));
        WebElement WEEmail = driver.findElement(By.id("email"));
        WebElement WEphone = driver.findElement(By.id("phone"));
        WebElement WEidNumber = driver.findElement(By.id("id-number"));
        String sql = "Select a.id, a.username, a.balance, c.name, c.id_number, c.birthday, c.phone, c.email, c.home_town, c.permanent_address from account a inner join customer c on a.customer_id = c.id Where a.number_account= 562523";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
            String numberAccount = "562523";
            String username = rs.getString(2);
            Long balance = rs.getLong(3);
            String name = rs.getString(4);
            String idNumber = rs.getString(5);
            Date birthday = rs.getDate(6);
            String phone = rs.getString(7);
            String email = rs.getString(8);
            String homeTown = rs.getString(9);
            String permanentAddress = rs.getString(10);
            Assert.assertEquals(numberAccount, WEnumberAccount.getText());
            Assert.assertEquals(balance.toString(), WEbalance.getText());
            Assert.assertEquals(name, WEname.getText());
            Assert.assertEquals(phone, WEphone.getText());
            Assert.assertEquals(idNumber, WEidNumber.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Assert.assertEquals(birthday, sdf.parse(WEBirthday.getText()));
            Assert.assertEquals(email, WEEmail.getText());
            Assert.assertEquals(homeTown, WEHometown.getText());
            Assert.assertEquals(permanentAddress, WEpermanentAddress.getText());
            Assert.assertEquals(username, WEUsername.getText());
        }

    }

    // test nút bấm rút sổ có chuyển giao diện sang giao diện rút tiền
    @Test // pass
    public void testGUIWebTranfer2() throws InterruptedException {
        driver.get("http://localhost:8080/customer/detail/1");
        driver.manage().window().maximize();
        WebElement btnWithdraw = driver.findElement(By.id("btn-withdraw1"));
        Thread.sleep(3000);
        btnWithdraw.click();
        Assert.assertEquals(driver.getTitle(), "Customer | Withdraw");
    }

    // kiểm tra database khi xác nhận rút sổ
    @Test
    public void testDBWithdraw() throws SQLException, InterruptedException {

        driver.get("http://localhost:8080/booksaving/withdraw-info/1");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        WebElement btnConfirm = driver.findElement(By.id("btn-confirm"));
        btnConfirm.click();
        Thread.sleep(3000);
        String messAlert = driver.switchTo().alert().getText();
        Assert.assertEquals(messAlert, "Successfully withdrawn savings book!");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        String sql = "select b.withdraw_date from book_saving b inner join account a on b.account_id = a.id " +
                "where a.number_account = 562523 and b.id = 1";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
            Date dateWithdraw = rs.getDate(1);
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Assert.assertEquals(sdf.format(dateWithdraw), "02-06-2021");
        }
    }


}
