package com.bankguru.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.bankguru.ui.EditCustomerPageUI;
import com.bankguru.ui.NewCustomerPageUI;

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
	
	public void clickSubmitEditCustomer() {
		waitForElementVisible(EditCustomerPageUI.SUBMIT_BTN);
		clickToElement(EditCustomerPageUI.SUBMIT_BTN);
	}
	
	public String getTilelEditPage() {
		return getTitle();
	}
	
	
	public void clearTextToAddressField() {
		waitForElementVisible(EditCustomerPageUI.ADDRESS_TXT);
		clearElement(EditCustomerPageUI.ADDRESS_TXT);
	}
	
	public void pressToAddressField(Keys key) {
		waitForElementVisible(EditCustomerPageUI.ADDRESS_TXT);
		sendKeyPress(EditCustomerPageUI.ADDRESS_TXT, key);
	}
	
	public String getMessageAddressField() {
		waitForElementVisible(EditCustomerPageUI.ADDRESS_LBL);
		return getTextElement(EditCustomerPageUI.ADDRESS_LBL);
	}
	
	
	
	public void clearTextToCityField() {
		waitForElementVisible(EditCustomerPageUI.CITY_TXT);
		clearElement(EditCustomerPageUI.CITY_TXT);
	}
	
	public void pressToCityField(Keys key) {
		waitForElementVisible(EditCustomerPageUI.CITY_TXT);
		sendKeyPress(EditCustomerPageUI.CITY_TXT, key);
	}
	
	public String getMessageCityField() {
		waitForElementVisible(EditCustomerPageUI.CITY_LBL);
		return getTextElement(EditCustomerPageUI.CITY_LBL);
	}
	
	public void inputToCityField(String value) {
		waitForElementVisible(EditCustomerPageUI.CITY_TXT);
		inputElement(EditCustomerPageUI.CITY_TXT, value);
	}
	
	
	
	public void clearTextToStateField() {
		waitForElementVisible(EditCustomerPageUI.STATE_TXT);
		clearElement(EditCustomerPageUI.STATE_TXT);
	}
	
	public void pressToStateField(Keys key) {
		waitForElementVisible(EditCustomerPageUI.STATE_TXT);
		sendKeyPress(EditCustomerPageUI.STATE_TXT, key);
	}
	
	public void inputToStateField(String value) {
		waitForElementVisible(EditCustomerPageUI.STATE_TXT);
		inputElement(EditCustomerPageUI.STATE_TXT, value);
	}
	
	public String getMessageStateField() {
		waitForElementVisible(EditCustomerPageUI.STATE_LBL);
		return getTextElement(EditCustomerPageUI.STATE_LBL);
	}
	
	
	public void clearTextToPINField() {
		waitForElementVisible(EditCustomerPageUI.PINFIELD_TXT);
		clearElement(EditCustomerPageUI.PINFIELD_TXT);
	}
	
	public void pressToPINField(Keys key) {
		waitForElementVisible(EditCustomerPageUI.PINFIELD_TXT);
		sendKeyPress(EditCustomerPageUI.PINFIELD_TXT, key);
	}
	
	public void inputToPINField(String value) {
		waitForElementVisible(EditCustomerPageUI.PINFIELD_TXT);
		inputElement(EditCustomerPageUI.PINFIELD_TXT, value);
	}
	
	public String getMessagePINField() {
		waitForElementVisible(EditCustomerPageUI.PINFIELD_LBL);
		return getTextElement(EditCustomerPageUI.PINFIELD_LBL);
	}
	
	
	public void clearTextToTelephoneField() {
		waitForElementVisible(EditCustomerPageUI.TELEPHONEFIELD_TXT);
		clearElement(EditCustomerPageUI.TELEPHONEFIELD_TXT);
	}
	
	public void pressToTelephoneField(Keys key) {
		waitForElementVisible(EditCustomerPageUI.TELEPHONEFIELD_TXT);
		sendKeyPress(EditCustomerPageUI.TELEPHONEFIELD_TXT, key);
	}
	
	public void inputToTelephoneField(String value) {
		waitForElementVisible(EditCustomerPageUI.TELEPHONEFIELD_TXT);
		inputElement(EditCustomerPageUI.TELEPHONEFIELD_TXT, value);
	}
	
	public String getMessageTelephoneField() {
		waitForElementVisible(EditCustomerPageUI.TELEPHONEFIELD_LBL);
		return getTextElement(EditCustomerPageUI.TELEPHONEFIELD_LBL);
	}
	
	
	public void clearTextToEmailField() {
		waitForElementVisible(EditCustomerPageUI.EMAILFIELD_TXT);
		clearElement(EditCustomerPageUI.EMAILFIELD_TXT);
	}
	
	public void pressToEmailField(Keys key) {
		waitForElementVisible(EditCustomerPageUI.EMAILFIELD_TXT);
		sendKeyPress(EditCustomerPageUI.EMAILFIELD_TXT, key);
	}
	
	public void inputToEmailField(String value) {
		waitForElementVisible(EditCustomerPageUI.EMAILFIELD_TXT);
		inputElement(EditCustomerPageUI.EMAILFIELD_TXT, value);
	}
	
	public String getMessageEmailField() {
		waitForElementVisible(EditCustomerPageUI.EMAILFIELD_LBL);
		return getTextElement(EditCustomerPageUI.EMAILFIELD_LBL);
	}
	

}
