//1: Open Browser and go to site http://www.techfios.com/billing/?ng=admin/ 
//2. Enter username: demo@techfios.com 
//3. Enter password: abc123
//4. Click login button
//5. Click on Bank & Cash button
//6. Click on New Account button 
//7. Fill out the Add New Account form
//8. Click on submit button
//9. Visually check if the account has been created

package variousConcept;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TechfiosLogin {
	WebDriver driver;

	@Before
	public void setup() throws InterruptedException {
		// Set properties to get into the website
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		// clear cookies
		driver.manage().deleteAllCookies();
		// To get into the website we use the following;
		driver.get("https://techfios.com/billing/?ng=login/after/dashboard");
		// To maximize the website windows
		driver.manage().window().maximize();
		// To manage time or to identify findElement we use implecityWait.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void loginTest() throws InterruptedException {
		// To identify website elements:
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.name("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		// Xpath
		// Here, / = select from root node. means, select from <html> opening node and that's a absolute path
		// Here, // = (ui is a node)select from current node and that's a relative path
		// Here, @ = (id is attributes)select attributes
		// Here, * = matches any element node
		// Here, @* = matches any attribute node

		// Click on Bank and Cash button
		driver.findElement(By.xpath("//ul[@id='side-menu']/li[10]")).click();
		// driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[10]/a/span[1]")).click();
		// (copy from xpath)
		// Click on new Account button
		driver.findElement(By.xpath("//ul[@id='side-menu']/li[10]/ul[1]/li[1]/a")).click();
		// driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[10]/ul/li[1]/a")).click();
		// (copy from xpath)
		driver.findElement(By.id("account")).sendKeys("Parves Mia");
		driver.findElement(By.id("description")).sendKeys("Free Account");
		driver.findElement(By.id("balance")).sendKeys("$1500");
		driver.findElement(By.id("account_number")).sendKeys("5613460");
		driver.findElement(By.id("contact_person")).sendKeys("AI");
		driver.findElement(By.id("contact_phone")).sendKeys("7189621154");
		driver.findElement(By.id("ib_url")).sendKeys("Muslim faith - Islamic Religion");
		// driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[2]/form/button")).click();

	}

	@After
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}
}
