package TestCase_2;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class TC_2 {
	protected String url="https://www.godaddy.com/en-in";
	WebDriver driver=null;
  @Test
  public void f() {
	  String title=driver.getTitle();
	  String currenturl=driver.getCurrentUrl();
	  System.out.println("Title of page : "+title);
	  System.out.println("Currenturl :: "+currenturl);
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
