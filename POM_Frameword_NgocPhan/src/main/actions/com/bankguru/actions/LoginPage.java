package com.bankguru.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bankguru.ui.LoginPageUI;

import common.CommonFunctions;

public class LoginPage extends CommonFunctions{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	public RegisterPage clickHereLink() {
		waitForElementVisible(LoginPageUI.HERE_LBL);
		clickToElement(LoginPageUI.HERE_LBL);
		return PageFactory.initElements(driver, RegisterPage.class);
	}
	public void inputUserID(String value) {
		waitForElementVisible(LoginPageUI.USERID_TXT);
		inputElement(LoginPageUI.USERID_TXT, value);
	}
	public void inputPassword(String value) {
		waitForElementVisible(LoginPageUI.PASSWORD_TXT);
		inputElement(LoginPageUI.PASSWORD_TXT, value);
	}
	public HomePage clickLogin() {
		waitForElementVisible(LoginPageUI.LOGIN_BTN);
		clickToElement(LoginPageUI.LOGIN_BTN);
		return PageFactory.initElements(driver, HomePage.class);
	}

}
