package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.HomePage;

//this test case for LogInwithInvalidDetails
public class TC012_LogInwithInvalidDetails extends ProjectSpecification {
	
	//to make data connection with excel
		@BeforeTest
		public void setup() {
			
			excelfile="TC012_LogInWithInvalidDetails";
			
		}
		//using dataprovider parameter to fetch data from excel
		@Test(dataProvider="getData")
		
		public void invlaidLoginTest(String email,String password,String msg) throws InterruptedException, IOException {
			
			//Login page methods called to check login using invalid credentials 
			new HomePage(driver)
			.clickLogIn()
			.clickEmailCheckBox()
			.enterEmail(email)
			.enterPassword(password)
			.clickLogInButton()
			.verifyInvalidMessage(msg)
			.capture("TC012_LogInWithInvalidDetails");
		}
		
		
		

}
