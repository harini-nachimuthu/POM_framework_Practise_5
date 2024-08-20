package Testcase_3;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_3 {
	protected String url="https://www.godaddy.com/en-in";
	WebDriver driver=null;
  @Test
  public void f() {
	  String pageSource = driver.getPageSource();
	  String title=driver.getTitle();
	  String currenturl=driver.getCurrentUrl();
	  System.out.println("Title of page : "+title);
	  System.out.println("Currenturl :: "+currenturl);
	  String actualtitle ="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN";
	  String actualurl="https://www.godaddy.com/en-in";
	  Assert.assertEquals(actualtitle, title);
	  Assert.assertEquals(actualurl, currenturl);
	  
	  boolean isTitleInPageSource = pageSource.contains(actualtitle);
		System.out.println("Is title in page source: " + isTitleInPageSource);

		
		//Assert.assertTrue(isTitleInPageSource, "Title is not present in the page source.");
	}
  
  @BeforeSuite
  
  public void beforeSuite() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }
  @BeforeClass

  public void beforecls() {
	  driver.get(url);
  }
  @AfterSuite
  
  public void afterSuite() {
	  if(driver!=null) {
		  driver.quit();
	  }
  }
}
