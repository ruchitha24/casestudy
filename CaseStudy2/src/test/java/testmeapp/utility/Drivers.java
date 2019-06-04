package testmeapp.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Drivers {
	@Test
	public static WebDriver getDriver(String s)
	{
		if(s.equalsIgnoreCase("chrome"))
		{
			String chromePath="C:\\Selenium-jars\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",chromePath);
			return new ChromeDriver();
		}
		else if(s.equalsIgnoreCase("InternetExplorer"))
		{
			String iePath="C:\\Selenium-jars\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", iePath);
			return new InternetExplorerDriver();
		}
		else 
			return null;
	}
	
}
