package greendesk.greendeskAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class ChaseLoanCalculator extends DriverUtility {
 WebDriver browser; 
 String base_url = "https://apply.chase.com/mortgage/CRQ/CustomRateQuote.aspx"; 
	
  @Test
  public void Verify_that_user_can_calculate_loan_for_purchase_single_family() {
	  browser.get(base_url);
	  
	  // verify we are in the right page 
	  String expected_text_quote_page = "CUSTOM RATE & PAYMENT QUOTE"; 
	  String actual_text_quote_page = browser.findElement(By.id("ctl00_CurrentPageTitle")).getText();
	  System.out.println("for debugging only :" + actual_text_quote_page);
	  assertEquals(actual_text_quote_page, expected_text_quote_page);
	  
	  
	  
	  // Select purchase from dropdown
	  Select purchase_type_dropdown = new Select(browser.findElement(By.id("ctl00_CenterContentPlaceHolder_CRQControl_loanTypeList")));
	  purchase_type_dropdown.selectByVisibleText("Purchase");
	  
	  
	  // Select single family from dropdown
	  Select property_type_dropdown = new Select(browser.findElement(By.id("ctl00_CenterContentPlaceHolder_CRQControl_loanTypeList")));
	  property_type_dropdown.selectByValue("0");
	  
	  
	  // Select residence type from dropdown
	  Select residence_type_dropdown = new Select(browser.findElement(By.id("ctl00_CenterContentPlaceHolder_CRQControl_loanTypeList")));
	  residence_type_dropdown.selectByIndex(0);
	  
	  
	  
	  // Select state from dropdown
	  Select state_dropdown = new Select(browser.findElement(By.id("ctl00_CenterContentPlaceHolder_CRQControl_stateList")));
	  state_dropdown.selectByVisibleText("NY");
	  
	  
	 // purchase price 
	  browser.findElement(By.id("ctl00_CenterContentPlaceHolder_CRQControl_homePrice")).sendKeys("600000");
	  
	  // down payment 
	  browser.findElement(By.id("ctl00_CenterContentPlaceHolder_CRQControl_downPayment")).sendKeys("120000");
	  
 
	  // fico score 
	  browser.findElement(By.id("ctl00_CenterContentPlaceHolder_CRQControl_ficoScore")).sendKeys("730");
	  
	  browser.findElement(By.id("ctl00_CenterContentPlaceHolder_RateandPayment")).click();
	  
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
