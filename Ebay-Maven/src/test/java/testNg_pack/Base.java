package testNg_pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Base {
	public static WebDriver openchromeBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Om\\Desktop\\Automation\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	public static WebDriver openfirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Om\\Desktop\\Automation\\geckodriver-v0.32.2-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	public static WebDriver openoperaBrowser() {
		System.setProperty("webdriver.opera.driver",
				"C:\\Users\\Om\\Desktop\\Automation\\operadriver_win32\\operadriver_win32\\operadriver.exe");
		WebDriver driver = new OperaDriver();
		return driver;
	}
	public static WebDriver openinternetexplorerBrowser() {
		System.setProperty("webdriver.ie.driver",
				"C:\\Users\\Om\\Desktop\\Automation\\IEDriverServer_Win32_4.8.1\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		return driver;

	}

}
