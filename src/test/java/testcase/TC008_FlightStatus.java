package testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.HomePage;


//this test case for to check fields and button are displayed  or not
public class TC008_FlightStatus extends ProjectSpecification {
       
	@Test
	public void flightStatusTest() throws IOException, InterruptedException {
		
		new HomePage(driver)
		.clickFlightStatus()
		.checkFrom()
		.checkTo()
		.checkFlightNo()
		.checkSearchButton()
		.capture("TC008_FlightStatus");
	}

}
