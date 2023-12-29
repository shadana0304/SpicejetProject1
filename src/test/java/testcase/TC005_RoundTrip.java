package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.HomePage;


//test case for user booking flight ticket for round trip
public class TC005_RoundTrip extends ProjectSpecification{

	//to make data connection with excel
	@BeforeTest
	public void setup() {
		
		excelfile="TC005_RoundTrip";
		
	}
	//using dataprovider parameter to fetch data from excel
	@Test(dataProvider="getData")
	
	public void roundTripTest(String from,String to,String firstname,String lastname,String phone,String mail1,String town
			,String number,String name,String month,String year,String code,String msg) throws InterruptedException, IOException {
		
		new HomePage(driver)
		.clickFlights()
		.clickRoundTrip()
		.enterFrom(from)
		.enterTo(to)
		.enterDepartureDate()
		.enterReturnDate()
		.clickFlightSearch()
		.clickContinue()
		.selectTitle1()
		.enterFirstName1(firstname)
		.enterLastName1(lastname)
		.enterContactNo(phone)
		.enterEmail(mail1)
		.enterCity(town)		
		.clickCheckBox()
		.clickContinue1()
		.clickContinue2()
		.enterCardNo(number)
		.enterCardName(name)
		.enterMonth(month)
		.enterYear(year)
		.enterCVVNo(code)
		.clickProceedToPay()
		.verifyMessage(msg)
		.capture("TC005_RoundTrip");
		
		
		
	}
}
