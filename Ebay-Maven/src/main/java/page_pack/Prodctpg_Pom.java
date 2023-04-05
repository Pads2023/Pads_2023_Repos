package page_pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Prodctpg_Pom {
	@FindBy (xpath="(//button[@class='x-flyout__button'])[1]")
	private WebElement conditionOption1;
	
	@FindBy (xpath="(//span[@class='srp-multi-aspect__flyout__btn-label'])[2]")
	private WebElement categoryOption2;
	//(//button[@class='x-flyout__button'])[2]
	@FindBy (xpath="(//button[@class='x-flyout__button'])[3]")
	private WebElement priceOption3;
	
	@FindBy (xpath="(//span[@class='srp-format-tabs-h2'])[2]")
	private WebElement acceptsOffer;
	////span[@aria-label='Accepts Offers Current view']
	
	@FindBy (xpath="(//span[@class='srp-format-tabs-h2'])[3]")
	private WebElement auction;
	
	@FindBy (xpath="(//span[@class='srp-format-tabs-h2'])[4]")
	private WebElement buyitnow;
	//================
	@FindBy (xpath="(//p[@class='b-guidancecard__title'])[1]")
	private WebElement women;
	
	
	private WebDriver driver;
	
	
	public Prodctpg_Pom(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void click2option1() {
		conditionOption1.click();
	}
	public void click2option2() {
		categoryOption2.click();
	}
	public void click2option3() {
		priceOption3.click();
	}
	
	public void click2acceptoffer() {
		acceptsOffer.click();
	}
	public void click2auction() {
		auction.click();
	}
	public void click2buyitnow() {
		buyitnow.click();
	}
	
	public void click2women() {
		women.click();
	}
	
	

}
