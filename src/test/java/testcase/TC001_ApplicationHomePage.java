package testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.HomePage;

//test case for launch application
public class TC001_ApplicationHomePage extends ProjectSpecification {
	
	@Test
	
	public void homePage() throws IOException {
		
		new HomePage(driver)
		.capture("TC001_ApplicationHomePage");
		
	}

}
