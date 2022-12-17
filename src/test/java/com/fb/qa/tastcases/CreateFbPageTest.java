package com.fb.qa.tastcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.BaseClass;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.pages.CreateFbPage;
//import com.fb.qa.pages.SignUpPage;
import com.fb.qa.pages.ForgetPassword;

@Listeners(com.fb.qa.listener.ListnerTest.class)
public class CreateFbPageTest extends BaseClass {
	LoginPage loginPage;
	CreateFbPage createPage;
	ForgetPassword forgetPass;

//	SignUpPage signupPage;
	public CreateFbPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initiazations();
		loginPage = new LoginPage();
//		signupPage =new 	SignUpPage();
		createPage = new CreateFbPage();
		loginPage.switchToFbPage();
		forgetPass = new ForgetPassword();
	}

	@Test
	public void switchSignUpPageFromNavbar() throws InterruptedException {
		createPage.gotoSignUpFromNavELe();
//		Thread.sleep(3000);
//		signupPage.fbSignup(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("email"),
//				prop.getProperty("confirm_email"), prop.getProperty("reg_passwd"), prop.getProperty("b_day"),
//				prop.getProperty("b_month"), prop.getProperty("b_year"));
	}

	@Test
	public void switchToCreateBusiORBrandFBPage() throws InterruptedException {
		createPage.gotoCreateBusiORBrandFBPage();
	}

	@Test
	public void switchToCreateCommuORPFigureFBPage() throws InterruptedException {
		createPage.gotoCreateCommuORPFigureFBPage();
	}

	@Test
	public void loginFromCreateFbpage() throws InterruptedException {
		createPage.loginFromCreateFbPage(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void forgetAcc() throws InterruptedException {
		forgetPass.switchToForgetAcc();
	}

	@Test
	public void switchToSignUpPageFromLoginPop() {
		createPage.gotoSignUpFromPopELe();
	}
}
