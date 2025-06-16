package com.nagarro.testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import com.nagarro.page.BaseTest;
import com.nagarro.page.DashboardPage;
import com.nagarro.page.LoginPage;
import com.nagarro.utility.ReadExcelFile;

public class DashboardTest extends BaseTest {

	String fileName = System.getProperty("user.dir") + "\\TestData\\TestPortalData.xlsx";

	@Test(priority = 1)
	public void VerifyLogin() throws IOException {
		LoginPage lp = new LoginPage(driver);
		String username = ReadExcelFile.getCellValue(fileName, "LoginData", 1, 0);
		String password = ReadExcelFile.getCellValue(fileName, "LoginData", 1, 1);
		System.out.println(username + " " + password);
		lp.loginToPortal(username, password);

//		if ((username.equals("Demo12")) && (password.equals("Test123456$"))) {
//			System.out.println("Test Passed");
//			Assert.assertTrue(true);
//		} else {
//			captureScreenShot(driver, "VerifyLogin");
//			Assert.assertTrue(false);
//		}

		DashboardPage dp = new DashboardPage(driver);
		dp.dashboardclick();
	}

//	@Test(priority = 2)
//	public void fetchDashboardText() throws IOException {
//		DashboardPage dp = new DashboardPage(driver);
//		String as = ReadExcelFile.getCellValue(fileName, "dash", 0, 0);
//		System.out.println("This is excel data " + as);
//		dp.dashboardportal(ReadExcelFile.getCellValue(fileName, "dash", 0, 0));
//		dp.dashboardclick();
//
//	}

}
