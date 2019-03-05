package greendesk.greendeskAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
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
	  
	  //Select dropdown for year of car
	  
	  Select year_model_dropdown = new Select(browser.findElement(By.name("salesLead.configuredVehicle.modelyear")));
	  year_model_dropdown.selectByIndex(1);
	  
	  // select dropdown for car model
	  
	  //Select model_dropdown = new Select (browser.findElement(By.xpath("//*[@id=\"select_vehicle\"]/div/div[2]/div/div[2]/div/div/div/div[1]/div[2]")));
	  //model_dropdown.selectByValue("camaro");

	  //enter client name on text field
	  browser.findElement(By.id("gmit-gf-first-name")).sendKeys("mario");
	  
	  //enter client last name field
	  browser.findElement(By.id("gmit-gf-last-name")).sendKeys("montana");
	  
	  // enter address on text field
	  Random rand = new Random(System.currentTimeMillis());
	  int num = rand.nextInt(99); 
	  int num2 = rand.nextInt(98);
	  browser.findElement(By.id("address_1")).sendKeys(num + "-" + num2 + " main st");
	  
	  //first clear default text on field, then enter City on required City text field
	  browser.findElement(By.name("salesLead.address.city")).clear();
	  browser.findElement(By.id("cityname")).sendKeys("Bayside");
	  
	  //select state on dropdown on state
	  
	  Select State_dropdown_chevy_quote = new Select(browser.findElement(By.id("state")));
	  State_dropdown_chevy_quote.selectByVisibleText("New York");
	  
	  
	  //enter valid zip code
	  
	 browser.findElement(By.id("gmit-gf-postal-code")).clear();
	 browser.findElement(By.id("gmit-gf-postal-code")).sendKeys("11360");
	 
	 //enter email address for car quote
	 browser.findElement(By.id("email_address")).sendKeys("mar_"+num +"@gmail.com");
	 
	  
	  
	  
	  
	  
	 
	  
	  
	  
	  
  }
  @BeforeTest
  public void Callbrowser () {
	  browser = getdriver ("chrome");
	  
  }

  @AfterTest
  public void Abort() {
	  //closeBrowser();
	  //browser.quit();
  }

}
