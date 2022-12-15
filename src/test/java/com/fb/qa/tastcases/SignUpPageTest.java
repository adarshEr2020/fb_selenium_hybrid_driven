package com.fb.qa.tastcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.BaseClass;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.pages.SignUpPage;

public class SignUpPageTest extends BaseClass {
	LoginPage loginPage;
	SignUpPage signUpPage;

	SignUpPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initiazations();
		loginPage = new LoginPage();
		signUpPage = new SignUpPage();
	}

	@Test
	public void signUp() {
		loginPage.switchToCreateAcc();
		signUpPage.fbSignup(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("email"),
				prop.getProperty("confirm_email"), prop.getProperty("reg_passwd"), prop.getProperty("b_day"),
				prop.getProperty("b_month"), prop.getProperty("b_year"));
	}
}
