package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.HomePage;


//test case for user booking flight ticket for oneway trip
public class TC006_OneWayTrip extends ProjectSpecification {
     
	//to make data connection with excel
	@BeforeTest
	public void setup() {
		
		excelfile="TC006_OneWayTrip";		
	}	
	//using dataprovider parameter to fetch data from excel
	@Test(dataProvider="getData")
	
	public void oneWayTripTest(String from,String to,String firstname,String lastname,String phone,String mail1,String town,String fname,String lname
			,String number,String name,String month,String year,String code,String msg) throws IOException, InterruptedException {
		
		new HomePage(driver)
		.clickFlights()
		.enterFrom(from)
		.enterTo(to)
		.enterDepartureDate()
		.clickPassengers()
		.addChildren()
		.clickFlightSearch()
		.clickContinue()
		.selectTitle1()
		.enterFirstName1(firstname)
		.enterLastName1(lastname)
		.enterContactNo(phone)
		.enterEmail(mail1)
		.enterCity(town)
		.clickCheckBox()
		.clickNext()
		.selectTitlePassenger2()
		.enterfname(fname)
		.enterlname(lname)
		.clickContinue1()
		.clickContinue2()
		.enterCardNo(number)
		.enterCardName(name)
		.enterMonth(month)
		.enterYear(year)
		.enterCVVNo(code)
		.clickProceedToPay()
		.verifyMessage(msg)
		.capture("TC006_OneWayTrip");
		
		
	}
	
	
}
