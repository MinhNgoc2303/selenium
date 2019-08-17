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
	
	
	public void pressKeyToAddress(Keys key) {
		waitForElementVisible(NewCustomerPageUI.ADDRESS_TXT);
		sendKeyPress(NewCustomerPageUI.ADDRESS_TXT, key);
	}

	public String getMessageAdressField() {
		waitForElementVisible(NewCustomerPageUI.ADDRESS_LBL);
		return getTextElement(NewCustomerPageUI.ADDRESS_LBL);
	}
	
	
	public void pressKeyToCityField(Keys key) {
		waitForElementVisible(NewCustomerPageUI.CITYFIELD_TXT);
		sendKeyPress(NewCustomerPageUI.CITYFIELD_TXT, key);
	}
	
	public String getMessageCityField( ) {
		waitForElementVisible(NewCustomerPageUI.CITYFIELD_LBL);
		return getTextElement(NewCustomerPageUI.CITYFIELD_LBL);	
	}
	
	public void inputCityField(String value) {
		waitForElementVisible(NewCustomerPageUI.CITYFIELD_TXT);
		inputElement(NewCustomerPageUI.CITYFIELD_TXT, value);
	}
	
	
	public void pressKeyToStateField(Keys key) {
		waitForElementVisible(NewCustomerPageUI.STATEFIELD_TXT);
		sendKeyPress(NewCustomerPageUI.STATEFIELD_TXT, key);
	}
	
	public String getMessageStateField( ) {
		waitForElementVisible(NewCustomerPageUI.STATEFIELD_LBL);
		return getTextElement(NewCustomerPageUI.STATEFIELD_LBL);	
	}
	
	public void inputStateField(String value) {
		waitForElementVisible(NewCustomerPageUI.STATEFIELD_TXT);
		inputElement(NewCustomerPageUI.STATEFIELD_TXT, value);
	}
	
	
	public void pressKeyToPINField(Keys key) {
		waitForElementVisible(NewCustomerPageUI.PINFIELD_TXT);
		sendKeyPress(NewCustomerPageUI.PINFIELD_TXT, key);
	}
	
	public String getMessagePINField( ) {
		waitForElementVisible(NewCustomerPageUI.PINFIELD_LBL);
		return getTextElement(NewCustomerPageUI.PINFIELD_LBL);	
	}
	
	public void inputPINField(String value) {
		waitForElementVisible(NewCustomerPageUI.PINFIELD_TXT);
		inputElement(NewCustomerPageUI.PINFIELD_TXT, value);
	}
	
	
	public void pressKeyToTelephoneField(Keys key) {
		waitForElementVisible(NewCustomerPageUI.TELEPHONEFIELD_TXT);
		sendKeyPress(NewCustomerPageUI.TELEPHONEFIELD_TXT, key);
	}
	
	public String getMessageTelephoneField( ) {
		waitForElementVisible(NewCustomerPageUI.TELEPHONEFIELD_LBL);
		return getTextElement(NewCustomerPageUI.TELEPHONEFIELD_LBL);	
	}
	
	public void inputTelephoneField(String value) {
		waitForElementVisible(NewCustomerPageUI.TELEPHONEFIELD_TXT);
		inputElement(NewCustomerPageUI.TELEPHONEFIELD_TXT, value);
	}
	
	
	public void pressKeyToEmailField(Keys key) {
		waitForElementVisible(NewCustomerPageUI.EMAILFIELD_TXT);
		sendKeyPress(NewCustomerPageUI.EMAILFIELD_TXT, key);
	}
	
	public String getMessageEmailField( ) {
		waitForElementVisible(NewCustomerPageUI.EMAILFIELD_LBL);
		return getTextElement(NewCustomerPageUI.EMAILFIELD_LBL);	
	}
	
	public void inputEmailField(String value) {
		waitForElementVisible(NewCustomerPageUI.EMAILFIELD_TXT);
		inputElement(NewCustomerPageUI.EMAILFIELD_TXT, value);
	}

}
