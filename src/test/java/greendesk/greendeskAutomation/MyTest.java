package greendesk.greendeskAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class MyTest extends DriverUtility {
	WebDriver browser;
	String base_url = "https://www.chevrolet.com/request-quote?x-caller=vco&x-modelyear=2019&x-carline=camaro&x-bodystyle=camaro&offerTitle=2019%20CHEVROLET%20Camaro%20Coupe&offerType=Cash&offerSummary=%20%20%24500%20Customer%20Cash%20%20%20%20";
  @Test
  public void Verify_user_can_get_car_quote() {
	  browser.get(base_url);
	  //verify if I am in right page
	  
	  String expected_text_page = "REQUEST A QUOTE";
	  String actual_text_page = browser.findElement(By.className("q-bold2")).getText();
	  System.out.println("For debugging only : " + actual_text_page );
	  assertEquals(actual_text_page, expected_text_page);
  }
  @BeforeTest
  public void Callbrowser () {
	  browser = getdriver ("chrome");
	  
  }

  @AfterTest
  public void Abort() {
	  closeBrowser();
	  browser.quit();
  }

}
