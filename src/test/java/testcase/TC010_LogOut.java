package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.HomePage;

    //this test case for login & Logout page methods are called to click logout button 
    public class TC010_LogOut extends ProjectSpecification{
       
    	//to make data connection with excel
	@BeforeTest
	public void setup() {
		
		excelfile="TC010_LogOut";
		
	}
	//using dataprovider parameter to fetch data from excel
	@Test(dataProvider="getData")
    public void logoutTest(String email,String password ,String text,String title,String msg) throws InterruptedException, IOException {
				
		new HomePage(driver)
		.clickLogIn()
		.clickEmailCheckBox()
		.enterEmail(email)
		.enterPassword(password)
		.clickLogInButton()
		.verifyLoginMessage(text)
		.verifyLoginPage(title)
		.clickLogout()
		.clickUserName()
		.clickLogoutButton()
		.verifyLogoutMessage(msg)
		.capture("TC010_LogOut");
	}

}
