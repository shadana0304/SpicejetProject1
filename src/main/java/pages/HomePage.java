package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecification;

public class HomePage extends ProjectSpecification {
	
	// element are located by using @Findby annotation
	@FindBy(xpath="//div[text()='Signup']")
	WebElement signup;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement login;
	
	@FindBy(xpath="//div[@class='css-76zvg2 r-jwli3a r-ubezar r-1ozqkpa']")
	WebElement flights;
	
	@FindBy(xpath="//div[text()='check-in']")
	WebElement checkin;
	
	@FindBy(xpath="//div[text()='flight status']")
	WebElement flightstatus;
	
	@FindBy(xpath="//div[text()='manage booking']")
	WebElement managebooking;
	
	@FindBy(xpath="//div[@class='css-76zvg2 r-c20mna r-1b43r93']")
	WebElement forgotpassword;
	
	//constructor initialization 
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
				
	}
	
	//click signup button & constructor chaining to signup page
	public SignUpPage clickSignUp() throws InterruptedException {
		click(signup);
		sleep();
		return new SignUpPage(driver);	
		
	}
	
	//click login button & constructor chaining to login page
	public LogInPage clickLogIn() {
		click(login);
		return new LogInPage(driver);
				
	}
	
	//click flight button & constructor chaining to FlightBookingPage page
	public FlightBookingPage clickFlights()  {		
		click(flights);	
		return new FlightBookingPage(driver);
    }
	
	//click checkIn button & constructor chaining to CheckInPage page
	public CheckInPage clickCheckIn() {		
		click(checkin);
		return new CheckInPage(driver);
		
	}
	
	//click flightstatus button & constructor chaining to FlightStatusPage page
	public FlightStatusPage clickFlightStatus() throws InterruptedException {		
		click(flightstatus);
		sleep();
		return new FlightStatusPage(driver);
		
	}
	
	//click managebooking button & constructor chaining to ManageBookingPage page
	public ManageBookingPage clickManageBooking() throws InterruptedException {		
		click(managebooking);
		sleep();
		return new ManageBookingPage(driver);
		
	}
	
	//click logout button & constructor chaining to LogOutPage page
	public LogOutPage clickLogout()  {		
		return new LogOutPage(driver);
		
	}
	
	//click forgetpassword button & constructor chaining to ForgetPasswordPage page
	public ForgetPasswordPage clickForgotPassword() {		
		click(login);
		click(forgotpassword);
		return new ForgetPasswordPage(driver);
	}
	
	
	
	
}