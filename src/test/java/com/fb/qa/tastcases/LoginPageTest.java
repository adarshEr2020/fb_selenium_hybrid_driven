package com.fb.qa.tastcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.BaseClass;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.util.GetTestData;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners(com.fb.qa.listener.ListnerTest.class)
public class LoginPageTest extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
//	GetTestData getTest;
	public static String sheetname = "user_data";

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initiazations();
		loginPage = new LoginPage();
//		getTest = new GetTestData();
	}

	@DataProvider
	public Object[][] getLoginTestData() {
		Object data[][] = GetTestData.getTestData(sheetname);
		return data;
	}

	@Test(dataProvider = "getLoginTestData")
	@Description("multiple user login...")
	@Severity(SeverityLevel.CRITICAL)
	@Feature("login : 2")
	@Story("Muliple facebook user login... ")
	public void multipleLoign(String username, String password) {
		loginPage.multipleUserLogin(username, password);
	}

	@Test
	@Description("single user login...")
	@Severity(SeverityLevel.CRITICAL)
	@Feature("login : 2")
	@Story("Indivisual facebook user login... ")
	
	public void loginTest() throws InterruptedException {
	homePage =  loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	System.out.println(homePage);
//		driver.close();
	}

	@Test
	@Description("crate user account...")
	@Severity(SeverityLevel.CRITICAL)
	@Feature("create account : 1")
	@Story("creating facebook user account... ")
	
	public void switchToCreateAcc() {
		loginPage.switchToCreateAcc();
//		driver.close();
	}

	@Test
	@Description("forget user password...")
	@Severity(SeverityLevel.CRITICAL)
	@Feature("forget pass : 1")
	@Story("forgeting facebook user account pass... ")
	
	public void switchToForgetPass() throws InterruptedException {
		loginPage.switchToForgetPassword();
//		driver.close();
	}

	@Test
	@Description("switching creat fb page...")
	@Severity(SeverityLevel.CRITICAL)
	@Feature("crate fb page : 3 ")
	@Story("switching to create facebook page... ")
	
	public void switchToCreateFbPage() {
		loginPage.switchToFbPage();
//		driver.close();
	}

}
