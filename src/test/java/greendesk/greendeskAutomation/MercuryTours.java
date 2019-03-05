package greendesk.greendeskAutomation;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class MercuryTours extends DriverUtility {
	WebDriver browser; 
	 String base_url = "https://mercurytours.com"; 
	 
	 
	 //this is for practice
	 //automation 
	 
	 
  @Test
  public void f() {
  }

  @BeforeTest
  public void CallDriver() {
	
	  
  }

  @AfterTest
  public void tearDown() {
		closeBrowser();
  }
  

}


