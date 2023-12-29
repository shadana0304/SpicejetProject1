package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.HomePage;
//test case for user login with phoneno
public class TC004_LogInWithPhoneNo extends ProjectSpecification{
    
	//to make data connection with excel
	@BeforeTest
	public void setup() {
		
		excelfile="TC004_LogInWithPhno";
		
	}
	//using dataprovider parameter to fetch data from excel
	@Test(dataProvider="getData")
	
	public void logInTestWithPhone(String phone,String password,String text,String title) throws IOException, InterruptedException {
		
		new HomePage(driver)
		.clickLogIn()
        .enterPhoneNo(phone)
        .enterPassword(password)
        .clickLogInButton()
        //.capture("TC004_LogInWithPhone");
        .verifyLoginMessage(text)
        .verifyLoginPage(title)
        .capture("TC004_LogInWithPhoneNo");
        
		
		
		
	}
	
	
	
	
	
	
	
	
	
}




