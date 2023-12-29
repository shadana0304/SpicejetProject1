package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecification;

public class CheckInPage extends ProjectSpecification{

	// element are located by using @Findby annotation
	@FindBy(xpath="(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-1eimq0t r-1e081e0 r-xfkzu9 r-lnhwgy'])[1]")
	WebElement ticketnumber;
	
	@FindBy(xpath="(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-1eimq0t r-1e081e0 r-xfkzu9 r-lnhwgy'])[2]")
	WebElement email;
	
	@FindBy(xpath="//div[text()='Search Booking']")
	WebElement searchbooking;
	
	
	//constructor initialization 
	public CheckInPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
				
	}
	
	public CheckInPage checkTicketNumberField() {
		isElementDisplayed(ticketnumber);
		return this;
				
	}

	public CheckInPage checkEmailField() {
		isElementDisplayed(email);
		return this;
	}

	public CheckInPage checkSearchField() {
		isElementDisplayed(searchbooking);
		return this;
	}

	
	
	
}
