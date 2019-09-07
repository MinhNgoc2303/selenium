package com.bankguru.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.actions.LoginPage;
import com.bankguru.actions.RegisterPage;

import common.CommonTestCase;

public class RegisterNewAccountScript extends CommonTestCase {

	WebDriver driver;
	LoginPage loginPage;
	RegisterPage registerPage;
	String email;
	public static String username, password;

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void BeforeClass(String browser, String version, String url) {
		driver = openBrowser(browser, version, url);// ham tra ve webdriver
		email = "ngoc" + randomemail() + "@gmail.com";

	}

	@Test
	public void RegisterScript() {
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		registerPage = loginPage.clickHereLink();

		registerPage.inputEmail(email);
		registerPage.clickRegister();
		username = registerPage.getUserName();
		password = registerPage.getPassword();
	}
	
	@AfterClass
	public void AfterClass() {
		closeBrowser();
		
	}

}
