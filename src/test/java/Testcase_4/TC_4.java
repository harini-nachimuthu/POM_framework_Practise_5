package Testcase_4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_4 {
	protected String url="https://www.godaddy.com/en-in";
	WebDriver driver=null;

  @Test
  public void f() throws InterruptedException {
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
	  JavascriptExecutor js=(JavascriptExecutor) driver;
	  
	  WebElement menubtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='pl-p1td6cxw']")));
	  js.executeScript("arguments[0].click()", menubtn)	 ; 
	
	  WebElement domainbtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class=\"pl-b1qxqzy9\"])[1]")));
	  js.executeScript("arguments[0].click()", domainbtn)	 ; 	  
	  
	  WebElement searchname=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class=\"pl-ly9402x\"])[1]")));
	  js.executeScript("arguments[0].click()", searchname)	 ; 	 	  
	  
	  //Thread.sleep(3000);
	  
	  String title=driver.getTitle();
	  System.out.println("title :"+title);
	  //String actual="";
	  Thread.sleep(1000);
	  
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
