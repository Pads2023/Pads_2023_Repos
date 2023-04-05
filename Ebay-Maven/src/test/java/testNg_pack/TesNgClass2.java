package testNg_pack;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import modules_pack.Categorypg_Pom;
import modules_pack.Conditionpg_Pom;
import page_pack.EbHompage_Pom;
import page_pack.Prodctpg_Pom;
import utils.Utility;

public class TesNgClass2 {
	
	WebDriver driver;
	EbHompage_Pom ebhome;
	Prodctpg_Pom womenpage;
	Conditionpg_Pom conditionPg;
	Categorypg_Pom categoryPg;
	
	//String data;
	
	SoftAssert soft;
	
	String testId;
	
	@BeforeSuite
	public void beforesuite() {
		System.out.println("before suite");
	}
	@Parameters("browser")
	@BeforeTest
	public void beforetest(String browserName) {
	//public void beforetest() {
		System.out.println("before test");
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\Om\\Desktop\\Automation\\chromedriver_win32 (1)\\chromedriver.exe");
		//driver = new ChromeDriver();
		
		
		if(browserName.equals("Chrome"))
		{
			driver = Base.openchromeBrowser();
			//OR
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\Om\\Desktop\\Automation\\chromedriver_win32 (1)\\chromedriver.exe");
		    //driver = new ChromeDriver();
		}
			
		if(browserName.equals("Firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Om\\Desktop\\Automation\\geckodriver-v0.32.2-win32\\geckodriver.exe");
			//driver = new FirefoxDriver();
			
			//OR
			
			driver = Base.openfirefoxBrowser();
		
			
		}
		if(browserName.equals("Opera"))
		{
			//System.setProperty("webdriver.opera.driver","C:\\Users\\Om\\Desktop\\Automation\\operadriver_win32\\operadriver_win32\\operadriver.exe");
			//driver = new OperaDriver();
			
		//OR
		    driver = Base.openoperaBrowser();
		}
		if(browserName.equals("Internet Expoler")) {
			//System.setProperty("webdriver.ie.driver","C:\\Users\\Om\\Desktop\\Automation\\IEDriverServer_Win32_4.8.1\\IEDriverServer.exe");
			//driver = new InternetExplorerDriver();
			
			//OR
			
			driver = Base.openinternetexplorerBrowser();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20));
		
		
					}
	
	
	@BeforeClass
	public void beforeclass() {
		System.out.println("before class");
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));	
	}
	
	@BeforeMethod
	public void beforemethod() {
		System.out.println("before method");
		driver.get("https://www.ebay.com/");
		
		ebhome = new EbHompage_Pom(driver);
		ebhome.mov2fashoin();
		
		//ebhome.serachProdct(String data);
		
		womenpage = new Prodctpg_Pom(driver);
		womenpage.click2women();		
		
		soft = new SoftAssert();
	}
	
	@Test
	public void testA() {
		System.out.println("testA");
		conditionPg = new Conditionpg_Pom(driver);
		conditionPg.click2wmnshoe();
		String actualUrl = conditionPg.getwmnshoeurl();
		String  expectedUrl = "https://www.ebay.com/b/Womens-Shoes/3034/bn_740022";
		//SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualUrl, expectedUrl);
		soft.assertAll();
		//Assert.assertEquals(actualUrl, expectedUrl, "Url is wrong");
		
		
	}
	
	@Test
	public void testB() {
		testId="T1_4587";
		System.out.println("testB");
		categoryPg = new Categorypg_Pom(driver);
		categoryPg.click2womenbag();
		String actualUrl = categoryPg.geturl1();
		String  expectedUrl = "https://www.ebay.com/b/Womens-Bags-Handbags/169291/bn_738272@@";
		soft.assertEquals(actualUrl, expectedUrl);
		soft.assertAll();
	}
	
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException {
		//System.out.println("after method");
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreen(driver, testId);
		}
		System.out.println("after method");
		driver.navigate().back();
	}
	
	@AfterClass
	public void afterclass() {
		System.out.println("afetr class");
		//driver.close();
	}
	
	@AfterTest
	public void aftertest()  {
		System.out.println("after test");
		
		driver.close();
	}
	@AfterSuite
	public void aftersuite() {
		System.out.println("after suite");
	}

}

/* TestSuite code
  <test thread-count="5" name="FirefoxTest">
  <parameter name="browser" value="Firefox"></parameter>
    <classes>
      <class name="testNg_pack.TesNgClass2">
      <methods>
      <include name="testA"></include>
      </methods>
      </class>
      
      <class name="testNg_pack.TestNgClass1">
      <methods>
      <exclude name="test3"></exclude>
      </methods>
      </class>
    </classes>
  </test> <!-- Test -->
  */
