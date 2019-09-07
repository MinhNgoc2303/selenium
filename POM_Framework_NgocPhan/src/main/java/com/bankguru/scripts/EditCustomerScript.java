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

import com.bankguru.actions.EditCustomerPage;
import com.bankguru.actions.HomePage;
import com.bankguru.actions.LoginPage;
import com.bankguru.actions.NewCustomerPage;
import com.bankguru.actions.RegisterPage;

import ObjectPageJson.JsonData;
import common.CommonTestCase;

public class EditCustomerScript extends CommonTestCase {
	WebDriver driver;
	LoginPage loginPage;
	RegisterPage registerPage;
	HomePage homePage;
	NewCustomerPage newCustomer;
	EditCustomerPage editCustomer;
	String email, username, password;
	JsonData commonData;
//	String expectedEmptyCusId, numeric, expectedIdNotNumberic;
//
//	String specialCharacter, expectedSpecialCharacter_msg;
//	String custmerId;
//	String expectedEmptyAddress_msg, expectedEmptyCity_msg, expectedNumberic_msg;
//	String expectedEmptyStateField_msg;
//	String expectedEmptyPINField_msg, expectedNumbericPINField_msg;
//	String expectedEmptyTelephoneField_msg, lessThan6Digits, invaldFormatMail;
//	String expectedEmptyEmailField_msg, expectedInvalidFormatEmail_msg;

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void BeforeClass(String browser, String version, String url) {
		String userPath = System.getProperty("user.dir");
		String pathFileJson = userPath.concat("/data/").concat("BankGuru.json");

		commonData = getDataJson(pathFileJson);

//		expectedEmptyCusId = "Customer ID is required";
//		numeric = "123ngoc";
//		expectedIdNotNumberic = "Characters are not allowed";
//		specialCharacter = "123$%^^";
//		expectedSpecialCharacter_msg = "Special characters are not allowed";
//
//		lessThan6Digits = "1234";
//
//		expectedEmptyAddress_msg = "Address Field must not be blank";
//
//		expectedEmptyCity_msg = "City Field must not be blank";
//
//		expectedNumberic_msg = "Numbers are not allowed";
//
//		expectedEmptyStateField_msg = "State must not be blank";
//
//		expectedEmptyPINField_msg = "PIN Code must not be blank";
//		expectedNumbericPINField_msg = "PIN Code must have 6 Digits";
//
//		expectedEmptyTelephoneField_msg = "Mobile no must not be blank";
//
//		expectedEmptyEmailField_msg = "Email-ID must not be blank";
//		expectedInvalidFormatEmail_msg = "Email-ID is not valid";
//
//		invaldFormatMail = "ngocgmail.com";

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
		editCustomer = homePage.clickEditCustomer();

	}
	

	@Test
	public void EC01_CustomerIdEmpty() {
		editCustomer.pressToCustomerId(Keys.TAB);
		assertEquals(editCustomer.getMessageOfCustomerId(), commonData.getEditCustomer().getExpectedEmptyCusId());
	}

	@Test
	public void EC02_CustomerIdNotNumberic() {
		editCustomer.inputToCustomerId(commonData.getEditCustomer().getNumeric());
		assertEquals(editCustomer.getMessageOfCustomerId(), commonData.getEditCustomer().getExpectedIdNotNumberic());
	}

	@Test
	public void EC03_CustomerIdhaveSpecialCharacter() {
		editCustomer.inputToCustomerId(commonData.getEditCustomer().getSpecialCharacter());
		assertEquals(editCustomer.getMessageOfCustomerId(), commonData.getEditCustomer().getExpectedSpecialCharacterMsg());
	}

	@Test
	public void EC04_ValidCustomerId() {
		editCustomer.inputToCustomerId(NewCustomerScript.custmerId);
		editCustomer.clickSubmitEditCustomer();
		assertEquals(editCustomer.getTilelEditPage(), "Guru99 Bank Edit Customer Entry Page");
	}

	@Test
	public void EC08_AddressIsEmpty() {
		editCustomer.inputToCustomerId(NewCustomerScript.custmerId);
		editCustomer.clickSubmitEditCustomer();
		editCustomer.clearTextToAddressField();
		editCustomer.pressToAddressField(Keys.TAB);
		assertEquals(editCustomer.getMessageAddressField(), commonData.getEditCustomer().getExpectedEmptyAddressMsg());
	}

	@Test
	public void EC09_CityIsEmpty() {
		//editCustomer = homePage.clickEditCustomer();
		editCustomer.inputToCustomerId(NewCustomerScript.custmerId);
		editCustomer.clickSubmitEditCustomer();
		editCustomer.clearTextToCityField();
		editCustomer.pressToCityField(Keys.TAB);
		assertEquals(editCustomer.getMessageCityField(), commonData.getEditCustomer().getExpectedEmptyCityMsg());
	}

	@Test
	public void EC10_CityNotNumberic() {
		//editCustomer = homePage.clickEditCustomer();
		editCustomer.inputToCustomerId(NewCustomerScript.custmerId);
		editCustomer.clickSubmitEditCustomer();
		editCustomer.clearTextToCityField();
		editCustomer.inputToCityField(commonData.getEditCustomer().getNumeric());
		assertEquals(editCustomer.getMessageCityField(), commonData.getEditCustomer().getExpectedNumbericMsg());
	}

	@Test
	public void EC11_CityCannotHaveSpecialCharacter() {
		//editCustomer = homePage.clickEditCustomer();
		editCustomer.inputToCustomerId(NewCustomerScript.custmerId);
		editCustomer.clickSubmitEditCustomer();
		editCustomer.clearTextToCityField();
		editCustomer.inputToCityField(commonData.getEditCustomer().getSpecialCharacter());
		assertEquals(editCustomer.getMessageCityField(), commonData.getEditCustomer().getExpectedSpecialCharacterMsg());

	}

	@Test
	public void EC12_StateFieldEmpty() {
		//editCustomer = homePage.clickEditCustomer();
		editCustomer.inputToCustomerId(NewCustomerScript.custmerId);
		editCustomer.clickSubmitEditCustomer();
		editCustomer.clearTextToStateField();
		editCustomer.pressToStateField(Keys.TAB);
		assertEquals(editCustomer.getMessageStateField(), commonData.getEditCustomer().getExpectedEmptyStateFieldMsg());
	}

	@Test
	public void EC13_StateWithNumeric() {
		//editCustomer = homePage.clickEditCustomer();
		editCustomer.inputToCustomerId(NewCustomerScript.custmerId);
		editCustomer.clickSubmitEditCustomer();
		editCustomer.clearTextToStateField();
		editCustomer.inputToStateField(commonData.getEditCustomer().getNumeric());
		assertEquals(editCustomer.getMessageStateField(), commonData.getEditCustomer().getExpectedNumbericMsg());
	}

	@Test
	public void EC14_StateFieldWithSpecialCharacter() {
		//editCustomer = homePage.clickEditCustomer();
		editCustomer.inputToCustomerId(NewCustomerScript.custmerId);
		editCustomer.clickSubmitEditCustomer();
		editCustomer.clearTextToStateField();
		editCustomer.inputToStateField(commonData.getEditCustomer().getSpecialCharacter());
		assertEquals(editCustomer.getMessageStateField(), commonData.getEditCustomer().getExpectedSpecialCharacterMsg());
	}

	@Test
	public void EC15_PINMustBeNumeric() {
		//editCustomer = homePage.clickEditCustomer();
		editCustomer.inputToCustomerId(NewCustomerScript.custmerId);
		editCustomer.clickSubmitEditCustomer();
		editCustomer.clearTextToPINField();
		editCustomer.inputToPINField(commonData.getEditCustomer().getNumeric());
		assertEquals(editCustomer.getMessagePINField(), commonData.getEditCustomer().getExpectedIdNotNumberic());
	}

	@Test
	public void EC16_PINFieldEmpty() {
		//editCustomer = homePage.clickEditCustomer();
		editCustomer.inputToCustomerId(NewCustomerScript.custmerId);
		editCustomer.clickSubmitEditCustomer();
		editCustomer.clearTextToPINField();
		editCustomer.pressToPINField(Keys.TAB);
		assertEquals(editCustomer.getMessagePINField(), commonData.getEditCustomer().getExpectedEmptyPINFieldMsg());
	}

	@Test
	public void EC17_PINMustHave6Digits() {
		//editCustomer = homePage.clickEditCustomer();
		editCustomer.inputToCustomerId(NewCustomerScript.custmerId);
		editCustomer.clickSubmitEditCustomer();
		editCustomer.clearTextToPINField();
		editCustomer.inputToPINField(commonData.getEditCustomer().getLessThan6Digits());
		assertEquals(editCustomer.getMessagePINField(), commonData.getEditCustomer().getExpectedNumbericPINFieldMsg());
	}

	@Test
	public void EC18_PINWithSpecialCharacter() {
		//editCustomer = homePage.clickEditCustomer();
		editCustomer.inputToCustomerId(NewCustomerScript.custmerId);
		editCustomer.clickSubmitEditCustomer();
		editCustomer.clearTextToPINField();
		editCustomer.inputToPINField(commonData.getEditCustomer().getSpecialCharacter());
		assertEquals(editCustomer.getMessagePINField(), commonData.getEditCustomer().getExpectedSpecialCharacterMsg());
	}

	@Test
	public void EC19_TelephoneWithEmpty() {
		//editCustomer = homePage.clickEditCustomer();
		editCustomer.inputToCustomerId(NewCustomerScript.custmerId);
		editCustomer.clickSubmitEditCustomer();
		editCustomer.clearTextToTelephoneField();
		editCustomer.pressToTelephoneField(Keys.TAB);
		assertEquals(editCustomer.getMessageTelephoneField(), commonData.getEditCustomer().getExpectedEmptyTelephoneFieldMsg());
	}

	@Test
	public void EC20_TelephoneWithSpecialCharacter() {
		//editCustomer = homePage.clickEditCustomer();
		editCustomer.inputToCustomerId(NewCustomerScript.custmerId);
		editCustomer.clickSubmitEditCustomer();
		editCustomer.clearTextToTelephoneField();
		editCustomer.inputToTelephoneField(commonData.getEditCustomer().getSpecialCharacter());
		assertEquals(editCustomer.getMessageTelephoneField(), commonData.getEditCustomer().getExpectedSpecialCharacterMsg());
	}

	@Test
	public void EC21_EmailEmpty() {
		//editCustomer = homePage.clickEditCustomer();
		editCustomer.inputToCustomerId(NewCustomerScript.custmerId);
		editCustomer.clickSubmitEditCustomer();
		editCustomer.clearTextToEmailField();
		editCustomer.pressToEmailField(Keys.TAB);
		assertEquals(editCustomer.getMessageEmailField(), commonData.getEditCustomer().getExpectedEmptyEmailFieldMsg());

	}

	@Test
	public void EC22_EmailWithInvalidFormat() {
		//editCustomer = homePage.clickEditCustomer();
		editCustomer.inputToCustomerId(NewCustomerScript.custmerId);
		editCustomer.clickSubmitEditCustomer();
		editCustomer.clearTextToEmailField();
		editCustomer.inputToEmailField(commonData.getEditCustomer().getInvaldFormatMail());
		assertEquals(editCustomer.getMessageEmailField(), commonData.getEditCustomer().getExpectedInvalidFormatEmailMsg());

	}

	@AfterClass
	public void AfterClass() {
		closeBrowser();

	}
}
