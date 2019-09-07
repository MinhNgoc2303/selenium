package com.bankguru.scripts;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.actions.HomePage;
import com.bankguru.actions.LoginPage;
import com.bankguru.actions.NewCustomerPage;
import com.bankguru.actions.RegisterPage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

import common.CommonTestCase;

public class LoginScript extends CommonTestCase{
	WebDriver driver;
	LoginPage loginPage;
	RegisterPage registerPage;
	HomePage homePage;
	String email, username, password;
	String msgcustomernameExpected,nameNumeric, msgNumericCaseExpected, specialCharacter, expectedSpecialCharactersMsg, expectedBlankCase;
	NewCustomerPage newCustomer;
	
	@Parameters({"browser", "version", "url"})
	@BeforeClass 
	public void BeforeClass(String browser, String version, String url) {
		msgcustomernameExpected = "Customer name must not be blank";
		msgNumericCaseExpected = "Numbers are not allowed";
		nameNumeric = "12345";
		specialCharacter = "!@#$%%";
		expectedSpecialCharactersMsg ="Special characters are not allowed";
		expectedBlankCase = "First character can not have space";
		
		driver = openBrowser(browser, version, url);//ham tra ve webdriver
		email = "ngoc" + randomemail() + "@gmail.com";
		//loginPage = new LoginPage(driver);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		registerPage = loginPage.clickHereLink();
		//registerPage = new RegisterPage(driver);
		//registerPage = PageFactory.initElements(driver, RegisterPage.class);
		registerPage.inputEmail(email);
		registerPage.clickRegister();
		username = registerPage.getUserName();
		password = registerPage.getPassword();
		
		registerPage.openLogInBankGuru(url);
		System.out.println(url);
		loginPage.inputUserID(username);
		loginPage.inputPassword(password);
		homePage = loginPage.clickLogin();
		
		//homePage = new HomePage(driver);
		//homePage = PageFactory.initElements(driver, HomePage.class);
		String welcomText = homePage.verifyHomePage();
		
		assertTrue(welcomText.contains("Welcome"));
		//Assert.assertTrue(welcomText.contains("Welcome"));
		
	}
	@Test
	public void NC01_NewCustomer01() {
		newCustomer = homePage.clickNewCustomer();
		newCustomer.pressKeysToCustomerName(Keys.TAB);
		String msgcustomernameActual = newCustomer.getMessageCustomerName();
		assertEquals(msgcustomernameActual, msgcustomernameExpected);
	}
	@Test
	public void NC02_NumericCase() {
		newCustomer = homePage.clickNewCustomer();
		newCustomer.inputCustomerName(nameNumeric);
		
		assertEquals(newCustomer.getMessageCustomerName(), msgNumericCaseExpected);
	}
	
	@Test
	public void NC03_SpecialCharacters() {
		newCustomer = homePage.clickNewCustomer();
		newCustomer.inputCustomerName(specialCharacter);
		assertEquals(newCustomer.getMessageCustomerName(), expectedSpecialCharactersMsg);
	}
	@Test
	public void NC04_FirstCharacterBlank() {
		newCustomer = homePage.clickNewCustomer();
		newCustomer.pressKeysToCustomerName(Keys.SPACE);
		assertEquals(newCustomer.getMessageCustomerName(), expectedBlankCase);
	}
	
	
	
	
	
	//@AfterClass
	public void AfterClass() {
		closeBrowser();
		
	}

}
