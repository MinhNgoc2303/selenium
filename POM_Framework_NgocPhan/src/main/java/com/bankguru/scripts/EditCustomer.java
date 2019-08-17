package com.bankguru.scripts;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.actions.EditCustomerPage;
import com.bankguru.actions.HomePage;
import com.bankguru.actions.LoginPage;
import com.bankguru.actions.RegisterPage;

import common.CommonTestCase;

public class EditCustomer extends CommonTestCase {
	WebDriver driver;
	LoginPage loginPage;
	RegisterPage registerPage;
	HomePage homePage;
	EditCustomerPage editCustomer;
	String email, username, password;
	String expectedEmptyCusId, idNotNumberric, expectedIdNotNumberic;

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void BeforeClass(String browser, String version, String url) {
		
		expectedEmptyCusId= "Customer ID is required";
		idNotNumberric ="123ngoc";
		expectedIdNotNumberic = "Characters are not allowed";

		driver = openBrowser(browser, version, url);// ham tra ve webdriver
		email = "ngoc" + randomemail() + "@gmail.com";
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		registerPage = loginPage.clickHereLink();
		registerPage.inputEmail(email);
		registerPage.clickRegister();
		username = registerPage.getUserName();
		password = registerPage.getPassword();

		registerPage.openLogInBankGuru(url);
		System.out.println(url);
		loginPage.inputUserID(username);
		loginPage.inputPassword(password);
		homePage = loginPage.clickLogin();

		String welcomText = homePage.verifyHomePage();

		assertTrue(welcomText.contains("Welcome"));

	}

	@Test
	public void EC01_CustomerIdEmpty() {
		editCustomer = homePage.clickEditCustomer();
		editCustomer.pressToCustomerId(Keys.TAB);
		assertEquals(editCustomer.getMessageOfCustomerId(), expectedEmptyCusId);
	}
	
	@Test
	public void EC02_CustomerIdNotNumberic() {
		editCustomer = homePage.clickEditCustomer();
		editCustomer.inputToCustomerId(idNotNumberric);
		assertEquals(editCustomer.getMessageOfCustomerId(), expectedIdNotNumberic );
	}
	
	@Test
	public void EC03_CustomerIdNotNumberic() {
		editCustomer = homePage.clickEditCustomer();
	}
	@Test
	public void EC04_CustomerIdNotNumberic() {
		editCustomer = homePage.clickEditCustomer();
	}
	
	@Test
	public void EC05_CustomerIdNotNumberic() {
		editCustomer = homePage.clickEditCustomer();
	}
	@Test
	public void EC06_CustomerIdNotNumberic() {
		editCustomer = homePage.clickEditCustomer();
	}
	
	@Test
	public void EC07_CustomerIdNotNumberic() {
		editCustomer = homePage.clickEditCustomer();
	}
	
	
	@Test
	public void EC08_CustomerIdNotNumberic() {
		editCustomer = homePage.clickEditCustomer();
	}
	@Test
	public void EC09_CustomerIdNotNumberic() {
		editCustomer = homePage.clickEditCustomer();
	}
	@Test
	public void EC10_CustomerIdNotNumberic() {
		editCustomer = homePage.clickEditCustomer();
	}
	
	
	@Test
	public void EC11_CustomerIdNotNumberic() {
		editCustomer = homePage.clickEditCustomer();
	}
	@Test
	public void EC12_CustomerIdNotNumberic() {
		editCustomer = homePage.clickEditCustomer();
	}
	@Test
	public void EC13_CustomerIdNotNumberic() {
		editCustomer = homePage.clickEditCustomer();
	}
	
	
	@Test
	public void EC14_CustomerIdNotNumberic() {
		editCustomer = homePage.clickEditCustomer();
	}
	@Test
	public void EC15_CustomerIdNotNumberic() {
		editCustomer = homePage.clickEditCustomer();
	}
	@Test
	public void EC16_CustomerIdNotNumberic() {
		editCustomer = homePage.clickEditCustomer();
	}
	@Test
	public void EC17_CustomerIdNotNumberic() {
		editCustomer = homePage.clickEditCustomer();
	}
	
	
	@Test
	public void EC18_CustomerIdNotNumberic() {
		editCustomer = homePage.clickEditCustomer();
	}
	@Test
	public void EC19_CustomerIdNotNumberic() {
		editCustomer = homePage.clickEditCustomer();
	}
	
	
	@Test
	public void EC20_CustomerIdNotNumberic() {
		editCustomer = homePage.clickEditCustomer();
	}
	@Test
	public void EC21_CustomerIdNotNumberic() {
		editCustomer = homePage.clickEditCustomer();
	}
	@Test
	public void EC22_CustomerIdNotNumberic() {
		editCustomer = homePage.clickEditCustomer();
	}
	
	@Test
	public void EC23_CustomerIdNotNumberic() {
		editCustomer = homePage.clickEditCustomer();
	}
}
