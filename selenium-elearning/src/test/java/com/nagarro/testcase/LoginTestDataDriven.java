package com.nagarro.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nagarro.page.BaseTest;
import com.nagarro.page.LoginPage;
import com.nagarro.utility.ReadExcelFile;

public class LoginTestDataDriven extends BaseTest {

	String fileName = System.getProperty("user.dir") + "\\TestData\\elearning_testdata.xlsx";

	@Test(priority = 1, dataProvider = "LoginDataProvider")
	void verifyLogin(String userEmail, String userPwd) throws IOException {
		LoginPage lp = new LoginPage(driver);
//		String userName = "Demo12";
//		String password = "Test123456$";
		lp.loginToPortal(userEmail, userPwd);
		if (userEmail.equals("Demo12") && userPwd.equals("Test123456$")) {
			System.out.println("Test Passed");
			Assert.assertTrue(true);
			lp.logout();
		} else {
			captureScreenShot(driver, userPwd);
			Assert.assertTrue(false);
		}
	}

	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider() {

		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginData");

		String data[][] = new String[ttlRows - 1][ttlColumns];

		for (int i = 1; i < ttlRows; i++) {
			for (int j = 0; j < ttlColumns; j++) {
				data[i - 1][j] = ReadExcelFile.getCellValue(fileName, "LoginData", i, j);
			}
		}
		return data;
	}
}
