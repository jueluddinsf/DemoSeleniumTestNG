package greendesk.greendeskAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class MyTest extends DriverUtility {
  @Test
  public void f() {
  }
  @BeforeTest
  public void Callbrowser () {
	  browser = getdriver ("chrome");
	  
  }

  @AfterTest
  public void Abort() {
	  closeBrowser();
  }

}
