package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.Utility;

public class AdminPage {
	
	WebDriver driver;
	
	public AdminPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By adminTab=By.xpath("//b[text()='Admin']");
	
	By addButton=By.id("btnAdd");
	
	By username=By.xpath("//*[contains(text(),'Username')]//following::input[1]");
	
	By empName=By.xpath("//*[contains(text(),'Employee Name')]//following::input[1]");
	
	By saveButton=By.id("btnSave");
	
	//By calen=By.xpath("//table[@class='ui-datepicker-calendar']//tr//td//a");
	
	
	public void createUser()
	{
		Utility.waitForWebElement(driver, adminTab).click();
		Utility.waitForWebElement(driver, addButton).click();
		Utility.waitForWebElement(driver, empName).sendKeys("Jasmine Morgan");
		Utility.waitForWebElement(driver, username).sendKeys("Dinesh_55");
		Utility.waitForWebElement(driver, saveButton).click();		
		//Utility.selectValueFromCalendar(Utility.waitForMultipleWebElement(driver, calen), "25");
	}
	

}
