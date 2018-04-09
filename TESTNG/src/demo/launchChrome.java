package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class launchChrome {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\a634969\\Chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("www.google.com");
		System.out.println("App launched using Chrome driver");
		
		/*System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://unifiedportal-mem.epfindia.gov.in/memberinterface/");
		System.out.println("launched using firefox");*/
		driver.close();
	}

}
