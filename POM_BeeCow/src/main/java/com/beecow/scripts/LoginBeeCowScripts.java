package com.beecow.scripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beecow.actions.LoginBeeCowPage;

import common.CommonTestCase;

public class LoginBeeCowScripts extends CommonTestCase {
	WebDriver driver;
	LoginBeeCowPage loginBeeCowPage;
	
	@Parameters({"browser","version","url"})
	@BeforeClass
	public void BeforeClass(String browser, String version, String url) {

		driver = openBrowser(browser, version, url);
		loginBeeCowPage = PageFactory.initElements(driver, LoginBeeCowPage.class);
	}

	@Test
	public void allFieldsEmpty() {
		loginBeeCowPage.clickToLoginHome();
		loginBeeCowPage.inputToUsername("");
		loginBeeCowPage.inputToPassword("");
		loginBeeCowPage.clickToLogin();
		
	}
}
