package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecification;

public class ManageBookingPage extends ProjectSpecification{
       
	
	  // element are located by using @Findby annotation
	  @FindBy(xpath="(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-1eimq0t r-1e081e0 r-xfkzu9 r-lnhwgy'])[1]")
	  WebElement ticketnumber;
	
	  @FindBy(xpath="(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-1eimq0t r-1e081e0 r-xfkzu9 r-lnhwgy'])[2]")
	  WebElement email;
	
	  @FindBy(xpath="//div[text()='Search Booking']")
	  WebElement searchbooking;
	
	
	        //Constructor Initialization
            public ManageBookingPage(WebDriver driver) {
		
		         this.driver=driver;
		         PageFactory.initElements(driver, this);
	     }


            public ManageBookingPage checkTicketNumberFeild() {
            	isElementDisplayed(ticketnumber);
            	return this;
            			
            }
            
            public ManageBookingPage checkEmailFeild() {
            	isElementDisplayed(email);
            	return this;
            }

            public ManageBookingPage checkSearchFeild() {
            	isElementDisplayed(searchbooking);
            	return this;
            }


}
