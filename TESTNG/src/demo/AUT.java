package demo;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class AUT {
	WebDriver driver;
	
	@Test
	public void screenshot() throws Exception{
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\a634969\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/V4/ ");
		
		this.takeSS(driver, "C:\\Users\\a634969\\Desktop\\ACF-AUTOMATION\\test.png");		
	}
	
	public void takeSS(WebDriver webdriver , String filepath) throws Exception{
		
		
		TakesScreenshot ss = ((TakesScreenshot)webdriver);
		
		File srcFile = ss.getScreenshotAs(OutputType.FILE);
		
		File destFile = new File(filepath);
		
		FileUtils.copyFile(srcFile, destFile);
		
		System.out.println("screenshote done!");
		
		driver.close();
		
		
		
		
		
	}

}
