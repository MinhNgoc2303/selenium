package common;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class CommonTestCase {
	WebDriver driver;

	public WebDriver openBrowser(String browser, String version, String url) {
		if (browser.equals("chrome")) {
			ChromeDriverManager.getInstance().version(version).setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			FirefoxDriverManager.getInstance().version(version).setup();
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		return driver;

	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public String randomemail() {
		Random rand = new Random();
		int number = rand.nextInt(9000000);
		String numberString = Integer.toString(number);
		return numberString;

	}
	public void assertTrue(Boolean condition) {
		Assert.assertTrue(condition);
	}
	public void assertFalse(Boolean condition) {
		Assert.assertFalse(condition);
	}
	public void asserEqual(String actual, String expected) {
		Assert.assertEquals(actual, expected);
	}
}
