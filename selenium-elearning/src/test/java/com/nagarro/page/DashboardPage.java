package com.nagarro.page;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPage extends BaseTest {

	WebDriver driver;

	// constructor
	public DashboardPage(WebDriver lDriver) {
		this.driver = lDriver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"login-list\"]/li[1]/a")
	WebElement dash;

	@FindBy(xpath = "//*[@id=\"learn-press-user-profile\"]/ul/li[3]")
	WebElement offerAcademies;

	@FindBy(xpath = "//*[@id=\"tab-academies\"]/div/div/ul/li[1]/form/div/button")
	WebElement subsribebtn;

	public void dashboardportal(String dashtext) throws IOException {
		String actualdash = dash.getText();
		System.out.println(actualdash);

		if (actualdash.equals(dashtext)) {
			System.out.println("Test Passed");
		} else {
			captureScreenShot(driver, "fetchDashboardText");
		}
		Assert.assertEquals(dashtext, actualdash);
	}

	public void dashboardclick() {
		dash.click();
		offerAcademies.click();
		subsribebtn.click();
	}

//	public void offeracad()
//	{
//		
//	}
//	
//	public void subscribeClick() {
//		
//	}
}
