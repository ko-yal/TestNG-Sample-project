package suite2;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import data.Util;



public class Snapdeal {
	
WebDriver driver;
	
	@BeforeTest
	public void Start(){
		
		System.setProperty(Util.arg0, Util.arg1);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Util.snapUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority = '1')
	public void title(){
		System.out.println("Login page Title : " +driver.getTitle());
	}
	
	@Test(priority = '2')
	public void search() throws Exception{
		driver.findElement(By.xpath(".//*[@id='inputValEnter']")).sendKeys(Util.product);
		driver.findElement(By.xpath(".//*[@id='sdHeader']/div[4]/div[2]/div/div[2]/button")).sendKeys(Keys.ENTER);
		driver.navigate().refresh();
		System.out.println("Title is  :" +driver.getTitle());
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void stop(){
		driver.close();
	}

	
	

}
