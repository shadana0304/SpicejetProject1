package testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.HomePage;

//this test case for to check fields and button are displayed or not
public class TC009_ManageBooking extends ProjectSpecification{
            
	@Test
	public void manageBookingTest() throws IOException, InterruptedException {
		
		new HomePage(driver)
		.clickManageBooking()
		.checkTicketNumberFeild()
		.checkEmailFeild()
		.checkSearchFeild()
		.capture("TC009_ManageBooking");
	}
}
