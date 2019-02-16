package greendesk.greendeskAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver browser;

	@Test
	public void verify_AbsoluteCare_FIDA_Plan_page_displays() {
		// click get health insurance link
		browser.findElement(By.linkText("Get Health Insurance")).click();
		browser.findElement(By.xpath("//*[@aria-label='More info about Healthfirst AbsoluteCare FIDA Plan']")).click();
		String expected_text = "The Healthfirst AbsoluteCare FIDA Plan is for full-benefit Medicare-Medicaid beneficiaries, age 21 or over, who require community-based, long-term care services or who reside in a nursing home.";
		boolean has_text_in_page = browser.getPageSource().contains(expected_text);
		assertTrue(has_text_in_page);
		System.out.println("test passed: Absolut Care FIDA Plan page displayed");
	}

	@Test
	public void verify_that_info_for_member_has_login_link() {
		browser.findElement(By.linkText("Info For Members")).click();
		String expected_text = "Your secure Healthfirst account is now easier to use!";
		//verify we are in the right page
		assertTrue(browser.getPageSource().contains(expected_text));
		assertTrue(browser.findElement(By.linkText("Member Log In")).isDisplayed());
		assertTrue(browser.findElement(By.linkText("Create Your Account")).isDisplayed());
		
	}

	@BeforeTest
	public void setup() {
		// this code will run before @test
		System.setProperty("webdriver.chrome.driver", "/Users/jueluddin/Desktop/chromedriver");
		browser = new ChromeDriver();
		browser.get("https://healthfirst.org/");
	}

	@AfterTest
	public void afterTest() {
		// this code will run after @test
		browser.close();
		browser.quit();

	}

}
