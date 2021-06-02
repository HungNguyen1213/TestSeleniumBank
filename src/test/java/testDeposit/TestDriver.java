package testDeposit;

import org.openqa.selenium.chrome.ChromeDriver;

public class TestDriver {
	private String driverUrl = "E:\\eclipse\\chromedriver_win3290\\chromedriver.exe";
	
	public TestDriver() {
	}
	public ChromeDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", driverUrl);
		return new ChromeDriver();
	}
}
