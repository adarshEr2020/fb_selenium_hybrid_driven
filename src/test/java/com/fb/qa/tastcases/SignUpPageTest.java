package com.fb.qa.tastcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.BaseClass;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.pages.SignUpPage;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners(com.fb.qa.listener.ListnerTest.class)
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
	@Description("fb user signup test...")
	@Severity(SeverityLevel.CRITICAL)
	@Feature("Signup : 1")
	@Story("The fb user signup with the some details... ")
	public void signUp() {
		loginPage.switchToCreateAcc();
		signUpPage.fbSignup(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("useremail"),
				prop.getProperty("confirm_email"), prop.getProperty("reg_passwd"), prop.getProperty("b_day"),
				prop.getProperty("b_month"), prop.getProperty("b_year"));
	}
}
