package testNg_pack;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import modules_pack.Buyitnwpg_Pom;
import modules_pack.Categorypg_Pom;
import modules_pack.Conditionpg_Pom;
import page_pack.EbHompage_Pom;
import page_pack.Prodctpg_Pom;

public class TestNgClass1 {
	
	WebDriver driver;
	EbHompage_Pom ebhome;
	Prodctpg_Pom toyspage;
	Conditionpg_Pom conditionPg;
	Categorypg_Pom categoryPg;
	Buyitnwpg_Pom buytnw;
	SoftAssert soft;
	
	@BeforeSuite
	public void beforesuite() {
		System.out.println("before suite");
	}
	//@Parameters ("browser")
	@BeforeTest
	public void openbrowser(String browserName) {
		System.out.println("before test");
		
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Om\\Desktop\\Automation\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Om\\Desktop\\Automation\\geckodriver-v0.32.2-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		if(browserName.equals("Opera"))
		{
			System.setProperty("webdriver.opera.driver",
					"C:\\Users\\Om\\Desktop\\Automation\\operadriver_win32\\operadriver_win32\\operadriver.exe");
			driver = new OperaDriver();
		}
		if(browserName.equals("Internet Expoler")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\Om\\Desktop\\Automation\\IEDriverServer_Win32_4.8.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20));
		
		
		
	}
	
	 /*
    org.testng.TestNGException: 
	Can inject only one of <ITestContext, XmlTest> into a @BeforeTest annotated openbrowser.
	*/
	
	@BeforeClass
	public void beforeclass() {
		System.out.println("before class");
		/*System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Om\\Desktop\\Automation\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20));
		*/
		
	}
	 
	@BeforeMethod
	public void beforemethod() {
		System.out.println("before method");
		driver.get("https://www.ebay.com/");
		
		ebhome = new EbHompage_Pom(driver);
		ebhome.move2srchfield();
		//ebhome.serachProdct(); later solve
		ebhome.click2srchBtn();
		soft = new SoftAssert();
	}
	/*
	@Test
	public void test1() throws InterruptedException {
		toyspage = new Prodctpg_Pom(driver);
		toyspage.click2option1();
		Thread.sleep(3000);
		conditionPg = new Conditionpg_Pom(driver);
		Thread.sleep(3000);

		conditionPg.checktext();
			
	}
	
	@Test
	public void test2() throws InterruptedException {
		toyspage = new Prodctpg_Pom(driver);
		toyspage.click2option2();	
		Thread.sleep(3000);

		categoryPg = new Categorypg_Pom(driver);
		Thread.sleep(3000);
		categoryPg.checktext2();
	}
	*/
	
	
	@Test(priority=1,invocationCount=2,enabled=true)
	public void test1() throws InterruptedException {
		System.out.println("test1");
		toyspage = new Prodctpg_Pom(driver);
		toyspage.click2acceptoffer();
		
		conditionPg = new Conditionpg_Pom(driver);
		Thread.sleep(3000);
		//conditionPg.geturl();
		String actualdata = conditionPg.geturl();
		String expecteddata ="https://www.ebay.com/sch/i.html?_from=R40&_nkw=toys&_sacat=0&rt=nc&LH_BO=";

		//Assert.assertEquals(actualdata, expecteddata);
		soft.assertEquals(actualdata, expecteddata);
		soft.assertAll();
		
	}
	
	@Test(priority=0,invocationCount=1)
	public void test2() throws InterruptedException {
		System.out.println("test2");
		toyspage = new Prodctpg_Pom(driver);
		toyspage.click2auction();
		
		categoryPg = new Categorypg_Pom(driver);
		Thread.sleep(3000);
		String actualdata = categoryPg.geturl();
		String expecteddata ="https://www.ebay.com/sch/i.html?_from=R40&_nkw=toys&_sacat=0&rt=nc&LH_Auction=1";
		//Assert.assertEquals(actualdata, expecteddata);
		soft.assertEquals(actualdata, expecteddata);
		soft.assertAll();
		
	}
	//invocationCount=0,-1,-2...... will not execute the method
	//1,2,3.....onwards will allow execution,N\But Minimum value should be 2 
	//dependOnmethods = test2 after execution which has highest priority that test method will execute

	
	@Test(priority=2,invocationCount=1,dependsOnMethods={"test2"},timeOut=10000)
	public void test3() throws InterruptedException {
		System.out.println("test 3");
		toyspage = new Prodctpg_Pom(driver);
		toyspage.click2buyitnow();
		
		buytnw = new Buyitnwpg_Pom(driver);
		Thread.sleep(3000);
		String actualdata = buytnw.geturl();
		String expecteddata = "https://www.ebay.com/sch/i.html?_from=R40&_nkw=toys&_sacat=0&rt=nc&LH_BIN=1";
		Assert.assertEquals(actualdata, expecteddata);
		
	}
	
	
	@AfterMethod
	public void aftermethod() {
		System.out.println("after method");
		driver.navigate().back();
		
	}
	
	@AfterClass
	public void afterclass() {
		System.out.println("after class");
		//driver.close();	
	}
	
	@AfterTest
	public void aftertest() {
		System.out.println("after test");
		driver.close();
	}
	
	@AfterSuite
	public void aftersuite(){
		System.out.println("after suite");
	}

}
