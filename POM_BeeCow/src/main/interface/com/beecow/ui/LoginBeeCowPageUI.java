package com.beecow.ui;

public class LoginBeeCowPageUI {
	public static String LOGINHOME_BTN = "//a[@class='login']//span[contains(text(),'Đăng nhập')]";
	public static String USERNAME_TXT ="//input[@id='usr']";
	public static String PASSWORD_TXT = "//input[@id='pwd' and contains(@class,'mrgb15')]";
	public static String LOGIN_BTN = "//button[@beetranslate='beecow.login.login']";
	public static String EMPTYALLFIELDS_MSG="//span[contains(text(),'Hãy nhập email / số điện thoại và mật khẩu')]";
}
