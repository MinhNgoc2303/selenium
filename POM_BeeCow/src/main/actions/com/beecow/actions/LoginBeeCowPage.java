package com.beecow.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beecow.ui.LoginBeeCowPageUI;

import common.CommonFunctions;

public class LoginBeeCowPage extends CommonFunctions{

	public LoginBeeCowPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickToLoginHome() {
		waitForElementVisible(LoginBeeCowPageUI.LOGINHOME_BTN);
		clickToElement(LoginBeeCowPageUI.LOGINHOME_BTN);
	}
	
	public void inputToUsername(String value) {
		waitForElementVisible(LoginBeeCowPageUI.USERNAME_TXT);
		inputElement(LoginBeeCowPageUI.USERNAME_TXT, value);
	}

	public void inputToPassword(String value) {
		waitForElementVisible(LoginBeeCowPageUI.PASSWORD_TXT);
		inputElement(LoginBeeCowPageUI.PASSWORD_TXT, value);
	}
	
	public void pressToUsernameField(Keys key) {
		waitForElementVisible(LoginBeeCowPageUI.USERNAME_TXT);
		sendKeyPress(LoginBeeCowPageUI.USERNAME_TXT, key);
	}
	
	public void pressToPasswordField(Keys key) {
		waitForElementVisible(LoginBeeCowPageUI.PASSWORD_TXT);
		sendKeyPress(LoginBeeCowPageUI.PASSWORD_TXT, key);
	}
	
	public void clickToLogin() {
		waitForElementVisible(LoginBeeCowPageUI.LOGIN_BTN);
		clickToElement(LoginBeeCowPageUI.LOGIN_BTN);
	}
	
	public String getMessageEmptyCase() {
		
		return null;
		
	}
}
