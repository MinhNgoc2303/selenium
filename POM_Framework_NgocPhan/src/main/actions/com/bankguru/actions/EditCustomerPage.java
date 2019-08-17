package com.bankguru.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.bankguru.ui.EditCustomerPageUI;

import common.CommonFunctions;

public class EditCustomerPage extends CommonFunctions{

	public EditCustomerPage(WebDriver driver) {
		super(driver);
	}
	
	public void inputToCustomerId(String value) {
		waitForElementVisible(EditCustomerPageUI.CUSTOMERID_TXT);
		inputElement(EditCustomerPageUI.CUSTOMERID_TXT, value);
	}
	
	public void pressToCustomerId(Keys key) {
		waitForElementVisible(EditCustomerPageUI.CUSTOMERID_TXT);
		sendKeyPress(EditCustomerPageUI.CUSTOMERID_TXT, key);
	}
	
	public String getMessageOfCustomerId() {
		waitForElementVisible(EditCustomerPageUI.CUSTOMERID_LBL);
		return getTextElement(EditCustomerPageUI.CUSTOMERID_LBL) ;	
	}

}
