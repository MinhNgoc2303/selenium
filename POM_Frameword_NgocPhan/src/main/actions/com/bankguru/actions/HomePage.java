package com.bankguru.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bankguru.ui.HomePageUI;

import common.CommonFunctions;

public class HomePage extends CommonFunctions{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	public String verifyHomePage() {
		waitForElementVisible(HomePageUI.WELCOME_LBL);
		return getTextElement(HomePageUI.WELCOME_LBL);
	}
	public NewCustomerPage clickNewCustomer() {
		waitForElementPresence(HomePageUI.NEWCUSTOMER_LBL);
		clickToElement(HomePageUI.NEWCUSTOMER_LBL);
		return PageFactory.initElements(driver, NewCustomerPage.class);
		
	}

}
