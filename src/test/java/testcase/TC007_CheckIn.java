package testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.HomePage;


//this test case for to check field and buttons are displayed or not
public class TC007_CheckIn extends ProjectSpecification{
       
	@Test
	public void checkInTest() throws IOException {
		
		new HomePage(driver)
		.clickCheckIn()
		.checkTicketNumberField()
		.checkEmailField()
		.checkSearchField()
		.capture("TC007_CheckIn");
	}
}
