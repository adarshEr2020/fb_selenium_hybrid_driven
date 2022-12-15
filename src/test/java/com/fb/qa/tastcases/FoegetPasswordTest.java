package com.fb.qa.tastcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.BaseClass;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.pages.ForgetPassword;

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
	public void login() throws InterruptedException {
		forgetPass.loginFromForgtPage(prop.getProperty("email"), prop.getProperty("password"));
		driver.close();
	}

	
	@Test
	public void forgetFbAccount() throws InterruptedException {
		forgetPass.switchToForgetAcc();
		driver.close();
	}
	
	@Test
	public void forgetPassTest() throws InterruptedException {
		forgetPass.forgetPassword(prop.getProperty("email"));
		Thread.sleep(3000);
		driver.close();
	}


}
