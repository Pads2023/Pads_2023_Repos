package page_pack;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utility;

public class EbHompage_Pom {
	@FindBy (xpath="//input[@id='gh-ac']")
	private WebElement searchfield;
	@FindBy (xpath="//input[@id='gh-btn']")
	private WebElement searchBtn;
	
	//For TestNgclass2 All POM CLasses n Methods
	@FindBy (xpath="(//a[@href='https://www.ebay.com/b/Fashion/bn_7000259856'])[2]")
	private WebElement fashion;
	@FindBy (xpath="")
	private WebElement women;
	
	WebDriver driver;
	Actions act ;
	
	public EbHompage_Pom(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.act= new Actions(driver);
	}
	
	public void move2srchfield() {
		act.moveToElement(searchBtn).click(searchBtn).build().perform();
	}
	public void serachProdct(String s) throws IOException {
		//searchfield.sendKeys("toys");
		String data = Utility.getExceldata("Velocity",1,2);
		searchfield.sendKeys(data);
		/*
		try {
			System.out.println("try block");
		}
		catch(exceptionName e)
		{
			System.out.println("Alternative code");
		}*/
	
	}
	public void click2srchBtn() {
		searchBtn.click();
	}
	//TesctNg Class2
	public void mov2fashoin() {
		act.moveToElement(fashion).click(fashion).build().perform();
		
	}
	
	
	

}
