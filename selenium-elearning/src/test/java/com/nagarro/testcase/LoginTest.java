package com.nagarro.testcase;

import org.testng.annotations.Test;

import com.nagarro.page.BaseTest;
import com.nagarro.page.LoginPage;

public class LoginTest extends BaseTest {

	String fileName = System.getProperty("user.dir") + "\\TestData\\elearning_testdata.xlsx";

	@Test(priority = 1, dataProvider = "LoginDataProvider")
	void verifyLogin() {
		LoginPage lp = new LoginPage(driver);
		String userName = "Demo12";
		String password = "Test123456$";
		lp.loginToPortal(userName, password);
	}
}
