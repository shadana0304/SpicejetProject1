package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.HomePage;

//this test case for SignupwithInvalidDetails
public class TC013_SignupWithInvalidDetails extends ProjectSpecification{
         
	//to make data connection with excel
			@BeforeTest
			public void setup() {
				
				excelfile="TC013_SignupWithInvalidDetails";
				
			}
			//using dataprovider parameter to fetch data from excel
			@Test(dataProvider="getData")
			
	public void invalid_signup(String title,String firstname,String lastname,String country,String year,String month,
					String password ,String password1,String message) throws InterruptedException, IOException {
				
				new HomePage(driver)
				.clickSignUp()
				.switchToSignUpPage()
				.selectTitle(title)
				.enterFirstName(firstname)
				.enterLastName(lastname)
				.country(country)
				.ClickDatePicker()
				.selectYear(year)
				.selectMonth(month)
				.selectDate()
				.enterPassword(password)
				.enterConfitmPassword(password1)
				.scrolltoSubmit()
				.clickCheckBox()
				.clickSubmitButton()
				.verifyErrorMessage(message)
				.capture("TC013_SignupWithInvalidDetails");
				

		}
			
}
