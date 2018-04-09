package suite1;
import data.Util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Flipkart {
	
	WebDriver driver;
	
	@BeforeTest
	public void Start(){
		
		System.setProperty(Util.arg0, Util.arg1);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Util.flipkartUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}

	@Test(priority = '1')
	public void title(){
		System.out.println("Login page Title : " +driver.getTitle());
	}
	
	@Test(priority = '2')
	public void login(){
		//driver.switchTo().frame("loginIframe");
		//driver.findElement(By.xpath(".//*[@id='container']/div/header/div[1]/div/div/div/div[2]/div[1]/a")).click();
		//driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).clear();
		WebElement user = driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input"));
		user.sendKeys(Util.username);
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys(Util.passwd);
		
		driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")).click();
		
		WebElement name = driver.findElement(By.xpath(".//*[@id='container']/div/header/div[1]/div[1]/div/ul/li[8]/a"));
		System.out.println(name.getText());
		Assert.assertTrue(driver.getTitle().contains("Online"));
		
	}
	
	@Test(priority = '3' , dependsOnMethods="login")
	public void search() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.findElement(By.xpath(".//*[@id='container']/div/header/div[1]/div[2]/div/div/div[2]/form/div/div[2]/button")).click();
		driver.findElement(By.xpath(".//*[@id='container']/div/header/div[1]/div[2]/div/div/div[2]/form/div/div[1]/div/input")).sendKeys(Util.product);
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		//driver.findElement(By.xpath(".//*[@id='container']/div/header/div[1]/div[2]/div/div/div[2]/form/div/div[2]/button")).click();
		driver.findElement(By.xpath(".//*[@id='container']/div/header/div[1]/div[2]/div/div/div[2]/form/div/div[1]/div/input")).sendKeys(Keys.ENTER);
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.navigate().refresh();
		Thread.sleep(3000);
	
		String searchtitle = driver.getTitle();
		System.out.println("Current title after Search :"+searchtitle);
		Assert.assertTrue(searchtitle.contains("Samsung"));
	}
	
	/*@Test(priority = '4')
	public void logout() throws Exception{
		driver.findElement(By.xpath(".//*[@id='container']/div/header/div[1]/div[1]/div/ul/li[8]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='container']/div/header/div[1]/div[1]/div/ul/li[8]/ul/li[8]/a")).click();
		System.out.println("User Logged out");
	}*/
	
	
	@AfterTest
	public void stop(){
		driver.close();
	}

}
