package com.nagarro.testcase;

import org.testng.annotations.Test;

import com.nagarro.page.BaseTest;
import com.nagarro.page.DashboardPage;
import com.nagarro.page.LoginPage;
import com.nagarro.page.PaymentPage;
import com.nagarro.utility.ReadExcelFile;

public class PaymentTestCase extends BaseTest {

	String fileName = System.getProperty("user.dir") + "\\TestData\\TestPortalData.xlsx";

	@Test(priority = 1)
	void testcourses() {
		LoginPage lp = new LoginPage(driver);
		String username = ReadExcelFile.getCellValue(fileName, "LoginData", 1, 0);
		String password = ReadExcelFile.getCellValue(fileName, "LoginData", 1, 1);
		lp.loginToPortal(username, password);

		DashboardPage dp = new DashboardPage(driver);

		dp.dashboardclick();

		PaymentPage pg = new PaymentPage(driver);
		String crdnum = ReadExcelFile.getCellValue(fileName, "CardDetails", 0, 0);
		String expdate = ReadExcelFile.getCellValue(fileName, "CardDetails", 0, 1);
		String cvcnum = ReadExcelFile.getCellValue(fileName, "CardDetails", 0, 2);

		pg.paymentOption(crdnum, expdate, cvcnum);

	}

}
