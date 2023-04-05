package modules_pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Buyitnwpg_Pom {
    WebDriver driver;
	
	
	public Buyitnwpg_Pom(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public String geturl() {
		String x=driver.getCurrentUrl();
		String y = "https://www.ebay.com/sch/i.html?_from=R40&_nkw=toys&_sacat=0&rt=nc&LH_BIN=1";
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

}
