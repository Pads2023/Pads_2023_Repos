package modules_pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Categorypg_Pom {
	@FindBy (xpath="//h2[@id='s0-17-18-6-3-4[0]-3-1-13-9[1]-0-0-flyout-title']")
	private WebElement text2;
	
	
	//auction's POM Class
	
	//womenbags pom class
	@FindBy (xpath="(//p[@class='b-guidancecard__title'])[3]")
	private WebElement womenbag;
	
    WebDriver driver;
	
	
	public Categorypg_Pom(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void checktext2() {
		String actual = text2.getText();
		String expected = "Popular in Category";
		if(actual==expected)
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");

		}
		
	}
	//acceptsOffer's POM Class
	public String geturl() {
		String x=driver.getCurrentUrl();
		String y = "https://www.ebay.com/sch/i.html?_from=R40&_nkw=toys&_sacat=0&rt=nc&LH_Auction=1";
		/*
		if(x.equals(y))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		*/
		return x;
	}
	
	public void click2womenbag() {
		womenbag.click();
	}
	public String geturl1() {
		String x=driver.getCurrentUrl();
		return x;
	}

}
