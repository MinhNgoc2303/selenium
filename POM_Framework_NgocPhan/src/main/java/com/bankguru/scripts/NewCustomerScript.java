package com.bankguru.scripts;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.actions.HomePage;
import com.bankguru.actions.LoginPage;
import com.bankguru.actions.NewCustomerPage;
import com.bankguru.actions.RegisterPage;

import ObjectPageJson.JsonData;
import common.CommonTestCase;

public class NewCustomerScript extends CommonTestCase {
	WebDriver driver;
	LoginPage loginPage;
	RegisterPage registerPage;
	HomePage homePage;
	String email;
	String emailNewCustomer;

	NewCustomerPage newCustomer;
	public static String custmerId;
	JsonData commonData;
	//String customerName, dateOfBirth, address, city, state, pin, mobile, emailNewCustomer, passwordNewCustomer;

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void BeforeClass(String browser, String version, String url) {
		String userPath = System.getProperty("user.dir");
		String pathFileJson = userPath.concat("/data/").concat("BankGuru.json");

		commonData = getDataJson(pathFileJson);
		
//		msgcustomernameExpected = "Customer name must not be blank";
//		msgNumericCaseExpected = "Numbers are not allowed";
//		numericCase = "1234";
//		specialCharacter = "!@#$%%";
//		expectedSpecialCharactersMsg = "Special characters are not allowed";
//		expectedBlankCase = "First character can not have space";
//		addressEmptyExpected_msg = "Address Field must not be blank";
//		cityEmptyExpected = "City Field must not be blank";
//		stateEmptyExpected = "State must not be blank";
//		invalidNumberic = "1234NMO";
//		invalidNumbericexpectedInvalidNUmberic_msg = "Characters are not allowed";
//		expectedEmptyPIN_msg = "PIN Code must not be blank";
//		expectedInvalidPIN_msg = "PIN Code must have 6 Digits";
//		expectedEmptyTelephone_msg = "Mobile no must not be blank";
//		expectedEmptyEmail_msg = "Email-ID must not be blank";
//		incorrectEmailFormat = "ngoc@hmal";
//		emailHaveSpace = "ngoc ng";
//		expectedIncorrectEmail = "Email-ID is not valid";
//		expectedEmptyCityField_msg = "City Field must not be blank";
//
//		customerName = "ngocminh";
//		dateOfBirth = "03/23/1999";
//		address = "123 alibaba";
//		city = "ho chi minh";
//		state = "ho chi minh";
//		pin = "123456";
//		mobile = "123456789";
		emailNewCustomer = "mimi" + randomemail() + "@gmail.com";
//		passwordNewCustomer = "1234567890";

		driver = openBrowser(browser, version, url);// ham tra ve webdriver
		email = "ngoc" + randomemail() + "@gmail.com";

		loginPage = PageFactory.initElements(driver, LoginPage.class);

		loginPage.inputUserID(RegisterNewAccountScript.username);
		loginPage.inputPassword(RegisterNewAccountScript.password);
		homePage = loginPage.clickLogin();

		String welcomText = homePage.verifyHomePage();

		assertTrue(welcomText.contains("Welcome"));
	}

	@BeforeMethod
	public void BeforeMethod() {
		newCustomer = homePage.clickNewCustomer();
	}

	@Test
	public void NC01_NewCustomer01() {
		// newCustomer = homePage.clickNewCustomer();
		newCustomer.pressKeysToCustomerName(Keys.TAB);
		String msgcustomernameActual = newCustomer.getMessageCustomerName();
		assertEquals(msgcustomernameActual,commonData.getNewCustomer().getMsgcustomernameExpected());
	}

	@Test
	public void NC02_NumericCase() {
		// newCustomer = homePage.clickNewCustomer();
		//newCustomer.inputCustomerName(numericCase);
		newCustomer.inputCustomerName(commonData.getNewCustomer().getNumericCase());
		//assertEquals(newCustomer.getMessageCustomerName(), msgNumericCaseExpected);
		assertEquals(newCustomer.getMessageCustomerName(), commonData.getNewCustomer().getMsgNumericCaseExpected());
	}

	@Test
	public void NC03_SpecialCharacters() {
		// newCustomer = homePage.clickNewCustomer();
//		newCustomer.inputCustomerName(specialCharacter);
//		assertEquals(newCustomer.getMessageCustomerName(), expectedSpecialCharactersMsg);
		newCustomer.inputCustomerName(commonData.getNewCustomer().getSpecialCharacter());
		assertEquals(newCustomer.getMessageCustomerName(), commonData.getNewCustomer().getExpectedSpecialCharactersMsg());
	}

	@Test
	public void NC04_FirstCharacterBlank() {
		// newCustomer = homePage.clickNewCustomer();
		newCustomer.pressKeysToCustomerName(Keys.SPACE);
//		assertEquals(newCustomer.getMessageCustomerName(), expectedBlankCase);
		assertEquals(newCustomer.getMessageCustomerName(), commonData.getNewCustomer().getExpectedBlankCase());
	}

	@Test
	public void NC05_AddressEmplty() {
		// newCustomer = homePage.clickNewCustomer();
		newCustomer.pressKeyToAddress(Keys.TAB);
//		assertEquals(newCustomer.getMessageAdressField(), addressEmptyExpected_msg);
		assertEquals(newCustomer.getMessageAdressField(), commonData.getNewCustomer().getAddressEmptyExpectedMsg());
	}

	@Test
	public void NC06_AddressHaveSpace() {
		// newCustomer = homePage.clickNewCustomer();
		newCustomer.pressKeyToAddress(Keys.SPACE);
//		assertEquals(newCustomer.getMessageAdressField(), expectedBlankCase);
		assertEquals(newCustomer.getMessageAdressField(), commonData.getNewCustomer().getExpectedBlankCase());

	}

	@Test
	public void NC08_CityFiledEmpty() {
		// newCustomer = homePage.clickNewCustomer();
		newCustomer.pressKeyToCityField(Keys.TAB);
//		asserEqual(newCustomer.getMessageCityField(), cityEmptyExpected);
		asserEqual(newCustomer.getMessageCityField(), commonData.getNewCustomer().getCityEmptyExpected());
	}

	@Test
	public void NC09_CityWithNumberic() {
		// newCustomer = homePage.clickNewCustomer();
//		newCustomer.inputCityField(numericCase);
//		asserEqual(newCustomer.getMessageCityField(), msgNumericCaseExpected);
		newCustomer.inputCityField(commonData.getNewCustomer().getNumericCase());
		asserEqual(newCustomer.getMessageCityField(), commonData.getNewCustomer().getMsgNumericCaseExpected());
	}

	@Test
	public void NC10_CityWithSpecialCharacter() {
		// newCustomer = homePage.clickNewCustomer();
//		newCustomer.inputCityField(specialCharacter);
//		asserEqual(newCustomer.getMessageCityField(), expectedSpecialCharactersMsg);
		newCustomer.inputCityField(commonData.getNewCustomer().getSpecialCharacter());
		asserEqual(newCustomer.getMessageCityField(), commonData.getNewCustomer().getExpectedSpecialCharactersMsg());
	}

	@Test
	public void NC11_CityHaveSpace() {
		// newCustomer = homePage.clickNewCustomer();
		newCustomer.pressKeyToCityField(Keys.TAB);
//		assertEquals(newCustomer.getMessageCityField(), expectedEmptyCityField_msg);
		assertEquals(newCustomer.getMessageCityField(), commonData.getNewCustomer().getExpectedEmptyCityFieldMsg());
	}

	@Test
	public void NC12_StateFieldEmpty() {
		// newCustomer = homePage.clickNewCustomer();
		newCustomer.pressKeyToStateField(Keys.TAB);
//		assertEquals(newCustomer.getMessageStateField(), stateEmptyExpected);
		assertEquals(newCustomer.getMessageStateField(), commonData.getNewCustomer().getStateEmptyExpected());
	}

	@Test
	public void NC13_StateFieldWithNumberic() {
		// newCustomer = homePage.clickNewCustomer();
//		newCustomer.inputStateField(numericCase);
//		assertEquals(newCustomer.getMessageStateField(), msgNumericCaseExpected);
		newCustomer.inputStateField(commonData.getNewCustomer().getNumericCase());
		assertEquals(newCustomer.getMessageStateField(), commonData.getNewCustomer().getMsgNumericCaseExpected());
	}

	@Test
	public void NC14_StateFieldWithSpecialCharacter() {
		// newCustomer = homePage.clickNewCustomer();
//		newCustomer.inputStateField(specialCharacter);
//		assertEquals(newCustomer.getMessageStateField(), expectedSpecialCharactersMsg);
		newCustomer.inputStateField(commonData.getNewCustomer().getSpecialCharacter());
		assertEquals(newCustomer.getMessageStateField(), commonData.getNewCustomer().getExpectedSpecialCharactersMsg());
	}

	@Test
	public void NC15_SateFieldWithSpace() {
		// newCustomer = homePage.clickNewCustomer();
		newCustomer.pressKeyToStateField(Keys.SPACE);
//		assertEquals(newCustomer.getMessageStateField(), expectedBlankCase);
		assertEquals(newCustomer.getMessageStateField(), commonData.getNewCustomer().getExpectedBlankCase());

	}

	@Test
	public void NC16_PINFiledWithNumberic() {
		// newCustomer = homePage.clickNewCustomer();
//		newCustomer.inputPINField(invalidNumberic);
//		assertEquals(newCustomer.getMessagePINField(), invalidNumbericexpectedInvalidNUmberic_msg);
		newCustomer.inputPINField(commonData.getNewCustomer().getInvalidNumberic());
		assertEquals(newCustomer.getMessagePINField(), commonData.getNewCustomer().getInvalidNumbericexpectedInvalidNUmbericMsg());
	}

	@Test
	public void NC17_PinFieldEmpty() {
		// newCustomer = homePage.clickNewCustomer();
		newCustomer.pressKeyToPINField(Keys.TAB);
//		assertEquals(newCustomer.getMessagePINField(), expectedEmptyPIN_msg);
		assertEquals(newCustomer.getMessagePINField(), commonData.getNewCustomer().getExpectedEmptyPINMsg());
	}

	@Test
	public void NC18_PinFieldHave6Digits() {
		// newCustomer = homePage.clickNewCustomer();
		// input less than and more than thi lam sao
//		newCustomer.inputPINField(numericCase);
//		asserEqual(newCustomer.getMessagePINField(), expectedInvalidPIN_msg);
		newCustomer.inputPINField(commonData.getNewCustomer().getNumericCase());
		asserEqual(newCustomer.getMessagePINField(), commonData.getNewCustomer().getExpectedInvalidPINMsg());
	}

	@Test
	public void NC19_PinFieldWithSpecialCharcter() {
		// newCustomer = homePage.clickNewCustomer();
//		newCustomer.inputPINField(specialCharacter);
//		assertEquals(newCustomer.getMessagePINField(), expectedSpecialCharactersMsg);
		newCustomer.inputPINField(commonData.getNewCustomer().getSpecialCharacter());
		assertEquals(newCustomer.getMessagePINField(), commonData.getNewCustomer().getExpectedSpecialCharactersMsg());
	}

	@Test
	public void NC20_PinFieldWithSpace() {
		// newCustomer = homePage.clickNewCustomer();
		newCustomer.pressKeyToPINField(Keys.SPACE);
//		assertEquals(newCustomer.getMessagePINField(), expectedBlankCase);
		assertEquals(newCustomer.getMessagePINField(), commonData.getNewCustomer().getExpectedBlankCase());
	}

	@Test
	public void NC21_TelephoneFieldEmpty() {
		// newCustomer = homePage.clickNewCustomer();
		newCustomer.pressKeyToTelephoneField(Keys.TAB);
		asserEqual(newCustomer.getMessageTelephoneField(), commonData.getNewCustomer().getExpectedEmptyTelephoneMsg());
	}

	@Test
	public void NC22_TelephoneFieldHaveSpace() {
		// newCustomer = homePage.clickNewCustomer();
		newCustomer.pressKeyToTelephoneField(Keys.SPACE);
		assertEquals(newCustomer.getMessageTelephoneField(), commonData.getNewCustomer().getExpectedBlankCase());
	}

	@Test
	public void NC25_TelephoneFieldWithSpecialCharacter() {
		// newCustomer = homePage.clickNewCustomer();
		newCustomer.inputTelephoneField(commonData.getNewCustomer().getSpecialCharacter());
		assertEquals(newCustomer.getMessageTelephoneField(),commonData.getNewCustomer().getExpectedSpecialCharactersMsg());
	}

	@Test
	public void NC26_EmailFieldEmpty() {
		// newCustomer = homePage.clickNewCustomer();
		newCustomer.pressKeyToEmailField(Keys.TAB);
		asserEqual(newCustomer.getMessageEmailField(), commonData.getNewCustomer().getExpectedEmptyEmailMsg());

	}

	@Test
	public void NC27_EmailFieldWithIncorrectFormat() {
		// newCustomer = homePage.clickNewCustomer();
		newCustomer.inputEmailField(commonData.getNewCustomer().getIncorrectEmailFormat());
		assertEquals(newCustomer.getMessageEmailField(), commonData.getNewCustomer().getExpectedIncorrectEmail());

	}

	@Test
	public void NC29_EmailFieldWithSpace() {
		// newCustomer = homePage.clickNewCustomer();
		newCustomer.inputEmailField(commonData.getNewCustomer().getEmailHaveSpace());
		asserEqual(newCustomer.getMessageEmailField(), commonData.getNewCustomer().getExpectedIncorrectEmail());
	}

	@Test
	public void NC30_CreateNewCustomer() {

		// Create successfully new customer
		// newCustomer = homePage.clickNewCustomer();
		newCustomer.inputCustomerName(commonData.getNewCustomer().getCustomerName());
		newCustomer.inputDateOfBirth(commonData.getNewCustomer().getDateOfBirth());
		newCustomer.inputAddress(commonData.getNewCustomer().getAddress());
		newCustomer.inputCityField(commonData.getNewCustomer().getCity());
		newCustomer.inputStateField(commonData.getNewCustomer().getState());
		newCustomer.inputPINField(commonData.getNewCustomer().getPin());
		newCustomer.inputTelephoneField(commonData.getNewCustomer().getMobile());
		newCustomer.inputEmailField(emailNewCustomer);
		newCustomer.inputPasswordNewCustomer(commonData.getNewCustomer().getPasswordNewCustomer());
		newCustomer.clickSubmitNewCustomer();
		custmerId = newCustomer.getCustomerId();
	}

	@AfterClass
	public void AfterClass() {
		closeBrowser();

	}

}
