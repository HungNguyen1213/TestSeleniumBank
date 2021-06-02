package testDeposit;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestDeposit extends TestDriver {
	ChromeDriver driver = getDriver();
	
	
	@BeforeEach
	public void beforeTest() {
		driver.get("http://localhost:8080//customer");
		driver.manage().window().maximize();
	}
	@AfterEach
	public void afterTest() {
		driver.close();
	}
	
	@Test //Tim kiem hop le
	public void validly_find() {
		driver.findElement(By.name("searchKey")).sendKeys("656221");
		driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/button[1]")).click();
	}
	@Test //Tim kiem khong hop le (Nhap tai khoan so am)
	public void invalidly_find1() {
		driver.findElement(By.name("searchKey")).sendKeys("-1");
		driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/button[1]")).click();
		
		String actual = driver.findElement(By.xpath("//h4[contains(text(),'Have no result match! Please try again.')]")).getText();
		String expected = "Have no result match! Please try again.";
		Assert.assertEquals(actual, expected);
		System.out.println("invalid_find1 PASSED");
		}
	
	@Test //Tim kiem khong hop le (Nhap tai khoan so 0)
	public void invalidly_find2() {
		driver.findElement(By.name("searchKey")).sendKeys("0");
		driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/button[1]")).click();
		String actual = driver.findElement(By.xpath("//h4[contains(text(),'Have no result match! Please try again.')]")).getText();
		String expected = "Have no result match! Please try again.";
		Assert.assertEquals(actual, expected);
		System.out.println("invalid_find2 PASSED");
		}
	
	@Test //Tim kiem khong hop le (Nhap tai khoan co mot ky tu so)
	public void invalidly_find3() {
		driver.findElement(By.name("searchKey")).sendKeys("5");
		driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/button[1]")).click();
		String actual = driver.findElement(By.xpath("//h4[contains(text(),'Have no result match! Please try again.')]")).getText();
		String expected = "Have no result match! Please try again.";
		Assert.assertEquals(actual, expected);
		System.out.println("invalid_find3 PASSED");
		}
	
	@Test //Tim kiem khong hop le (Nhap tai khoan co 7 ky tu so)
	public void invalidly_find4() {
		driver.findElement(By.name("searchKey")).sendKeys("9875674");
		driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/button[1]")).click();
		String actual = driver.findElement(By.xpath("//h4[contains(text(),'Have no result match! Please try again.')]")).getText();
		String expected = "Have no result match! Please try again.";
		Assert.assertEquals(actual, expected);
		System.out.println("invalid_find4 PASSED");
		}
	
	@Test //Tim kiem khong hop le (Nhap tai khoan chua du 6 ky tu so)
	public void invalidly_find5() {
		driver.findElement(By.name("searchKey")).sendKeys("5436");
		driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/button[1]")).click();
		String actual = driver.findElement(By.xpath("//h4[contains(text(),'Have no result match! Please try again.')]")).getText();
		String expected = "Have no result match! Please try again.";
		Assert.assertEquals(actual, expected);
		System.out.println("invalid_find5 PASSED");
		}
	
	@Test //Tim kiem khong hop le (Khong nhap gi trong o tim kiem)
	public void invalidly_find6() {
		driver.findElement(By.name("searchKey"));
		driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/button[1]")).click();
		String actual = driver.findElement(By.xpath("//h4[contains(text(),'Have no result match! Please try again.')]")).getText();
		String expected = "Have no result match! Please try again.";
		Assert.assertEquals(actual, expected);
		System.out.println("invalid_find6 PASSED");
		}
	
	@Test //Tim kiem khong hop le (Nhap ky tu khac so)
	public void invalidly_find7() {
		driver.findElement(By.name("searchKey")).sendKeys("acv");;
		driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/button[1]")).click();
		String actual = driver.findElement(By.xpath("//h4[contains(text(),'Have no result match! Please try again.')]")).getText();
		String expected = "Have no result match! Please try again.";
		Assert.assertEquals(actual, expected);
		System.out.println("invalid_find7 PASSED");
		}
	
	@Test //Mo so tiet kiem hop le (Khong ky han)
	public void validly_deposit1() throws InterruptedException {
		driver.findElement(By.name("searchKey")).sendKeys("535046");;
		driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/button[1]")).click();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//a[contains(text(),'Detail')]")).click();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//a[contains(text(),'To Saving')]")).click();
		Thread.sleep(500);
		
		driver.findElement(By.id("description")).sendKeys("mua lambor");
		driver.findElement(By.id("amountSend")).sendKeys("1000");
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[3]/div[1]/input[1]")).click();
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[6]/button[1]")).click();
	
		String title = driver.getTitle();
		String expectedTitle = "Customer | Detail";
		Assert.assertEquals(expectedTitle, title);
		}
	
	@Test //Mo so tiet kiem hop le (Ky han 1 thang)
	public void validly_deposit2() throws InterruptedException {
		driver.findElement(By.name("searchKey")).sendKeys("535046");;
		driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/button[1]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.xpath("//a[contains(text(),'Detail')]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.xpath("//a[contains(text(),'To Saving')]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.id("description")).sendKeys("mua lambor");
		driver.findElement(By.id("amountSend")).sendKeys("1000");
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[4]/div[1]/input[1]")).click();
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[6]/button[1]")).click();
		}
	
	@Test //Mo so tiet kiem hop le (Ky han 6 thang)
	public void validly_deposit3() throws InterruptedException {
		driver.findElement(By.name("searchKey")).sendKeys("535046");;
		driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/button[1]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.xpath("//a[contains(text(),'Detail')]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.xpath("//a[contains(text(),'To Saving')]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.id("description")).sendKeys("mua lambor");
		driver.findElement(By.id("amountSend")).sendKeys("1000");
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[4]/div[4]/input[1]")).click();
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[6]/button[1]")).click();
		}
	
	@Test //Mo so tiet kiem hop le (Ky han 1 nam)
	public void validly_deposit4() throws InterruptedException {
		driver.findElement(By.name("searchKey")).sendKeys("535046");;
		driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/button[1]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.xpath("//a[contains(text(),'Detail')]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.xpath("//a[contains(text(),'To Saving')]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.id("description")).sendKeys("mua lambor");
		driver.findElement(By.id("amountSend")).sendKeys("1000");
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[5]/div[1]/input[1]")).click();
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[6]/button[1]")).click();
		}
	
	@Test //Mo so tiet kiem khong hop le (De trong Descrpition - Khong ky han)
	public void invalidly_deposit1() throws InterruptedException {
		driver.findElement(By.name("searchKey")).sendKeys("535046");;
		driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/button[1]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.xpath("//a[contains(text(),'Detail')]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.xpath("//a[contains(text(),'To Saving')]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.id("amountSend")).sendKeys("1000");
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[5]/div[1]/input[1]")).click();
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[6]/button[1]")).click();
		String alert = driver.switchTo().alert().getText();
		String expectedAlert = "Vui long nhap mo ta cua so tiet kiem";
		Assert.assertEquals(expectedAlert, alert);
		}
	
	@Test //Mo so tiet kiem khong hop le (De trong Deposit amount - Khong ky han)
	public void invalidly_deposit2() throws InterruptedException {
		driver.findElement(By.name("searchKey")).sendKeys("535046");;
		driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/button[1]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.xpath("//a[contains(text(),'Detail')]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.xpath("//a[contains(text(),'To Saving')]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.id("description")).sendKeys("mua lambor");
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[5]/div[1]/input[1]")).click();
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[6]/button[1]")).click();
		
		String alert = driver.switchTo().alert().getText();
		String expectedAlert = "Vui long nhap so tien gui vao so tiet kiem";
		Assert.assertEquals(expectedAlert, alert);
		}
	
	@Test //Mo so tiet kiem khong hop le (Nhap ky tu khac so trong Deposit amount - Khong ky han)
	public void invalidly_deposit3() throws InterruptedException {
		driver.findElement(By.name("searchKey")).sendKeys("535046");;
		driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/button[1]")).click();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//a[contains(text(),'Detail')]")).click();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//a[contains(text(),'To Saving')]")).click();
		Thread.sleep(500);
		
		driver.findElement(By.id("description")).sendKeys("mua lambor");
		driver.findElement(By.id("amountSend")).sendKeys("abc");
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[3]/div[1]/input[1]")).click();
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[6]/button[1]")).click();
	
		String alert = driver.switchTo().alert().getText();
		String expectedAlert = "Vui long khong nhap ky tu khac so";
		Assert.assertEquals(expectedAlert, alert);
		}
	
	@Test //Mo so tiet kiem khong hop le (De trong Descrpition - 1 thang)
	public void invalidly_deposit4() throws InterruptedException {
		driver.findElement(By.name("searchKey")).sendKeys("535046");;
		driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/button[1]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.xpath("//a[contains(text(),'Detail')]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.xpath("//a[contains(text(),'To Saving')]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.id("amountSend")).sendKeys("1000");
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[4]/div[1]/input[1]")).click();
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[6]/button[1]")).click();
		
		String alert = driver.switchTo().alert().getText();
		String expectedAlert = "Vui long nhap mo ta cua so tiet kiem";
		Assert.assertEquals(expectedAlert, alert);
		}
	
	@Test //Mo so tiet kiem khong hop le (De trong Deposit amount - 1 thang)
	public void invalidly_deposit5() throws InterruptedException {
		driver.findElement(By.name("searchKey")).sendKeys("535046");;
		driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/button[1]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.xpath("//a[contains(text(),'Detail')]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.xpath("//a[contains(text(),'To Saving')]")).click();
		Thread.sleep(500);
		
		driver.findElement(By.id("description")).sendKeys("mua lambor");
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[4]/div[1]/input[1]")).click();
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[6]/button[1]")).click();
		
		String alert = driver.switchTo().alert().getText();
		String expectedAlert = "Vui long nhap so tien gui vao so tiet kiem";
		Assert.assertEquals(expectedAlert, alert);
		}
	
	@Test //Mo so tiet kiem khong hop le (Nhap ky tu khac so trong Deposit amount - 1 thang)
	public void invalidly_deposit6() throws InterruptedException {
		driver.findElement(By.name("searchKey")).sendKeys("535046");;
		driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/button[1]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.xpath("//a[contains(text(),'Detail')]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.xpath("//a[contains(text(),'To Saving')]")).click();
		Thread.sleep(500);
		driver.findElement(By.id("description")).sendKeys("mua lambor");
		driver.findElement(By.id("amountSend")).sendKeys("abc");
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[4]/div[1]/input[1]")).click();
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[6]/button[1]")).click();
		
		String alert = driver.switchTo().alert().getText();
		String expectedAlert = "Vui long khong nhap ky tu khac so";
		Assert.assertEquals(expectedAlert, alert);
		}
	
		@Test //Mo so tiet kiem khong hop le (De trong Descrpition - 1 nam)
		public void invalidly_deposit7() throws InterruptedException {
		driver.findElement(By.name("searchKey")).sendKeys("535046");;
		driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/button[1]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.xpath("//a[contains(text(),'Detail')]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.xpath("//a[contains(text(),'To Saving')]")).click();
		Thread.sleep(500);
	
		
		driver.findElement(By.id("amountSend")).sendKeys("1000");
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[5]/div[1]/input[1]")).click();
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[6]/button[1]")).click();
		
		String alert = driver.switchTo().alert().getText();
		String expectedAlert = "Vui long nhap mo ta cua so tiet kiem";
		Assert.assertEquals(expectedAlert, alert);
		}
	
		@Test //Mo so tiet kiem khong hop le (De trong Deposit amount - 1 nam)
		public void invalidly_deposit8() throws InterruptedException {
		driver.findElement(By.name("searchKey")).sendKeys("535046");;
		driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/button[1]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.xpath("//a[contains(text(),'Detail')]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.xpath("//a[contains(text(),'To Saving')]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.id("description")).sendKeys("mua lambor");
		
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[5]/div[1]/input[1]")).click();
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[6]/button[1]")).click();
		
		String alert = driver.switchTo().alert().getText();
		String expectedAlert = "Vui long nhap so tien gui vao so tiet kiem";
		Assert.assertEquals(expectedAlert, alert);
		}	
		
		@Test //Mo so tiet kiem khong hop le (Nhap ky tu khac so trong Deposit amount - 1 nam)
		public void invalidly_deposit9() throws InterruptedException {
		driver.findElement(By.name("searchKey")).sendKeys("535046");;
		driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/button[1]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.xpath("//a[contains(text(),'Detail')]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.xpath("//a[contains(text(),'To Saving')]")).click();
		Thread.sleep(500);
	
		driver.findElement(By.id("description")).sendKeys("mua lambor");
		driver.findElement(By.id("amountSend")).sendKeys("abc");
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[5]/div[1]/input[1]")).click();
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[6]/button[1]")).click();
		
		String alert = driver.switchTo().alert().getText();
		String expectedAlert = "Vui long khong nhap ky tu khac so";
		Assert.assertEquals(expectedAlert, alert);
		}		
	
		@Test //Mo so tiet kiem khong hop le (Khong chon ky han)
		public void invalidly_deposit10() throws InterruptedException {
			driver.findElement(By.name("searchKey")).sendKeys("535046");;
			driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/button[1]")).click();
			Thread.sleep(500);
			
			driver.findElement(By.xpath("//a[contains(text(),'Detail')]")).click();
			Thread.sleep(500);
			
			driver.findElement(By.xpath("//a[contains(text(),'To Saving')]")).click();
			Thread.sleep(500);
			
			driver.findElement(By.id("description")).sendKeys("mua lambor");
			driver.findElement(By.id("amountSend")).sendKeys("1000");
			
			driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[6]/button[1]")).click();
		
			String alert = driver.switchTo().alert().getText();
			String expectedAlert = "Vui long chon ky han gui";
			Assert.assertEquals(expectedAlert, alert);
			}
	
	@Test //Mo so tiet kiem khong hop le (Gui nhieu hon so tien trong tai khoan - Khong ky han)
	public void invalidly_deposit11() throws InterruptedException {
		driver.findElement(By.name("searchKey")).sendKeys("535046");;
		driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/button[1]")).click();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//a[contains(text(),'Detail')]")).click();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//a[contains(text(),'To Saving')]")).click();
		Thread.sleep(500);
		
		driver.findElement(By.id("description")).sendKeys("mua lambor");
		driver.findElement(By.id("amountSend")).sendKeys("12345678");
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[3]/div[1]/input[1]")).click();
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[6]/button[1]")).click();
	
		String alert = driver.switchTo().alert().getText();
		String expectedAlert = "Khong du tien trong tai khoan de mo so tiet kiem, vui long nhap lai so tien";
		Assert.assertEquals(expectedAlert, alert);
		}
	
	@Test //Mo so tiet kiem khong hop le (Gui nhieu hon so tien trong tai khoan - 1 thang)
	public void invalidly_deposit12() throws InterruptedException {
		driver.findElement(By.name("searchKey")).sendKeys("535046");;
		driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/button[1]")).click();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//a[contains(text(),'Detail')]")).click();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//a[contains(text(),'To Saving')]")).click();
		Thread.sleep(500);
		
		driver.findElement(By.id("description")).sendKeys("mua lambor");
		driver.findElement(By.id("amountSend")).sendKeys("12345678");
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[4]/div[1]/input[1]")).click();
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[6]/button[1]")).click();
	
		String alert = driver.switchTo().alert().getText();
		String expectedAlert = "Khong du tien trong tai khoan de mo so tiet kiem, vui long nhap lai so tien";
		Assert.assertEquals(expectedAlert, alert);
		}
	
	@Test //Mo so tiet kiem khong hop le (Gui nhieu hon so tien trong tai khoan - 1 nam)
	public void invalidly_deposit13() throws InterruptedException {
		driver.findElement(By.name("searchKey")).sendKeys("535046");;
		driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/button[1]")).click();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//a[contains(text(),'Detail')]")).click();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//a[contains(text(),'To Saving')]")).click();
		Thread.sleep(500);
		
		driver.findElement(By.id("description")).sendKeys("mua lambor");
		driver.findElement(By.id("amountSend")).sendKeys("12345678");
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[5]/div[1]/input[1]")).click();
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[6]/button[1]")).click();
	
		String alert = driver.switchTo().alert().getText();
		String expectedAlert = "Khong du tien trong tai khoan de mo so tiet kiem, vui long nhap lai so tien";
		Assert.assertEquals(expectedAlert, alert);
		}
	
	
}
