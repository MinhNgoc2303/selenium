package common;

import java.io.BufferedReader;


import java.io.FileReader;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.google.gson.Gson;

//import ObjectPageJson.JsonData;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class CommonTestCase {
	WebDriver driver;

	public WebDriver openBrowser(String browser, String version, String url) {
		if (browser.equals("chrome")) {
			ChromeDriverManager.getInstance().version(version).setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extendsions");
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
	
	public static String readFile(String filename) {
		String result = "";
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(filename));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
				System.out.println("value " + line);

			}
			result = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
	
//	public static JsonData getDataJson(String JsonFile) {
//		String json = readFile(JsonFile);
//		return new Gson().fromJson(json, JsonData.class);
//	}
	
	
}
