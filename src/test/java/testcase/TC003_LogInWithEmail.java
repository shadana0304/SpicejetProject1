package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.HomePage;

//test case for user login with email
public class TC003_LogInWithEmail extends ProjectSpecification{
      
	//to make data connection with excel
	@BeforeTest
	public void setup() {
		
		excelfile="TC003_LogInWithEmail";
		
	}
	//using dataprovider parameter to fetch data from excel
	@Test(dataProvider="getData")
	
	public void logInTestWithEmail(String email,String password ,String text,String title) throws IOException, InterruptedException {
		
		new HomePage(driver)
		.clickLogIn()
		.clickEmailCheckBox()
		.enterEmail(email)
		.enterPassword(password)
		.clickLogInButton()
		//.capture("TC003_LogInWithMail");
		.verifyLoginMessage(text)
		.verifyLoginPage(title)
		.capture("TC003_LogInWithEmail");
		
		
	}
}
