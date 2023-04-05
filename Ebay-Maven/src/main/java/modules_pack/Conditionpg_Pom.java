package modules_pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Conditionpg_Pom {
	
	
	@FindBy (xpath="//h2[@id='s0-17-18-6-3-4[0]-3-1-13-9[0]-0-0-flyout-title']")
	private WebElement text1;
	
	//acceptsOffer's POM Class
	
	//women's shoe
	@FindBy (xpath="(//p[@class='b-guidancecard__title'])[2]")
	private WebElement womenShoe;
	

	
	
	
	
WebDriver driver;
	
	
	public Conditionpg_Pom(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void checktext() {
		String actual = text1.getText();
		String expected = "Condition";
		if(actual==expected)
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");

		}
		
	}
	//acceptsOffer's POM Class Method
	public String geturl() {
		String x= driver.getCurrentUrl();
		String y ="https://www.ebay.com/sch/i.html?_from=R40&_nkw=toys&_sacat=0&rt=nc&LH_BO=1";
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
	
	public void click2wmnshoe() {
		womenShoe.click();
	}
	public String getwmnshoeurl() {
		String x = driver.getCurrentUrl();
		
		return x;
	}
	

}
