package utility;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BaseUtility {
	public static WebDriver driver;
	public String excelfile;
	
	// for Browser launch
	public void launchBroswer(String url, String browser) throws InterruptedException {
		  		  
		  	ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			
			if(browser.equalsIgnoreCase("chrome")) {
				
			driver = new ChromeDriver(options);
				} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			    } else if (browser.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
			    } else {
			driver = new ChromeDriver(options);
			    }
			
		   // window maximize
			sleep();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			driver.get(url);
			
	        }
			
		    // close the browser
	        public void close() {
		       driver.close();
	         }
	        //click on element   
	        public void click(WebElement element) {
		        element.click();
	         }
	        //pass value through sendkeys    
	        public void sendKeys(WebElement ele, String value) {
				
				ele.sendKeys(value);
	        
	         }	
	        //take data from excel file  
	        public static String[][] readExcel(String excelfile) throws IOException {
				XSSFWorkbook book =new XSSFWorkbook("./data/"+excelfile+".xlsx");
				XSSFSheet sheet = book.getSheet("Sheet1");
				int rowcount = sheet.getLastRowNum();
				short columncount = sheet.getRow(0).getLastCellNum();
				String [][] data=new String[rowcount][columncount];		
				for(int i=1;i<=rowcount; i++) {
				XSSFRow row =sheet.getRow(i);
				for(int j=0;j<columncount; j++) {
				XSSFCell cell = row.getCell(j);			
					
				data[i-1][j]=cell.getStringCellValue();
					}
					
				}
				book.close();
				return data;
	        }
	        
	      //for use thread.sleep  
	        public void sleep() throws InterruptedException {	    		
	    			Thread.sleep(5000);
	       	}
	        
	        //to wait till the element to be available
	        public void waitForVisible(WebElement element) {
	        	WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(6000));
	        	wait.until(ExpectedConditions.visibilityOf(element));
	        }
	        
	        // to wait for an alert
	        public void waitForAlert() {
	        	WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(30));
	        	wait.until(ExpectedConditions.alertIsPresent());
	        	
	        }
	        //getTitle
	        public String getTitle() {
	        	String title=driver.getTitle();
	        	return title;
	        	
	        }
	        
	        //for getText
	        public String getText(WebElement element) {	        	
	        	String text=element.getText();
	        	return text;
	        }
	        
	       //to scroll down until the webelement using java script executor  
	        public void scrollUntillElement(WebElement element) {
	        	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	        }
	        
	        //for accept alert
	        public void acceptAlert() {
	        	Alert alert=driver.switchTo().alert();
	        	alert.accept();
	        }
	        
	        //navigate back
	        public void back() {
	        	driver.navigate().back();
	        		        	
	        }
	        //navigate forward
	        public  void forward() {
	    		driver.navigate().forward();
	    	}
	        
	      
	        //refresh webpage
	        public  void refresh() {
	        	driver.navigate().refresh();
	        }
	        
	        //using dropdown to select the value
	        public void select(WebElement element,String value) {
	        	
	        	Select option=new Select(element);
	        	option.selectByVisibleText(value);
	        }
	        
	        // to mousehover an element using action class
	        public void moveToElement(WebElement element) {
	        	Actions action=new Actions(driver);
	        	action.moveToElement(element).perform();
	        	
	        }
	        
	        //to click an element using action class
	        public void actionClick(WebElement element) {
	        	
	        	Actions builder= new Actions(driver);
	        	builder.click(element).perform();
	        	
	        }
	        //Assertion
	        public void softAssert(String actual ,String expected) {
	        	SoftAssert so=new SoftAssert();
	        	so.assertEquals(actual,expected);
	        	
	        }
	        //validate title
	        public void validateTitle(String expected) {
	        	String actual=driver.getTitle();
	        	Assert.assertEquals(actual, expected);
	        	System.out.println("Titles are Matched");
	        }
	        //validate text
	        public void validateText(WebElement element,String expected) {
	        	String actual=element.getText();
	        	Assert.assertEquals(actual, expected);
	        	System.out.println("Message Displayed");
	        }
	        
	        //to take Screenshot
	        public String capture(String name) throws IOException {
	       			TakesScreenshot scs = ((TakesScreenshot) driver);
	    			File source = scs.getScreenshotAs(OutputType.FILE);
	    			String path="./screenshot/" + name + ".png";
	    			File dest=new File(path);
	    			FileUtils.copyFile(source, dest);
	    			return path;
	    		
	    	}
            //to verify whether the link is broken or not
            public void verifyURL(String url) {
            	try {
            		URL site = new URL(url);
            		HttpURLConnection httpURL = (HttpURLConnection) site.openConnection();
            		httpURL.setConnectTimeout(5000);
            		httpURL.connect();
            		if (httpURL.getResponseCode() >= 400) {
            			System.out.println(site + " - " + httpURL.getResponseMessage() + "is a broken link");
            		}
            		else {
            			System.out.println(site + " - " + httpURL.getResponseMessage());
            		}
            	} catch (Exception e) {
            	}
            }
            //switch windows
            public void switchToWindow() {
            	
    			Set<String> windowhandles=driver.getWindowHandles();
    			List<String> first_window=new ArrayList<>(windowhandles);
    			driver.switchTo().window(first_window.get(1));
    			
            }
            
            //click element by using javascriptexecutor
            public void jsClick(WebElement element) {
            	JavascriptExecutor js=(JavascriptExecutor) driver;
            	js.executeScript("arguments[0].click();", element);

}
            //scroll down using java script executor
            public void scrolldown(WebElement element) {
            	JavascriptExecutor js=(JavascriptExecutor) driver;
            	js.executeScript("arguments[0].scrollIntoView(true);", element);

            }
            
          //scroll up using java script executor
            public void scrollup() {
            	JavascriptExecutor js=(JavascriptExecutor) driver;
            	js.executeScript("scroll(0, -250);");
            }
            
            public void clear(WebElement element) {           	
            	element.clear();
            }
            
          //switch to frame by webelement 
            public void switchFrame(WebElement frame) {
            	driver.switchTo().frame(frame);
            }
            
          //Method to come of the  current frame to first frame   
            public void comeOutFromFrame() {
            	driver.switchTo().defaultContent();
            }
            
          //check wether te element is displayed or not  
            public boolean isElementDisplayed(WebElement element) {
            	
            	boolean displayed=element.isDisplayed();
            	if(displayed)
            		System.out.println("Fields are displayed");
            	else
            		System.out.println("Fields are not displayed");
            	return displayed;
            }
            
            //check wether the button is enabled or not
            public boolean isElementEnabled(WebElement element) {
            	
            	boolean enabled=element.isEnabled();
            	if(enabled)
            		System.out.println("Button is enabled");
            	else
            		System.out.println("Button is not enabled");
            	return enabled;
            }
}