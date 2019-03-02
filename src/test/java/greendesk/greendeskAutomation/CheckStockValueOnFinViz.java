package greendesk.greendeskAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class CheckStockValueOnFinViz extends DriverUtility {
	 WebDriver browser; 
	 String base_url = "https://finviz.com/"; 
	 
  @Test
  public void Verify_Face_Book_Stock_Details() {
	  browser.get(base_url);
	  
	  //Do later
	  
  }
  
  @BeforeTest
  public void CallDriver() {
		 browser = getdriver("chrome");
  }

  @AfterTest
  public void tearDown() {
		closeBrowser();
  }

}
