package com.bankguru.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.bankguru.ui.NewCustomerPageUI;

import common.CommonFunctions;

public class NewCustomerPage extends CommonFunctions {

	public NewCustomerPage(WebDriver driver) {
		super(driver);
	}

	public void pressKeysToCustomerName(Keys key) {
		waitForElementVisible(NewCustomerPageUI.CUSTOMERNAME_TXT);
		sendKeyPress(NewCustomerPageUI.CUSTOMERNAME_TXT, key);
	}

	public String getMessageCustomerName() {
		waitForElementVisible(NewCustomerPageUI.CUSTOMERNAME_MSG);
		return getTextElement(NewCustomerPageUI.CUSTOMERNAME_MSG);

	}

	public void inputCustomerName(String value) {
		waitForElementVisible(NewCustomerPageUI.CUSTOMERNAME_TXT);
		inputElement(NewCustomerPageUI.CUSTOMERNAME_TXT, value);
	}

//	//public String getMessageWithNumericCase() {
//		waitForElementVisible(NewCustomerPageUI.CUSTOMERNAME_MSG);
//		return getTextElement(NewCustomerPageUI.CUSTOMERNAME_MSG);
//	}
//
//	public void inputSpecialCharacter(String specialCharacterCustomerName) {
//		waitForElementVisible(NewCustomerPageUI.CUSTOMERNAME_MSG);
//		inputElement(NewCustomerPageUI.CUSTOMERNAME_MSG, specialCharacterCustomerName);
//	}
//
//	public String getMsgSpecialCharacter() {
//		waitForElementVisible(NewCustomerPageUI.CUSTOMERNAME_MSG);
//		return getTextElement(NewCustomerPageUI.CUSTOMERNAME_MSG);
//
//	}

}
