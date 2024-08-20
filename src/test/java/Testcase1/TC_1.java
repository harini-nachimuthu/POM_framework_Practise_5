package Testcase1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class TC_1 {
	protected String url="https://www.godaddy.com/en-in";
	WebDriver driver=null;
	
  @Test
  public void f() {
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }
  @BeforeSuite
  public void beforeSuite() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  
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
