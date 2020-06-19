package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageFactory.DataProviderFactory;
import pages.AdminPage;
import pages.BaseClass;
import pages.LoginPage;
import pages.LogoutPage;

public class TC_001 extends BaseClass{
	LoginPage login;
	LogoutPage logout;	
	AdminPage admin;
	
	@Test(priority=0)
	public void verifyPage()
	{		
			
		login=PageFactory.initElements(driver, LoginPage.class);
		
		logout=PageFactory.initElements(driver, LogoutPage.class);	
		
		admin=PageFactory.initElements(driver, AdminPage.class);
		
		logger=report.createTest("URL validation");
		
		login.verifyUrlBeforeLogin();	
		
		logger.info("Validating url");
		
	}
	
	@Test(priority=1,dependsOnMethods="verifyPage")
	public void loginToApplication()
	{
		
		logger=report.createTest("Login as admin");
		
		login.loginToApplication(DataProviderFactory.getExcel().getCellData("OrangeHRM", 1, 0),
				
				DataProviderFactory.getExcel().getCellData("OrangeHRM", 1, 1));
		
		login.verifyUrlAfterLogin();
		
		logger.info("Logged in");
	}
	
	@Test(priority=2,dependsOnMethods="loginToApplication")
	public void logoutFromApplication()
	{
		logger=report.createTest("User addition");
		
		admin.createUser();
		
		logger.info("User added ");
		
	}

}
