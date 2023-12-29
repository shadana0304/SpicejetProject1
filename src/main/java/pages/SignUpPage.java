package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecification;

public class SignUpPage extends ProjectSpecification {
	
	@FindBy(xpath="//div[@class='col-sm-4 mt-2 px-sm-4']//select[contains(@class,'form-control form-select')]")
	WebElement title;
	
	@FindBy(id="first_name")
	WebElement fname;
	
	@FindBy(id="last_name")
	WebElement lname;
	
	@FindBy(xpath="//select[@class='form-control form-select']")
	WebElement country;
	
	@FindBy(xpath="//img[@class='d-inline-block datepicker']")
	WebElement datepicker;
	
	@FindBy(xpath="//select[@class='react-datepicker__year-select']")
	WebElement selectyear;
	
	@FindBy(xpath="//select[@class='react-datepicker__month-select']")
	WebElement selectmonth;
	
	@FindBy(xpath="//div[text()='22']")
	WebElement selectdate;
	
	@FindBy(xpath="//input[@class=' form-control']")
	WebElement phoneno;
	
	@FindBy(xpath="//input[@id='email_id']")
	WebElement mailid;
	
	@FindBy(xpath="//input[@id='new-password']")
	WebElement password;
	
	@FindBy(xpath="(//img[@class='icon-active'])[1]")
	WebElement eyebox;
	
	@FindBy(id="c-password")
	WebElement confpassword;
	
	@FindBy(xpath="(//img[@alt='eye-icon'])[2]")
	WebElement eyebox1;
	
	@FindBy(xpath="//input[@class='form-check-input mt-02']")
	WebElement checkbox;
	
	@FindBy(xpath="//button[normalize-space()='Submit']")
	WebElement submit;
	
	@FindBy(xpath="(//div[@class='font-13 mt-10 inlineErrors'])[1]")
	WebElement errormessage;
	
	
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
				
	}
	
	public SignUpPage switchToSignUpPage() throws InterruptedException {
		sleep();
		switchToWindow();
		return this;
	}
	
	public SignUpPage selectTitle(String value) throws InterruptedException {
		sleep();
		select(title,value);
		return this;
				
	}
	
	public SignUpPage enterFirstName(String firstname) throws InterruptedException {
		sleep();
		sendKeys(fname,firstname);
		return this;
				
	}
	
	public SignUpPage enterLastName(String lastname) throws InterruptedException {
		
		sendKeys(lname,lastname);
		return this;
				
	}
	
	public SignUpPage country(String value) {
		select(country,value);
		return this;
			
	}
	
	public SignUpPage ClickDatePicker() {
		click(datepicker);
		return this;
	}
	
	public SignUpPage selectMonth(String value) throws InterruptedException {
		sleep();
		select(selectmonth,value);
		return this;
	}
	
	public SignUpPage selectYear(String value) {
		select(selectyear,value);
		return this;
	}
	
	public SignUpPage selectDate() {
		click(selectdate);
		return this;
	}
	
	public SignUpPage enterDate() {
		
		return this;
	}
	
    public SignUpPage enterPhNo(String phno ) {		
		sendKeys(phoneno, phno);
		return this;
	}
    
     public SignUpPage enterMailId(String email) {		
	    sendKeys(mailid, email);
		return this;
	}

     public SignUpPage enterPassword(String pword) {    	
    	 sendKeys(password, pword);
    	 return this;
    	
    }
    
     public SignUpPage clickEyeBox() {    	
    	 click(eyebox);
    	 return this;
    	
    }
     
     public SignUpPage enterConfitmPassword(String conpword) {    	
   	     sendKeys(confpassword, conpword);
   	     return this;
   	
   }
     
     public SignUpPage clickEyeBox1() {    	
    	 click(eyebox1);
    	 return this;
    	
    }
    
     public SignUpPage clickCheckBox() {    	
    	jsClick(checkbox);
    	return this;
    }
    
     public SignUpPage clickSubmitButton() {   
    	 try {
    	click(submit);}
    	 catch(Exception e) {
    		 System.out.println("button not click");
    	 }
    	return this;
    }
     
     public SignUpPage scrolltoSubmit() throws InterruptedException {
 		scrolldown(submit);
 		return this;
 	}
     
     public SignUpPage verifyErrorMessage(String excepted) throws InterruptedException {
 		scrollup();
 		validateText(errormessage,excepted);
 		return this;
 	}
     
}
