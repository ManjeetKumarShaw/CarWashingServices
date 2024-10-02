package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public WebDriver driver;
	public Properties properties;

	@BeforeClass
	@Parameters({"os", "browser"})
	public void setup(String os,String browser) throws IOException {

		FileReader file=new FileReader(".//src//test//resources//config.properties");
		properties=new Properties();
		properties.load(file);


		switch(browser.toLowerCase()) {

		case "edge":{
			EdgeOptions options = new EdgeOptions();
			options.addArguments("start-maximized");
			options.addArguments("--disable-blink-features=AutomationControlled");
			options.addArguments("--disable-notifications");
			driver = new EdgeDriver(options);
			break;

		}
		case "chrome":{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("--disable-blink-features=AutomationControlled");
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			break;
		}
		case "firefox": {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("start-maximized");
			options.addArguments("--disable-blink-features=AutomationControlled");
			options.addArguments("--disable-notifications");
			driver = new FirefoxDriver(options);
			break;

		}
		default:
			System.out.println("Invalid browser name!!!");
			return;
		}
		
		driver.manage().deleteAllCookies();
		driver.get(properties.getProperty("appURL"));


	}
	@AfterClass
	public void tearDown()
	{
		if (driver != null) {
            driver.quit();
        }
	}


}
