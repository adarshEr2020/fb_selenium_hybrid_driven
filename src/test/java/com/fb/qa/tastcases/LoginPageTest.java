package com.fb.qa.tastcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.BaseClass;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.util.GetTestData;

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
	public void multipleLoign(String username, String password) {
		loginPage.multipleUserLogin(username, password);
	}

	@Test
	public void loginTest() throws InterruptedException {
	homePage =  loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	System.out.println(homePage);
//		driver.close();
	}

	@Test
	public void switchToCreateAcc() {
		loginPage.switchToCreateAcc();
//		driver.close();
	}

	@Test
	public void switchToForgetPass() throws InterruptedException {
		loginPage.switchToForgetPassword();
//		driver.close();
	}

	@Test
	public void switchToCreateFbPage() {
		loginPage.switchToFbPage();
//		driver.close();
	}

}
