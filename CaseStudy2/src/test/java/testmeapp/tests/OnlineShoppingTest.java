package testmeapp.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testmeapp.utility.*;
public class OnlineShoppingTest {
  public WebDriver driver;
  public String url="http://10.232.237.143:443/TestMeApp/";
	@BeforeClass
  public void openBrowser() {
	   driver=Drivers.getDriver("chrome");
	   driver.get(url);
  }
	@Test(priority = 1)
	public void testRegistration()
	{
		driver.findElement(By.linkText("SignUp")).click();
		driver.findElement(By.id("userName")).sendKeys("harshini3");
		driver.findElement(By.cssSelector("#err")).click();
		String s=driver.findElement(By.cssSelector("#err")).getText();
		System.out.println(s);
		if(s.equals("Available"))
		{
			driver.findElement(By.id("firstName")).sendKeys("harshini");
			driver.findElement(By.id("lastName")).sendKeys("T");
			driver.findElement(By.id("password")).sendKeys("harshu123");
			driver.findElement(By.id("pass_confirmation")).sendKeys("harshu123");
			driver.findElement(By.xpath("//input[@id='gender'][@value='Female']")).click();
			driver.findElement(By.id("emailAddress")).sendKeys("harshu@gmail.com");
			driver.findElement(By.id("mobileNumber")).sendKeys("9843519078");
			driver.findElement(By.name("dob")).sendKeys("29/05/1998");
			driver.findElement(By.id("address")).sendKeys("Srivilliputhur");
			//WebElement search=driver.findElement(By.name("Security Question"));
			Actions action=new Actions(driver);
			action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
			driver.findElement(By.name("answer")).sendKeys("Pink");
			driver.findElement(By.name("Submit")).click();
		}
	}
	@Test(priority = 2)
	public void testLogin()
	{
		driver.findElement(By.id("userName")).sendKeys("harshini3");
		driver.findElement(By.id("password")).sendKeys("harshu123");
		driver.findElement(By.xpath("//input[@name='Login']")).click();
	}
	@Test(priority = 3)
	public void testCart() throws InterruptedException
	{
		  Actions action=new Actions(driver);
		  driver.findElement(By.id("myInput")).click();
		  Thread.sleep(3000);
		  action.sendKeys("Headphone").sendKeys(Keys.ENTER).build().perform();
		  driver.findElement(By.linkText("Add to cart")).click();
		  driver.findElement(By.xpath("//a[contains(@href,'displayCart.htm')]")).click();
		  
		  
	}
	@Test(priority = 4)
	public void testPayment() throws InterruptedException
	{
		driver.findElement(By.linkText("Checkout")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[contains(text(),'Bank of Baroda')]")).click();
		driver.findElement(By.id("btn")).click();
		driver.findElement(By.name("username")).sendKeys("harshini3");
		driver.findElement(By.name("password")).sendKeys("harshu123");
		driver.findElement(By.cssSelector(".user-right:nth-child(3)> input")).click();
	}
	
}
 