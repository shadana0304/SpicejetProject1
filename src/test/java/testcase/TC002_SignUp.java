package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.HomePage;

//test case for signup user with valid credientials to create account
public class TC002_SignUp extends ProjectSpecification{
	
	//to make data connection with excel
	@BeforeTest
	public void setup() {
		
		excelfile="TC002_SignUp";
		
	}
	//using dataprovider parameter to fetch data from excel
	@Test(dataProvider="getData")
	
	
	public void signUpTest(String title,String firstname,String lastname,String country,String month ,String year,String phoneno,
			String email,String password ,String password1 ) throws InterruptedException, IOException {
		
		new HomePage(driver)
		.clickSignUp()
		.switchToSignUpPage()
		.selectTitle(title)
		.enterFirstName(firstname)
		.enterLastName(lastname)
		//.country(country)
		.ClickDatePicker()
		.selectMonth(month)
		.selectYear(year)
		.selectMonth(month)
		.selectDate()
		.enterPhNo(phoneno)
		.enterMailId(email)
		.enterPassword(password)
		.clickEyeBox()
		.enterConfitmPassword(password1)
		.clickEyeBox1()
		.scrolltoSubmit()
		.clickCheckBox()
		.clickSubmitButton()
		.capture("TC002_SignUp");
		
		
		
		
	}

}
