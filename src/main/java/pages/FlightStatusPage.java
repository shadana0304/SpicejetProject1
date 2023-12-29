package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecification;

public class FlightStatusPage extends ProjectSpecification{
     
	
	// element are located by using @Findby annotation
	@FindBy(xpath="//div[@class='css-76zvg2 css-bfa6kz r-1862ga2 r-1gkfh8e']")
	WebElement departuredate;
	
	@FindBy(xpath="//div[text()='From']")
	WebElement from;
	
	@FindBy(xpath="//div[text()='To']")
	WebElement to;
	
	@FindBy(xpath="//input[@class='css-1cwyjr8 r-homxoj r-1i10wst r-1eimq0t r-mk0yit r-xfkzu9 r-lnhwgy']")
	WebElement flightno;
	
	@FindBy(xpath="//div[text()='Search Flights']")
	WebElement searchflights;
	
	    //Constructor Initialization
        public FlightStatusPage(WebDriver driver) {		
		       this.driver=driver;
		       PageFactory.initElements(driver, this);
	}
	
        public FlightStatusPage checkDepartureDate() {
        	
        	isElementDisplayed(departuredate);
        	return this;
        }

        public FlightStatusPage checkFrom() {       	
        	isElementDisplayed(from);
        	return this;
        }

        public FlightStatusPage checkTo() {	
        	isElementDisplayed(to);
        	return this;
        }

        public FlightStatusPage checkFlightNo() {      	
        	isElementDisplayed(flightno);
        	return this;
        }

        public FlightStatusPage checkSearchButton() {        	
        	isElementEnabled(searchflights);
        	return this;
        }

}
