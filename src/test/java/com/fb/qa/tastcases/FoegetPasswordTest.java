package com.fb.qa.tastcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.BaseClass;
import com.fb.qa.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import com.fb.qa.pages.ForgetPassword;

@Listeners(com.fb.qa.listener.ListnerTest.class)
public class FoegetPasswordTest extends BaseClass {
	LoginPage loginPage;
	ForgetPassword forgetPass;

	public FoegetPasswordTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initiazations();
		loginPage = new LoginPage();
		forgetPass = new ForgetPassword();
		loginPage.switchToForgetPassword();
	}

	@Test
	@Description("user login")
	@Severity(SeverityLevel.NORMAL)
	@Feature("login : 2")
	@Story("user login facebook from forgt pass page... ")
	
	public void login() throws InterruptedException {
		forgetPass.loginFromForgtPage(prop.getProperty("email"), prop.getProperty("password"));
//		driver.close();
	}

	
	@Test
	@Description("forget account")
	@Severity(SeverityLevel.CRITICAL)
	@Feature("forget account : 2")
	@Story("user forget facebook account... ")
	
	public void forgetFbAccount() throws InterruptedException {
		forgetPass.switchToForgetAcc();
//		driver.close();
	}
	
	@Test
	@Description("forget pass")
	@Severity(SeverityLevel.CRITICAL)
	@Feature("forget pass : 2")
	@Story("user forget facebook pass... ")
	
	public void forgetPassTest() throws InterruptedException {
		forgetPass.forgetPassword(prop.getProperty("email"));
		Thread.sleep(3000);
//		driver.close();
	}


}
