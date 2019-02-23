package greendesk.greendeskAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class WellsFargo extends DriverUtility {
	WebDriver browser;
	String base_url = "https://www.wellsfargo.com/mortgage/rates/calculator/";

	
	@Test
	public void Verify_mortgage_calculator() {
		browser.get(base_url);

		// verify that we are in the right page
		String expected_page_header = "Mortgage Calculator";
		assertTrue(browser.getPageSource().contains(expected_page_header));

		// enter value in home value field
		browser.findElement(By.id("homeValue")).sendKeys("250000");

		// enter value in downpayment field
		browser.findElement(By.id("downPayment")).sendKeys("50000");

		// select credit score
		Select credit_score_dropdown = new Select(browser.findElement(By.id("creditScore")));
		credit_score_dropdown.selectByValue("780");

		// verify that correct loan amount displaying
		String actual_loan_amount_value = browser.findElement(By.id("p_loanAmount")).getText();
		String expected_loan_amount = "200,000";
		assertEquals(actual_loan_amount_value, expected_loan_amount);
		System.out.println("Passed: expected loan ammount: " + expected_loan_amount + "found loan ammount: "
				+ actual_loan_amount_value);

		// select property location state
		Select state_dropdown = new Select(browser.findElement(By.cssSelector("#propertyState")));
		state_dropdown.selectByValue("NY");

		// select property County
		Select propertyCounty_dropdown = new Select(browser.findElement(By.cssSelector("#propertyCounty")));
		propertyCounty_dropdown.selectByValue("New York");

		// click on calculate button
		browser.findElement(By.xpath("//*[@value='Calculate']")).click();

		// verify we are in result page
		String expected_text_result_page = "Purchase Rate and Payment Results";
		assertTrue(browser.getPageSource().contains(expected_text_result_page));

		// click on calculate button
		browser.findElement(By.linkText("View Details >")).click();

		// validate monthly payment

		String expected_monthly_payment = "$999.00";
		String actual_monthly_payment = browser
				.findElement(By.cssSelector("#contentBody > table > tbody > tr:nth-child(1) > td:nth-child(2)"))
				.getText();
		assertEquals(actual_monthly_payment, expected_monthly_payment);

	}

	@BeforeTest
	public void setup() {
		browser = getdriver("chrome");
	}

	@AfterTest
	public void afterTest() {
		browser.close();
		browser.quit();
		

	}

}
