import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		option.addArguments("--disable-blink-features=AutomationControlled");
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
//		EdgeOptions options = new EdgeOptions();
//		options.addArguments("start-maximized");
//		options.addArguments("--disable-blink-features=AutomationControlled");
//		options.addArguments("--disable-notifications");
//
//		WebDriver driver = new EdgeDriver(options);
        // Navigate to the website
        driver.get("https://www.justdial.com/");

        // Clear cookies
        driver.manage().deleteAllCookies();

        // Set up WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Wait for the login pop-up and handle it
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='loginPop']")));
        driver.findElement(By.xpath("//a[normalize-space(text())='Maybe Later']")).click();

        // Enter search term
        driver.findElement(By.xpath("//*[@id='main-auto']")).sendKeys("Car Washing");
        

        // Click on the first suggestion
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li/a//b[1]"))).click();

       // driver.findElement(By.xpath("//ul/li/a//b[text()=\"Car Washing Services\"]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Top Rated\"]"))).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@keyid='0']//*[contains(@class, ' resultbox_title_anchor ')]")));
        
        for(int i=0; i<5; i++) {
        	System.out.println("name : "+driver.findElement(By.xpath("//*[@keyid='"+i+"']//*[contains(@class, ' resultbox_title_anchor ')]")).getText());
        	//System.out.println("rating :"+ driver.findElement(By.xpath("//*[@keyid='"+i+"']/div/div[2]/div[2]/div[1]")).getText());
        	System.out.println("rating : "+driver.findElement(By.xpath("//*[@keyid='"+i+"']//*[contains(@class, ' whitestar ')]/parent::div")).getText());
        	String str = driver.findElement(By.xpath("//*[@keyid='"+i+"']//div[contains(@class,\" resultbox_countrate  \")]")).getText();
        	System.out.println("votes :"+str.split(" ")[0]);
        	driver.findElement(By.xpath("//*[@keyid='"+i+"']//*[contains(normalize-space(@class), 'callcontent')]")).click();
        	String phone= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@keyid='"+i+"']//*[contains(@class, 'whitecall_icon')]/parent::*"))).getText();
        	System.out.println("Phone no : "+ phone);
 
        }
        driver.get("https://www.justdial.com/");
        driver.findElement(By.xpath("//*[text()=\"Free Listing\"]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[normalize-space(@aria-label=\"Enter Mobile Number\")]"))).sendKeys("9999");
        driver.findElement(By.xpath("//button[normalize-space(@aria-label=\"Start Now\")]")).click();
        String err = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class,'entermobilenumber_error__text')]"))).getText();
        System.out.println(err);
        
        driver.get("https://www.justdial.com/");
        driver.findElement(By.xpath("//img[contains(@title,'Gym')]")).click();
        Thread.sleep(3000);
        List<WebElement> list = driver.findElements(By.xpath("//nav//li[@role='menuitem']"));
        System.out.println("Sub-Menues"+list.size());
        for(int i=0; i<list.size();i++) {
        	System.out.println(list.get(i).getText());
        }
    }
}


