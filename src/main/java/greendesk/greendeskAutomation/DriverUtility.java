package greendesk.greendeskAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtility

{
	public WebDriver browser;

	public DriverUtility() {
		System.setProperty("webdriver.chrome.driver", "/Users/jueluddin/Desktop/chromedriver");
		browser = new ChromeDriver();
	}

	public WebDriver getdriver(String browserType) {
		if (browserType == "chrome") {
			if (browser == null) {
				browser = new ChromeDriver();
				return browser;
			} else {
				return browser;
			}

		} else {
			if (browser == null) {
				browser = new FirefoxDriver();
				return browser;
			} else {
				return browser;
			}

		}

	}
	
	public void closeBrowser() {
		browser.close();
		browser.quit();
	}
	
	
	
	
}
