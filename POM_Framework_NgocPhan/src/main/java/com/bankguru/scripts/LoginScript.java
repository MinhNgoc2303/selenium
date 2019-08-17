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
	String msgcustomernameExpected,numericCase, msgNumericCaseExpected, specialCharacter, expectedSpecialCharactersMsg, expectedBlankCase, addressEmptyExpected_msg;
	String cityEmptyExpected, expectedEmptyCityField_msg, stateEmptyExpected, invalidNumbericexpectedInvalidNUmberic_msg, invalidNumberic;
	String expectedEmptyPIN_msg, expectedInvalidPIN_msg, expectedEmptyTelephone_msg, expectedEmptyEmail_msg;
	String incorrectEmailFormat, emailHaveSpace, expectedIncorrectEmail;
	NewCustomerPage newCustomer;
	
	@Parameters({"browser", "version", "url"})
	@BeforeClass 
	public void BeforeClass(String browser, String version, String url) {
		msgcustomernameExpected = "Customer name must not be blank";
		msgNumericCaseExpected = "Numbers are not allowed";
		numericCase = "1234";
		specialCharacter = "!@#$%%";
		expectedSpecialCharactersMsg ="Special characters are not allowed";
		expectedBlankCase = "First character can not have space";
		addressEmptyExpected_msg = "Address Field must not be blank";
		cityEmptyExpected = "City Field must not be blank";
		stateEmptyExpected = "State must not be blank";
		invalidNumberic ="1234NMO";
		invalidNumbericexpectedInvalidNUmberic_msg ="Characters are not allowed";
		expectedEmptyPIN_msg="PIN Code must not be blank";
		expectedInvalidPIN_msg= "PIN Code must have 6 Digits";
		expectedEmptyTelephone_msg = "Mobile no must not be blank";
		expectedEmptyEmail_msg = "Email-ID must not be blank";
		incorrectEmailFormat="ngoc@hmal";
		emailHaveSpace = "ngoc ng";
		expectedIncorrectEmail ="Email-ID is not valid";
		expectedEmptyCityField_msg ="City Field must not be blank";
		
		
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
		newCustomer.inputCustomerName(numericCase);
		
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
	
	
	@Test
	public void NC05_AddressEmplty() {
		newCustomer = homePage.clickNewCustomer();
		newCustomer.pressKeyToAddress(Keys.TAB);
		assertEquals(newCustomer.getMessageAdressField(), addressEmptyExpected_msg);
	}
	
	@Test
	public void NC06_AddressHaveSpace() {
		newCustomer = homePage.clickNewCustomer();
		newCustomer.pressKeyToAddress(Keys.SPACE);
		assertEquals(newCustomer.getMessageAdressField(), expectedBlankCase);
		
	}
	
	
	@Test
	public void NC08_CityFiledEmpty() {
		newCustomer = homePage.clickNewCustomer();
		newCustomer.pressKeyToCityField(Keys.TAB);
		asserEqual(newCustomer.getMessageCityField(),cityEmptyExpected );
	}
	
	@Test
	public void NC09_CityWithNumberic() {
		newCustomer = homePage.clickNewCustomer();
		newCustomer.inputCityField(numericCase);
		asserEqual(newCustomer.getMessageCityField(), msgNumericCaseExpected);
	}
	
	@Test
	public void NC10_CityWithSpecialCharacter() {
		newCustomer = homePage.clickNewCustomer();
		newCustomer.inputCityField(specialCharacter);
		asserEqual(newCustomer.getMessageCityField(), expectedSpecialCharactersMsg);
	}
	
	@Test
	public void NC11_CityHaveSpace() {
		newCustomer = homePage.clickNewCustomer();
		newCustomer.pressKeyToCityField(Keys.TAB);
		assertEquals(newCustomer.getMessageCityField(), expectedEmptyCityField_msg);
	}
	
	
	@Test
	public void NC12_StateFieldEmpty() {
		newCustomer = homePage.clickNewCustomer();
		newCustomer.pressKeyToStateField(Keys.TAB);
		assertEquals(newCustomer.getMessageStateField(), stateEmptyExpected);
	}
	
	@Test
	public void NC13_StateFieldWithNumberic() {
		newCustomer = homePage.clickNewCustomer();
		newCustomer.inputStateField(numericCase);
		assertEquals(newCustomer.getMessageCityField(), msgNumericCaseExpected);
	}
	
	@Test
	public void NC14_StateFieldWithSpecialCharacter() {
		newCustomer = homePage.clickNewCustomer();
		newCustomer.inputStateField(specialCharacter);
		assertEquals(newCustomer.getMessageStateField(), expectedSpecialCharactersMsg);
	}
	
	@Test
	public void NC15_SateFieldWithSpace() {
		newCustomer = homePage.clickNewCustomer();
		newCustomer.pressKeyToStateField(Keys.SPACE);
		assertEquals(newCustomer.getMessageStateField(),expectedBlankCase );
		
	}
	
	
	@Test
	public void NC16_PINFiledWithNumberic() {
		newCustomer = homePage.clickNewCustomer();
		newCustomer.inputPINField(invalidNumberic);
		assertEquals(newCustomer.getMessagePINField(), invalidNumbericexpectedInvalidNUmberic_msg);
	}
	
	@Test
	public void NC17_PinFieldEmpty() {
		newCustomer = homePage.clickNewCustomer();
		newCustomer.pressKeyToPINField(Keys.TAB);
		assertEquals(newCustomer.getMessagePINField(), expectedEmptyPIN_msg );
	}
	
	@Test
	public void NC18_PinFieldHave6Digits() {
		newCustomer = homePage.clickNewCustomer();
		//input less than and more than thi lam sao 
		newCustomer.inputPINField(numericCase);
		asserEqual(newCustomer.getMessagePINField(), expectedInvalidPIN_msg);
	}
	
	@Test
	public void NC19_PinFieldWithSpecialCharcter() {
		newCustomer = homePage.clickNewCustomer();
		newCustomer.inputPINField(specialCharacter);
		assertEquals(newCustomer.getMessagePINField(), expectedSpecialCharactersMsg);
	}
	
	@Test
	public void NC20_PinFieldWithSpace() {
		newCustomer = homePage.clickNewCustomer();
		newCustomer.pressKeyToPINField(Keys.SPACE);
		assertEquals(newCustomer.getMessagePINField(), expectedBlankCase);
	}
	
	
	@Test
	public void NC21_TelephoneFieldEmpty() {
		newCustomer = homePage.clickNewCustomer();
		newCustomer.pressKeyToTelephoneField(Keys.TAB);
		asserEqual(newCustomer.getMessageTelephoneField(), expectedEmptyTelephone_msg);
	}
	
	@Test
	public void NC22_TelephoneFieldHaveSpace() {
		newCustomer = homePage.clickNewCustomer();
		newCustomer.pressKeyToTelephoneField(Keys.SPACE);
		assertEquals(newCustomer.getMessageTelephoneField(), expectedBlankCase);
	}
	
	@Test
	public void NC25_TelephoneFieldWithSpecialCharacter() {
		newCustomer = homePage.clickNewCustomer();
		newCustomer.inputTelephoneField(specialCharacter);
		assertEquals(newCustomer.getMessageTelephoneField(), expectedSpecialCharactersMsg);
	}
	
	
	@Test
	public void NC26_EmailFieldEmpty() {
		newCustomer = homePage.clickNewCustomer();
		newCustomer.pressKeyToEmailField(Keys.TAB);
		asserEqual(newCustomer.getMessageEmailField(), expectedEmptyEmail_msg);
		
	}
	@Test
	public void NC27_EmailFieldWithIncorrectFormat() {
		newCustomer = homePage.clickNewCustomer();
		newCustomer.inputEmailField(incorrectEmailFormat);
		assertEquals(newCustomer.getMessageEmailField(), expectedIncorrectEmail);
		
	}
	@Test
	public void NC29_EmailFieldWithSpace() {
		newCustomer = homePage.clickNewCustomer();
		newCustomer.inputEmailField(emailHaveSpace);
		asserEqual(newCustomer.getMessageEmailField(), expectedIncorrectEmail);
	}
	
	
	
	@AfterClass
	public void AfterClass() {
		closeBrowser();
		
	}

}
