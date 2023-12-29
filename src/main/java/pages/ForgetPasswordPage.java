package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecification;

public class ForgetPasswordPage extends ProjectSpecification{
           
	// element are located by using @Findby annotation
	@FindBy(xpath="//input[@class='css-1cwyjr8 r-homxoj r-13awgt0 r-ubezar r-tmtnm0 r-oxtfae r-10paoce r-ymttw5 r-9qu9m4']")
	WebElement mobile;
	
	@FindBy(xpath="//div[text()='SEND OTP']")
	WebElement send;
	
	@FindBy(xpath="//div[@class='css-76zvg2 r-1862ga2 r-2t9rge r-n6v787 r-1bymd8e']")
	WebElement message;
	
	
	//constructor initialization 
	public ForgetPasswordPage(WebDriver driver) {				
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	    public ForgetPasswordPage enterMobile(String phone) {		
		          sendKeys(mobile,phone);
		          return this;
	    }
	    
	    public ForgetPasswordPage clickSendOTP() {
	    	actionClick(send);
	    	return this;
	    }
	    
	    public ForgetPasswordPage verifyOTPMesaage(String excepted) {	    	
	    	validateText(message,excepted);
	    	return this;
	    }
}
